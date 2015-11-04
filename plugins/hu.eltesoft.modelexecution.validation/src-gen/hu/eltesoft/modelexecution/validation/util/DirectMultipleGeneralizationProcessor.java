package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.DirectMultipleGeneralizationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.DirectMultipleGeneralization pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DirectMultipleGeneralizationProcessor implements IMatchProcessor<DirectMultipleGeneralizationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSpec the value of pattern parameter spec in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pSpec);
  
  @Override
  public void process(final DirectMultipleGeneralizationMatch match) {
    process(match.getSpec());
  }
}
