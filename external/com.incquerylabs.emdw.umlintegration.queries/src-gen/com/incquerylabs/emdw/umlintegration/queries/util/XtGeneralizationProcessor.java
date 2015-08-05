package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtGeneralizationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Generalization;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtGeneralization pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtGeneralizationProcessor implements IMatchProcessor<XtGeneralizationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSubClass the value of pattern parameter subClass in the currently processed match
   * @param pGeneralization the value of pattern parameter generalization in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization);
  
  @Override
  public void process(final XtGeneralizationMatch match) {
    process(match.getSubClass(), match.getGeneralization());
  }
}
