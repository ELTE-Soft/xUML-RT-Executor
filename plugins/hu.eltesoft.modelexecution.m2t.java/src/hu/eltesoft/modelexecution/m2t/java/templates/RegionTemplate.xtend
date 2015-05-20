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
		«generatedHeader(region.originalName)»
		public class «region.name» extends «StateMachineRegion.canonicalName» {
		
			private enum States {
				@Generated(value = { "«initState.originalName»" })
				«initState.name»,
				«FOR state : region.states SEPARATOR ','»
					@Generated(value = { "«state.originalName»" })
					«state.name»
				«ENDFOR»
			}
		
			private «region.containerClass.name» owner;
			private States currentState = States.«initState.name»;
		
			public «region.name»(«region.containerClass.name» owner) {
				this.owner = owner;
			}
		
			@Override
			public void doInitialTransition() {
				// Initial state exit
				owner.getRuntime().logExitState("«traceOriginal(initState, Exit)»");
		
				// Initial transition effect
				owner.getRuntime().logTransition("<init transition>", "<init transition>", "«trace(initState.originalName, initTransition.reference)»", "«firstState.originalName»");
				«IF null != initTransition.effect»
					new «initTransition.effect.name»(owner).execute();
				«ENDIF»
		
				// First state entry
				owner.getRuntime().logEnterState("«traceOriginal(firstState, Entry)»");
				«IF null != firstState.entry»
					new «firstState.entry.name»(owner).execute();
				«ENDIF»
		
				currentState = States.«firstState.name»;
			}
		
			@Override
			public void step(«Message.canonicalName» message) {
				owner.getRuntime().logMessageDispatched(owner, message);
				step0(message);
			}
		
			«FOR i : 0 ..< partitioning.numberOfPartitions»
				«makeStep(i)»
				
			«ENDFOR»
			@Override
			public String toString() {
				return "«region.originalName» { currentState = " + currentState + " }";
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
					case «state.name»:
						«FOR transition : state.transitions SEPARATOR ' else '»
							if (message instanceof «transition.message.name»)
							{
								// State exit
								owner.getRuntime().logExitState("«traceOriginal(state, Exit)»");
								«IF null != state.exit»
									new «state.exit.name»(owner).execute();
								«ENDIF»
							
								// Transition effect
								owner.getRuntime().logTransition("«transition.event.originalName»", "«transition.message.originalName»", "«trace(state.originalName, transition.reference)»", "«transition.target.originalName»");
								«IF null != transition.effect»
									new «transition.effect.name»(owner).execute();
								«ENDIF»
							
								// State entry
								owner.getRuntime().logEnterState("«traceOriginal(transition.target, Entry)»");
								«IF null != transition.target.entry»
									new «transition.target.entry.name»(owner).execute();
								«ENDIF»
							
								currentState = States.«transition.target.name»;
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
