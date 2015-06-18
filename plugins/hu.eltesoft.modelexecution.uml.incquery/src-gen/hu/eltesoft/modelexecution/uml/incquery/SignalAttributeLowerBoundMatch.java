package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeLowerBoundQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBound pattern,
 * to be used in conjunction with {@link SignalAttributeLowerBoundMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalAttributeLowerBoundMatcher
 * @see SignalAttributeLowerBoundProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeLowerBoundMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private Property fAttribute;
  
  private ValueSpecification fLowerBound;
  
  private static List<String> parameterNames = makeImmutableList("signal", "attribute", "lowerBound");
  
  private SignalAttributeLowerBoundMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    this.fSignal = pSignal;
    this.fAttribute = pAttribute;
    this.fLowerBound = pLowerBound;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    if ("lowerBound".equals(parameterName)) return this.fLowerBound;
    return null;
    
  }
  
  public Signal getSignal() {
    return this.fSignal;
    
  }
  
  public Property getAttribute() {
    return this.fAttribute;
    
  }
  
  public ValueSpecification getLowerBound() {
    return this.fLowerBound;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("signal".equals(parameterName) ) {
    	this.fSignal = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("attribute".equals(parameterName) ) {
    	this.fAttribute = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("lowerBound".equals(parameterName) ) {
    	this.fLowerBound = (org.eclipse.uml2.uml.ValueSpecification) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSignal(final Signal pSignal) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignal = pSignal;
    
  }
  
  public void setAttribute(final Property pAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute = pAttribute;
    
  }
  
  public void setLowerBound(final ValueSpecification pLowerBound) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLowerBound = pLowerBound;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBound";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalAttributeLowerBoundMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fAttribute, fLowerBound};
    
  }
  
  @Override
  public SignalAttributeLowerBoundMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fAttribute, fLowerBound) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute) + ", ");
    result.append("\"lowerBound\"=" + prettyPrintValue(fLowerBound));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    result = prime * result + ((fLowerBound == null) ? 0 : fLowerBound.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalAttributeLowerBoundMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SignalAttributeLowerBoundMatch other = (SignalAttributeLowerBoundMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    if (fLowerBound == null) {if (other.fLowerBound != null) return false;}
    else if (!fLowerBound.equals(other.fLowerBound)) return false;
    return true;
  }
  
  @Override
  public SignalAttributeLowerBoundQuerySpecification specification() {
    try {
    	return SignalAttributeLowerBoundQuerySpecification.instance();
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
  public static SignalAttributeLowerBoundMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalAttributeLowerBoundMatch newMutableMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return new Mutable(pSignal, pAttribute, pLowerBound);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalAttributeLowerBoundMatch newMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return new Immutable(pSignal, pAttribute, pLowerBound);
    
  }
  
  private static final class Mutable extends SignalAttributeLowerBoundMatch {
    Mutable(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
      super(pSignal, pAttribute, pLowerBound);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalAttributeLowerBoundMatch {
    Immutable(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
      super(pSignal, pAttribute, pLowerBound);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
