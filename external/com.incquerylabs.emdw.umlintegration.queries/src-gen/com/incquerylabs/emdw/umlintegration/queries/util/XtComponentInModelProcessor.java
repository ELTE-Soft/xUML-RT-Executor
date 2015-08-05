package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.XtComponentInModelMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.xtComponentInModel pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class XtComponentInModelProcessor implements IMatchProcessor<XtComponentInModelMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pModel the value of pattern parameter model in the currently processed match
   * @param pComponent the value of pattern parameter component in the currently processed match
   * 
   */
  public abstract void process(final Model pModel, final Component pComponent);
  
  @Override
  public void process(final XtComponentInModelMatch match) {
    process(match.getModel(), match.getComponent());
  }
}
