package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LowBoundHigherThanHighBoundProcessor implements IMatchProcessor<LowBoundHigherThanHighBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMe the value of pattern parameter me in the currently processed match
   * 
   */
  public abstract void process(final MultiplicityElement pMe);
  
  @Override
  public void process(final LowBoundHigherThanHighBoundMatch match) {
    process(match.getMe());
  }
}
