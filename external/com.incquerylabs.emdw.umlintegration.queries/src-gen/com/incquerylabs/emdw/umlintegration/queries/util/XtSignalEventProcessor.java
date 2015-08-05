package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtSignalEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtSignalEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtSignalEventProcessor implements IMatchProcessor<XtSignalEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal);
  
  @Override
  public void process(final XtSignalEventMatch match) {
    process(match.getUmlClass(), match.getSignal());
  }
}
