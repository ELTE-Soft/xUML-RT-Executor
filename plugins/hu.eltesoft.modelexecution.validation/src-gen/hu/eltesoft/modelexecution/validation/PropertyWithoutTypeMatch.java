package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.PropertyWithoutTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.PropertyWithoutType pattern,
 * to be used in conjunction with {@link PropertyWithoutTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PropertyWithoutTypeMatcher
 * @see PropertyWithoutTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyWithoutTypeMatch extends BasePatternMatch {
  private Property fPr;
  
  private static List<String> parameterNames = makeImmutableList("pr");
  
  private PropertyWithoutTypeMatch(final Property pPr) {
    this.fPr = pPr;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pr".equals(parameterName)) return this.fPr;
    return null;
  }
  
  public Property getPr() {
    return this.fPr;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pr".equals(parameterName) ) {
    	this.fPr = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPr(final Property pPr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPr = pPr;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.PropertyWithoutType";
  }
  
  @Override
  public List<String> parameterNames() {
    return PropertyWithoutTypeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPr};
  }
  
  @Override
  public PropertyWithoutTypeMatch toImmutable() {
    return isMutable() ? newMatch(fPr) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pr\"=" + prettyPrintValue(fPr)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPr == null) ? 0 : fPr.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PropertyWithoutTypeMatch)) { // this should be infrequent
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
    PropertyWithoutTypeMatch other = (PropertyWithoutTypeMatch) obj;
    if (fPr == null) {if (other.fPr != null) return false;}
    else if (!fPr.equals(other.fPr)) return false;
    return true;
  }
  
  @Override
  public PropertyWithoutTypeQuerySpecification specification() {
    try {
    	return PropertyWithoutTypeQuerySpecification.instance();
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
  public static PropertyWithoutTypeMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPr the fixed value of pattern parameter pr, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PropertyWithoutTypeMatch newMutableMatch(final Property pPr) {
    return new Mutable(pPr);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPr the fixed value of pattern parameter pr, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PropertyWithoutTypeMatch newMatch(final Property pPr) {
    return new Immutable(pPr);
  }
  
  private static final class Mutable extends PropertyWithoutTypeMatch {
    Mutable(final Property pPr) {
      super(pPr);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PropertyWithoutTypeMatch {
    Immutable(final Property pPr) {
      super(pPr);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
