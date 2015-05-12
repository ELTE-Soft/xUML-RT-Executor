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

@SourceMappedTemplate(stratumName=XUML_RT)
class RegionTemplate extends Template {

	val RgRegion region
	val RgInitialPseudostate initState
	val RgTransition initTransition
	val RgState firstState

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
				// Initial state exit
				owner.getRuntime().logExitState("«trace(initState, Exit)»");
		
				// Initial transition effect
				owner.getRuntime().logTransition("<init transition>", "«trace(initState.name, initTransition.reference)»", "«firstState.
			name»");
				«IF null != initTransition.effect»
					new «initTransition.effect.name»(owner).execute();
				«ENDIF»
		
				// First state entry
				owner.getRuntime().logEnterState("«trace(firstState, Entry)»");
				«IF null != firstState.entry»
					new «firstState.entry.name»(owner).execute();
				«ENDIF»
		
				currentState = States.«firstState.name»;
			}
		
			@Override
			public void step(«Message.canonicalName» message) {
				owner.getRuntime().logMessageDispatched(owner, message);
				switch (currentState) {
				case «initState.name»:
					break;
				«FOR state : region.states»
					case «state.name»:
						«FOR transition : state.transitions SEPARATOR ' else '»
							if (message instanceof «transition.message.name»)
							{
								// State exit
								owner.getRuntime().logExitState("«trace(state, Exit)»");
								«IF null != state.exit»
									new «state.exit.name»(owner).execute();
								«ENDIF»
							
								// Transition effect
								owner.getRuntime().logTransition("«trace(transition.message.name, transition.reference)»", "«state.name»", "«transition.target.name»");
								«IF null != transition.effect»
									new «transition.effect.name»(owner).execute();
								«ENDIF»
							
								// State entry
								owner.getRuntime().logEnterState("«trace(transition.target, Entry)»");
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
