package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.parameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ParameterProcessor implements IMatchProcessor<ParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * 
   */
  public abstract void process(final Parameter pParameter);
  
  @Override
  public void process(final ParameterMatch match) {
    process(match.getParameter());
  }
}
