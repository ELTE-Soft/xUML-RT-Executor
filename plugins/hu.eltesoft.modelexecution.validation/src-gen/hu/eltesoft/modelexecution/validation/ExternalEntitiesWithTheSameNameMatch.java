package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ExternalEntitiesWithTheSameNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameName pattern,
 * to be used in conjunction with {@link ExternalEntitiesWithTheSameNameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExternalEntitiesWithTheSameNameMatcher
 * @see ExternalEntitiesWithTheSameNameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntitiesWithTheSameNameMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCl1;
  
  private org.eclipse.uml2.uml.Class fCl2;
  
  private static List<String> parameterNames = makeImmutableList("cl1", "cl2");
  
  private ExternalEntitiesWithTheSameNameMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    this.fCl1 = pCl1;
    this.fCl2 = pCl2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cl1".equals(parameterName)) return this.fCl1;
    if ("cl2".equals(parameterName)) return this.fCl2;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getCl1() {
    return this.fCl1;
  }
  
  public org.eclipse.uml2.uml.Class getCl2() {
    return this.fCl2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cl1".equals(parameterName) ) {
    	this.fCl1 = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("cl2".equals(parameterName) ) {
    	this.fCl2 = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCl1(final org.eclipse.uml2.uml.Class pCl1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl1 = pCl1;
  }
  
  public void setCl2(final org.eclipse.uml2.uml.Class pCl2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCl2 = pCl2;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameName";
  }
  
  @Override
  public List<String> parameterNames() {
    return ExternalEntitiesWithTheSameNameMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCl1, fCl2};
  }
  
  @Override
  public ExternalEntitiesWithTheSameNameMatch toImmutable() {
    return isMutable() ? newMatch(fCl1, fCl2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cl1\"=" + prettyPrintValue(fCl1) + ", ");
    
    result.append("\"cl2\"=" + prettyPrintValue(fCl2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCl1 == null) ? 0 : fCl1.hashCode());
    result = prime * result + ((fCl2 == null) ? 0 : fCl2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExternalEntitiesWithTheSameNameMatch)) { // this should be infrequent
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
    ExternalEntitiesWithTheSameNameMatch other = (ExternalEntitiesWithTheSameNameMatch) obj;
    if (fCl1 == null) {if (other.fCl1 != null) return false;}
    else if (!fCl1.equals(other.fCl1)) return false;
    if (fCl2 == null) {if (other.fCl2 != null) return false;}
    else if (!fCl2.equals(other.fCl2)) return false;
    return true;
  }
  
  @Override
  public ExternalEntitiesWithTheSameNameQuerySpecification specification() {
    try {
    	return ExternalEntitiesWithTheSameNameQuerySpecification.instance();
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
  public static ExternalEntitiesWithTheSameNameMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExternalEntitiesWithTheSameNameMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return new Mutable(pCl1, pCl2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl1 the fixed value of pattern parameter cl1, or null if not bound.
   * @param pCl2 the fixed value of pattern parameter cl2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExternalEntitiesWithTheSameNameMatch newMatch(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
    return new Immutable(pCl1, pCl2);
  }
  
  private static final class Mutable extends ExternalEntitiesWithTheSameNameMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
      super(pCl1, pCl2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExternalEntitiesWithTheSameNameMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2) {
      super(pCl1, pCl2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
