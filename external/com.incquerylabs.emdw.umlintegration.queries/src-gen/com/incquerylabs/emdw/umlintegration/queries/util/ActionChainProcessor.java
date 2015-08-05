package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ActionChainMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.actionChain pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ActionChainProcessor implements IMatchProcessor<ActionChainMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pEffect the value of pattern parameter effect in the currently processed match
   * 
   */
  public abstract void process(final Transition pTransition, final Behavior pEffect);
  
  @Override
  public void process(final ActionChainMatch match) {
    process(match.getTransition(), match.getEffect());
  }
}
