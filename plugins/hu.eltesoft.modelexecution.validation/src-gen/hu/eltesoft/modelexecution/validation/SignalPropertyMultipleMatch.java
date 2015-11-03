package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.SignalPropertyMultipleQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.SignalPropertyMultiple pattern,
 * to be used in conjunction with {@link SignalPropertyMultipleMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalPropertyMultipleMatcher
 * @see SignalPropertyMultipleProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalPropertyMultipleMatch extends BasePatternMatch {
  private Signal fSg;
  
  private Property fProp;
  
  private static List<String> parameterNames = makeImmutableList("sg", "prop");
  
  private SignalPropertyMultipleMatch(final Signal pSg, final Property pProp) {
    this.fSg = pSg;
    this.fProp = pProp;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sg".equals(parameterName)) return this.fSg;
    if ("prop".equals(parameterName)) return this.fProp;
    return null;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  public Property getProp() {
    return this.fProp;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("prop".equals(parameterName) ) {
    	this.fProp = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  public void setProp(final Property pProp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProp = pProp;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.SignalPropertyMultiple";
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalPropertyMultipleMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSg, fProp};
  }
  
  @Override
  public SignalPropertyMultipleMatch toImmutable() {
    return isMutable() ? newMatch(fSg, fProp) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
    
    result.append("\"prop\"=" + prettyPrintValue(fProp)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    result = prime * result + ((fProp == null) ? 0 : fProp.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalPropertyMultipleMatch)) { // this should be infrequent
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
    SignalPropertyMultipleMatch other = (SignalPropertyMultipleMatch) obj;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    if (fProp == null) {if (other.fProp != null) return false;}
    else if (!fProp.equals(other.fProp)) return false;
    return true;
  }
  
  @Override
  public SignalPropertyMultipleQuerySpecification specification() {
    try {
    	return SignalPropertyMultipleQuerySpecification.instance();
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
  public static SignalPropertyMultipleMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalPropertyMultipleMatch newMutableMatch(final Signal pSg, final Property pProp) {
    return new Mutable(pSg, pProp);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pProp the fixed value of pattern parameter prop, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalPropertyMultipleMatch newMatch(final Signal pSg, final Property pProp) {
    return new Immutable(pSg, pProp);
  }
  
  private static final class Mutable extends SignalPropertyMultipleMatch {
    Mutable(final Signal pSg, final Property pProp) {
      super(pSg, pProp);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalPropertyMultipleMatch {
    Immutable(final Signal pSg, final Property pProp) {
      super(pSg, pProp);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
