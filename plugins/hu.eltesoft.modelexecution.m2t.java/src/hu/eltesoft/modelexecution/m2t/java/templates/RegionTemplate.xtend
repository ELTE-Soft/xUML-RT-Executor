package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers.Entry
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers.Exit
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Message
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion

import static hu.eltesoft.modelexecution.m2t.java.Languages.*

/**
 * Provides calculations for partitioning the step operation in the region
 * template, based on the number of states in the region.
 */
class StepPartitioning {

	/**
	 * How many states a single step partition method should handle
	 */
	public static val PARTITION_SIZE = 128;

	val int numberOfStates

	new(int numberOfStates) {
		this.numberOfStates = numberOfStates
	}

	def numberOfPartitions() {
		Math.ceil(numberOfStates / (PARTITION_SIZE as double)) as int
	}

	def firstState(int partitionIndex) {
		partitionIndex * PARTITION_SIZE
	}

	def afterLastState(int partitionIndex) {
		Math.min((partitionIndex + 1) * PARTITION_SIZE, numberOfStates)
	}

	def isLast(int partitionIndex) {
		afterLastState(partitionIndex) >= numberOfStates
	}
}

@SourceMappedTemplate(stratumName=XUML_RT)
class RegionTemplate extends Template {

	val RgRegion region
	val RgInitialPseudostate initState
	val RgTransition initTransition
	val RgState firstState

	val StepPartitioning partitioning

	new(RgRegion region) {
		super(region)
		this.region = region
		initState = region.initialPseudostate
		initTransition = initState.initialTransition
		firstState = initTransition.target

		val numberOfStates = region.states.length
		partitioning = new StepPartitioning(numberOfStates)
	}

	override generate() '''
		/** Class for state machine region «region.javadoc» */
		«generatedHeaderForClass(region)»
		public class «region.identifier» implements «StateMachineRegion.canonicalName» {
		
			private enum State {
				/** Enum literal for initial state «initState.javadoc» */
				«initState.identifier»(«initState.nameLiteral»),
				«FOR state : region.states SEPARATOR ','»
					/** Enum literal for state «state.javadoc» */
					«state.identifier»(«state.nameLiteral»)
				«ENDFOR»
				;
		
				private final String name;
		
				State(String name) {
					this.name = name;
				}
		
				@Override
				public String toString() {
					return name;
				}
			}
		
			private «region.containerClass.identifier» owner;
			private State currentState = State.«initState.identifier»;
		
			public «region.identifier»(«region.containerClass.identifier» owner) {
				this.owner = owner;
			}
		
			@Override
			public void doInitialTransition() {
				// Initial state exit
				owner.getRuntime().logExitState(«traceLiteral(initState, Exit)»);
		
				// Initial transition effect
				owner.getRuntime().logTransition(
						"<init transition>",
						"<init transition>",
						«trace(initState.nameLiteral, initTransition.reference)»,
						«firstState.nameLiteral»);
				«IF null != initTransition.effect»
					new «initTransition.effect.identifier»(owner).execute();
				«ENDIF»
		
				// First state entry
				owner.getRuntime().logEnterState(«traceLiteral(firstState, Entry)»);
				«IF null != firstState.entry»
					«firstState.entry.identifier».execute(owner);
				«ENDIF»
				
				currentState = State.«firstState.identifier»;
				«IF firstState.isFinal»
					
					// The class cannot get more events
					owner.dispose();
				«ENDIF»
			}
		
			@Override
			public void step(«Message.canonicalName» message) {
				step0(message);
			}
		
			«FOR i : 0 ..< partitioning.numberOfPartitions»
				«makeStep(i)»
				
			«ENDFOR»
			@Override
			public String toString() {
				return «region.nameLiteral» + " { currentState = " + currentState + " }";
			}
		}
	'''

	def makeStep(int i) '''
		«IF partitioning.isLast(i)»
			@SuppressWarnings("incomplete-switch")
		«ENDIF»
		private void step«i»(«Message.canonicalName» message) {
			switch (currentState) {
				«FOR state : region.states.subList(partitioning.firstState(i), partitioning.afterLastState(i))»
					case «state.identifier»:
						«FOR transition : state.transitions SEPARATOR ' else '»
							if (message instanceof «transition.message.identifier»)
							{
								// State exit
								owner.getRuntime().logExitState(«traceLiteral(state, Exit)»);
								«IF null != state.exit»
									«state.exit.identifier».execute(owner);
								«ENDIF»
							
								// Transition effect
								owner.getRuntime().logTransition(
										«transition.event.nameLiteral»,
										«transition.message.nameLiteral»,
										«trace(state.nameLiteral, transition.reference)»,
										«transition.target.nameLiteral»);
								«IF null != transition.effect»
									«transition.effect.identifier».execute(owner);
								«ENDIF»
							
								// State entry
								owner.getRuntime().logEnterState(«traceLiteral(transition.target, Entry)»);
								«IF null != transition.target.entry»
									«transition.target.entry.identifier».execute(owner);
								«ENDIF»
								
								currentState = State.«transition.target.identifier»;
								«IF transition.target.isFinal»
									
									// The class cannot get more events
									owner.dispose();
								«ENDIF»
							}
						«ENDFOR»
						break;
				«ENDFOR»
				«IF !partitioning.isLast(i)»
					default:
						step«i + 1»(message);
						break;
				«ENDIF»
			}
		}
	'''
}
