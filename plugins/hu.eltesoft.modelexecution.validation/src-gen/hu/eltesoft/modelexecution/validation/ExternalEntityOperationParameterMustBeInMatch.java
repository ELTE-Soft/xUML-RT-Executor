package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ExternalEntityOperationParameterMustBeInQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Parameter;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMustBeIn pattern,
 * to be used in conjunction with {@link ExternalEntityOperationParameterMustBeInMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExternalEntityOperationParameterMustBeInMatcher
 * @see ExternalEntityOperationParameterMustBeInProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityOperationParameterMustBeInMatch extends BasePatternMatch {
  private Parameter fPm;
  
  private static List<String> parameterNames = makeImmutableList("pm");
  
  private ExternalEntityOperationParameterMustBeInMatch(final Parameter pPm) {
    this.fPm = pPm;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pm".equals(parameterName)) return this.fPm;
    return null;
  }
  
  public Parameter getPm() {
    return this.fPm;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pm".equals(parameterName) ) {
    	this.fPm = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPm(final Parameter pPm) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPm = pPm;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMustBeIn";
  }
  
  @Override
  public List<String> parameterNames() {
    return ExternalEntityOperationParameterMustBeInMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPm};
  }
  
  @Override
  public ExternalEntityOperationParameterMustBeInMatch toImmutable() {
    return isMutable() ? newMatch(fPm) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pm\"=" + prettyPrintValue(fPm)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPm == null) ? 0 : fPm.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExternalEntityOperationParameterMustBeInMatch)) { // this should be infrequent
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
    ExternalEntityOperationParameterMustBeInMatch other = (ExternalEntityOperationParameterMustBeInMatch) obj;
    if (fPm == null) {if (other.fPm != null) return false;}
    else if (!fPm.equals(other.fPm)) return false;
    return true;
  }
  
  @Override
  public ExternalEntityOperationParameterMustBeInQuerySpecification specification() {
    try {
    	return ExternalEntityOperationParameterMustBeInQuerySpecification.instance();
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
  public static ExternalEntityOperationParameterMustBeInMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPm the fixed value of pattern parameter pm, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExternalEntityOperationParameterMustBeInMatch newMutableMatch(final Parameter pPm) {
    return new Mutable(pPm);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPm the fixed value of pattern parameter pm, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExternalEntityOperationParameterMustBeInMatch newMatch(final Parameter pPm) {
    return new Immutable(pPm);
  }
  
  private static final class Mutable extends ExternalEntityOperationParameterMustBeInMatch {
    Mutable(final Parameter pPm) {
      super(pPm);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExternalEntityOperationParameterMustBeInMatch {
    Immutable(final Parameter pPm) {
      super(pPm);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
