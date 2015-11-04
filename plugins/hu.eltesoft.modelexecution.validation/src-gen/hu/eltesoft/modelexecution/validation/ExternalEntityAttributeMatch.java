package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ExternalEntityAttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ExternalEntityAttribute pattern,
 * to be used in conjunction with {@link ExternalEntityAttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExternalEntityAttributeMatcher
 * @see ExternalEntityAttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntityAttributeMatch extends BasePatternMatch {
  private Property fAttr;
  
  private static List<String> parameterNames = makeImmutableList("attr");
  
  private ExternalEntityAttributeMatch(final Property pAttr) {
    this.fAttr = pAttr;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("attr".equals(parameterName)) return this.fAttr;
    return null;
  }
  
  public Property getAttr() {
    return this.fAttr;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("attr".equals(parameterName) ) {
    	this.fAttr = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAttr(final Property pAttr) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttr = pAttr;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ExternalEntityAttribute";
  }
  
  @Override
  public List<String> parameterNames() {
    return ExternalEntityAttributeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAttr};
  }
  
  @Override
  public ExternalEntityAttributeMatch toImmutable() {
    return isMutable() ? newMatch(fAttr) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"attr\"=" + prettyPrintValue(fAttr)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAttr == null) ? 0 : fAttr.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExternalEntityAttributeMatch)) { // this should be infrequent
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
    ExternalEntityAttributeMatch other = (ExternalEntityAttributeMatch) obj;
    if (fAttr == null) {if (other.fAttr != null) return false;}
    else if (!fAttr.equals(other.fAttr)) return false;
    return true;
  }
  
  @Override
  public ExternalEntityAttributeQuerySpecification specification() {
    try {
    	return ExternalEntityAttributeQuerySpecification.instance();
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
  public static ExternalEntityAttributeMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExternalEntityAttributeMatch newMutableMatch(final Property pAttr) {
    return new Mutable(pAttr);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExternalEntityAttributeMatch newMatch(final Property pAttr) {
    return new Immutable(pAttr);
  }
  
  private static final class Mutable extends ExternalEntityAttributeMatch {
    Mutable(final Property pAttr) {
      super(pAttr);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExternalEntityAttributeMatch {
    Immutable(final Property pAttr) {
      super(pAttr);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
