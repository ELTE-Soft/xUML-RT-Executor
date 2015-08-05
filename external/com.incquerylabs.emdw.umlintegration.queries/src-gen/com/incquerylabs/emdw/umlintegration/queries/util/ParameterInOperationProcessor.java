package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.ParameterInOperationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.parameterInOperation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ParameterInOperationProcessor implements IMatchProcessor<ParameterInOperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * @param pParameter the value of pattern parameter parameter in the currently processed match
   * 
   */
  public abstract void process(final Operation pOperation, final Parameter pParameter);
  
  @Override
  public void process(final ParameterInOperationMatch match) {
    process(match.getOperation(), match.getParameter());
  }
}
