package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageProcessor implements IMatchProcessor<XtPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pUmlPackage);
  
  @Override
  public void process(final XtPackageMatch match) {
    process(match.getUmlPackage());
  }
}
