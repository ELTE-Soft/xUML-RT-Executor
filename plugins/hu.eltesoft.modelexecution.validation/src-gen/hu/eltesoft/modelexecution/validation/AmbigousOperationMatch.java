package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.AmbigousOperationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Operation;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.AmbigousOperation pattern,
 * to be used in conjunction with {@link AmbigousOperationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AmbigousOperationMatcher
 * @see AmbigousOperationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AmbigousOperationMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl;
  
  private Operation fOverridden;
  
  private static List<String> parameterNames = makeImmutableList("cl", "overridden");
  
  private AmbigousOperationMatch(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden) {
    this.fCl = pCl;
    this.fOverridden = pOverridden;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl".equals(parameterName)) return this.fCl;
    if ("overridden".equals(parameterName)) return this.fOverridden;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl() {
    return this.fCl;
  }
  
  public Operation getOverridden() {
    return this.fOverridden;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl".equals(parameterName) ) {
    	this.fCl = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("overridden".equals(parameterName) ) {
    	this.fOverridden = (org.eclipse.uml2.uml.Operation) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl(final org.eclipse.uml2.uml.Class pCl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl = pCl;
  }
  
  public void setOverridden(final Operation pOverridden) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOverridden = pOverridden;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.AmbigousOperation";
  }
  
  @Override
  public List<String> parameterNames() {
    return AmbigousOperationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl, fOverridden};
  }
  
  @Override
  public AmbigousOperationMatch toImmutable() {
    return isMutable() ? newMatch(fCl, fOverridden) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl\"=" + prettyPrintValue(fCl) + ", ");
    
    result.append("\"overridden\"=" + prettyPrintValue(fOverridden)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl == null) ? 0 : fCl.hashCode());
    result = prime * result + ((fOverridden == null) ? 0 : fOverridden.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AmbigousOperationMatch)) { // this should be infrequent
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
    AmbigousOperationMatch other = (AmbigousOperationMatch) obj;
    if (fCl == null) {if (other.fCl != null) return false;}
    else if (!fCl.equals(other.fCl)) return false;
    if (fOverridden == null) {if (other.fOverridden != null) return false;}
    else if (!fOverridden.equals(other.fOverridden)) return false;
    return true;
  }
  
  @Override
  public AmbigousOperationQuerySpecification specification() {
    try {
    	return AmbigousOperationQuerySpecification.instance();
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
  public static AmbigousOperationMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pOverridden the fixed value of pattern parameter overridden, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AmbigousOperationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden) {
    return new Mutable(pCl, pOverridden);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pOverridden the fixed value of pattern parameter overridden, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AmbigousOperationMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden) {
    return new Immutable(pCl, pOverridden);
  }
  
  private static final class Mutable extends AmbigousOperationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden) {
      super(pCl, pOverridden);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AmbigousOperationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl, final Operation pOverridden) {
      super(pCl, pOverridden);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
