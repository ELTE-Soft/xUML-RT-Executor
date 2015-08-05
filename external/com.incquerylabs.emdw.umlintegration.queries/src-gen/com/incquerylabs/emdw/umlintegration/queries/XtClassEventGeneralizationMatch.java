package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventGeneralizationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClassEventGeneralization pattern,
 * to be used in conjunction with {@link XtClassEventGeneralizationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassEventGeneralizationMatcher
 * @see XtClassEventGeneralizationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassEventGeneralizationMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private Signal fSuperSignal;
  
  private static List<String> parameterNames = makeImmutableList("signal", "superSignal");
  
  private XtClassEventGeneralizationMatch(final Signal pSignal, final Signal pSuperSignal) {
    this.fSignal = pSignal;
    this.fSuperSignal = pSuperSignal;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("superSignal".equals(parameterName)) return this.fSuperSignal;
    return null;
  }
  
  public Signal getSignal() {
    return this.fSignal;
  }
  
  public Signal getSuperSignal() {
    return this.fSuperSignal;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("superSignal".equals(parameterName) ) {
    	this.fSuperSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
  }
  
  public void setSuperSignal(final Signal pSuperSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSuperSignal = pSuperSignal;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClassEventGeneralization";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassEventGeneralizationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fSuperSignal};
  }
  
  @Override
  public XtClassEventGeneralizationMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fSuperSignal) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    
    result.append("\"superSignal\"=" + prettyPrintValue(fSuperSignal)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fSuperSignal == null) ? 0 : fSuperSignal.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassEventGeneralizationMatch)) { // this should be infrequent
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
    XtClassEventGeneralizationMatch other = (XtClassEventGeneralizationMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fSuperSignal == null) {if (other.fSuperSignal != null) return false;}
    else if (!fSuperSignal.equals(other.fSuperSignal)) return false;
    return true;
  }
  
  @Override
  public XtClassEventGeneralizationQuerySpecification specification() {
    try {
    	return XtClassEventGeneralizationQuerySpecification.instance();
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
  public static XtClassEventGeneralizationMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassEventGeneralizationMatch newMutableMatch(final Signal pSignal, final Signal pSuperSignal) {
    return new Mutable(pSignal, pSuperSignal);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassEventGeneralizationMatch newMatch(final Signal pSignal, final Signal pSuperSignal) {
    return new Immutable(pSignal, pSuperSignal);
  }
  
  private static final class Mutable extends XtClassEventGeneralizationMatch {
    Mutable(final Signal pSignal, final Signal pSuperSignal) {
      super(pSignal, pSuperSignal);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassEventGeneralizationMatch {
    Immutable(final Signal pSignal, final Signal pSuperSignal) {
      super(pSignal, pSuperSignal);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
