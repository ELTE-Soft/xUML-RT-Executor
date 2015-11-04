package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExternalEntityGeneralizedMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ExternalEntityGeneralized pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityGeneralizedProcessor implements IMatchProcessor<ExternalEntityGeneralizedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl the value of pattern parameter cl in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl);
  
  @Override
  public void process(final ExternalEntityGeneralizedMatch match) {
    process(match.getCl());
  }
}
