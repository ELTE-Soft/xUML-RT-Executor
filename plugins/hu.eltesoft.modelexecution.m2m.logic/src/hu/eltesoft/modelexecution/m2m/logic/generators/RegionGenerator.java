package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.changeregistry.ChangeRegistry;
import hu.eltesoft.modelexecution.m2m.logic.listeners.MatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.listeners.RootMatchUpdateListener;
import hu.eltesoft.modelexecution.m2m.logic.tasks.ReversibleTask;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgInitialPseudostate;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgRegion;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgState;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RgTransition;
import hu.eltesoft.modelexecution.m2t.java.Template;
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
import java.util.function.Consumer;

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
import org.eclipse.xtext.xbase.lib.Pair;

public class RegionGenerator extends AbstractGenerator<Region> {

	private static final RegionFactory FACTORY = RegionFactory.eINSTANCE;

	private final RegionMatcher regionMatcher;
	private final ContainerClassOfRegionMatcher containerMatcher;
	private final InitialsMatcher initialsMatcher;
	private final StateMatcher stateMatcher;
	private final EntryMatcher entryMatcher;
	private final ExitMatcher exitMatcher;
	private final TransitionMatcher transitionMatcher;
	private final TransitionEffectMatcher transitionEffectMatcher;

	public RegionGenerator(IncQueryEngine engine) throws IncQueryException {
		regionMatcher = RegionMatcher.on(engine);
		containerMatcher = ContainerClassOfRegionMatcher.on(engine);
		initialsMatcher = InitialsMatcher.on(engine);
		stateMatcher = StateMatcher.on(engine);
		entryMatcher = EntryMatcher.on(engine);
		exitMatcher = ExitMatcher.on(engine);
		transitionMatcher = TransitionMatcher.on(engine);
		transitionEffectMatcher = TransitionEffectMatcher.on(engine);
	}

	@Override
	public Pair<String, Template> getTemplate(Region source)
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

		String rootName = NamedReference.getIdentifier(source);
		return new Pair<>(rootName, new RegionTemplate(root));
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
	public void runOn(Consumer<Region> task) {
		regionMatcher.forEachMatch((Region) null,
				match -> task.accept(match.getRegion()));
	}

	@Override
	public ReversibleTask addListeners(AdvancedIncQueryEngine engine,
			ChangeRegistry changeRegistry) {

		return new ReversibleTask() {

			private final IMatchUpdateListener<RegionMatch> regionListener;
			private final IMatchUpdateListener<ContainerClassOfRegionMatch> containerClassOfRegionListener;
			private final IMatchUpdateListener<InitialsMatch> initialsListener;
			private final IMatchUpdateListener<StateMatch> stateListener;
			private final IMatchUpdateListener<EntryMatch> entryListener;
			private final IMatchUpdateListener<ExitMatch> exitListener;
			private final IMatchUpdateListener<TransitionMatch> transitionListener;
			private final IMatchUpdateListener<TransitionEffectMatch> transitionEffectListener;

			{
				regionMatcher.forEachMatch((Region) null,
						match -> saveRootName(match.getRegion()));

				regionListener = new RootMatchUpdateListener<>(
						RegionGenerator.this, changeRegistry,
						match -> match.getRegion());

				engine.addMatchUpdateListener(regionMatcher, regionListener,
						false);
			}

			{
				containerClassOfRegionListener = new MatchUpdateListener<>(
						RegionGenerator.this, changeRegistry,
						match -> match.getRegion());

				engine.addMatchUpdateListener(containerMatcher,
						containerClassOfRegionListener, false);
			}

			{
				initialsListener = new MatchUpdateListener<>(
						RegionGenerator.this, changeRegistry,
						match -> match.getRegion());

				engine.addMatchUpdateListener(initialsMatcher,
						initialsListener, false);
			}

			{
				stateListener = new MatchUpdateListener<>(RegionGenerator.this,
						changeRegistry, match -> match.getRegion());

				engine.addMatchUpdateListener(stateMatcher, stateListener,
						false);
			}

			{
				entryListener = new MatchUpdateListener<>(RegionGenerator.this,
						changeRegistry, match -> match.getRegion());

				engine.addMatchUpdateListener(entryMatcher, entryListener,
						false);
			}

			{
				exitListener = new MatchUpdateListener<>(RegionGenerator.this,
						changeRegistry, match -> match.getRegion());

				engine.addMatchUpdateListener(exitMatcher, exitListener, false);
			}

			{
				transitionListener = new MatchUpdateListener<>(
						RegionGenerator.this, changeRegistry,
						match -> match.getRegion());

				engine.addMatchUpdateListener(transitionMatcher,
						transitionListener, false);
			}

			{
				transitionEffectListener = new MatchUpdateListener<>(
						RegionGenerator.this, changeRegistry,
						match -> match.getRegion());

				engine.addMatchUpdateListener(transitionEffectMatcher,
						transitionEffectListener, false);
			}

			@Override
			public boolean revert() {
				engine.removeMatchUpdateListener(regionMatcher, regionListener);
				engine.removeMatchUpdateListener(containerMatcher,
						containerClassOfRegionListener);
				engine.removeMatchUpdateListener(initialsMatcher,
						initialsListener);
				engine.removeMatchUpdateListener(stateMatcher, stateListener);
				engine.removeMatchUpdateListener(entryMatcher, entryListener);
				engine.removeMatchUpdateListener(exitMatcher, exitListener);
				engine.removeMatchUpdateListener(transitionMatcher,
						transitionListener);
				engine.removeMatchUpdateListener(transitionEffectMatcher,
						transitionEffectListener);
				return true;
			}
		};
	}
}
