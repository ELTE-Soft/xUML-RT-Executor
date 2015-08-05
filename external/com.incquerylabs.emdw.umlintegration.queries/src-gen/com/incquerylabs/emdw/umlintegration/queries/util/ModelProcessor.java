package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ModelMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.model pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ModelProcessor implements IMatchProcessor<ModelMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pModel the value of pattern parameter model in the currently processed match
   * 
   */
  public abstract void process(final Model pModel);
  
  @Override
  public void process(final ModelMatch match) {
    process(match.getModel());
  }
}
