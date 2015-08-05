package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtClassInPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtClassInPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassInPackageProcessor implements IMatchProcessor<XtClassInPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pUmlPackage, final org.eclipse.uml2.uml.Class pUmlClass);
  
  @Override
  public void process(final XtClassInPackageMatch match) {
    process(match.getUmlPackage(), match.getUmlClass());
  }
}
