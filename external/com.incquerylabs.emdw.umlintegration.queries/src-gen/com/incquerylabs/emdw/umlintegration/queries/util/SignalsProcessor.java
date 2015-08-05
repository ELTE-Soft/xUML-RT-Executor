package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.SignalsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.signals pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalsProcessor implements IMatchProcessor<SignalsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSig the value of pattern parameter sig in the currently processed match
   * 
   */
  public abstract void process(final Signal pSig);
  
  @Override
  public void process(final SignalsMatch match) {
    process(match.getSig());
  }
}
