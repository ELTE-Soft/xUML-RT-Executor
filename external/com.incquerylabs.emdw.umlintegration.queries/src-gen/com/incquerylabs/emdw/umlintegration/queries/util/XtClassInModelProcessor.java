package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtClassInModelMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtClassInModel pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassInModelProcessor implements IMatchProcessor<XtClassInModelMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pModel the value of pattern parameter model in the currently processed match
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * 
   */
  public abstract void process(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass);
  
  @Override
  public void process(final XtClassInModelMatch match) {
    process(match.getModel(), match.getUmlClass());
  }
}
