package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.SignalAttribute pattern,
 * to be used in conjunction with {@link SignalAttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SignalAttributeMatcher
 * @see SignalAttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SignalAttributeMatch extends BasePatternMatch {
  private Signal fSignal;
  
  private Property fAttribute;
  
  private Type fType;
  
  private Boolean fOrdered;
  
  private Boolean fUnique;
  
  private static List<String> parameterNames = makeImmutableList("signal", "attribute", "type", "ordered", "unique");
  
  private SignalAttributeMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    this.fSignal = pSignal;
    this.fAttribute = pAttribute;
    this.fType = pType;
    this.fOrdered = pOrdered;
    this.fUnique = pUnique;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("signal".equals(parameterName)) return this.fSignal;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    if ("type".equals(parameterName)) return this.fType;
    if ("ordered".equals(parameterName)) return this.fOrdered;
    if ("unique".equals(parameterName)) return this.fUnique;
    return null;
    
  }
  
  public Signal getSignal() {
    return this.fSignal;
    
  }
  
  public Property getAttribute() {
    return this.fAttribute;
    
  }
  
  public Type getType() {
    return this.fType;
    
  }
  
  public Boolean getOrdered() {
    return this.fOrdered;
    
  }
  
  public Boolean getUnique() {
    return this.fUnique;
    
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
    if ("type".equals(parameterName) ) {
    	this.fType = (org.eclipse.uml2.uml.Type) newValue;
    	return true;
    }
    if ("ordered".equals(parameterName) ) {
    	this.fOrdered = (java.lang.Boolean) newValue;
    	return true;
    }
    if ("unique".equals(parameterName) ) {
    	this.fUnique = (java.lang.Boolean) newValue;
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
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
    
  }
  
  public void setOrdered(final Boolean pOrdered) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOrdered = pOrdered;
    
  }
  
  public void setUnique(final Boolean pUnique) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fUnique = pUnique;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalAttribute";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SignalAttributeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSignal, fAttribute, fType, fOrdered, fUnique};
    
  }
  
  @Override
  public SignalAttributeMatch toImmutable() {
    return isMutable() ? newMatch(fSignal, fAttribute, fType, fOrdered, fUnique) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"signal\"=" + prettyPrintValue(fSignal) + ", ");
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
    result.append("\"ordered\"=" + prettyPrintValue(fOrdered) + ", ");
    result.append("\"unique\"=" + prettyPrintValue(fUnique));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSignal == null) ? 0 : fSignal.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    result = prime * result + ((fOrdered == null) ? 0 : fOrdered.hashCode());
    result = prime * result + ((fUnique == null) ? 0 : fUnique.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SignalAttributeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SignalAttributeMatch other = (SignalAttributeMatch) obj;
    if (fSignal == null) {if (other.fSignal != null) return false;}
    else if (!fSignal.equals(other.fSignal)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    if (fOrdered == null) {if (other.fOrdered != null) return false;}
    else if (!fOrdered.equals(other.fOrdered)) return false;
    if (fUnique == null) {if (other.fUnique != null) return false;}
    else if (!fUnique.equals(other.fUnique)) return false;
    return true;
  }
  
  @Override
  public SignalAttributeQuerySpecification specification() {
    try {
    	return SignalAttributeQuerySpecification.instance();
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
  public static SignalAttributeMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SignalAttributeMatch newMutableMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Mutable(pSignal, pAttribute, pType, pOrdered, pUnique);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SignalAttributeMatch newMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Immutable(pSignal, pAttribute, pType, pOrdered, pUnique);
    
  }
  
  private static final class Mutable extends SignalAttributeMatch {
    Mutable(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pSignal, pAttribute, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SignalAttributeMatch {
    Immutable(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pSignal, pAttribute, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
