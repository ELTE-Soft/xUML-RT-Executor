package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ToplevelEntryPointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.toplevelEntryPoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ToplevelEntryPointProcessor implements IMatchProcessor<ToplevelEntryPointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStateMachine the value of pattern parameter stateMachine in the currently processed match
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pStateMachine, final Pseudostate pPseudostate);
  
  @Override
  public void process(final ToplevelEntryPointMatch match) {
    process(match.getStateMachine(), match.getPseudostate());
  }
}
