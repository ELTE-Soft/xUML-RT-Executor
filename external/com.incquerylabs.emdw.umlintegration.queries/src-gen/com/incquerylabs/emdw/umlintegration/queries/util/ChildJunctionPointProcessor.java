package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ChildJunctionPointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.childJunctionPoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildJunctionPointProcessor implements IMatchProcessor<ChildJunctionPointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pState the value of pattern parameter state in the currently processed match
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final State pState, final Pseudostate pPseudostate);
  
  @Override
  public void process(final ChildJunctionPointMatch match) {
    process(match.getState(), match.getPseudostate());
  }
}
