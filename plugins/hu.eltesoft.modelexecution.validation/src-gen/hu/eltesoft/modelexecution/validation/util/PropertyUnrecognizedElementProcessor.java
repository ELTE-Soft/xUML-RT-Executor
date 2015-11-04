package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.PropertyUnrecognizedElementMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.PropertyUnrecognizedElement pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyUnrecognizedElementProcessor implements IMatchProcessor<PropertyUnrecognizedElementMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPr the value of pattern parameter pr in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Property pPr, final Element pElem);
  
  @Override
  public void process(final PropertyUnrecognizedElementMatch match) {
    process(match.getPr(), match.getElem());
  }
}
