package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.SignalWithReceptionInClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.signalWithReceptionInClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalWithReceptionInClassProcessor implements IMatchProcessor<SignalWithReceptionInClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSignal the value of pattern parameter signal in the currently processed match
   * @param pReception the value of pattern parameter reception in the currently processed match
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * 
   */
  public abstract void process(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass);
  
  @Override
  public void process(final SignalWithReceptionInClassMatch match) {
    process(match.getSignal(), match.getReception(), match.getUmlClass());
  }
}
