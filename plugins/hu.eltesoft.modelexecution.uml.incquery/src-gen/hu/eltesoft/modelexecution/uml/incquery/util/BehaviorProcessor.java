package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Behavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorProcessor implements IMatchProcessor<BehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pBehaviorName the value of pattern parameter behaviorName in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final String pBehaviorName);
  
  @Override
  public void process(final BehaviorMatch match) {
    process(match.getBehavior(), match.getBehaviorName());
    
  }
}
