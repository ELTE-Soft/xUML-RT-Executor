package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtPackageInPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtPackageInPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageInPackageProcessor implements IMatchProcessor<XtPackageInPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParent the value of pattern parameter parent in the currently processed match
   * @param pChild the value of pattern parameter child in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pParent, final org.eclipse.uml2.uml.Package pChild);
  
  @Override
  public void process(final XtPackageInPackageMatch match) {
    process(match.getParent(), match.getChild());
  }
}
