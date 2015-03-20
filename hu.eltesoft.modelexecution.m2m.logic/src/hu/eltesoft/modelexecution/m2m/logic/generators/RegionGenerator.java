package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher;
import hu.eltesoft.modelexecution.uml.incquery.InitialTransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.EntryProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ExitProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.InitialTransitionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.StateProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionProcessor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

public class RegionGenerator extends AbstractGenerator<Region, RgRegion> {

	private static final RegionFactory FACTORY = RegionFactory.eINSTANCE;

	private final RegionMatcher regionMatcher;
	private final InitialTransitionMatcher initialTransitionMatcher;
	private final StateMatcher stateMatcher;
	private final EntryMatcher entryMatcher;
	private final ExitMatcher exitMatcher;
	private final TransitionMatcher transitionMatcher;
	private final TransitionEffectMatcher transitionEffectMatcher;

	public RegionGenerator(IncQueryEngine engine, TextChangesListener listener) throws IncQueryException {
		super(listener);
		regionMatcher = RegionMatcher.on(engine);
		initialTransitionMatcher = InitialTransitionMatcher.on(engine);
		stateMatcher = StateMatcher.on(engine);
		entryMatcher = EntryMatcher.on(engine);
		exitMatcher = ExitMatcher.on(engine);
		transitionMatcher = TransitionMatcher.on(engine);
		transitionEffectMatcher = TransitionEffectMatcher.on(engine);
	}

	@Override
	public RgRegion generateTranslationModel(Region source) {
		StateManager manager = new StateManager();

		// new RgRegion
		RgRegion root = FACTORY.createRgRegion();

		// name, containingClass, initialPseudoState
		regionMatcher.forOneArbitraryMatch(source, null, null, null,
				getProcessorToSetNameAndContainingClassAndInitialPseudoStateOfRoot(root, manager));

		// states
		stateMatcher.forEachMatch(source, null, null, getProcessorToSetStatesOfRoot(root.getStates(), manager));

		return root;
	}

	private RegionProcessor getProcessorToSetNameAndContainingClassAndInitialPseudoStateOfRoot(RgRegion root,
			StateManager manager) {
		return new RegionProcessor() {

			@Override
			public void process(Region pRegion, String pRegionName, String pContainingClassName,
					Pseudostate pInitPseudostate) {

				// name
				root.setName(pRegionName);

				// containing class
				root.setContainerClass(createContainingClass(pContainingClassName));

				// initial pseudostate
				root.setInitialPseudostate(createInitialPseudostate(pInitPseudostate, manager));

			}

			private RgClass createContainingClass(String name) {
				// new RgClass
				RgClass rgClass = FACTORY.createRgClass();

				// name
				rgClass.setName(name);

				return rgClass;
			}

			private RgInitialPseudostate createInitialPseudostate(Pseudostate initPseudostate, StateManager manager) {
				// new RgInitialPseudostate
				RgInitialPseudostate rgInitialPseudostate = FACTORY.createRgInitialPseudostate();

				// name
				// TODO

				// reference
				rgInitialPseudostate.setReference(new Reference(rgInitialPseudostate));

				// initialTransition
				initialTransitionMatcher.forOneArbitraryMatch(null, initPseudostate, null, null, null,
						getProcessorToSetInitialTransitionOfInitialPseudostate(rgInitialPseudostate, manager));

				return rgInitialPseudostate;
			}

			private InitialTransitionProcessor getProcessorToSetInitialTransitionOfInitialPseudostate(
					RgInitialPseudostate rgInitialPseudostate, StateManager manager) {
				return new InitialTransitionProcessor() {

					@Override
					public void process(Region pRegion, Pseudostate pInitPseudostate, Transition pInitTransition,
							String pInitTransitionName, String pTargetName) {

						rgInitialPseudostate.setInitialTransition(createTransition(pInitTransition, null, pTargetName,
								manager));
						// Event is not set. Initial transition has no explicit
						// triggering event.

					}

				};
			}

		};
	}

	private StateProcessor getProcessorToSetStatesOfRoot(EList<RgState> states, StateManager manager) {
		return new StateProcessor() {

			@Override
			public void process(Region pRegion, State pState, String pStateName) {
				states.add(manager.get(pState, pStateName));
			}

		};
	}

	private RgTransition createTransition(Transition transition, String eventName, String targetName,
			StateManager manager) {
		// new RgTransition
		RgTransition rgTransition = FACTORY.createRgTransition();

		// reference
		rgTransition.setReference(new Reference(transition));

		// event
		if (eventName != null) { // in case of the initial transition
			rgTransition.setEvent(createEvent(eventName));
		}

		// effect
		transitionEffectMatcher.forOneArbitraryMatch(null, transition, null,
				getProcessorToSetEffectOfTransition(rgTransition));

		// target
		rgTransition.setTarget(manager.get(targetName));

		return rgTransition;
	}

	private RgEvent createEvent(String name) {
		// new RgEvent
		RgEvent rgEvent = FACTORY.createRgEvent();

		// name
		rgEvent.setName(name);

		return rgEvent;
	}

	private TransitionEffectProcessor getProcessorToSetEffectOfTransition(RgTransition rgTransition) {
		return new TransitionEffectProcessor() {

			@Override
			public void process(Region pRegion, Transition pTransition, String pEffectName) {
				rgTransition.setEffect(createBehavior(pEffectName));
			}

		};
	}

	private class StateManager {

		private Map<String, RgState> map;

		StateManager() {
			map = new HashMap<>();
		}

		RgState get(String name) {
			RgState rgState = map.get(name);
			if (rgState == null) {
				rgState = createState(name);
			}
			return rgState;
		}

		RgState get(State state, String name) {
			return setAttributesOfState(get(name), state);
		}

		private RgState createState(String name) {
			// new RgState
			RgState rgState = FACTORY.createRgState();

			// name
			rgState.setName(name);

			return rgState;
		}

		private RgState setAttributesOfState(RgState rgState, State state) {
			// reference
			rgState.setReference(new Reference(state));

			// entry
			entryMatcher.forOneArbitraryMatch(null, state, null, getProcessorToSetEntryOfState(rgState));

			// exit
			exitMatcher.forOneArbitraryMatch(null, state, null, getProcessorToSetExitOfState(rgState));

			// transitions
			transitionMatcher.forOneArbitraryMatch(null, state, null, null, null, null,
					getProcessorToSetTransitionsOfState(rgState.getTransitions()));

			return rgState;
		}

		private EntryProcessor getProcessorToSetEntryOfState(RgState rgState) {
			return new EntryProcessor() {

				@Override
				public void process(Region pRegion, State pState, String pEntryName) {
					rgState.setEntry(createBehavior(pEntryName));
				}

			};
		}

		private ExitProcessor getProcessorToSetExitOfState(RgState rgState) {
			return new ExitProcessor() {

				@Override
				public void process(Region pRegion, State pState, String pEntryName) {
					rgState.setExit(createBehavior(pEntryName));
				}

			};
		}

		private TransitionProcessor getProcessorToSetTransitionsOfState(EList<RgTransition> transitionsOfRgState) {
			return new TransitionProcessor() {

				@Override
				public void process(Region pRegion, State pSourceState, Transition pTransition, String pTransitionName,
						String pEventName, String pTargetName) {

					transitionsOfRgState.add(createTransition(pTransition, pEventName, pTargetName, StateManager.this));
				}

			};
		}

	}

	private RgBehavior createBehavior(String name) {
		// new RgBehavior
		RgBehavior rgBehavior = FACTORY.createRgBehavior();

		// name
		rgBehavior.setName(name);

		return rgBehavior;
	}

	@Override
	public void generateText(RgRegion root) {
		RegionTemplate template = new RegionTemplate(root);

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		listener.contentChanged(root.getName(), output, symbols);
	}

	@Override
	public RgRegion generateModelRoot(Region source) {
		// TODO Auto-generated method stub
		return null;
	}

}
