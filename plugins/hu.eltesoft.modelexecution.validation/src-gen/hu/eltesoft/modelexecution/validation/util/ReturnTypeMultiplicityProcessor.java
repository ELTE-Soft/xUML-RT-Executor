package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicityMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicity pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReturnTypeMultiplicityProcessor implements IMatchProcessor<ReturnTypeMultiplicityMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParam the value of pattern parameter param in the currently processed match
   * 
   */
  public abstract void process(final Parameter pParam);
  
  @Override
  public void process(final ReturnTypeMultiplicityMatch match) {
    process(match.getParam());
  }
}
