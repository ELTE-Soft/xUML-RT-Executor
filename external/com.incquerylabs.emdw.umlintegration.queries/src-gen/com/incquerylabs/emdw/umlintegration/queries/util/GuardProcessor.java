package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.GuardMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.guard pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GuardProcessor implements IMatchProcessor<GuardMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pGuard the value of pattern parameter guard in the currently processed match
   * 
   */
  public abstract void process(final Transition pTransition, final Constraint pGuard);
  
  @Override
  public void process(final GuardMatch match) {
    process(match.getTransition(), match.getGuard());
  }
}
