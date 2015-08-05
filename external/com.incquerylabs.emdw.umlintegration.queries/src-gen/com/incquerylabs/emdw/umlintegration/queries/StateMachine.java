package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ActionChainMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildChoicePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildCompositeStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildDeepHistoryMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildEntryPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildExitPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildInitialPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildJunctionPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildSimpleStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildTerminatePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChildTransitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ChoicePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.CompositeStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.DeepHistoryMatcher;
import com.incquerylabs.emdw.umlintegration.queries.EntryPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ExitPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.GuardMatcher;
import com.incquerylabs.emdw.umlintegration.queries.InitialPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.JunctionPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.SignalWithReceptionInClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.SimpleStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StateEntryBehaviorMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StateExitBehaviorMatcher;
import com.incquerylabs.emdw.umlintegration.queries.StateMachineMatcher;
import com.incquerylabs.emdw.umlintegration.queries.TerminatePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelChoicePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelCompositeStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelDeepHistoryMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelEntryPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelExitPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelInitialPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelJunctionPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelSimpleStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelTerminatePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelTransitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.TransitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.UmlStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtEventTriggerMatcher;
import com.incquerylabs.emdw.umlintegration.queries.XtSignalEventMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ActionChainQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildChoicePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildCompositeStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildDeepHistoryQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildEntryPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildExitPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildInitialPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildJunctionPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildSimpleStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildTerminatePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildTransitionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ChoicePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.CompositeStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.DeepHistoryQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.EntryPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ExitPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.GuardQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.InitialPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.JunctionPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalWithReceptionInClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.SimpleStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StateEntryBehaviorQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StateExitBehaviorQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StateMachineQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TerminatePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelChoicePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelCompositeStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelDeepHistoryQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelEntryPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelExitPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelInitialPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelJunctionPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelSimpleStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelTerminatePointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelTransitionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TransitionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.UmlStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtEventTriggerQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtSignalEventQuerySpecification;
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
 * <p> From package com.incquerylabs.emdw.umlintegration.queries, the group contains the definition of the following patterns: <ul>
 * <li>stateMachine</li>
 * <li>initialPoint</li>
 * <li>toplevelInitialPoint</li>
 * <li>childInitialPoint</li>
 * <li>pseudostateOfRegion</li>
 * <li>terminatePoint</li>
 * <li>toplevelTerminatePoint</li>
 * <li>childTerminatePoint</li>
 * <li>choicePoint</li>
 * <li>toplevelChoicePoint</li>
 * <li>childChoicePoint</li>
 * <li>entryPoint</li>
 * <li>toplevelEntryPoint</li>
 * <li>childEntryPoint</li>
 * <li>exitPoint</li>
 * <li>toplevelExitPoint</li>
 * <li>childExitPoint</li>
 * <li>junctionPoint</li>
 * <li>toplevelJunctionPoint</li>
 * <li>childJunctionPoint</li>
 * <li>deepHistory</li>
 * <li>toplevelDeepHistory</li>
 * <li>childDeepHistory</li>
 * <li>simpleState</li>
 * <li>toplevelSimpleState</li>
 * <li>childSimpleState</li>
 * <li>compositeState</li>
 * <li>toplevelCompositeState</li>
 * <li>childCompositeState</li>
 * <li>region</li>
 * <li>transition</li>
 * <li>toplevelTransition</li>
 * <li>childTransition</li>
 * <li>transitionOfRegion</li>
 * <li>xtEventTrigger</li>
 * <li>transitionInStateMachine</li>
 * <li>subregion</li>
 * <li>triggerSignal</li>
 * <li>signalWithReceptionInClass</li>
 * <li>guard</li>
 * <li>actionChain</li>
 * <li>umlState</li>
 * <li>stateEntryBehavior</li>
 * <li>stateExitBehavior</li>
 * <li>xtSignalEvent</li>
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
    querySpecifications.add(StateMachineQuerySpecification.instance());
    querySpecifications.add(InitialPointQuerySpecification.instance());
    querySpecifications.add(ToplevelInitialPointQuerySpecification.instance());
    querySpecifications.add(ChildInitialPointQuerySpecification.instance());
    querySpecifications.add(TerminatePointQuerySpecification.instance());
    querySpecifications.add(ToplevelTerminatePointQuerySpecification.instance());
    querySpecifications.add(ChildTerminatePointQuerySpecification.instance());
    querySpecifications.add(ChoicePointQuerySpecification.instance());
    querySpecifications.add(ToplevelChoicePointQuerySpecification.instance());
    querySpecifications.add(ChildChoicePointQuerySpecification.instance());
    querySpecifications.add(EntryPointQuerySpecification.instance());
    querySpecifications.add(ToplevelEntryPointQuerySpecification.instance());
    querySpecifications.add(ChildEntryPointQuerySpecification.instance());
    querySpecifications.add(ExitPointQuerySpecification.instance());
    querySpecifications.add(ToplevelExitPointQuerySpecification.instance());
    querySpecifications.add(ChildExitPointQuerySpecification.instance());
    querySpecifications.add(JunctionPointQuerySpecification.instance());
    querySpecifications.add(ToplevelJunctionPointQuerySpecification.instance());
    querySpecifications.add(ChildJunctionPointQuerySpecification.instance());
    querySpecifications.add(DeepHistoryQuerySpecification.instance());
    querySpecifications.add(ToplevelDeepHistoryQuerySpecification.instance());
    querySpecifications.add(ChildDeepHistoryQuerySpecification.instance());
    querySpecifications.add(SimpleStateQuerySpecification.instance());
    querySpecifications.add(ToplevelSimpleStateQuerySpecification.instance());
    querySpecifications.add(ChildSimpleStateQuerySpecification.instance());
    querySpecifications.add(CompositeStateQuerySpecification.instance());
    querySpecifications.add(ToplevelCompositeStateQuerySpecification.instance());
    querySpecifications.add(ChildCompositeStateQuerySpecification.instance());
    querySpecifications.add(TransitionQuerySpecification.instance());
    querySpecifications.add(ToplevelTransitionQuerySpecification.instance());
    querySpecifications.add(ChildTransitionQuerySpecification.instance());
    querySpecifications.add(XtEventTriggerQuerySpecification.instance());
    querySpecifications.add(SignalWithReceptionInClassQuerySpecification.instance());
    querySpecifications.add(GuardQuerySpecification.instance());
    querySpecifications.add(ActionChainQuerySpecification.instance());
    querySpecifications.add(UmlStateQuerySpecification.instance());
    querySpecifications.add(StateEntryBehaviorQuerySpecification.instance());
    querySpecifications.add(StateExitBehaviorQuerySpecification.instance());
    querySpecifications.add(XtSignalEventQuerySpecification.instance());
  }
  
  public StateMachineQuerySpecification getStateMachine() throws IncQueryException {
    return StateMachineQuerySpecification.instance();
  }
  
  public StateMachineMatcher getStateMachine(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMatcher.on(engine);
  }
  
  public InitialPointQuerySpecification getInitialPoint() throws IncQueryException {
    return InitialPointQuerySpecification.instance();
  }
  
  public InitialPointMatcher getInitialPoint(final IncQueryEngine engine) throws IncQueryException {
    return InitialPointMatcher.on(engine);
  }
  
  public ToplevelInitialPointQuerySpecification getToplevelInitialPoint() throws IncQueryException {
    return ToplevelInitialPointQuerySpecification.instance();
  }
  
  public ToplevelInitialPointMatcher getToplevelInitialPoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelInitialPointMatcher.on(engine);
  }
  
  public ChildInitialPointQuerySpecification getChildInitialPoint() throws IncQueryException {
    return ChildInitialPointQuerySpecification.instance();
  }
  
  public ChildInitialPointMatcher getChildInitialPoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildInitialPointMatcher.on(engine);
  }
  
  public TerminatePointQuerySpecification getTerminatePoint() throws IncQueryException {
    return TerminatePointQuerySpecification.instance();
  }
  
  public TerminatePointMatcher getTerminatePoint(final IncQueryEngine engine) throws IncQueryException {
    return TerminatePointMatcher.on(engine);
  }
  
  public ToplevelTerminatePointQuerySpecification getToplevelTerminatePoint() throws IncQueryException {
    return ToplevelTerminatePointQuerySpecification.instance();
  }
  
  public ToplevelTerminatePointMatcher getToplevelTerminatePoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelTerminatePointMatcher.on(engine);
  }
  
  public ChildTerminatePointQuerySpecification getChildTerminatePoint() throws IncQueryException {
    return ChildTerminatePointQuerySpecification.instance();
  }
  
  public ChildTerminatePointMatcher getChildTerminatePoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildTerminatePointMatcher.on(engine);
  }
  
  public ChoicePointQuerySpecification getChoicePoint() throws IncQueryException {
    return ChoicePointQuerySpecification.instance();
  }
  
  public ChoicePointMatcher getChoicePoint(final IncQueryEngine engine) throws IncQueryException {
    return ChoicePointMatcher.on(engine);
  }
  
  public ToplevelChoicePointQuerySpecification getToplevelChoicePoint() throws IncQueryException {
    return ToplevelChoicePointQuerySpecification.instance();
  }
  
  public ToplevelChoicePointMatcher getToplevelChoicePoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelChoicePointMatcher.on(engine);
  }
  
  public ChildChoicePointQuerySpecification getChildChoicePoint() throws IncQueryException {
    return ChildChoicePointQuerySpecification.instance();
  }
  
  public ChildChoicePointMatcher getChildChoicePoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildChoicePointMatcher.on(engine);
  }
  
  public EntryPointQuerySpecification getEntryPoint() throws IncQueryException {
    return EntryPointQuerySpecification.instance();
  }
  
  public EntryPointMatcher getEntryPoint(final IncQueryEngine engine) throws IncQueryException {
    return EntryPointMatcher.on(engine);
  }
  
  public ToplevelEntryPointQuerySpecification getToplevelEntryPoint() throws IncQueryException {
    return ToplevelEntryPointQuerySpecification.instance();
  }
  
  public ToplevelEntryPointMatcher getToplevelEntryPoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelEntryPointMatcher.on(engine);
  }
  
  public ChildEntryPointQuerySpecification getChildEntryPoint() throws IncQueryException {
    return ChildEntryPointQuerySpecification.instance();
  }
  
  public ChildEntryPointMatcher getChildEntryPoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildEntryPointMatcher.on(engine);
  }
  
  public ExitPointQuerySpecification getExitPoint() throws IncQueryException {
    return ExitPointQuerySpecification.instance();
  }
  
  public ExitPointMatcher getExitPoint(final IncQueryEngine engine) throws IncQueryException {
    return ExitPointMatcher.on(engine);
  }
  
  public ToplevelExitPointQuerySpecification getToplevelExitPoint() throws IncQueryException {
    return ToplevelExitPointQuerySpecification.instance();
  }
  
  public ToplevelExitPointMatcher getToplevelExitPoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelExitPointMatcher.on(engine);
  }
  
  public ChildExitPointQuerySpecification getChildExitPoint() throws IncQueryException {
    return ChildExitPointQuerySpecification.instance();
  }
  
  public ChildExitPointMatcher getChildExitPoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildExitPointMatcher.on(engine);
  }
  
  public JunctionPointQuerySpecification getJunctionPoint() throws IncQueryException {
    return JunctionPointQuerySpecification.instance();
  }
  
  public JunctionPointMatcher getJunctionPoint(final IncQueryEngine engine) throws IncQueryException {
    return JunctionPointMatcher.on(engine);
  }
  
  public ToplevelJunctionPointQuerySpecification getToplevelJunctionPoint() throws IncQueryException {
    return ToplevelJunctionPointQuerySpecification.instance();
  }
  
  public ToplevelJunctionPointMatcher getToplevelJunctionPoint(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelJunctionPointMatcher.on(engine);
  }
  
  public ChildJunctionPointQuerySpecification getChildJunctionPoint() throws IncQueryException {
    return ChildJunctionPointQuerySpecification.instance();
  }
  
  public ChildJunctionPointMatcher getChildJunctionPoint(final IncQueryEngine engine) throws IncQueryException {
    return ChildJunctionPointMatcher.on(engine);
  }
  
  public DeepHistoryQuerySpecification getDeepHistory() throws IncQueryException {
    return DeepHistoryQuerySpecification.instance();
  }
  
  public DeepHistoryMatcher getDeepHistory(final IncQueryEngine engine) throws IncQueryException {
    return DeepHistoryMatcher.on(engine);
  }
  
  public ToplevelDeepHistoryQuerySpecification getToplevelDeepHistory() throws IncQueryException {
    return ToplevelDeepHistoryQuerySpecification.instance();
  }
  
  public ToplevelDeepHistoryMatcher getToplevelDeepHistory(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelDeepHistoryMatcher.on(engine);
  }
  
  public ChildDeepHistoryQuerySpecification getChildDeepHistory() throws IncQueryException {
    return ChildDeepHistoryQuerySpecification.instance();
  }
  
  public ChildDeepHistoryMatcher getChildDeepHistory(final IncQueryEngine engine) throws IncQueryException {
    return ChildDeepHistoryMatcher.on(engine);
  }
  
  public SimpleStateQuerySpecification getSimpleState() throws IncQueryException {
    return SimpleStateQuerySpecification.instance();
  }
  
  public SimpleStateMatcher getSimpleState(final IncQueryEngine engine) throws IncQueryException {
    return SimpleStateMatcher.on(engine);
  }
  
  public ToplevelSimpleStateQuerySpecification getToplevelSimpleState() throws IncQueryException {
    return ToplevelSimpleStateQuerySpecification.instance();
  }
  
  public ToplevelSimpleStateMatcher getToplevelSimpleState(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelSimpleStateMatcher.on(engine);
  }
  
  public ChildSimpleStateQuerySpecification getChildSimpleState() throws IncQueryException {
    return ChildSimpleStateQuerySpecification.instance();
  }
  
  public ChildSimpleStateMatcher getChildSimpleState(final IncQueryEngine engine) throws IncQueryException {
    return ChildSimpleStateMatcher.on(engine);
  }
  
  public CompositeStateQuerySpecification getCompositeState() throws IncQueryException {
    return CompositeStateQuerySpecification.instance();
  }
  
  public CompositeStateMatcher getCompositeState(final IncQueryEngine engine) throws IncQueryException {
    return CompositeStateMatcher.on(engine);
  }
  
  public ToplevelCompositeStateQuerySpecification getToplevelCompositeState() throws IncQueryException {
    return ToplevelCompositeStateQuerySpecification.instance();
  }
  
  public ToplevelCompositeStateMatcher getToplevelCompositeState(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelCompositeStateMatcher.on(engine);
  }
  
  public ChildCompositeStateQuerySpecification getChildCompositeState() throws IncQueryException {
    return ChildCompositeStateQuerySpecification.instance();
  }
  
  public ChildCompositeStateMatcher getChildCompositeState(final IncQueryEngine engine) throws IncQueryException {
    return ChildCompositeStateMatcher.on(engine);
  }
  
  public TransitionQuerySpecification getTransition() throws IncQueryException {
    return TransitionQuerySpecification.instance();
  }
  
  public TransitionMatcher getTransition(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  public ToplevelTransitionQuerySpecification getToplevelTransition() throws IncQueryException {
    return ToplevelTransitionQuerySpecification.instance();
  }
  
  public ToplevelTransitionMatcher getToplevelTransition(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelTransitionMatcher.on(engine);
  }
  
  public ChildTransitionQuerySpecification getChildTransition() throws IncQueryException {
    return ChildTransitionQuerySpecification.instance();
  }
  
  public ChildTransitionMatcher getChildTransition(final IncQueryEngine engine) throws IncQueryException {
    return ChildTransitionMatcher.on(engine);
  }
  
  public XtEventTriggerQuerySpecification getXtEventTrigger() throws IncQueryException {
    return XtEventTriggerQuerySpecification.instance();
  }
  
  public XtEventTriggerMatcher getXtEventTrigger(final IncQueryEngine engine) throws IncQueryException {
    return XtEventTriggerMatcher.on(engine);
  }
  
  public SignalWithReceptionInClassQuerySpecification getSignalWithReceptionInClass() throws IncQueryException {
    return SignalWithReceptionInClassQuerySpecification.instance();
  }
  
  public SignalWithReceptionInClassMatcher getSignalWithReceptionInClass(final IncQueryEngine engine) throws IncQueryException {
    return SignalWithReceptionInClassMatcher.on(engine);
  }
  
  public GuardQuerySpecification getGuard() throws IncQueryException {
    return GuardQuerySpecification.instance();
  }
  
  public GuardMatcher getGuard(final IncQueryEngine engine) throws IncQueryException {
    return GuardMatcher.on(engine);
  }
  
  public ActionChainQuerySpecification getActionChain() throws IncQueryException {
    return ActionChainQuerySpecification.instance();
  }
  
  public ActionChainMatcher getActionChain(final IncQueryEngine engine) throws IncQueryException {
    return ActionChainMatcher.on(engine);
  }
  
  public UmlStateQuerySpecification getUmlState() throws IncQueryException {
    return UmlStateQuerySpecification.instance();
  }
  
  public UmlStateMatcher getUmlState(final IncQueryEngine engine) throws IncQueryException {
    return UmlStateMatcher.on(engine);
  }
  
  public StateEntryBehaviorQuerySpecification getStateEntryBehavior() throws IncQueryException {
    return StateEntryBehaviorQuerySpecification.instance();
  }
  
  public StateEntryBehaviorMatcher getStateEntryBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StateEntryBehaviorMatcher.on(engine);
  }
  
  public StateExitBehaviorQuerySpecification getStateExitBehavior() throws IncQueryException {
    return StateExitBehaviorQuerySpecification.instance();
  }
  
  public StateExitBehaviorMatcher getStateExitBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StateExitBehaviorMatcher.on(engine);
  }
  
  public XtSignalEventQuerySpecification getXtSignalEvent() throws IncQueryException {
    return XtSignalEventQuerySpecification.instance();
  }
  
  public XtSignalEventMatcher getXtSignalEvent(final IncQueryEngine engine) throws IncQueryException {
    return XtSignalEventMatcher.on(engine);
  }
}
