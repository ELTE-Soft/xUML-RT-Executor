package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.TransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.transition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionProcessor implements IMatchProcessor<TransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pSourceState the value of pattern parameter sourceState in the currently processed match
   * @param pTargetState the value of pattern parameter targetState in the currently processed match
   * 
   */
  public abstract void process(final Transition pTransition, final Vertex pSourceState, final Vertex pTargetState);
  
  @Override
  public void process(final TransitionMatch match) {
    process(match.getTransition(), match.getSourceState(), match.getTargetState());
  }
}
