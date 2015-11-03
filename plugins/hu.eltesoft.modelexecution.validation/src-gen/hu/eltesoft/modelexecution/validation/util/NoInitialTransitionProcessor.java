package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.NoInitialTransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.NoInitialTransition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NoInitialTransitionProcessor implements IMatchProcessor<NoInitialTransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSrc the value of pattern parameter src in the currently processed match
   * 
   */
  public abstract void process(final Pseudostate pSrc);
  
  @Override
  public void process(final NoInitialTransitionMatch match) {
    process(match.getSrc());
  }
}
