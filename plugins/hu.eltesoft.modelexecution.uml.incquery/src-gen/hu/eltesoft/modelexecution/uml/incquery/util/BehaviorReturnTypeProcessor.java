package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorReturnTypeProcessor implements IMatchProcessor<BehaviorReturnTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final Type pType);
  
  @Override
  public void process(final BehaviorReturnTypeMatch match) {
    process(match.getBehavior(), match.getType());
    
  }
}
