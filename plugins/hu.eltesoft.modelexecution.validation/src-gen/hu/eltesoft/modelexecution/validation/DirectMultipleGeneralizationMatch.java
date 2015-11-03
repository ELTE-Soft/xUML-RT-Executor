package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.DirectMultipleGeneralizationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.DirectMultipleGeneralization pattern,
 * to be used in conjunction with {@link DirectMultipleGeneralizationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DirectMultipleGeneralizationMatcher
 * @see DirectMultipleGeneralizationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DirectMultipleGeneralizationMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fSpec;
  
  private static List<String> parameterNames = makeImmutableList("spec");
  
  private DirectMultipleGeneralizationMatch(final org.eclipse.uml2.uml.Class pSpec) {
    this.fSpec = pSpec;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("spec".equals(parameterName)) return this.fSpec;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getSpec() {
    return this.fSpec;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("spec".equals(parameterName) ) {
    	this.fSpec = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSpec(final org.eclipse.uml2.uml.Class pSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSpec = pSpec;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.DirectMultipleGeneralization";
  }
  
  @Override
  public List<String> parameterNames() {
    return DirectMultipleGeneralizationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSpec};
  }
  
  @Override
  public DirectMultipleGeneralizationMatch toImmutable() {
    return isMutable() ? newMatch(fSpec) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"spec\"=" + prettyPrintValue(fSpec)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSpec == null) ? 0 : fSpec.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DirectMultipleGeneralizationMatch)) { // this should be infrequent
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
    DirectMultipleGeneralizationMatch other = (DirectMultipleGeneralizationMatch) obj;
    if (fSpec == null) {if (other.fSpec != null) return false;}
    else if (!fSpec.equals(other.fSpec)) return false;
    return true;
  }
  
  @Override
  public DirectMultipleGeneralizationQuerySpecification specification() {
    try {
    	return DirectMultipleGeneralizationQuerySpecification.instance();
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
  public static DirectMultipleGeneralizationMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DirectMultipleGeneralizationMatch newMutableMatch(final org.eclipse.uml2.uml.Class pSpec) {
    return new Mutable(pSpec);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DirectMultipleGeneralizationMatch newMatch(final org.eclipse.uml2.uml.Class pSpec) {
    return new Immutable(pSpec);
  }
  
  private static final class Mutable extends DirectMultipleGeneralizationMatch {
    Mutable(final org.eclipse.uml2.uml.Class pSpec) {
      super(pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DirectMultipleGeneralizationMatch {
    Immutable(final org.eclipse.uml2.uml.Class pSpec) {
      super(pSpec);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
