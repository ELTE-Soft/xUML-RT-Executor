package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.FinalStateWithExitActionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.FinalState;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.FinalStateWithExitAction pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FinalStateWithExitActionProcessor implements IMatchProcessor<FinalStateWithExitActionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSt the value of pattern parameter st in the currently processed match
   * 
   */
  public abstract void process(final FinalState pSt);
  
  @Override
  public void process(final FinalStateWithExitActionMatch match) {
    process(match.getSt());
  }
}
