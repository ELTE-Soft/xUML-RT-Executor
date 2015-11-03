package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.MethodAbstractQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.MethodAbstract pattern,
 * to be used in conjunction with {@link MethodAbstractMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see MethodAbstractMatcher
 * @see MethodAbstractProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class MethodAbstractMatch extends BasePatternMatch {
  private OpaqueBehavior fMe;
  
  private static List<String> parameterNames = makeImmutableList("me");
  
  private MethodAbstractMatch(final OpaqueBehavior pMe) {
    this.fMe = pMe;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("me".equals(parameterName)) return this.fMe;
    return null;
  }
  
  public OpaqueBehavior getMe() {
    return this.fMe;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("me".equals(parameterName) ) {
    	this.fMe = (org.eclipse.uml2.uml.OpaqueBehavior) newValue;
    	return true;
    }
    return false;
  }
  
  public void setMe(final OpaqueBehavior pMe) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMe = pMe;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.MethodAbstract";
  }
  
  @Override
  public List<String> parameterNames() {
    return MethodAbstractMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fMe};
  }
  
  @Override
  public MethodAbstractMatch toImmutable() {
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
    if (!(obj instanceof MethodAbstractMatch)) { // this should be infrequent
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
    MethodAbstractMatch other = (MethodAbstractMatch) obj;
    if (fMe == null) {if (other.fMe != null) return false;}
    else if (!fMe.equals(other.fMe)) return false;
    return true;
  }
  
  @Override
  public MethodAbstractQuerySpecification specification() {
    try {
    	return MethodAbstractQuerySpecification.instance();
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
  public static MethodAbstractMatch newEmptyMatch() {
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
  public static MethodAbstractMatch newMutableMatch(final OpaqueBehavior pMe) {
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
  public static MethodAbstractMatch newMatch(final OpaqueBehavior pMe) {
    return new Immutable(pMe);
  }
  
  private static final class Mutable extends MethodAbstractMatch {
    Mutable(final OpaqueBehavior pMe) {
      super(pMe);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends MethodAbstractMatch {
    Immutable(final OpaqueBehavior pMe) {
      super(pMe);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
