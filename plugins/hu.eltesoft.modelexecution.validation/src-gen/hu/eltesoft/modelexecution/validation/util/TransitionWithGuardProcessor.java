package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.TransitionWithGuardMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.TransitionWithGuard pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionWithGuardProcessor implements IMatchProcessor<TransitionWithGuardMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTr the value of pattern parameter tr in the currently processed match
   * 
   */
  public abstract void process(final Transition pTr);
  
  @Override
  public void process(final TransitionWithGuardMatch match) {
    process(match.getTr());
  }
}
