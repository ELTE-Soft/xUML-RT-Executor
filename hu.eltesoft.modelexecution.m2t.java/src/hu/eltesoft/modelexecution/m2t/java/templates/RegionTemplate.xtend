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

import static hu.eltesoft.modelexecution.m2t.java.Languages.*
import hu.eltesoft.modelexecution.runtime.base.StateMachineRegion

@SourceMappedTemplate(stratumName=XUML_RT)
class RegionTemplate extends Template {

	val RgRegion region;
	val RgInitialPseudostate initState;
	val RgTransition initTransition;
	val RgState firstState;

	new(RgRegion region) {
		super(region)
		this.region = region
		initState = region.initialPseudostate
		initTransition = initState.initialTransition
		firstState = initTransition.target
	}

	override generate() '''
		«generatedHeader(region.name)»
		public class «region.name» extends «StateMachineRegion.canonicalName» {
		
			private enum States {
				«initState.name», «FOR state : region.states SEPARATOR ', '»«state.name»«ENDFOR»
			}
		
			private «region.containerClass.name» owner;
			private States currentState = States.«initState.name»;
		
			public «region.name»(«region.containerClass.name» owner) {
				this.owner = owner;
			}
		
			@Override
			public void doInitialTransition() {
				// Initial state exit «trace(initState.reference, Exit)»
				owner.getRuntime().logExitState("«initState.name»");
		
				// Initial transition effect «trace(initTransition.reference)»
				owner.getRuntime().logTransition("<init transition>", "«initState.name»", "«firstState.name»");
				«IF null != initTransition.effect»
					new «initTransition.effect.name»(owner).execute();
				«ENDIF»
		
				// First state entry «trace(firstState.reference, Entry)»
				owner.getRuntime().logEnterState("«firstState.name»");
				«IF null != firstState.entry»
					new «firstState.entry.name»(owner).execute();
				«ENDIF»
		
				currentState = States.«firstState.name»;
			}
		
			@Override
			public void step(«Event.canonicalName» event) {
				owner.getRuntime().logEventDispatched(owner, event);
				switch (currentState) {
				case «initState.name»:
					break;
				«FOR state : region.states»
					case «state.name»:
						«FOR transition : state.transitions SEPARATOR ' else '»
							if («transition.event.name».eventMatches(event))
							{
								// State exit «trace(state.reference, Exit)»
								owner.getRuntime().logExitState("«state.name»");
								«IF null != state.exit»
									new «state.exit.name»(owner).execute();
								«ENDIF»
							
								// Transition effect «trace(transition.reference)»
								owner.getRuntime().logTransition("«transition.event.name»", "«state.name»", "«transition.target.name»");
								«IF null != transition.effect»
									new «transition.effect.name»(owner).execute();
								«ENDIF»
							
								// State entry «trace(transition.target.reference, Entry)»
								owner.getRuntime().logEnterState("«transition.target.name»");
								«IF null != transition.target.entry»
									new «transition.target.entry.name»(owner).execute();
								«ENDIF»
							
								currentState = States.«transition.target.name»;
							}
						«ENDFOR»
						break;
				«ENDFOR»
				}
			}
		
			@Override
			public String toString() {
				return "«region.name» { currentState = " + currentState + " }";
			}
		}
	'''
}
