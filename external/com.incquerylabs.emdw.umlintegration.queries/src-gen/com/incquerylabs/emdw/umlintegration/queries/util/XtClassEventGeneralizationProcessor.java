package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtClassEventGeneralizationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtClassEventGeneralization pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassEventGeneralizationProcessor implements IMatchProcessor<XtClassEventGeneralizationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pSuperSignal the value of pattern parameter superSignal in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final Signal pSuperSignal);
  
  @Override
  public void process(final XtClassEventGeneralizationMatch match) {
    process(match.getSignal(), match.getSuperSignal());
  }
}
