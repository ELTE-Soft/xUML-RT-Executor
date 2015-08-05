package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ChildInitialPointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.childInitialPoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildInitialPointProcessor implements IMatchProcessor<ChildInitialPointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pState the value of pattern parameter state in the currently processed match
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final State pState, final Pseudostate pPseudostate);
  
  @Override
  public void process(final ChildInitialPointMatch match) {
    process(match.getState(), match.getPseudostate());
  }
}
