package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.UmlTypesMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.umlTypes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UmlTypesProcessor implements IMatchProcessor<UmlTypesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Type pType);
  
  @Override
  public void process(final UmlTypesMatch match) {
    process(match.getType());
  }
}
