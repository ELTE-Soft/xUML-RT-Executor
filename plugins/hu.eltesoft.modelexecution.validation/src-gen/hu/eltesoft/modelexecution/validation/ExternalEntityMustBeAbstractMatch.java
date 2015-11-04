package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ExternalEntityMustBeAbstractQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstract pattern,
 * to be used in conjunction with {@link ExternalEntityMustBeAbstractMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExternalEntityMustBeAbstractMatcher
 * @see ExternalEntityMustBeAbstractProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityMustBeAbstractMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl;
  
  private static List<String> parameterNames = makeImmutableList("cl");
  
  private ExternalEntityMustBeAbstractMatch(final org.eclipse.uml2.uml.Class pCl) {
    this.fCl = pCl;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl".equals(parameterName)) return this.fCl;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstract";
  }
  
  @Override
  public List<String> parameterNames() {
    return ExternalEntityMustBeAbstractMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl};
  }
  
  @Override
  public ExternalEntityMustBeAbstractMatch toImmutable() {
    return isMutable() ? newMatch(fCl) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl\"=" + prettyPrintValue(fCl)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExternalEntityMustBeAbstractMatch)) { // this should be infrequent
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
    ExternalEntityMustBeAbstractMatch other = (ExternalEntityMustBeAbstractMatch) obj;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    return true;
  }
  
  @Override
  public ExternalEntityMustBeAbstractQuerySpecification specification() {
    try {
    	return ExternalEntityMustBeAbstractQuerySpecification.instance();
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
  public static ExternalEntityMustBeAbstractMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExternalEntityMustBeAbstractMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl) {
    return new Mutable(pCl);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExternalEntityMustBeAbstractMatch newMatch(final org.eclipse.uml2.uml.Class pCl) {
    return new Immutable(pCl);
  }
  
  private static final class Mutable extends ExternalEntityMustBeAbstractMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl) {
      super(pCl);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExternalEntityMustBeAbstractMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl) {
      super(pCl);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
