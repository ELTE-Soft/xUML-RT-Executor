package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.DeepHistoryMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.deepHistory pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DeepHistoryProcessor implements IMatchProcessor<DeepHistoryMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPseudostate the value of pattern parameter pseudostate in the currently processed match
   * 
   */
  public abstract void process(final Pseudostate pPseudostate);
  
  @Override
  public void process(final DeepHistoryMatch match) {
    process(match.getPseudostate());
  }
}
