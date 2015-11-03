package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.GeneralizationOfAssocClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClass pattern,
 * to be used in conjunction with {@link GeneralizationOfAssocClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GeneralizationOfAssocClassMatcher
 * @see GeneralizationOfAssocClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationOfAssocClassMatch extends BasePatternMatch {
  private AssociationClass fAc;
  
  private org.eclipse.uml2.uml.Class fSpec;
  
  private static List<String> parameterNames = makeImmutableList("ac", "spec");
  
  private GeneralizationOfAssocClassMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    this.fAc = pAc;
    this.fSpec = pSpec;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ac".equals(parameterName)) return this.fAc;
    if ("spec".equals(parameterName)) return this.fSpec;
    return null;
  }
  
  public AssociationClass getAc() {
    return this.fAc;
  }
  
  public org.eclipse.uml2.uml.Class getSpec() {
    return this.fSpec;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ac".equals(parameterName) ) {
    	this.fAc = (org.eclipse.uml2.uml.AssociationClass) newValue;
    	return true;
    }
    if ("spec".equals(parameterName) ) {
    	this.fSpec = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAc(final AssociationClass pAc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAc = pAc;
  }
  
  public void setSpec(final org.eclipse.uml2.uml.Class pSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSpec = pSpec;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return GeneralizationOfAssocClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAc, fSpec};
  }
  
  @Override
  public GeneralizationOfAssocClassMatch toImmutable() {
    return isMutable() ? newMatch(fAc, fSpec) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ac\"=" + prettyPrintValue(fAc) + ", ");
    
    result.append("\"spec\"=" + prettyPrintValue(fSpec)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAc == null) ? 0 : fAc.hashCode());
    result = prime * result + ((fSpec == null) ? 0 : fSpec.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GeneralizationOfAssocClassMatch)) { // this should be infrequent
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
    GeneralizationOfAssocClassMatch other = (GeneralizationOfAssocClassMatch) obj;
    if (fAc == null) {if (other.fAc != null) return false;}
    else if (!fAc.equals(other.fAc)) return false;
    if (fSpec == null) {if (other.fSpec != null) return false;}
    else if (!fSpec.equals(other.fSpec)) return false;
    return true;
  }
  
  @Override
  public GeneralizationOfAssocClassQuerySpecification specification() {
    try {
    	return GeneralizationOfAssocClassQuerySpecification.instance();
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
  public static GeneralizationOfAssocClassMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GeneralizationOfAssocClassMatch newMutableMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return new Mutable(pAc, pSpec);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GeneralizationOfAssocClassMatch newMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return new Immutable(pAc, pSpec);
  }
  
  private static final class Mutable extends GeneralizationOfAssocClassMatch {
    Mutable(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
      super(pAc, pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GeneralizationOfAssocClassMatch {
    Immutable(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
      super(pAc, pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
