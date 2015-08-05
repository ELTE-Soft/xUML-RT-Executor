package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelCompositeStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.toplevelCompositeState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelCompositeStateProcessor implements IMatchProcessor<ToplevelCompositeStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStateMachine the value of pattern parameter stateMachine in the currently processed match
   * @param pState the value of pattern parameter state in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pStateMachine, final State pState);
  
  @Override
  public void process(final ToplevelCompositeStateMatch match) {
    process(match.getStateMachine(), match.getState());
  }
}
