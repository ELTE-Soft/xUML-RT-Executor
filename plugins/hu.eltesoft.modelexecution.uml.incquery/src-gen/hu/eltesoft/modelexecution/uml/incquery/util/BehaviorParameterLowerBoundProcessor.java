package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorParameterLowerBoundProcessor implements IMatchProcessor<BehaviorParameterLowerBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pLowerBound the value of pattern parameter lowerBound in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ValueSpecification pLowerBound);
  
  @Override
  public void process(final BehaviorParameterLowerBoundMatch match) {
    process(match.getBehavior(), match.getParameter(), match.getType(), match.getLowerBound());
    
  }
}