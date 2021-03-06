package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.SignalPropertyNotPrimitiveMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.SignalPropertyNotPrimitive pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalPropertyNotPrimitiveProcessor implements IMatchProcessor<SignalPropertyNotPrimitiveMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSg the value of pattern parameter sg in the currently processed match
   * @param pProp the value of pattern parameter prop in the currently processed match
   * 
   */
  public abstract void process(final Signal pSg, final Property pProp);
  
  @Override
  public void process(final SignalPropertyNotPrimitiveMatch match) {
    process(match.getSg(), match.getProp());
  }
}
