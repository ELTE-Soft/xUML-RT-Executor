package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtAssociationClass pattern,
 * to be used in conjunction with {@link XtAssociationClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtAssociationClassMatcher
 * @see XtAssociationClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtAssociationClassMatch extends BasePatternMatch {
  private AssociationClass fAssociationClass;
  
  private static List<String> parameterNames = makeImmutableList("associationClass");
  
  private XtAssociationClassMatch(final AssociationClass pAssociationClass) {
    this.fAssociationClass = pAssociationClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("associationClass".equals(parameterName)) return this.fAssociationClass;
    return null;
  }
  
  public AssociationClass getAssociationClass() {
    return this.fAssociationClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("associationClass".equals(parameterName) ) {
    	this.fAssociationClass = (org.eclipse.uml2.uml.AssociationClass) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAssociationClass(final AssociationClass pAssociationClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociationClass = pAssociationClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtAssociationClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtAssociationClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAssociationClass};
  }
  
  @Override
  public XtAssociationClassMatch toImmutable() {
    return isMutable() ? newMatch(fAssociationClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"associationClass\"=" + prettyPrintValue(fAssociationClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAssociationClass == null) ? 0 : fAssociationClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtAssociationClassMatch)) { // this should be infrequent
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
    XtAssociationClassMatch other = (XtAssociationClassMatch) obj;
    if (fAssociationClass == null) {if (other.fAssociationClass != null) return false;}
    else if (!fAssociationClass.equals(other.fAssociationClass)) return false;
    return true;
  }
  
  @Override
  public XtAssociationClassQuerySpecification specification() {
    try {
    	return XtAssociationClassQuerySpecification.instance();
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
  public static XtAssociationClassMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAssociationClass the fixed value of pattern parameter associationClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtAssociationClassMatch newMutableMatch(final AssociationClass pAssociationClass) {
    return new Mutable(pAssociationClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociationClass the fixed value of pattern parameter associationClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtAssociationClassMatch newMatch(final AssociationClass pAssociationClass) {
    return new Immutable(pAssociationClass);
  }
  
  private static final class Mutable extends XtAssociationClassMatch {
    Mutable(final AssociationClass pAssociationClass) {
      super(pAssociationClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtAssociationClassMatch {
    Immutable(final AssociationClass pAssociationClass) {
      super(pAssociationClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
