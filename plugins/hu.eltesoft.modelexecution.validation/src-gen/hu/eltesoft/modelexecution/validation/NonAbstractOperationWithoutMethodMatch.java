package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.NonAbstractOperationWithoutMethodQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethod pattern,
 * to be used in conjunction with {@link NonAbstractOperationWithoutMethodMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NonAbstractOperationWithoutMethodMatcher
 * @see NonAbstractOperationWithoutMethodProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NonAbstractOperationWithoutMethodMatch extends BasePatternMatch {
  private Operation fOp;
  
  private static List<String> parameterNames = makeImmutableList("op");
  
  private NonAbstractOperationWithoutMethodMatch(final Operation pOp) {
    this.fOp = pOp;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("op".equals(parameterName)) return this.fOp;
    return null;
  }
  
  public Operation getOp() {
    return this.fOp;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("op".equals(parameterName) ) {
    	this.fOp = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOp(final Operation pOp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOp = pOp;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethod";
  }
  
  @Override
  public List<String> parameterNames() {
    return NonAbstractOperationWithoutMethodMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOp};
  }
  
  @Override
  public NonAbstractOperationWithoutMethodMatch toImmutable() {
    return isMutable() ? newMatch(fOp) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"op\"=" + prettyPrintValue(fOp)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOp == null) ? 0 : fOp.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NonAbstractOperationWithoutMethodMatch)) { // this should be infrequent
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
    NonAbstractOperationWithoutMethodMatch other = (NonAbstractOperationWithoutMethodMatch) obj;
    if (fOp == null) {if (other.fOp != null) return false;}
    else if (!fOp.equals(other.fOp)) return false;
    return true;
  }
  
  @Override
  public NonAbstractOperationWithoutMethodQuerySpecification specification() {
    try {
    	return NonAbstractOperationWithoutMethodQuerySpecification.instance();
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
  public static NonAbstractOperationWithoutMethodMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NonAbstractOperationWithoutMethodMatch newMutableMatch(final Operation pOp) {
    return new Mutable(pOp);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NonAbstractOperationWithoutMethodMatch newMatch(final Operation pOp) {
    return new Immutable(pOp);
  }
  
  private static final class Mutable extends NonAbstractOperationWithoutMethodMatch {
    Mutable(final Operation pOp) {
      super(pOp);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NonAbstractOperationWithoutMethodMatch {
    Immutable(final Operation pOp) {
      super(pOp);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
