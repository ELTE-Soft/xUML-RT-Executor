package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.StateWithDeferrableTriggerMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.StateWithDeferrableTrigger pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateWithDeferrableTriggerProcessor implements IMatchProcessor<StateWithDeferrableTriggerMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSt the value of pattern parameter st in the currently processed match
   * 
   */
  public abstract void process(final State pSt);
  
  @Override
  public void process(final StateWithDeferrableTriggerMatch match) {
    process(match.getSt());
  }
}
