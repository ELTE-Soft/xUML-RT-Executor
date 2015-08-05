package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.AssociationOwnedEndMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.associationOwnedEnd pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationOwnedEndProcessor implements IMatchProcessor<AssociationOwnedEndMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * @param pOwnedEnd the value of pattern parameter ownedEnd in the currently processed match
   * 
   */
  public abstract void process(final Association pAssociation, final Property pOwnedEnd);
  
  @Override
  public void process(final AssociationOwnedEndMatch match) {
    process(match.getAssociation(), match.getOwnedEnd());
  }
}
