package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtComponentInPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtComponentInPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtComponentInPackageProcessor implements IMatchProcessor<XtComponentInPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * @param pComponent the value of pattern parameter component in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pUmlPackage, final Component pComponent);
  
  @Override
  public void process(final XtComponentInPackageMatch match) {
    process(match.getUmlPackage(), match.getComponent());
  }
}
