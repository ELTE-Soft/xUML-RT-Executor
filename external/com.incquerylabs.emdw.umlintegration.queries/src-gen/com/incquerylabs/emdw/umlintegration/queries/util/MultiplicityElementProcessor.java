package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.MultiplicityElementMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.multiplicityElement pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultiplicityElementProcessor implements IMatchProcessor<MultiplicityElementMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMultiplicityElement the value of pattern parameter multiplicityElement in the currently processed match
   * @param pLowerValue the value of pattern parameter lowerValue in the currently processed match
   * @param pUpperValue the value of pattern parameter upperValue in the currently processed match
   * 
   */
  public abstract void process(final MultiplicityElement pMultiplicityElement, final ValueSpecification pLowerValue, final ValueSpecification pUpperValue);
  
  @Override
  public void process(final MultiplicityElementMatch match) {
    process(match.getMultiplicityElement(), match.getLowerValue(), match.getUpperValue());
  }
}
