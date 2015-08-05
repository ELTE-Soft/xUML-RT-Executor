package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.PrimitiveTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.PrimitiveType;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.primitiveType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PrimitiveTypeProcessor implements IMatchProcessor<PrimitiveTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPrimitiveType the value of pattern parameter primitiveType in the currently processed match
   * 
   */
  public abstract void process(final PrimitiveType pPrimitiveType);
  
  @Override
  public void process(final PrimitiveTypeMatch match) {
    process(match.getPrimitiveType());
  }
}
