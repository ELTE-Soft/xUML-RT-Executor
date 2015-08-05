package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelTransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.toplevelTransition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelTransitionProcessor implements IMatchProcessor<ToplevelTransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStateMachine the value of pattern parameter stateMachine in the currently processed match
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pSourceState the value of pattern parameter sourceState in the currently processed match
   * @param pTargetState the value of pattern parameter targetState in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pStateMachine, final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState);
  
  @Override
  public void process(final ToplevelTransitionMatch match) {
    process(match.getStateMachine(), match.getTransition(), match.getSourceState(), match.getTargetState());
  }
}
