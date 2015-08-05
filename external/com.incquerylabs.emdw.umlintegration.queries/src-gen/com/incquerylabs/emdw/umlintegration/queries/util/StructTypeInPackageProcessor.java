package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.StructTypeInPackageMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.DataType;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.structTypeInPackage pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StructTypeInPackageProcessor implements IMatchProcessor<StructTypeInPackageMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStructType the value of pattern parameter structType in the currently processed match
   * @param pUmlPackage the value of pattern parameter umlPackage in the currently processed match
   * 
   */
  public abstract void process(final DataType pStructType, final org.eclipse.uml2.uml.Package pUmlPackage);
  
  @Override
  public void process(final StructTypeInPackageMatch match) {
    process(match.getStructType(), match.getUmlPackage());
  }
}
