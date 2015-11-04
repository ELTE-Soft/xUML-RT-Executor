package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSameMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSame pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedAndRedefiningParametersMustBeTheSameProcessor implements IMatchProcessor<RedefinedAndRedefiningParametersMustBeTheSameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRedefined the value of pattern parameter redefined in the currently processed match
   * @param pRedefiner the value of pattern parameter redefiner in the currently processed match
   * 
   */
  public abstract void process(final Operation pRedefined, final Operation pRedefiner);
  
  @Override
  public void process(final RedefinedAndRedefiningParametersMustBeTheSameMatch match) {
    process(match.getRedefined(), match.getRedefiner());
  }
}
