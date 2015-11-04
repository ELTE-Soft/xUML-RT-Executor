package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.SignalElementMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.SignalElement pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalElementProcessor implements IMatchProcessor<SignalElementMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Element pElem);
  
  @Override
  public void process(final SignalElementMatch match) {
    process(match.getElem());
  }
}
