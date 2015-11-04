package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ActiveStateMachineMatcher;
import hu.eltesoft.modelexecution.validation.EventWithoutReceptionMatcher;
import hu.eltesoft.modelexecution.validation.FinalStateWithEntryActionMatcher;
import hu.eltesoft.modelexecution.validation.FinalStateWithExitActionMatcher;
import hu.eltesoft.modelexecution.validation.ForbiddenRegionMemberMatcher;
import hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMemberMatcher;
import hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.InitialTransitionWithTriggerMatcher;
import hu.eltesoft.modelexecution.validation.MultipleInitialStateMatcher;
import hu.eltesoft.modelexecution.validation.MultipleInitialTransitionsMatcher;
import hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEventMatcher;
import hu.eltesoft.modelexecution.validation.NoInitialTransitionMatcher;
import hu.eltesoft.modelexecution.validation.NonExternalTransitionMatcher;
import hu.eltesoft.modelexecution.validation.NonPublicStateMachineMatcher;
import hu.eltesoft.modelexecution.validation.NonReentrantStateMachineMatcher;
import hu.eltesoft.modelexecution.validation.RegionNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.RegionWithoutInitialStateMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegionMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegionMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineRedefineBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineWithClassifierBehaviorMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineWithSpecificationMatcher;
import hu.eltesoft.modelexecution.validation.StateMachineWithSubmachineStateMatcher;
import hu.eltesoft.modelexecution.validation.StateMustBePublicMatcher;
import hu.eltesoft.modelexecution.validation.StateRedefineAnotherMatcher;
import hu.eltesoft.modelexecution.validation.StateWithDeferrableTriggerMatcher;
import hu.eltesoft.modelexecution.validation.StateWithDoActivityMatcher;
import hu.eltesoft.modelexecution.validation.StateWithInvariantMatcher;
import hu.eltesoft.modelexecution.validation.StateWithSubmachineMatcher;
import hu.eltesoft.modelexecution.validation.TransitionNotPublicMatcher;
import hu.eltesoft.modelexecution.validation.TransitionRedefinesAnotherMatcher;
import hu.eltesoft.modelexecution.validation.TransitionSourceUnknownMatcher;
import hu.eltesoft.modelexecution.validation.TransitionTargetUnknownMatcher;
import hu.eltesoft.modelexecution.validation.TransitionWithGuardMatcher;
import hu.eltesoft.modelexecution.validation.TransitionWithoutEventMatcher;
import hu.eltesoft.modelexecution.validation.UnreachableStateMatcher;
import hu.eltesoft.modelexecution.validation.util.ActiveStateMachineQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.EventWithoutReceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.FinalStateWithEntryActionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.FinalStateWithExitActionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ForbiddenRegionMemberQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ForbiddenStateMachineMemberQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.InitialPseudostateNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.InitialTransitionWithTriggerQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MultipleInitialStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MultipleInitialTransitionsQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.MultipleTransitionsWithAnEventQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NoInitialTransitionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NonExternalTransitionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NonPublicStateMachineQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.NonReentrantStateMachineQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RegionNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RegionWithoutInitialStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineMustHaveOneRegionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineMustHaveRegionQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineRedefineBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineWithClassifierBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineWithSpecificationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineWithSubmachineStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMustBePublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateRedefineAnotherQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateWithDeferrableTriggerQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateWithDoActivityQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateWithInvariantQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateWithSubmachineQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionNotPublicQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionRedefinesAnotherQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionSourceUnknownQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionTargetUnknownQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionWithGuardQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.TransitionWithoutEventQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UnreachableStateQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in StateMachine.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file StateMachine.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>StateMachineMustHaveRegion</li>
 * <li>StateMachineMustHaveOneRegion</li>
 * <li>StateMachineRegion</li>
 * <li>ForbiddenStateMachineMember</li>
 * <li>ActiveStateMachine</li>
 * <li>NonReentrantStateMachine</li>
 * <li>NonPublicStateMachine</li>
 * <li>StateMachineWithSpecification</li>
 * <li>StateMachineWithClassifierBehavior</li>
 * <li>StateMachineRedefineBehavior</li>
 * <li>StateMachineWithSubmachineState</li>
 * <li>RegionNotPublic</li>
 * <li>ForbiddenRegionMember</li>
 * <li>Transition</li>
 * <li>RegionWithoutInitialState</li>
 * <li>MultipleInitialState</li>
 * <li>InitialState</li>
 * <li>StateMustBePublic</li>
 * <li>StateWithInvariant</li>
 * <li>StateWithDoActivity</li>
 * <li>StateWithSubmachine</li>
 * <li>StateWithDeferrableTrigger</li>
 * <li>StateRedefineAnother</li>
 * <li>UnreachableState</li>
 * <li>ReachableState</li>
 * <li>TransitionStep</li>
 * <li>InitialPseudostateNotPublic</li>
 * <li>NoInitialTransition</li>
 * <li>MultipleInitialTransitions</li>
 * <li>InitialTransitionWithTrigger</li>
 * <li>InitialTransition</li>
 * <li>FinalStateWithEntryAction</li>
 * <li>FinalStateWithExitAction</li>
 * <li>TransitionSourceUnknown</li>
 * <li>TransitionSource</li>
 * <li>MultipleTransitionsWithAnEvent</li>
 * <li>TransitionTargetUnknown</li>
 * <li>TransitionTarget</li>
 * <li>TransitionWithoutEvent</li>
 * <li>EventWithoutReception</li>
 * <li>TransitionEvent</li>
 * <li>TransitionNotPublic</li>
 * <li>NonExternalTransition</li>
 * <li>TransitionWithGuard</li>
 * <li>TransitionRedefinesAnother</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class StateMachine extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static StateMachine instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new StateMachine();
    }
    return INSTANCE;
  }
  
  private static StateMachine INSTANCE;
  
  private StateMachine() throws IncQueryException {
    querySpecifications.add(StateMachineMustHaveRegionQuerySpecification.instance());
    querySpecifications.add(StateMachineMustHaveOneRegionQuerySpecification.instance());
    querySpecifications.add(ForbiddenStateMachineMemberQuerySpecification.instance());
    querySpecifications.add(ActiveStateMachineQuerySpecification.instance());
    querySpecifications.add(NonReentrantStateMachineQuerySpecification.instance());
    querySpecifications.add(NonPublicStateMachineQuerySpecification.instance());
    querySpecifications.add(StateMachineWithSpecificationQuerySpecification.instance());
    querySpecifications.add(StateMachineWithClassifierBehaviorQuerySpecification.instance());
    querySpecifications.add(StateMachineRedefineBehaviorQuerySpecification.instance());
    querySpecifications.add(StateMachineWithSubmachineStateQuerySpecification.instance());
    querySpecifications.add(RegionNotPublicQuerySpecification.instance());
    querySpecifications.add(ForbiddenRegionMemberQuerySpecification.instance());
    querySpecifications.add(RegionWithoutInitialStateQuerySpecification.instance());
    querySpecifications.add(MultipleInitialStateQuerySpecification.instance());
    querySpecifications.add(StateMustBePublicQuerySpecification.instance());
    querySpecifications.add(StateWithInvariantQuerySpecification.instance());
    querySpecifications.add(StateWithDoActivityQuerySpecification.instance());
    querySpecifications.add(StateWithSubmachineQuerySpecification.instance());
    querySpecifications.add(StateWithDeferrableTriggerQuerySpecification.instance());
    querySpecifications.add(StateRedefineAnotherQuerySpecification.instance());
    querySpecifications.add(UnreachableStateQuerySpecification.instance());
    querySpecifications.add(InitialPseudostateNotPublicQuerySpecification.instance());
    querySpecifications.add(NoInitialTransitionQuerySpecification.instance());
    querySpecifications.add(MultipleInitialTransitionsQuerySpecification.instance());
    querySpecifications.add(InitialTransitionWithTriggerQuerySpecification.instance());
    querySpecifications.add(FinalStateWithEntryActionQuerySpecification.instance());
    querySpecifications.add(FinalStateWithExitActionQuerySpecification.instance());
    querySpecifications.add(TransitionSourceUnknownQuerySpecification.instance());
    querySpecifications.add(MultipleTransitionsWithAnEventQuerySpecification.instance());
    querySpecifications.add(TransitionTargetUnknownQuerySpecification.instance());
    querySpecifications.add(TransitionWithoutEventQuerySpecification.instance());
    querySpecifications.add(EventWithoutReceptionQuerySpecification.instance());
    querySpecifications.add(TransitionNotPublicQuerySpecification.instance());
    querySpecifications.add(NonExternalTransitionQuerySpecification.instance());
    querySpecifications.add(TransitionWithGuardQuerySpecification.instance());
    querySpecifications.add(TransitionRedefinesAnotherQuerySpecification.instance());
  }
  
  public StateMachineMustHaveRegionQuerySpecification getStateMachineMustHaveRegion() throws IncQueryException {
    return StateMachineMustHaveRegionQuerySpecification.instance();
  }
  
  public StateMachineMustHaveRegionMatcher getStateMachineMustHaveRegion(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMustHaveRegionMatcher.on(engine);
  }
  
  public StateMachineMustHaveOneRegionQuerySpecification getStateMachineMustHaveOneRegion() throws IncQueryException {
    return StateMachineMustHaveOneRegionQuerySpecification.instance();
  }
  
  public StateMachineMustHaveOneRegionMatcher getStateMachineMustHaveOneRegion(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMustHaveOneRegionMatcher.on(engine);
  }
  
  public ForbiddenStateMachineMemberQuerySpecification getForbiddenStateMachineMember() throws IncQueryException {
    return ForbiddenStateMachineMemberQuerySpecification.instance();
  }
  
  public ForbiddenStateMachineMemberMatcher getForbiddenStateMachineMember(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenStateMachineMemberMatcher.on(engine);
  }
  
  public ActiveStateMachineQuerySpecification getActiveStateMachine() throws IncQueryException {
    return ActiveStateMachineQuerySpecification.instance();
  }
  
  public ActiveStateMachineMatcher getActiveStateMachine(final IncQueryEngine engine) throws IncQueryException {
    return ActiveStateMachineMatcher.on(engine);
  }
  
  public NonReentrantStateMachineQuerySpecification getNonReentrantStateMachine() throws IncQueryException {
    return NonReentrantStateMachineQuerySpecification.instance();
  }
  
  public NonReentrantStateMachineMatcher getNonReentrantStateMachine(final IncQueryEngine engine) throws IncQueryException {
    return NonReentrantStateMachineMatcher.on(engine);
  }
  
  public NonPublicStateMachineQuerySpecification getNonPublicStateMachine() throws IncQueryException {
    return NonPublicStateMachineQuerySpecification.instance();
  }
  
  public NonPublicStateMachineMatcher getNonPublicStateMachine(final IncQueryEngine engine) throws IncQueryException {
    return NonPublicStateMachineMatcher.on(engine);
  }
  
  public StateMachineWithSpecificationQuerySpecification getStateMachineWithSpecification() throws IncQueryException {
    return StateMachineWithSpecificationQuerySpecification.instance();
  }
  
  public StateMachineWithSpecificationMatcher getStateMachineWithSpecification(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineWithSpecificationMatcher.on(engine);
  }
  
  public StateMachineWithClassifierBehaviorQuerySpecification getStateMachineWithClassifierBehavior() throws IncQueryException {
    return StateMachineWithClassifierBehaviorQuerySpecification.instance();
  }
  
  public StateMachineWithClassifierBehaviorMatcher getStateMachineWithClassifierBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineWithClassifierBehaviorMatcher.on(engine);
  }
  
  public StateMachineRedefineBehaviorQuerySpecification getStateMachineRedefineBehavior() throws IncQueryException {
    return StateMachineRedefineBehaviorQuerySpecification.instance();
  }
  
  public StateMachineRedefineBehaviorMatcher getStateMachineRedefineBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineRedefineBehaviorMatcher.on(engine);
  }
  
  public StateMachineWithSubmachineStateQuerySpecification getStateMachineWithSubmachineState() throws IncQueryException {
    return StateMachineWithSubmachineStateQuerySpecification.instance();
  }
  
  public StateMachineWithSubmachineStateMatcher getStateMachineWithSubmachineState(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineWithSubmachineStateMatcher.on(engine);
  }
  
  public RegionNotPublicQuerySpecification getRegionNotPublic() throws IncQueryException {
    return RegionNotPublicQuerySpecification.instance();
  }
  
  public RegionNotPublicMatcher getRegionNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return RegionNotPublicMatcher.on(engine);
  }
  
  public ForbiddenRegionMemberQuerySpecification getForbiddenRegionMember() throws IncQueryException {
    return ForbiddenRegionMemberQuerySpecification.instance();
  }
  
  public ForbiddenRegionMemberMatcher getForbiddenRegionMember(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenRegionMemberMatcher.on(engine);
  }
  
  public RegionWithoutInitialStateQuerySpecification getRegionWithoutInitialState() throws IncQueryException {
    return RegionWithoutInitialStateQuerySpecification.instance();
  }
  
  public RegionWithoutInitialStateMatcher getRegionWithoutInitialState(final IncQueryEngine engine) throws IncQueryException {
    return RegionWithoutInitialStateMatcher.on(engine);
  }
  
  public MultipleInitialStateQuerySpecification getMultipleInitialState() throws IncQueryException {
    return MultipleInitialStateQuerySpecification.instance();
  }
  
  public MultipleInitialStateMatcher getMultipleInitialState(final IncQueryEngine engine) throws IncQueryException {
    return MultipleInitialStateMatcher.on(engine);
  }
  
  public StateMustBePublicQuerySpecification getStateMustBePublic() throws IncQueryException {
    return StateMustBePublicQuerySpecification.instance();
  }
  
  public StateMustBePublicMatcher getStateMustBePublic(final IncQueryEngine engine) throws IncQueryException {
    return StateMustBePublicMatcher.on(engine);
  }
  
  public StateWithInvariantQuerySpecification getStateWithInvariant() throws IncQueryException {
    return StateWithInvariantQuerySpecification.instance();
  }
  
  public StateWithInvariantMatcher getStateWithInvariant(final IncQueryEngine engine) throws IncQueryException {
    return StateWithInvariantMatcher.on(engine);
  }
  
  public StateWithDoActivityQuerySpecification getStateWithDoActivity() throws IncQueryException {
    return StateWithDoActivityQuerySpecification.instance();
  }
  
  public StateWithDoActivityMatcher getStateWithDoActivity(final IncQueryEngine engine) throws IncQueryException {
    return StateWithDoActivityMatcher.on(engine);
  }
  
  public StateWithSubmachineQuerySpecification getStateWithSubmachine() throws IncQueryException {
    return StateWithSubmachineQuerySpecification.instance();
  }
  
  public StateWithSubmachineMatcher getStateWithSubmachine(final IncQueryEngine engine) throws IncQueryException {
    return StateWithSubmachineMatcher.on(engine);
  }
  
  public StateWithDeferrableTriggerQuerySpecification getStateWithDeferrableTrigger() throws IncQueryException {
    return StateWithDeferrableTriggerQuerySpecification.instance();
  }
  
  public StateWithDeferrableTriggerMatcher getStateWithDeferrableTrigger(final IncQueryEngine engine) throws IncQueryException {
    return StateWithDeferrableTriggerMatcher.on(engine);
  }
  
  public StateRedefineAnotherQuerySpecification getStateRedefineAnother() throws IncQueryException {
    return StateRedefineAnotherQuerySpecification.instance();
  }
  
  public StateRedefineAnotherMatcher getStateRedefineAnother(final IncQueryEngine engine) throws IncQueryException {
    return StateRedefineAnotherMatcher.on(engine);
  }
  
  public UnreachableStateQuerySpecification getUnreachableState() throws IncQueryException {
    return UnreachableStateQuerySpecification.instance();
  }
  
  public UnreachableStateMatcher getUnreachableState(final IncQueryEngine engine) throws IncQueryException {
    return UnreachableStateMatcher.on(engine);
  }
  
  public InitialPseudostateNotPublicQuerySpecification getInitialPseudostateNotPublic() throws IncQueryException {
    return InitialPseudostateNotPublicQuerySpecification.instance();
  }
  
  public InitialPseudostateNotPublicMatcher getInitialPseudostateNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return InitialPseudostateNotPublicMatcher.on(engine);
  }
  
  public NoInitialTransitionQuerySpecification getNoInitialTransition() throws IncQueryException {
    return NoInitialTransitionQuerySpecification.instance();
  }
  
  public NoInitialTransitionMatcher getNoInitialTransition(final IncQueryEngine engine) throws IncQueryException {
    return NoInitialTransitionMatcher.on(engine);
  }
  
  public MultipleInitialTransitionsQuerySpecification getMultipleInitialTransitions() throws IncQueryException {
    return MultipleInitialTransitionsQuerySpecification.instance();
  }
  
  public MultipleInitialTransitionsMatcher getMultipleInitialTransitions(final IncQueryEngine engine) throws IncQueryException {
    return MultipleInitialTransitionsMatcher.on(engine);
  }
  
  public InitialTransitionWithTriggerQuerySpecification getInitialTransitionWithTrigger() throws IncQueryException {
    return InitialTransitionWithTriggerQuerySpecification.instance();
  }
  
  public InitialTransitionWithTriggerMatcher getInitialTransitionWithTrigger(final IncQueryEngine engine) throws IncQueryException {
    return InitialTransitionWithTriggerMatcher.on(engine);
  }
  
  public FinalStateWithEntryActionQuerySpecification getFinalStateWithEntryAction() throws IncQueryException {
    return FinalStateWithEntryActionQuerySpecification.instance();
  }
  
  public FinalStateWithEntryActionMatcher getFinalStateWithEntryAction(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateWithEntryActionMatcher.on(engine);
  }
  
  public FinalStateWithExitActionQuerySpecification getFinalStateWithExitAction() throws IncQueryException {
    return FinalStateWithExitActionQuerySpecification.instance();
  }
  
  public FinalStateWithExitActionMatcher getFinalStateWithExitAction(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateWithExitActionMatcher.on(engine);
  }
  
  public TransitionSourceUnknownQuerySpecification getTransitionSourceUnknown() throws IncQueryException {
    return TransitionSourceUnknownQuerySpecification.instance();
  }
  
  public TransitionSourceUnknownMatcher getTransitionSourceUnknown(final IncQueryEngine engine) throws IncQueryException {
    return TransitionSourceUnknownMatcher.on(engine);
  }
  
  public MultipleTransitionsWithAnEventQuerySpecification getMultipleTransitionsWithAnEvent() throws IncQueryException {
    return MultipleTransitionsWithAnEventQuerySpecification.instance();
  }
  
  public MultipleTransitionsWithAnEventMatcher getMultipleTransitionsWithAnEvent(final IncQueryEngine engine) throws IncQueryException {
    return MultipleTransitionsWithAnEventMatcher.on(engine);
  }
  
  public TransitionTargetUnknownQuerySpecification getTransitionTargetUnknown() throws IncQueryException {
    return TransitionTargetUnknownQuerySpecification.instance();
  }
  
  public TransitionTargetUnknownMatcher getTransitionTargetUnknown(final IncQueryEngine engine) throws IncQueryException {
    return TransitionTargetUnknownMatcher.on(engine);
  }
  
  public TransitionWithoutEventQuerySpecification getTransitionWithoutEvent() throws IncQueryException {
    return TransitionWithoutEventQuerySpecification.instance();
  }
  
  public TransitionWithoutEventMatcher getTransitionWithoutEvent(final IncQueryEngine engine) throws IncQueryException {
    return TransitionWithoutEventMatcher.on(engine);
  }
  
  public EventWithoutReceptionQuerySpecification getEventWithoutReception() throws IncQueryException {
    return EventWithoutReceptionQuerySpecification.instance();
  }
  
  public EventWithoutReceptionMatcher getEventWithoutReception(final IncQueryEngine engine) throws IncQueryException {
    return EventWithoutReceptionMatcher.on(engine);
  }
  
  public TransitionNotPublicQuerySpecification getTransitionNotPublic() throws IncQueryException {
    return TransitionNotPublicQuerySpecification.instance();
  }
  
  public TransitionNotPublicMatcher getTransitionNotPublic(final IncQueryEngine engine) throws IncQueryException {
    return TransitionNotPublicMatcher.on(engine);
  }
  
  public NonExternalTransitionQuerySpecification getNonExternalTransition() throws IncQueryException {
    return NonExternalTransitionQuerySpecification.instance();
  }
  
  public NonExternalTransitionMatcher getNonExternalTransition(final IncQueryEngine engine) throws IncQueryException {
    return NonExternalTransitionMatcher.on(engine);
  }
  
  public TransitionWithGuardQuerySpecification getTransitionWithGuard() throws IncQueryException {
    return TransitionWithGuardQuerySpecification.instance();
  }
  
  public TransitionWithGuardMatcher getTransitionWithGuard(final IncQueryEngine engine) throws IncQueryException {
    return TransitionWithGuardMatcher.on(engine);
  }
  
  public TransitionRedefinesAnotherQuerySpecification getTransitionRedefinesAnother() throws IncQueryException {
    return TransitionRedefinesAnotherQuerySpecification.instance();
  }
  
  public TransitionRedefinesAnotherMatcher getTransitionRedefinesAnother(final IncQueryEngine engine) throws IncQueryException {
    return TransitionRedefinesAnotherMatcher.on(engine);
  }
}
