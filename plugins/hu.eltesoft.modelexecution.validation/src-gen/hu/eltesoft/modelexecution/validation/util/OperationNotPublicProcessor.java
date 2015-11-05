package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.OperationNotPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.OperationNotPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OperationNotPublicProcessor implements IMatchProcessor<OperationNotPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOp the value of pattern parameter op in the currently processed match
   * 
   */
  public abstract void process(final Operation pOp);
  
  @Override
  public void process(final OperationNotPublicMatch match) {
    process(match.getOp());
  }
}