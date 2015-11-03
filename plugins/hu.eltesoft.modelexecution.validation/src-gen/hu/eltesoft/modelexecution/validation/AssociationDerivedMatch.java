package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.AssociationDerivedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.AssociationDerived pattern,
 * to be used in conjunction with {@link AssociationDerivedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationDerivedMatcher
 * @see AssociationDerivedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationDerivedMatch extends BasePatternMatch {
  private Association fAc;
  
  private static List<String> parameterNames = makeImmutableList("ac");
  
  private AssociationDerivedMatch(final Association pAc) {
    this.fAc = pAc;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ac".equals(parameterName)) return this.fAc;
    return null;
  }
  
  public Association getAc() {
    return this.fAc;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ac".equals(parameterName) ) {
    	this.fAc = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAc(final Association pAc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAc = pAc;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.AssociationDerived";
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationDerivedMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAc};
  }
  
  @Override
  public AssociationDerivedMatch toImmutable() {
    return isMutable() ? newMatch(fAc) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ac\"=" + prettyPrintValue(fAc)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAc == null) ? 0 : fAc.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AssociationDerivedMatch)) { // this should be infrequent
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
    AssociationDerivedMatch other = (AssociationDerivedMatch) obj;
    if (fAc == null) {if (other.fAc != null) return false;}
    else if (!fAc.equals(other.fAc)) return false;
    return true;
  }
  
  @Override
  public AssociationDerivedQuerySpecification specification() {
    try {
    	return AssociationDerivedQuerySpecification.instance();
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
  public static AssociationDerivedMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AssociationDerivedMatch newMutableMatch(final Association pAc) {
    return new Mutable(pAc);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AssociationDerivedMatch newMatch(final Association pAc) {
    return new Immutable(pAc);
  }
  
  private static final class Mutable extends AssociationDerivedMatch {
    Mutable(final Association pAc) {
      super(pAc);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationDerivedMatch {
    Immutable(final Association pAc) {
      super(pAc);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
