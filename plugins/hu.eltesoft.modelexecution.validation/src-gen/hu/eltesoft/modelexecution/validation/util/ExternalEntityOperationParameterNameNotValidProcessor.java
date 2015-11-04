package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValidMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValid pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityOperationParameterNameNotValidProcessor implements IMatchProcessor<ExternalEntityOperationParameterNameNotValidMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPm the value of pattern parameter pm in the currently processed match
   * 
   */
  public abstract void process(final Parameter pPm);
  
  @Override
  public void process(final ExternalEntityOperationParameterNameNotValidMatch match) {
    process(match.getPm());
  }
}
