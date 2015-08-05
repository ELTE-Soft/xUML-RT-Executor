package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ExitPointMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.exitPoint pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExitPointProcessor implements IMatchProcessor<ExitPointMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final Pseudostate pPseudostate);
  
  @Override
  public void process(final ExitPointMatch match) {
    process(match.getPseudostate());
  }
}
