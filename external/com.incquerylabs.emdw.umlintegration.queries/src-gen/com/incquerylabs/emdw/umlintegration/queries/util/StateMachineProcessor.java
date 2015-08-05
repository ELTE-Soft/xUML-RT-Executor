package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.StateMachineMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.stateMachine pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineProcessor implements IMatchProcessor<StateMachineMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavioredClassifier the value of pattern parameter behavioredClassifier in the currently processed match
   * @param pStateMachine the value of pattern parameter stateMachine in the currently processed match
   * 
   */
  public abstract void process(final BehavioredClassifier pBehavioredClassifier, final StateMachine pStateMachine);
  
  @Override
  public void process(final StateMachineMatch match) {
    process(match.getBehavioredClassifier(), match.getStateMachine());
  }
}
