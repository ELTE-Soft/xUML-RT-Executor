package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.LeafClassGeneralizedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.LeafClassGeneralized pattern,
 * to be used in conjunction with {@link LeafClassGeneralizedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LeafClassGeneralizedMatcher
 * @see LeafClassGeneralizedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LeafClassGeneralizedMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl;
  
  private org.eclipse.uml2.uml.Class fSpec;
  
  private static List<String> parameterNames = makeImmutableList("cl", "spec");
  
  private LeafClassGeneralizedMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    this.fCl = pCl;
    this.fSpec = pSpec;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl".equals(parameterName)) return this.fCl;
    if ("spec".equals(parameterName)) return this.fSpec;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  public org.eclipse.uml2.uml.Class getSpec() {
    return this.fSpec;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("spec".equals(parameterName) ) {
    	this.fSpec = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  public void setSpec(final org.eclipse.uml2.uml.Class pSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSpec = pSpec;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.LeafClassGeneralized";
  }
  
  @Override
  public List<String> parameterNames() {
    return LeafClassGeneralizedMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl, fSpec};
  }
  
  @Override
  public LeafClassGeneralizedMatch toImmutable() {
    return isMutable() ? newMatch(fCl, fSpec) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl\"=" + prettyPrintValue(fCl) + ", ");
    
    result.append("\"spec\"=" + prettyPrintValue(fSpec)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    result = prime * result + ((fSpec == null) ? 0 : fSpec.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LeafClassGeneralizedMatch)) { // this should be infrequent
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
    LeafClassGeneralizedMatch other = (LeafClassGeneralizedMatch) obj;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    if (fSpec == null) {if (other.fSpec != null) return false;}
    else if (!fSpec.equals(other.fSpec)) return false;
    return true;
  }
  
  @Override
  public LeafClassGeneralizedQuerySpecification specification() {
    try {
    	return LeafClassGeneralizedQuerySpecification.instance();
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
  public static LeafClassGeneralizedMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LeafClassGeneralizedMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return new Mutable(pCl, pSpec);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LeafClassGeneralizedMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return new Immutable(pCl, pSpec);
  }
  
  private static final class Mutable extends LeafClassGeneralizedMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
      super(pCl, pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LeafClassGeneralizedMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
      super(pCl, pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
