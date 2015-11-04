package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.StateMachineRedefineBehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.StateMachineRedefineBehavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineRedefineBehaviorProcessor implements IMatchProcessor<StateMachineRedefineBehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSm the value of pattern parameter sm in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pSm);
  
  @Override
  public void process(final StateMachineRedefineBehaviorMatch match) {
    process(match.getSm());
  }
}
