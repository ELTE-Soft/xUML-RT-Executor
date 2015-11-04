package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.TransitionRedefinesAnotherMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.TransitionRedefinesAnother pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionRedefinesAnotherProcessor implements IMatchProcessor<TransitionRedefinesAnotherMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTr the value of pattern parameter tr in the currently processed match
   * 
   */
  public abstract void process(final Transition pTr);
  
  @Override
  public void process(final TransitionRedefinesAnotherMatch match) {
    process(match.getTr());
  }
}
