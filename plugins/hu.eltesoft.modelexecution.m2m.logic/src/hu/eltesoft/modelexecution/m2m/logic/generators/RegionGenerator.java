package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversionTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;
import hu.eltesoft.modelexecution.m2t.java.templates.RegionTemplate;
import hu.eltesoft.modelexecution.m2t.smap.emf.Reference;
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

import java.util.HashMap;
import java.util.Map;

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

public class RegionGenerator extends
		AbstractGenerator<Region, RgRegion, RegionTemplate> {

	private static final RegionFactory FACTORY = RegionFactory.eINSTANCE;

	private final RegionMatcher regionMatcher;
	private final ContainerClassOfRegionMatcher containerMatcher;
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
		containerMatcher = ContainerClassOfRegionMatcher.on(engine);
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

	@Override
	public RgRegion generateTranslationModel(Region source)
			throws GenerationException {
		RgRegion root = FACTORY.createRgRegion();

		check(regionMatcher.forOneArbitraryMatch(source, match -> {
			Region pRegion = match.getRegion();
			root.setReference(new NamedReference(pRegion));
		}));

		check(containerMatcher.forOneArbitraryMatch(source, null, match -> {
			Class pContainerClass = match.getContainerClass();
			root.setContainerClass(new NamedReference(pContainerClass));
		}));

		// initialPseudoState, states
		new StatesGenerator(source, root).generate();

		return root;
	}

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
			// states without transitions
			stateMatcher.forEachMatch(source, null, match -> {
				manager.set(match.getState());
			});

			check(initialsMatcher.forOneArbitraryMatch(
					source,
					null,
					null,
					null,
					match -> {
						Pseudostate pInitState = match.getInitPseudostate();
						Transition pInitTransition = match.getInitTransition();
						State pFirstState = match.getFirstState();

						RgInitialPseudostate rgInitialPseudostate = FACTORY
								.createRgInitialPseudostate();

						// register initial to EObject -> container name mapping
						setContainerName(pInitState, root.getReference()
								.getIdentifier());

						// reference
						rgInitialPseudostate.setReference(new NamedReference(
								pInitState));

						// initialTransition
						rgInitialPseudostate
								.setInitialTransition(createTransition(
										pInitTransition, null, null,
										pFirstState));
						// Event is not set. Initial transition has no explicit
						// triggering event.

						root.setInitialPseudostate(rgInitialPseudostate);
					}));

			// add transitions to states
			transitionMatcher.forEachMatch(
					source,
					null,
					null,
					null,
					null,
					null,
					match -> {
						State pSource = match.getSource();
						Transition pTransition = match.getTransition();
						Event pEvent = match.getEvent();
						Signal pSignal = match.getSignal();
						State pTarget = match.getTarget();

						RgState rgState = manager.get(pSource);

						rgState.getTransitions().add(
								createTransition(pTransition, pEvent, pSignal,
										pTarget));
					});
		}

		private RgTransition createTransition(Transition transition,
				Event event, Signal signal, State target) {

			RgTransition rgTransition = FACTORY.createRgTransition();

			// register transition to EObject -> container name mapping
			setContainerName(transition, root.getReference().getIdentifier());

			rgTransition.setReference(new Reference(transition));

			// in case of any other than the initial transition
			if (signal != null) {
				rgTransition.setMessage(new NamedReference(signal));
			}

			// in case of any other than the initial transition
			if (event != null) {
				rgTransition.setEvent(new NamedReference(event));
			}

			transitionEffectMatcher.forOneArbitraryMatch(null, transition,
					null, match -> {
						Behavior pEffect = match.getEffect();
						rgTransition.setEffect(new NamedReference(pEffect));
					});

			rgTransition.setTarget(manager.get(target));

			return rgTransition;
		}

		private class StateManager {

			private final Map<State, RgState> map = new HashMap<>();

			void set(State state) {
				RgState rgState = FACTORY.createRgState();

				// register state to EObject -> container name mapping
				setContainerName(state, root.getReference().getIdentifier());

				rgState.setReference(new NamedReference(state));

				entryMatcher.forOneArbitraryMatch(null, state, null, match -> {
					Behavior pEntry = match.getEntry();
					rgState.setEntry(new NamedReference(pEntry));
				});

				exitMatcher.forOneArbitraryMatch(null, state, null, match -> {
					Behavior pExit = match.getExit();
					rgState.setExit(new NamedReference(pExit));
				});

				root.getStates().add(rgState);
				map.put(state, rgState);
			}

			RgState get(State state) {
				RgState rgState = map.get(state);
				check(rgState != null);
				return rgState;
			}
		}
	}

	@Override
	protected RegionTemplate createTemplate(RgRegion root) {
		return new RegionTemplate(root);
	};

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
						Region region = match.getRegion();
						String fileName = NamedReference.getIdentifier(region);
						changeRegistry.newDeletion(fileName);
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

				advancedEngine.addMatchUpdateListener(containerMatcher,
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
				advancedEngine.removeMatchUpdateListener(containerMatcher,
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
