package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.HighBoundZeroQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.HighBoundZero pattern,
 * to be used in conjunction with {@link HighBoundZeroMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see HighBoundZeroMatcher
 * @see HighBoundZeroProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class HighBoundZeroMatch extends BasePatternMatch {
  private MultiplicityElement fMe;
  
  private static List<String> parameterNames = makeImmutableList("me");
  
  private HighBoundZeroMatch(final MultiplicityElement pMe) {
    this.fMe = pMe;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("me".equals(parameterName)) return this.fMe;
    return null;
  }
  
  public MultiplicityElement getMe() {
    return this.fMe;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("me".equals(parameterName) ) {
    	this.fMe = (org.eclipse.uml2.uml.MultiplicityElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMe(final MultiplicityElement pMe) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMe = pMe;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.HighBoundZero";
  }
  
  @Override
  public List<String> parameterNames() {
    return HighBoundZeroMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMe};
  }
  
  @Override
  public HighBoundZeroMatch toImmutable() {
    return isMutable() ? newMatch(fMe) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"me\"=" + prettyPrintValue(fMe)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fMe == null) ? 0 : fMe.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof HighBoundZeroMatch)) { // this should be infrequent
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
    HighBoundZeroMatch other = (HighBoundZeroMatch) obj;
    if (fMe == null) {if (other.fMe != null) return false;}
    else if (!fMe.equals(other.fMe)) return false;
    return true;
  }
  
  @Override
  public HighBoundZeroQuerySpecification specification() {
    try {
    	return HighBoundZeroQuerySpecification.instance();
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
  public static HighBoundZeroMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static HighBoundZeroMatch newMutableMatch(final MultiplicityElement pMe) {
    return new Mutable(pMe);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pMe the fixed value of pattern parameter me, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static HighBoundZeroMatch newMatch(final MultiplicityElement pMe) {
    return new Immutable(pMe);
  }
  
  private static final class Mutable extends HighBoundZeroMatch {
    Mutable(final MultiplicityElement pMe) {
      super(pMe);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends HighBoundZeroMatch {
    Immutable(final MultiplicityElement pMe) {
      super(pMe);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
