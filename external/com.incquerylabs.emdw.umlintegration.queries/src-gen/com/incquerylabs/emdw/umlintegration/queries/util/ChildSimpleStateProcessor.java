package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ChildSimpleStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.childSimpleState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ChildSimpleStateProcessor implements IMatchProcessor<ChildSimpleStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParentState the value of pattern parameter parentState in the currently processed match
   * @param pState the value of pattern parameter state in the currently processed match
   * 
   */
  public abstract void process(final State pParentState, final State pState);
  
  @Override
  public void process(final ChildSimpleStateMatch match) {
    process(match.getParentState(), match.getState());
  }
}
