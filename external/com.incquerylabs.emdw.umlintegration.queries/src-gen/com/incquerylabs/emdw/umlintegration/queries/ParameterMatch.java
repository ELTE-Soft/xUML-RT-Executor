package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.ParameterQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Parameter;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.parameter pattern,
 * to be used in conjunction with {@link ParameterMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ParameterMatcher
 * @see ParameterProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ParameterMatch extends BasePatternMatch {
  private Parameter fParameter;
  
  private static List<String> parameterNames = makeImmutableList("parameter");
  
  private ParameterMatch(final Parameter pParameter) {
    this.fParameter = pParameter;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parameter".equals(parameterName)) return this.fParameter;
    return null;
  }
  
  public Parameter getParameter() {
    return this.fParameter;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parameter".equals(parameterName) ) {
    	this.fParameter = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParameter(final Parameter pParameter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParameter = pParameter;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.parameter";
  }
  
  @Override
  public List<String> parameterNames() {
    return ParameterMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParameter};
  }
  
  @Override
  public ParameterMatch toImmutable() {
    return isMutable() ? newMatch(fParameter) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parameter\"=" + prettyPrintValue(fParameter)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ParameterMatch)) { // this should be infrequent
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
    ParameterMatch other = (ParameterMatch) obj;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    return true;
  }
  
  @Override
  public ParameterQuerySpecification specification() {
    try {
    	return ParameterQuerySpecification.instance();
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
  public static ParameterMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ParameterMatch newMutableMatch(final Parameter pParameter) {
    return new Mutable(pParameter);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ParameterMatch newMatch(final Parameter pParameter) {
    return new Immutable(pParameter);
  }
  
  private static final class Mutable extends ParameterMatch {
    Mutable(final Parameter pParameter) {
      super(pParameter);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ParameterMatch {
    Immutable(final Parameter pParameter) {
      super(pParameter);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
