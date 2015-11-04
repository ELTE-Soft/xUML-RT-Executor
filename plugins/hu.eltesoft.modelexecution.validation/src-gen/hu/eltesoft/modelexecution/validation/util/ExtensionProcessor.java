package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExtensionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.Extension pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExtensionProcessor implements IMatchProcessor<ExtensionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pElem);
  
  @Override
  public void process(final ExtensionMatch match) {
    process(match.getElem());
  }
}
