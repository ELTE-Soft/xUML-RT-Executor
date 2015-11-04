package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.AbstractSignalMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.AbstractSignal pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AbstractSignalProcessor implements IMatchProcessor<AbstractSignalMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSg the value of pattern parameter sg in the currently processed match
   * 
   */
  public abstract void process(final Signal pSg);
  
  @Override
  public void process(final AbstractSignalMatch match) {
    process(match.getSg());
  }
}
