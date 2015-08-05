package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.SignalAttributeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.signalAttribute pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeProcessor implements IMatchProcessor<SignalAttributeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlSignal the value of pattern parameter umlSignal in the currently processed match
   * @param pProperty the value of pattern parameter property in the currently processed match
   * 
   */
  public abstract void process(final Signal pUmlSignal, final Property pProperty);
  
  @Override
  public void process(final SignalAttributeMatch match) {
    process(match.getUmlSignal(), match.getProperty());
  }
}
