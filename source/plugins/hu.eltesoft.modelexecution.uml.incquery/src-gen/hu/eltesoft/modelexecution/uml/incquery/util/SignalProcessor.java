package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Signal pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalProcessor implements IMatchProcessor<SignalMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal);
  
  @Override
  public void process(final SignalMatch match) {
    process(match.getSignal());
    
  }
}
