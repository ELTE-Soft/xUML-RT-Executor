package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.StaticBehavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StaticBehaviorProcessor implements IMatchProcessor<StaticBehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior);
  
  @Override
  public void process(final StaticBehaviorMatch match) {
    process(match.getBehavior());
    
  }
}
