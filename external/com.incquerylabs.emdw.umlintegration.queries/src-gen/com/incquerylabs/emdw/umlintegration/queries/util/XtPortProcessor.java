package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtPortMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtPortProcessor implements IMatchProcessor<XtPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pComponent the value of pattern parameter component in the currently processed match
   * @param pPort the value of pattern parameter port in the currently processed match
   * 
   */
  public abstract void process(final Component pComponent, final Port pPort);
  
  @Override
  public void process(final XtPortMatch match) {
    process(match.getComponent(), match.getPort());
  }
}
