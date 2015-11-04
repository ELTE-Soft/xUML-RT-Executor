package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExternalEntityAttributeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ExternalEntityAttribute pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityAttributeProcessor implements IMatchProcessor<ExternalEntityAttributeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAttr the value of pattern parameter attr in the currently processed match
   * 
   */
  public abstract void process(final Property pAttr);
  
  @Override
  public void process(final ExternalEntityAttributeMatch match) {
    process(match.getAttr());
  }
}
