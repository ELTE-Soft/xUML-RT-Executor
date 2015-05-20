package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgBehavior;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgClass;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgEvent;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgMessage;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatch;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatch;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatch;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StateMatch;
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatch;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatch;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.EntryProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.ExitProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.InitialsProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.StateProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectProcessor;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionProcessor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

public class RegionGenerator extends AbstractGenerator<Region, RgRegion> {

	private static final RegionFactory FACTORY = RegionFactory.eINSTANCE;

	private final RegionMatcher regionMatcher;
	private final ContainerClassOfRegionMatcher containerClassOfRegionMatcher;
	private final InitialsMatcher initialsMatcher;
	private final StateMatcher stateMatcher;
	private final EntryMatcher entryMatcher;
	private final ExitMatcher exitMatcher;
	private final TransitionMatcher transitionMatcher;
	private final TransitionEffectMatcher transitionEffectMatcher;

	/**
	 * To manage EObject -> container name mapping. If <code>null</code>, no
	 * mapping is required.
	 */
	private ChangeRegistry changeRegistry = null;

	public RegionGenerator(IncQueryEngine engine, TextChangesListener listener)
			throws IncQueryException {
		super(listener);
		regionMatcher = RegionMatcher.on(engine);
		containerClassOfRegionMatcher = ContainerClassOfRegionMatcher
				.on(engine);
		initialsMatcher = InitialsMatcher.on(engine);
		stateMatcher = StateMatcher.on(engine);
		entryMatcher = EntryMatcher.on(engine);
		exitMatcher = ExitMatcher.on(engine);
		transitionMatcher = TransitionMatcher.on(engine);
		transitionEffectMatcher = TransitionEffectMatcher.on(engine);
	}

	public void setChangeRegistry(ChangeRegistry changeRegistry) {
		this.changeRegistry = changeRegistry;
	}

	private void setContainerName(EObject modelElement, String rootName) {
		if (changeRegistry != null) {
			changeRegistry.setContainerName(modelElement, rootName);
		}
	}

	// generate translation model

	@Override
	public RgRegion generateTranslationModel(Region source)
			throws GenerationException {

		// new RgRegion
		RgRegion root = FACTORY.createRgRegion();

		// name
		check(regionMatcher.forOneArbitraryMatch(source, null,
				getProcessorToSetNameOfRoot(root)));

		// containerClass
		check(containerClassOfRegionMatcher.forOneArbitraryMatch(source, null,
				null, getProcessorToSetContainerClassOfRoot(root)));

		// initialPseudoState, states
		new StatesGenerator(source, root).generate();

		return root;
	}

	private RegionProcessor getProcessorToSetNameOfRoot(RgRegion root) {
		return new RegionProcessor() {

			@Override
			public void process(Region pRegion, String pRegionName) {
				root.setReference(new NamedReference(pRegion, pRegionName));
			}

		};
	}

	private ContainerClassOfRegionProcessor getProcessorToSetContainerClassOfRoot(
			RgRegion root) {
		return new ContainerClassOfRegionProcessor() {

			@Override
			public void process(Region pRegion, Class pContainerClass,
					String pContainerClassName) {
				root.setContainerClass(createContainerClass(pContainerClass,
						pContainerClassName));
			}

			private RgClass createContainerClass(Class containerClass,
					String name) {
				// new RgClass
				RgClass rgClass = FACTORY.createRgClass();

				// name
				rgClass.setReference(new NamedReference(containerClass, name));

				return rgClass;
			}

		};
	}

	// states generator

	private class StatesGenerator {

		private final Region source;
		private final RgRegion root;
		private final StateManager manager;

		StatesGenerator(Region source, RgRegion root) {
			this.source = source;
			this.root = root;
			this.manager = new StateManager();
		}

		void generate() {
			// states (without transitions)
			stateMatcher.forEachMatch(source, null, null,
					getProcessorToSetStatesOfRoot(root.getStates()));

			// initialPseudoState
			check(initialsMatcher.forOneArbitraryMatch(source, null, null,
					null, null, getProcessorToSetInitialPseudoStateOfRoot()));

			// (add transitions to states)
			transitionMatcher.forEachMatch(source, null, null, null, null,
					null, null, null, null,
					getProcessorToSetTransitionsOfState());

		}

		private StateProcessor getProcessorToSetStatesOfRoot(
				EList<RgState> states) {
			return new StateProcessor() {

				@Override
				public void process(Region pRegion, State pState,
						String pStateName) {
					manager.set(pState, pStateName);
				}

			};
		}

		private InitialsProcessor getProcessorToSetInitialPseudoStateOfRoot() {
			return new InitialsProcessor() {

				@Override
				public void process(Region pRegion,
						Pseudostate pInitPseudostate,
						String pInitPseudostateName,
						Transition pInitTransition, State pFirstState) {

					// new RgInitialPseudostate
					RgInitialPseudostate rgInitialPseudostate = FACTORY
							.createRgInitialPseudostate();

					// register initial to EObject -> container name mapping
					setContainerName(pInitPseudostate, root.getReference()
							.getNewIdentifier());

					// reference
					rgInitialPseudostate.setReference(new NamedReference(
							pInitPseudostate, pInitPseudostateName));

					// initialTransition
					rgInitialPseudostate.setInitialTransition(createTransition(
							pInitTransition, null, null, null, null, null,
							pFirstState));
					// Event is not set. Initial transition has no explicit
					// triggering event.

					root.setInitialPseudostate(rgInitialPseudostate);
				}

			};
		}

		private TransitionProcessor getProcessorToSetTransitionsOfState() {
			return new TransitionProcessor() {

				@Override
				public void process(Region pRegion, State pSource,
						Transition pTransition, String pTransitionName,
						Event pEvent, String pEventName, Signal pSignal,
						String pMessageName, State pTarget) {

					RgState rgState = manager.get(pSource);

					rgState.getTransitions().add(
							createTransition(pTransition, pTransitionName,
									pEvent, pEventName, pSignal, pMessageName,
									pTarget));
				}

			};
		}

		private RgTransition createTransition(Transition transition,
				String transitionName, Event event, String eventName,
				Signal signal, String messageName, State target) {

			// new RgTransition
			RgTransition rgTransition = FACTORY.createRgTransition();

			// register transition to EObject -> container name mapping
			setContainerName(transition, root.getReference().getNewIdentifier());

			// reference
			rgTransition.setReference(new NamedReference(transition,
					transitionName));

			// message
			if (messageName != null) { // in case of any other than the initial
										// transition
				rgTransition.setMessage(createMessage(signal, messageName));
			}

			// event
			if (eventName != null) { // in case of any other than the initial
										// transition
				rgTransition.setEvent(createEvent(event, eventName));
			}

			// effect
			transitionEffectMatcher.forOneArbitraryMatch(null, transition,
					null, null,
					getProcessorToSetEffectOfTransition(rgTransition));

			// target
			rgTransition.setTarget(manager.get(target));

			return rgTransition;
		}

		private RgEvent createEvent(Event event, String name) {
			RgEvent rgEvent = FACTORY.createRgEvent();
			rgEvent.setReference(new NamedReference(event, name));
			return rgEvent;
		}

		private RgMessage createMessage(Signal signal, String name) {
			// new RgEvent
			RgMessage rgMessage = FACTORY.createRgMessage();

			// name
			rgMessage.setReference(new NamedReference(signal, name));

			return rgMessage;
		}

		private TransitionEffectProcessor getProcessorToSetEffectOfTransition(
				RgTransition rgTransition) {
			return new TransitionEffectProcessor() {

				@Override
				public void process(Region pRegion, Transition pTransition,
						Behavior pEffect, String pEffectName) {

					rgTransition
							.setEffect(createBehavior(pEffect, pEffectName));
				}

			};
		}

		private RgBehavior createBehavior(Behavior behavior, String name) {
			// new RgBehavior
			RgBehavior rgBehavior = FACTORY.createRgBehavior();

			// name
			rgBehavior.setReference(new NamedReference(behavior, name));

			return rgBehavior;
		}

		// state manager

		private class StateManager {

			private Map<State, RgState> map;

			StateManager() {
				map = new HashMap<>();
			}

			void set(State state, String name) {
				// new RgState
				RgState rgState = FACTORY.createRgState();

				// register state to EObject -> container name mapping
				setContainerName(state, root.getReference().getNewIdentifier());

				// reference
				rgState.setReference(new NamedReference(state, name));

				// entry
				entryMatcher.forOneArbitraryMatch(null, state, null, null,
						getProcessorToSetEntryOfState(rgState));

				// exit
				exitMatcher.forOneArbitraryMatch(null, state, null, null,
						getProcessorToSetExitOfState(rgState));

				// transitions
				// (later)

				map.put(state, rgState);

				root.getStates().add(rgState);
			}

			RgState get(State state) {
				RgState rgState = map.get(state);
				check(rgState != null);
				return rgState;
			}

			private EntryProcessor getProcessorToSetEntryOfState(RgState rgState) {
				return new EntryProcessor() {

					@Override
					public void process(Region pRegion, State pState,
							Behavior pEntry, String pEntryName) {

						rgState.setEntry(createBehavior(pEntry, pEntryName));
					}

				};
			}

			private ExitProcessor getProcessorToSetExitOfState(RgState rgState) {
				return new ExitProcessor() {

					@Override
					public void process(Region pRegion, State pState,
							Behavior pExit, String pExitName) {

						rgState.setExit(createBehavior(pExit, pExitName));
					}

				};
			}
		}
	}

	// generate text

	@Override
	public void generateText(RgRegion root) {
		RegionTemplate template = new RegionTemplate(root);

		SourceMappedText output = template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		textChangesListener.contentChanged(root.getReference()
				.getNewIdentifier(), output, symbols);
	}

	// add match update listeners

	@Override
	public ReversionTask addMatchUpdateListeners(
			AdvancedIncQueryEngine advancedEngine, ChangeRegistry changeRegistry) {

		return new ReversionTask() {

			private final IMatchUpdateListener<RegionMatch> regionListener;
			private final IMatchUpdateListener<ContainerClassOfRegionMatch> containerClassOfRegionListener;
			private final IMatchUpdateListener<InitialsMatch> initialsListener;
			private final IMatchUpdateListener<StateMatch> stateListener;
			private final IMatchUpdateListener<EntryMatch> entryListener;
			private final IMatchUpdateListener<ExitMatch> exitListener;
			private final IMatchUpdateListener<TransitionMatch> transitionListener;
			private final IMatchUpdateListener<TransitionEffectMatch> transitionEffectListener;

			{ // set regionListener
				regionListener = new IMatchUpdateListener<RegionMatch>() {

					@Override
					public void notifyAppearance(RegionMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(RegionMatch match) {
						// disappearance of root: delete file
						changeRegistry.newDeletion(match.getRegionName());
					}

				};

				advancedEngine.addMatchUpdateListener(regionMatcher,
						regionListener, false);
			}

			{ // set containerClassOfRegionListener
				containerClassOfRegionListener = new IMatchUpdateListener<ContainerClassOfRegionMatch>() {

					@Override
					public void notifyAppearance(
							ContainerClassOfRegionMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(
							ContainerClassOfRegionMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(
						containerClassOfRegionMatcher,
						containerClassOfRegionListener, false);
			}

			{ // set initialsListener
				initialsListener = new IMatchUpdateListener<InitialsMatch>() {

					@Override
					public void notifyAppearance(InitialsMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(InitialsMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(initialsMatcher,
						initialsListener, false);
			}

			{ // set stateListener
				stateListener = new IMatchUpdateListener<StateMatch>() {

					@Override
					public void notifyAppearance(StateMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(StateMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(stateMatcher,
						stateListener, false);
			}

			{ // set entryListener
				entryListener = new IMatchUpdateListener<EntryMatch>() {

					@Override
					public void notifyAppearance(EntryMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(EntryMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(entryMatcher,
						entryListener, false);
			}

			{ // set exitListener
				exitListener = new IMatchUpdateListener<ExitMatch>() {

					@Override
					public void notifyAppearance(ExitMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(ExitMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(exitMatcher,
						exitListener, false);
			}

			{ // set transitionListener
				transitionListener = new IMatchUpdateListener<TransitionMatch>() {

					@Override
					public void notifyAppearance(TransitionMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(TransitionMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(transitionMatcher,
						transitionListener, false);
			}

			{ // set transitionEffectListener
				transitionEffectListener = new IMatchUpdateListener<TransitionEffectMatch>() {

					@Override
					public void notifyAppearance(TransitionEffectMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

					@Override
					public void notifyDisappearance(TransitionEffectMatch match) {
						changeRegistry.newModification(match.getRegion(),
								RegionGenerator.this);
					}

				};

				advancedEngine.addMatchUpdateListener(transitionEffectMatcher,
						transitionEffectListener, false);
			}

			@Override
			public boolean revert() {

				advancedEngine.removeMatchUpdateListener(regionMatcher,
						regionListener);
				advancedEngine.removeMatchUpdateListener(
						containerClassOfRegionMatcher,
						containerClassOfRegionListener);
				advancedEngine.removeMatchUpdateListener(initialsMatcher,
						initialsListener);
				advancedEngine.removeMatchUpdateListener(stateMatcher,
						stateListener);
				advancedEngine.removeMatchUpdateListener(entryMatcher,
						entryListener);
				advancedEngine.removeMatchUpdateListener(exitMatcher,
						exitListener);
				advancedEngine.removeMatchUpdateListener(transitionMatcher,
						transitionListener);
				advancedEngine.removeMatchUpdateListener(
						transitionEffectMatcher, transitionEffectListener);

				return true;
			}

		};

	}
}