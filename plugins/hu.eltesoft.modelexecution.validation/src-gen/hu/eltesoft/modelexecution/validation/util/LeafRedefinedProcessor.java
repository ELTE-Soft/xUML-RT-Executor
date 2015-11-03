package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.LeafRedefinedMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.RedefinableElement;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.LeafRedefined pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LeafRedefinedProcessor implements IMatchProcessor<LeafRedefinedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pElem the value of pattern parameter elem in the currently processed match
   * @param pRedefining the value of pattern parameter redefining in the currently processed match
   * 
   */
  public abstract void process(final RedefinableElement pElem, final RedefinableElement pRedefining);
  
  @Override
  public void process(final LeafRedefinedMatch match) {
    process(match.getElem(), match.getRedefining());
  }
}
