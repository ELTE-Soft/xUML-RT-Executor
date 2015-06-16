package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterType pattern,
 * to be used in conjunction with {@link BehaviorParameterTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BehaviorParameterTypeMatcher
 * @see BehaviorParameterTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BehaviorParameterTypeMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private Parameter fParameter;
  
  private Type fType;
  
  private Boolean fOrdered;
  
  private Boolean fUnique;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "parameter", "type", "ordered", "unique");
  
  private BehaviorParameterTypeMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    this.fBehavior = pBehavior;
    this.fParameter = pParameter;
    this.fType = pType;
    this.fOrdered = pOrdered;
    this.fUnique = pUnique;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("type".equals(parameterName)) return this.fType;
    if ("ordered".equals(parameterName)) return this.fOrdered;
    if ("unique".equals(parameterName)) return this.fUnique;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public Parameter getParameter() {
    return this.fParameter;
    
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
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("parameter".equals(parameterName) ) {
    	this.fParameter = (org.eclipse.uml2.uml.Parameter) newValue;
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
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setParameter(final Parameter pParameter) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParameter = pParameter;
    
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
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return BehaviorParameterTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fParameter, fType, fOrdered, fUnique};
    
  }
  
  @Override
  public BehaviorParameterTypeMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fParameter, fType, fOrdered, fUnique) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"parameter\"=" + prettyPrintValue(fParameter) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType) + ", ");
    result.append("\"ordered\"=" + prettyPrintValue(fOrdered) + ", ");
    result.append("\"unique\"=" + prettyPrintValue(fUnique));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    result = prime * result + ((fType == null) ? 0 : fType.hashCode());
    result = prime * result + ((fOrdered == null) ? 0 : fOrdered.hashCode());
    result = prime * result + ((fUnique == null) ? 0 : fUnique.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BehaviorParameterTypeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BehaviorParameterTypeMatch other = (BehaviorParameterTypeMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    if (fOrdered == null) {if (other.fOrdered != null) return false;}
    else if (!fOrdered.equals(other.fOrdered)) return false;
    if (fUnique == null) {if (other.fUnique != null) return false;}
    else if (!fUnique.equals(other.fUnique)) return false;
    return true;
  }
  
  @Override
  public BehaviorParameterTypeQuerySpecification specification() {
    try {
    	return BehaviorParameterTypeQuerySpecification.instance();
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
  public static BehaviorParameterTypeMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BehaviorParameterTypeMatch newMutableMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Mutable(pBehavior, pParameter, pType, pOrdered, pUnique);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BehaviorParameterTypeMatch newMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Immutable(pBehavior, pParameter, pType, pOrdered, pUnique);
    
  }
  
  private static final class Mutable extends BehaviorParameterTypeMatch {
    Mutable(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pBehavior, pParameter, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BehaviorParameterTypeMatch {
    Immutable(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pBehavior, pParameter, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
