package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.SignalNonPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.SignalNonPublic pattern,
 * to be used in conjunction with {@link SignalNonPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalNonPublicMatcher
 * @see SignalNonPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalNonPublicMatch extends BasePatternMatch {
  private Signal fSg;
  
  private static List<String> parameterNames = makeImmutableList("sg");
  
  private SignalNonPublicMatch(final Signal pSg) {
    this.fSg = pSg;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sg".equals(parameterName)) return this.fSg;
    return null;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.SignalNonPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalNonPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSg};
  }
  
  @Override
  public SignalNonPublicMatch toImmutable() {
    return isMutable() ? newMatch(fSg) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sg\"=" + prettyPrintValue(fSg)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalNonPublicMatch)) { // this should be infrequent
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
    SignalNonPublicMatch other = (SignalNonPublicMatch) obj;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    return true;
  }
  
  @Override
  public SignalNonPublicQuerySpecification specification() {
    try {
    	return SignalNonPublicQuerySpecification.instance();
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
  public static SignalNonPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalNonPublicMatch newMutableMatch(final Signal pSg) {
    return new Mutable(pSg);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalNonPublicMatch newMatch(final Signal pSg) {
    return new Immutable(pSg);
  }
  
  private static final class Mutable extends SignalNonPublicMatch {
    Mutable(final Signal pSg) {
      super(pSg);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalNonPublicMatch {
    Immutable(final Signal pSg) {
      super(pSg);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
