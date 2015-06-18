package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeLowerBoundProcessor implements IMatchProcessor<SignalAttributeLowerBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * @param pLowerBound the value of pattern parameter lowerBound in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound);
  
  @Override
  public void process(final SignalAttributeLowerBoundMatch match) {
    process(match.getSignal(), match.getAttribute(), match.getLowerBound());
    
  }
}
