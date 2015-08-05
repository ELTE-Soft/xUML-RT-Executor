package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageInModelQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Model;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtPackageInModel pattern,
 * to be used in conjunction with {@link XtPackageInModelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtPackageInModelMatcher
 * @see XtPackageInModelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtPackageInModelMatch extends BasePatternMatch {
  private Model fModel;
  
  private org.eclipse.uml2.uml.Package fUmlPackage;
  
  private static List<String> parameterNames = makeImmutableList("model", "umlPackage");
  
  private XtPackageInModelMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    this.fModel = pModel;
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("model".equals(parameterName)) return this.fModel;
    if ("umlPackage".equals(parameterName)) return this.fUmlPackage;
    return null;
  }
  
  public Model getModel() {
    return this.fModel;
  }
  
  public org.eclipse.uml2.uml.Package getUmlPackage() {
    return this.fUmlPackage;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("model".equals(parameterName) ) {
    	this.fModel = (org.eclipse.uml2.uml.Model) newValue;
    	return true;
    }
    if ("umlPackage".equals(parameterName) ) {
    	this.fUmlPackage = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setModel(final Model pModel) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModel = pModel;
  }
  
  public void setUmlPackage(final org.eclipse.uml2.uml.Package pUmlPackage) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUmlPackage = pUmlPackage;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtPackageInModel";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtPackageInModelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fModel, fUmlPackage};
  }
  
  @Override
  public XtPackageInModelMatch toImmutable() {
    return isMutable() ? newMatch(fModel, fUmlPackage) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"model\"=" + prettyPrintValue(fModel) + ", ");
    
    result.append("\"umlPackage\"=" + prettyPrintValue(fUmlPackage)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fModel == null) ? 0 : fModel.hashCode());
    result = prime * result + ((fUmlPackage == null) ? 0 : fUmlPackage.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtPackageInModelMatch)) { // this should be infrequent
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
    XtPackageInModelMatch other = (XtPackageInModelMatch) obj;
    if (fModel == null) {if (other.fModel != null) return false;}
    else if (!fModel.equals(other.fModel)) return false;
    if (fUmlPackage == null) {if (other.fUmlPackage != null) return false;}
    else if (!fUmlPackage.equals(other.fUmlPackage)) return false;
    return true;
  }
  
  @Override
  public XtPackageInModelQuerySpecification specification() {
    try {
    	return XtPackageInModelQuerySpecification.instance();
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
  public static XtPackageInModelMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtPackageInModelMatch newMutableMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Mutable(pModel, pUmlPackage);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @param pUmlPackage the fixed value of pattern parameter umlPackage, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtPackageInModelMatch newMatch(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
    return new Immutable(pModel, pUmlPackage);
  }
  
  private static final class Mutable extends XtPackageInModelMatch {
    Mutable(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pModel, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtPackageInModelMatch {
    Immutable(final Model pModel, final org.eclipse.uml2.uml.Package pUmlPackage) {
      super(pModel, pUmlPackage);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
