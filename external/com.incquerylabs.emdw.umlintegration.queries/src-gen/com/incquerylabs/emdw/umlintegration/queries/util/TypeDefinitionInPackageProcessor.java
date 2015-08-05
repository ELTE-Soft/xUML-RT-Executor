package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Type;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TypeDefinitionInPackageProcessor implements IMatchProcessor<TypeDefinitionInPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pUmlPackage, final Type pType);
  
  @Override
  public void process(final TypeDefinitionInPackageMatch match) {
    process(match.getUmlPackage(), match.getType());
  }
}
