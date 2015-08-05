package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.AssociationsOfClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.associationsOfClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationsOfClassProcessor implements IMatchProcessor<AssociationsOfClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl the value of pattern parameter cl in the currently processed match
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl, final Property pAssociation);
  
  @Override
  public void process(final AssociationsOfClassMatch match) {
    process(match.getCl(), match.getAssociation());
  }
}
