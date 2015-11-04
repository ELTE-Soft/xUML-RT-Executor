package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.PropertyNotPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.PropertyNotPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyNotPublicProcessor implements IMatchProcessor<PropertyNotPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPr the value of pattern parameter pr in the currently processed match
   * 
   */
  public abstract void process(final Property pPr);
  
  @Override
  public void process(final PropertyNotPublicMatch match) {
    process(match.getPr());
  }
}
