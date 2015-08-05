package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.AttributesOfClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.attributesOfClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AttributesOfClassProcessor implements IMatchProcessor<AttributesOfClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl the value of pattern parameter cl in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute);
  
  @Override
  public void process(final AttributesOfClassMatch match) {
    process(match.getCl(), match.getAttribute());
  }
}
