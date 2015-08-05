package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtEventTriggerQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtEventTrigger pattern,
 * to be used in conjunction with {@link XtEventTriggerMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtEventTriggerMatcher
 * @see XtEventTriggerProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtEventTriggerMatch extends BasePatternMatch {
  private Transition fTransition;
  
  private Trigger fTrigger;
  
  private static List<String> parameterNames = makeImmutableList("transition", "trigger");
  
  private XtEventTriggerMatch(final Transition pTransition, final Trigger pTrigger) {
    this.fTransition = pTransition;
    this.fTrigger = pTrigger;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("transition".equals(parameterName)) return this.fTransition;
    if ("trigger".equals(parameterName)) return this.fTrigger;
    return null;
  }
  
  public Transition getTransition() {
    return this.fTransition;
  }
  
  public Trigger getTrigger() {
    return this.fTrigger;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("transition".equals(parameterName) ) {
    	this.fTransition = (org.eclipse.uml2.uml.Transition) newValue;
    	return true;
    }
    if ("trigger".equals(parameterName) ) {
    	this.fTrigger = (org.eclipse.uml2.uml.Trigger) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTransition(final Transition pTransition) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTransition = pTransition;
  }
  
  public void setTrigger(final Trigger pTrigger) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTrigger = pTrigger;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtEventTrigger";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtEventTriggerMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTransition, fTrigger};
  }
  
  @Override
  public XtEventTriggerMatch toImmutable() {
    return isMutable() ? newMatch(fTransition, fTrigger) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"transition\"=" + prettyPrintValue(fTransition) + ", ");
    
    result.append("\"trigger\"=" + prettyPrintValue(fTrigger)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTransition == null) ? 0 : fTransition.hashCode());
    result = prime * result + ((fTrigger == null) ? 0 : fTrigger.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtEventTriggerMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    XtEventTriggerMatch other = (XtEventTriggerMatch) obj;
    if (fTransition == null) {if (other.fTransition != null) return false;}
    else if (!fTransition.equals(other.fTransition)) return false;
    if (fTrigger == null) {if (other.fTrigger != null) return false;}
    else if (!fTrigger.equals(other.fTrigger)) return false;
    return true;
  }
  
  @Override
  public XtEventTriggerQuerySpecification specification() {
    try {
    	return XtEventTriggerQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static XtEventTriggerMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtEventTriggerMatch newMutableMatch(final Transition pTransition, final Trigger pTrigger) {
    return new Mutable(pTransition, pTrigger);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pTrigger the fixed value of pattern parameter trigger, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtEventTriggerMatch newMatch(final Transition pTransition, final Trigger pTrigger) {
    return new Immutable(pTransition, pTrigger);
  }
  
  private static final class Mutable extends XtEventTriggerMatch {
    Mutable(final Transition pTransition, final Trigger pTrigger) {
      super(pTransition, pTrigger);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtEventTriggerMatch {
    Immutable(final Transition pTransition, final Trigger pTrigger) {
      super(pTransition, pTrigger);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
