package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.SignalAttributeType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeTypeProcessor implements IMatchProcessor<SignalAttributeTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final Property pAttribute, final Type pType);
  
  @Override
  public void process(final SignalAttributeTypeMatch match) {
    process(match.getSignal(), match.getAttribute(), match.getType());
    
  }
}
