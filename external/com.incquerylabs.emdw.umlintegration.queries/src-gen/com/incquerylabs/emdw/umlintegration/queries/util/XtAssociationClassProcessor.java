package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtAssociationClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtAssociationClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtAssociationClassProcessor implements IMatchProcessor<XtAssociationClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociationClass the value of pattern parameter associationClass in the currently processed match
   * 
   */
  public abstract void process(final AssociationClass pAssociationClass);
  
  @Override
  public void process(final XtAssociationClassMatch match) {
    process(match.getAssociationClass());
  }
}
