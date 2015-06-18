package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
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
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pOrdered the value of pattern parameter ordered in the currently processed match
   * @param pUnique the value of pattern parameter unique in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique);
  
  @Override
  public void process(final BehaviorReturnTypeMatch match) {
    process(match.getBehavior(), match.getParameter(), match.getType(), match.getOrdered(), match.getUnique());
    
  }
}
