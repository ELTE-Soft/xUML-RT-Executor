package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.UnrecognizedElementInClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.UnrecognizedElementInClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UnrecognizedElementInClassProcessor implements IMatchProcessor<UnrecognizedElementInClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl the value of pattern parameter cl in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl, final Element pElem);
  
  @Override
  public void process(final UnrecognizedElementInClassMatch match) {
    process(match.getCl(), match.getElem());
  }
}
