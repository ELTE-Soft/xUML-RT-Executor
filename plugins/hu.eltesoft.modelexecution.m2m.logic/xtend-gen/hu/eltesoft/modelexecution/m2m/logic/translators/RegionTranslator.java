package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.region.RegionPackage;
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
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class RegionTranslator extends RootElementTranslator<Region, RgRegion, RegionMatch> {
  private final static RegionFactory FACTORY = RegionFactory.eINSTANCE;
  
  private final static RegionPackage PACKAGE = RegionPackage.eINSTANCE;
  
  public RegionTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  public RootNode<Region, RgRegion, RegionMatch> buildMapper(final IncQueryEngine engine) {
    try {
      RegionMatcher _on = RegionMatcher.on(engine);
      final Function<RegionMatch, RgRegion> _function = new Function<RegionMatch, RgRegion>() {
        public RgRegion apply(final RegionMatch it) {
          final RgRegion root = RegionTranslator.FACTORY.createRgRegion();
          Region _region = it.getRegion();
          NamedReference _namedReference = new NamedReference(_region);
          root.setReference(_namedReference);
          return root;
        }
      };
      final RootNode<Region, RgRegion, RegionMatch> rootNode = this.fromRoot(_on, _function);
      EAttribute _rgRegion_ContainerClass = RegionTranslator.PACKAGE.getRgRegion_ContainerClass();
      ContainerClassOfRegionMatcher _on_1 = ContainerClassOfRegionMatcher.on(engine);
      final Function<ContainerClassOfRegionMatch, NamedReference> _function_1 = new Function<ContainerClassOfRegionMatch, NamedReference>() {
        public NamedReference apply(final ContainerClassOfRegionMatch it) {
          org.eclipse.uml2.uml.Class _containerClass = it.getContainerClass();
          return new NamedReference(_containerClass);
        }
      };
      rootNode.<NamedReference, ContainerClassOfRegionMatch>on(_rgRegion_ContainerClass, _on_1, _function_1);
      final HashMap<State, RgState> stateMap = new HashMap<State, RgState>();
      EReference _rgRegion_States = RegionTranslator.PACKAGE.getRgRegion_States();
      StateMatcher _on_2 = StateMatcher.on(engine);
      final Function<StateMatch, RgState> _function_2 = new Function<StateMatch, RgState>() {
        public RgState apply(final StateMatch it) {
          final RgState newState = RegionTranslator.FACTORY.createRgState();
          State _state = it.getState();
          NamedReference _namedReference = new NamedReference(_state);
          newState.setReference(_namedReference);
          State _state_1 = it.getState();
          stateMap.put(_state_1, newState);
          return newState;
        }
      };
      final AbstractFeatureNode<RgState, StateMatch> stateNode = rootNode.<RgState, StateMatch>onEObject(_rgRegion_States, _on_2, _function_2);
      EAttribute _rgState_Entry = RegionTranslator.PACKAGE.getRgState_Entry();
      EntryMatcher _on_3 = EntryMatcher.on(engine);
      final Function<EntryMatch, NamedReference> _function_3 = new Function<EntryMatch, NamedReference>() {
        public NamedReference apply(final EntryMatch it) {
          Behavior _entry = it.getEntry();
          return new NamedReference(_entry);
        }
      };
      stateNode.<NamedReference, EntryMatch>on(_rgState_Entry, _on_3, _function_3);
      EAttribute _rgState_Exit = RegionTranslator.PACKAGE.getRgState_Exit();
      ExitMatcher _on_4 = ExitMatcher.on(engine);
      final Function<ExitMatch, NamedReference> _function_4 = new Function<ExitMatch, NamedReference>() {
        public NamedReference apply(final ExitMatch it) {
          Behavior _exit = it.getExit();
          return new NamedReference(_exit);
        }
      };
      stateNode.<NamedReference, ExitMatch>on(_rgState_Exit, _on_4, _function_4);
      EReference _rgState_Transitions = RegionTranslator.PACKAGE.getRgState_Transitions();
      TransitionMatcher _on_5 = TransitionMatcher.on(engine);
      final Function<TransitionMatch, RgTransition> _function_5 = new Function<TransitionMatch, RgTransition>() {
        public RgTransition apply(final TransitionMatch it) {
          final RgTransition rgTransition = RegionTranslator.FACTORY.createRgTransition();
          Transition _transition = it.getTransition();
          Reference _reference = new Reference(_transition);
          rgTransition.setReference(_reference);
          Signal _signal = it.getSignal();
          NamedReference _namedReference = new NamedReference(_signal);
          rgTransition.setMessage(_namedReference);
          Event _event = it.getEvent();
          NamedReference _namedReference_1 = new NamedReference(_event);
          rgTransition.setEvent(_namedReference_1);
          State _target = it.getTarget();
          RgState _get = stateMap.get(_target);
          rgTransition.setTarget(_get);
          return rgTransition;
        }
      };
      final AbstractFeatureNode<RgTransition, TransitionMatch> transitionNode = stateNode.<RgTransition, TransitionMatch>onEObject(_rgState_Transitions, _on_5, _function_5);
      EAttribute _rgTransition_Effect = RegionTranslator.PACKAGE.getRgTransition_Effect();
      TransitionEffectMatcher _on_6 = TransitionEffectMatcher.on(engine);
      final Function<TransitionEffectMatch, NamedReference> _function_6 = new Function<TransitionEffectMatch, NamedReference>() {
        public NamedReference apply(final TransitionEffectMatch it) {
          Behavior _effect = it.getEffect();
          return new NamedReference(_effect);
        }
      };
      transitionNode.<NamedReference, TransitionEffectMatch>on(_rgTransition_Effect, _on_6, _function_6);
      EReference _rgRegion_InitialPseudostate = RegionTranslator.PACKAGE.getRgRegion_InitialPseudostate();
      InitialsMatcher _on_7 = InitialsMatcher.on(engine);
      final Function<InitialsMatch, RgInitialPseudostate> _function_7 = new Function<InitialsMatch, RgInitialPseudostate>() {
        public RgInitialPseudostate apply(final InitialsMatch it) {
          final RgInitialPseudostate rgInitialPseudostate = RegionTranslator.FACTORY.createRgInitialPseudostate();
          Pseudostate _initPseudostate = it.getInitPseudostate();
          NamedReference _namedReference = new NamedReference(_initPseudostate);
          rgInitialPseudostate.setReference(_namedReference);
          final RgTransition rgTransition = RegionTranslator.FACTORY.createRgTransition();
          Transition _initTransition = it.getInitTransition();
          Reference _reference = new Reference(_initTransition);
          rgTransition.setReference(_reference);
          State _firstState = it.getFirstState();
          RgState _get = stateMap.get(_firstState);
          rgTransition.setTarget(_get);
          rgInitialPseudostate.setInitialTransition(rgTransition);
          return rgInitialPseudostate;
        }
      };
      rootNode.<RgInitialPseudostate, InitialsMatch>onEObject(_rgRegion_InitialPseudostate, _on_7, _function_7);
      return rootNode;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Template createTemplate(final RgRegion region) {
    return new RegionTemplate(region);
  }
}
