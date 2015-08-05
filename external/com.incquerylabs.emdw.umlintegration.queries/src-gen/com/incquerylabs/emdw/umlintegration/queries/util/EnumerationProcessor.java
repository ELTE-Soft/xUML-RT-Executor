package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.EnumerationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Enumeration;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.enumeration pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EnumerationProcessor implements IMatchProcessor<EnumerationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEnumeration the value of pattern parameter enumeration in the currently processed match
   * 
   */
  public abstract void process(final Enumeration pEnumeration);
  
  @Override
  public void process(final EnumerationMatch match) {
    process(match.getEnumeration());
  }
}
