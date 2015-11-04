package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValidMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValid pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityOperationParameterTypeNotValidProcessor implements IMatchProcessor<ExternalEntityOperationParameterTypeNotValidMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPm the value of pattern parameter pm in the currently processed match
   * 
   */
  public abstract void process(final Parameter pPm);
  
  @Override
  public void process(final ExternalEntityOperationParameterTypeNotValidMatch match) {
    process(match.getPm());
  }
}
