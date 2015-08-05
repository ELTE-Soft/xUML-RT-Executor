package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageInModelMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtPackageInModel pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageInModelProcessor implements IMatchProcessor<XtPackageInModelMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pModel the value of pattern parameter model in the currently processed match
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * 
   */
  public abstract void process(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage);
  
  @Override
  public void process(final XtPackageInModelMatch match) {
    process(match.getModel(), match.getUmlPackage());
  }
}
