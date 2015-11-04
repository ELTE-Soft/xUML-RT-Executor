package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.TwoElementWithSameNameMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.TwoElementWithSameName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TwoElementWithSameNameProcessor implements IMatchProcessor<TwoElementWithSameNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pQname the value of pattern parameter qname in the currently processed match
   * @param pElem1 the value of pattern parameter elem1 in the currently processed match
   * @param pElem2 the value of pattern parameter elem2 in the currently processed match
   * 
   */
  public abstract void process(final String pQname, final NamedElement pElem1, final NamedElement pElem2);
  
  @Override
  public void process(final TwoElementWithSameNameMatch match) {
    process(match.getQname(), match.getElem1(), match.getElem2());
  }
}
