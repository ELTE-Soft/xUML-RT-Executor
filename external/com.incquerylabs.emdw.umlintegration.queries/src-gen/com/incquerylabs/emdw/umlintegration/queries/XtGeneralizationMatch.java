package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtGeneralizationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Generalization;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtGeneralization pattern,
 * to be used in conjunction with {@link XtGeneralizationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtGeneralizationMatcher
 * @see XtGeneralizationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtGeneralizationMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fSubClass;
  
  private Generalization fGeneralization;
  
  private static List<String> parameterNames = makeImmutableList("subClass", "generalization");
  
  private XtGeneralizationMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    this.fSubClass = pSubClass;
    this.fGeneralization = pGeneralization;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("subClass".equals(parameterName)) return this.fSubClass;
    if ("generalization".equals(parameterName)) return this.fGeneralization;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getSubClass() {
    return this.fSubClass;
  }
  
  public Generalization getGeneralization() {
    return this.fGeneralization;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("subClass".equals(parameterName) ) {
    	this.fSubClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("generalization".equals(parameterName) ) {
    	this.fGeneralization = (org.eclipse.uml2.uml.Generalization) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSubClass(final org.eclipse.uml2.uml.Class pSubClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubClass = pSubClass;
  }
  
  public void setGeneralization(final Generalization pGeneralization) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGeneralization = pGeneralization;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtGeneralization";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtGeneralizationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSubClass, fGeneralization};
  }
  
  @Override
  public XtGeneralizationMatch toImmutable() {
    return isMutable() ? newMatch(fSubClass, fGeneralization) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"subClass\"=" + prettyPrintValue(fSubClass) + ", ");
    
    result.append("\"generalization\"=" + prettyPrintValue(fGeneralization)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubClass == null) ? 0 : fSubClass.hashCode());
    result = prime * result + ((fGeneralization == null) ? 0 : fGeneralization.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtGeneralizationMatch)) { // this should be infrequent
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
    XtGeneralizationMatch other = (XtGeneralizationMatch) obj;
    if (fSubClass == null) {if (other.fSubClass != null) return false;}
    else if (!fSubClass.equals(other.fSubClass)) return false;
    if (fGeneralization == null) {if (other.fGeneralization != null) return false;}
    else if (!fGeneralization.equals(other.fGeneralization)) return false;
    return true;
  }
  
  @Override
  public XtGeneralizationQuerySpecification specification() {
    try {
    	return XtGeneralizationQuerySpecification.instance();
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
  public static XtGeneralizationMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtGeneralizationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return new Mutable(pSubClass, pGeneralization);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubClass the fixed value of pattern parameter subClass, or null if not bound.
   * @param pGeneralization the fixed value of pattern parameter generalization, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtGeneralizationMatch newMatch(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
    return new Immutable(pSubClass, pGeneralization);
  }
  
  private static final class Mutable extends XtGeneralizationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
      super(pSubClass, pGeneralization);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtGeneralizationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pSubClass, final Generalization pGeneralization) {
      super(pSubClass, pGeneralization);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
