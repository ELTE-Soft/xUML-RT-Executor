package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.AssociationAbstractQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.AssociationAbstract pattern,
 * to be used in conjunction with {@link AssociationAbstractMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AssociationAbstractMatcher
 * @see AssociationAbstractProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationAbstractMatch extends BasePatternMatch {
  private Association fAc;
  
  private static List<String> parameterNames = makeImmutableList("ac");
  
  private AssociationAbstractMatch(final Association pAc) {
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
    return "hu.eltesoft.modelexecution.validation.AssociationAbstract";
  }
  
  @Override
  public List<String> parameterNames() {
    return AssociationAbstractMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAc};
  }
  
  @Override
  public AssociationAbstractMatch toImmutable() {
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
    if (!(obj instanceof AssociationAbstractMatch)) { // this should be infrequent
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
    AssociationAbstractMatch other = (AssociationAbstractMatch) obj;
    if (fAc == null) {if (other.fAc != null) return false;}
    else if (!fAc.equals(other.fAc)) return false;
    return true;
  }
  
  @Override
  public AssociationAbstractQuerySpecification specification() {
    try {
    	return AssociationAbstractQuerySpecification.instance();
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
  public static AssociationAbstractMatch newEmptyMatch() {
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
  public static AssociationAbstractMatch newMutableMatch(final Association pAc) {
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
  public static AssociationAbstractMatch newMatch(final Association pAc) {
    return new Immutable(pAc);
  }
  
  private static final class Mutable extends AssociationAbstractMatch {
    Mutable(final Association pAc) {
      super(pAc);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AssociationAbstractMatch {
    Immutable(final Association pAc) {
      super(pAc);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
