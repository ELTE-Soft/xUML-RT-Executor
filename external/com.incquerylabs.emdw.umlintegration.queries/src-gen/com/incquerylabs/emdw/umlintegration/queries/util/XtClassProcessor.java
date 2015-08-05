package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassProcessor implements IMatchProcessor<XtClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pUmlClass);
  
  @Override
  public void process(final XtClassMatch match) {
    process(match.getUmlClass());
  }
}
