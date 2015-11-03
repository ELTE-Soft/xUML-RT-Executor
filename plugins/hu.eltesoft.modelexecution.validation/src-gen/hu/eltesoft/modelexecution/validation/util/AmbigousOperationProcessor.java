package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.AmbigousOperationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.AmbigousOperation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AmbigousOperationProcessor implements IMatchProcessor<AmbigousOperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl the value of pattern parameter cl in the currently processed match
   * @param pOverridden the value of pattern parameter overridden in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden);
  
  @Override
  public void process(final AmbigousOperationMatch match) {
    process(match.getCl(), match.getOverridden());
  }
}
