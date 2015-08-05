package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInComponentMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInComponent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TypeDefinitionInComponentProcessor implements IMatchProcessor<TypeDefinitionInComponentMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlComponent the value of pattern parameter umlComponent in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Component pUmlComponent, final Type pType);
  
  @Override
  public void process(final TypeDefinitionInComponentMatch match) {
    process(match.getUmlComponent(), match.getType());
  }
}
