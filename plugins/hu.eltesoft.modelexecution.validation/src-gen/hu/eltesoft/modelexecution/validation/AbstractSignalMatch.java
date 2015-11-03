package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.AbstractSignalQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.AbstractSignal pattern,
 * to be used in conjunction with {@link AbstractSignalMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AbstractSignalMatcher
 * @see AbstractSignalProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AbstractSignalMatch extends BasePatternMatch {
  private Signal fSg;
  
  private static List<String> parameterNames = makeImmutableList("sg");
  
  private AbstractSignalMatch(final Signal pSg) {
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
    return "hu.eltesoft.modelexecution.validation.AbstractSignal";
  }
  
  @Override
  public List<String> parameterNames() {
    return AbstractSignalMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSg};
  }
  
  @Override
  public AbstractSignalMatch toImmutable() {
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
    if (!(obj instanceof AbstractSignalMatch)) { // this should be infrequent
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
    AbstractSignalMatch other = (AbstractSignalMatch) obj;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    return true;
  }
  
  @Override
  public AbstractSignalQuerySpecification specification() {
    try {
    	return AbstractSignalQuerySpecification.instance();
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
  public static AbstractSignalMatch newEmptyMatch() {
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
  public static AbstractSignalMatch newMutableMatch(final Signal pSg) {
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
  public static AbstractSignalMatch newMatch(final Signal pSg) {
    return new Immutable(pSg);
  }
  
  private static final class Mutable extends AbstractSignalMatch {
    Mutable(final Signal pSg) {
      super(pSg);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AbstractSignalMatch {
    Immutable(final Signal pSg) {
      super(pSg);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
