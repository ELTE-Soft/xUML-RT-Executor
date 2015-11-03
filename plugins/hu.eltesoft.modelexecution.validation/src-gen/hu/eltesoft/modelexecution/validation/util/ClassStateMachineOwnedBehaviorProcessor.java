package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassStateMachineOwnedBehaviorProcessor implements IMatchProcessor<ClassStateMachineOwnedBehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBeh the value of pattern parameter beh in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pBeh);
  
  @Override
  public void process(final ClassStateMachineOwnedBehaviorMatch match) {
    process(match.getBeh());
  }
}
