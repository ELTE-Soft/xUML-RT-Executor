package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.SignalQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Signal pattern,
 * to be used in conjunction with {@link SignalMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalMatcher
 * @see SignalProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private static List<String> parameterNames = makeImmutableList("signal");
  
  private SignalMatch(final Signal pSignal) {
    this.fSignal = pSignal;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    return null;
    
  }
  
  public Signal getSignal() {
    return this.fSignal;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Signal";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal};
    
  }
  
  @Override
  public SignalMatch toImmutable() {
    return isMutable() ? newMatch(fSignal) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SignalMatch other = (SignalMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    return true;
  }
  
  @Override
  public SignalQuerySpecification specification() {
    try {
    	return SignalQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static SignalMatch newEmptyMatch() {
    return new Mutable(null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalMatch newMutableMatch(final Signal pSignal) {
    return new Mutable(pSignal);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalMatch newMatch(final Signal pSignal) {
    return new Immutable(pSignal);
    
  }
  
  private static final class Mutable extends SignalMatch {
    Mutable(final Signal pSignal) {
      super(pSignal);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalMatch {
    Immutable(final Signal pSignal) {
      super(pSignal);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
