package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtAssociationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtAssociation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtAssociationProcessor implements IMatchProcessor<XtAssociationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * @param pSourceEnd the value of pattern parameter sourceEnd in the currently processed match
   * @param pTargetEnd the value of pattern parameter targetEnd in the currently processed match
   * 
   */
  public abstract void process(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd);
  
  @Override
  public void process(final XtAssociationMatch match) {
    process(match.getAssociation(), match.getSourceEnd(), match.getTargetEnd());
  }
}
