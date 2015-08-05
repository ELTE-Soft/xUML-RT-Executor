package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.DestructorOperationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.destructorOperation pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DestructorOperationProcessor implements IMatchProcessor<DestructorOperationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlClass the value of pattern parameter umlClass in the currently processed match
   * @param pOperation the value of pattern parameter operation in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation);
  
  @Override
  public void process(final DestructorOperationMatch match) {
    process(match.getUmlClass(), match.getOperation());
  }
}
