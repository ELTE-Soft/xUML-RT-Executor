package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtComponentMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtComponent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtComponentProcessor implements IMatchProcessor<XtComponentMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pComponent the value of pattern parameter component in the currently processed match
   * 
   */
  public abstract void process(final Component pComponent);
  
  @Override
  public void process(final XtComponentMatch match) {
    process(match.getComponent());
  }
}
