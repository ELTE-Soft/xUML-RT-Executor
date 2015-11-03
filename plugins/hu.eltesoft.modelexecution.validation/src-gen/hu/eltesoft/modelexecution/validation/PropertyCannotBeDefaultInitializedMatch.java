package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.PropertyCannotBeDefaultInitializedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitialized pattern,
 * to be used in conjunction with {@link PropertyCannotBeDefaultInitializedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PropertyCannotBeDefaultInitializedMatcher
 * @see PropertyCannotBeDefaultInitializedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyCannotBeDefaultInitializedMatch extends BasePatternMatch {
  private Property fPr;
  
  private static List<String> parameterNames = makeImmutableList("pr");
  
  private PropertyCannotBeDefaultInitializedMatch(final Property pPr) {
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
    return "hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitialized";
  }
  
  @Override
  public List<String> parameterNames() {
    return PropertyCannotBeDefaultInitializedMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPr};
  }
  
  @Override
  public PropertyCannotBeDefaultInitializedMatch toImmutable() {
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
    if (!(obj instanceof PropertyCannotBeDefaultInitializedMatch)) { // this should be infrequent
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
    PropertyCannotBeDefaultInitializedMatch other = (PropertyCannotBeDefaultInitializedMatch) obj;
    if (fPr == null) {if (other.fPr != null) return false;}
    else if (!fPr.equals(other.fPr)) return false;
    return true;
  }
  
  @Override
  public PropertyCannotBeDefaultInitializedQuerySpecification specification() {
    try {
    	return PropertyCannotBeDefaultInitializedQuerySpecification.instance();
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
  public static PropertyCannotBeDefaultInitializedMatch newEmptyMatch() {
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
  public static PropertyCannotBeDefaultInitializedMatch newMutableMatch(final Property pPr) {
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
  public static PropertyCannotBeDefaultInitializedMatch newMatch(final Property pPr) {
    return new Immutable(pPr);
  }
  
  private static final class Mutable extends PropertyCannotBeDefaultInitializedMatch {
    Mutable(final Property pPr) {
      super(pPr);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PropertyCannotBeDefaultInitializedMatch {
    Immutable(final Property pPr) {
      super(pPr);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
