package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.typeDefinition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TypeDefinitionProcessor implements IMatchProcessor<TypeDefinitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Type pType);
  
  @Override
  public void process(final TypeDefinitionMatch match) {
    process(match.getType());
  }
}
