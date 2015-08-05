package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtClassInModelQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtClassInModel pattern,
 * to be used in conjunction with {@link XtClassInModelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtClassInModelMatcher
 * @see XtClassInModelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtClassInModelMatch extends BasePatternMatch {
  private Model fModel;
  
  private org.eclipse.uml2.uml.Class fUmlClass;
  
  private static List<String> parameterNames = makeImmutableList("model", "umlClass");
  
  private XtClassInModelMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    this.fModel = pModel;
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("model".equals(parameterName)) return this.fModel;
    if ("umlClass".equals(parameterName)) return this.fUmlClass;
    return null;
  }
  
  public Model getModel() {
    return this.fModel;
  }
  
  public org.eclipse.uml2.uml.Class getUmlClass() {
    return this.fUmlClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("model".equals(parameterName) ) {
    	this.fModel = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    if ("umlClass".equals(parameterName) ) {
    	this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setModel(final Model pModel) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModel = pModel;
  }
  
  public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlClass = pUmlClass;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtClassInModel";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtClassInModelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fModel, fUmlClass};
  }
  
  @Override
  public XtClassInModelMatch toImmutable() {
    return isMutable() ? newMatch(fModel, fUmlClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"model\"=" + prettyPrintValue(fModel) + ", ");
    
    result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fModel == null) ? 0 : fModel.hashCode());
    result = prime * result + ((fUmlClass == null) ? 0 : fUmlClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtClassInModelMatch)) { // this should be infrequent
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
    XtClassInModelMatch other = (XtClassInModelMatch) obj;
    if (fModel == null) {if (other.fModel != null) return false;}
    else if (!fModel.equals(other.fModel)) return false;
    if (fUmlClass == null) {if (other.fUmlClass != null) return false;}
    else if (!fUmlClass.equals(other.fUmlClass)) return false;
    return true;
  }
  
  @Override
  public XtClassInModelQuerySpecification specification() {
    try {
    	return XtClassInModelQuerySpecification.instance();
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
  public static XtClassInModelMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtClassInModelMatch newMutableMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Mutable(pModel, pUmlClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtClassInModelMatch newMatch(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
    return new Immutable(pModel, pUmlClass);
  }
  
  private static final class Mutable extends XtClassInModelMatch {
    Mutable(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pModel, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtClassInModelMatch {
    Immutable(final Model pModel, final org.eclipse.uml2.uml.Class pUmlClass) {
      super(pModel, pUmlClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
