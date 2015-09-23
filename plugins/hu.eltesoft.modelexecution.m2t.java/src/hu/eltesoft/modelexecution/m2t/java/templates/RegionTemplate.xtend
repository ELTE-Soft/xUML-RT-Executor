package hu.eltesoft.modelexecution.m2t.java.templates

import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers.Entry
import hu.eltesoft.modelexecution.m2t.java.StateQualifiers.Exit
import hu.eltesoft.modelexecution.m2t.java.Template
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedTemplate
import hu.eltesoft.modelexecution.runtime.base.Event
import hu.eltesoft.modelexecution.runtime.base.Signal
import hu.eltesoft.modelexecution.runtime.base.SignalEvent
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

	public static val OWNER_FIELD_NAME = "owner"
	public static val SIGNAL_VARIABLE = "signal"
	public static val CURRENT_STATE_ATTRIBUTE = "currentState"
	
	val RgRegion region
	val RgInitialPseudostate initState
	val RgTransition initTransition
	val RgState firstState

	val StepPartitioning partitioning
	var hasAnySignalChecks = false
	
	

	new(RgRegion region) {
		super(region)
		this.region = region
		initState = region.initialPseudostate
		initTransition = initState.initialTransition
		firstState = initTransition.target
		region.states.forEach[ transitions.forEach[ hasAnySignalChecks = true ] ]

		val numberOfStates = region.states.length
		partitioning = new StepPartitioning(numberOfStates)
	}

	override wrapContent(CharSequence content) '''
		/** Class for state machine region «region.javadoc» */
		«generatedHeaderForClass(region)»
		public class «region.identifier» implements «StateMachineRegion.canonicalName» {
			
			public «region.identifier»(«region.containerClass.identifier» owner) {
				this.«OWNER_FIELD_NAME» = owner;
			}
			«content»
		}
	'''

	override generateContent() '''
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
		
			private «region.containerClass.identifier» «OWNER_FIELD_NAME»;
			private State «CURRENT_STATE_ATTRIBUTE» = State.«initState.identifier»;
		
			@Override
			public void doInitialTransition() {
				// Initial state exit
				«runtime».logExitState(«traceLiteral(initState, Exit)»);
		
				// Initial transition effect
				«runtime».logTransition(
						"<init transition>",
						"<init transition>",
						«trace(initState.nameLiteral, initTransition.reference)»,
						«firstState.nameLiteral»);
				«IF null != initTransition.effect»
					new «initTransition.effect.identifier»(«OWNER_FIELD_NAME»).execute();
				«ENDIF»
				
				«CURRENT_STATE_ATTRIBUTE» = State.«firstState.identifier»;
		
				// First state entry
				«runtime».logEnterState(«traceLiteral(firstState, Entry)»);
				«IF null != firstState.entry»
					«firstState.entry.identifier».execute(«OWNER_FIELD_NAME», null);
				«ENDIF»
				«IF firstState.isFinal»
					
					// Deletes the owner instance. The machine will be unable to receive more events.
					«OWNER_FIELD_NAME».delete();
				«ENDIF»
			}
		
			@Override
			public void step(«Event.canonicalName» message) {
				step0(message);
			}
		
			«FOR i : 0 ..< partitioning.numberOfPartitions»
				«makeStep(i)»
				
			«ENDFOR»
			@Override
			public String toString() {
				return «region.nameLiteral» + " { currentState = " + «CURRENT_STATE_ATTRIBUTE» + " }";
			}	
	'''

	def makeStep(int i) '''
		«IF partitioning.isLast(i)»
			@SuppressWarnings("incomplete-switch")
		«ENDIF»
		private void step«i»(«Event.canonicalName» event) {
			if (event instanceof «SignalEvent.canonicalName») {
				«IF hasAnySignalChecks»«Signal.canonicalName» «SIGNAL_VARIABLE» = ((«SignalEvent.canonicalName») event).getSignal();«ENDIF»
				switch («CURRENT_STATE_ATTRIBUTE») {
					«FOR state : region.states.subList(partitioning.firstState(i), partitioning.afterLastState(i))»
						case «state.identifier»:
							«FOR transition : state.transitions SEPARATOR ' else '»
								if («SIGNAL_VARIABLE» instanceof «transition.message.identifier»)
								{
									// State exit
									«runtime».logExitState(«traceLiteral(state, Exit)»);
									«IF null != state.exit»
										«state.exit.identifier».execute(«OWNER_FIELD_NAME», «SIGNAL_VARIABLE»);
									«ENDIF»
								
									// Transition effect
									«runtime».logTransition(
											«transition.event.nameLiteral»,
											«transition.message.nameLiteral»,
											«trace(state.nameLiteral, transition.reference)»,
											«transition.target.nameLiteral»);
									«IF null != transition.effect»
										«transition.effect.identifier».execute(«OWNER_FIELD_NAME», «SIGNAL_VARIABLE»);
									«ENDIF»
								
									«CURRENT_STATE_ATTRIBUTE» = State.«transition.target.identifier»;
									
									// State entry
									«runtime».logEnterState(«traceLiteral(transition.target, Entry)»);
									«IF null != transition.target.entry»
										«transition.target.entry.identifier».execute(«OWNER_FIELD_NAME», «SIGNAL_VARIABLE»);
									«ENDIF»
									«IF transition.target.isFinal»
										
										// Deletes the owner instance. The machine will be unable to receive more events.
										«OWNER_FIELD_NAME».delete();
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
		}
	'''
}
