package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.BehaviorParameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorParameterProcessor implements IMatchProcessor<BehaviorParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pDirection the value of pattern parameter direction in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection);
  
  @Override
  public void process(final BehaviorParameterMatch match) {
    process(match.getBehavior(), match.getParameter(), match.getDirection());
    
  }
}
