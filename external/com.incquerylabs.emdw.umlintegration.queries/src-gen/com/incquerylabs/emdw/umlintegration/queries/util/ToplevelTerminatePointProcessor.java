package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelTerminatePointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.toplevelTerminatePoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelTerminatePointProcessor implements IMatchProcessor<ToplevelTerminatePointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStateMachine the value of pattern parameter stateMachine in the currently processed match
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pStateMachine, final Pseudostate pPseudostate);
  
  @Override
  public void process(final ToplevelTerminatePointMatch match) {
    process(match.getStateMachine(), match.getPseudostate());
  }
}
