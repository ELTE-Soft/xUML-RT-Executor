package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.StateEntryBehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.stateEntryBehavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateEntryBehaviorProcessor implements IMatchProcessor<StateEntryBehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pState the value of pattern parameter state in the currently processed match
   * @param pEntry the value of pattern parameter entry in the currently processed match
   * 
   */
  public abstract void process(final State pState, final Behavior pEntry);
  
  @Override
  public void process(final StateEntryBehaviorMatch match) {
    process(match.getState(), match.getEntry());
  }
}
