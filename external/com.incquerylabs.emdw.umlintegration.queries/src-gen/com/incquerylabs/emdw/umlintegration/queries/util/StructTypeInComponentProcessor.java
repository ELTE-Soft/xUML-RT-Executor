package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.StructTypeInComponentMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.structTypeInComponent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StructTypeInComponentProcessor implements IMatchProcessor<StructTypeInComponentMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStructType the value of pattern parameter structType in the currently processed match
   * @param pUmlComponent the value of pattern parameter umlComponent in the currently processed match
   * 
   */
  public abstract void process(final DataType pStructType, final Component pUmlComponent);
  
  @Override
  public void process(final StructTypeInComponentMatch match) {
    process(match.getStructType(), match.getUmlComponent());
  }
}
