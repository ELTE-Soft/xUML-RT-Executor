package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.EnumerationLiteralMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.enumerationLiteral pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EnumerationLiteralProcessor implements IMatchProcessor<EnumerationLiteralMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEnumeration the value of pattern parameter enumeration in the currently processed match
   * @param pEnumerationLiteral the value of pattern parameter enumerationLiteral in the currently processed match
   * 
   */
  public abstract void process(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral);
  
  @Override
  public void process(final EnumerationLiteralMatch match) {
    process(match.getEnumeration(), match.getEnumerationLiteral());
  }
}
