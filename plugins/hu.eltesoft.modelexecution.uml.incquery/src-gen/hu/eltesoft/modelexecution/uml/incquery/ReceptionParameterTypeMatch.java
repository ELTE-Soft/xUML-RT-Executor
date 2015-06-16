package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Type;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterType pattern,
 * to be used in conjunction with {@link ReceptionParameterTypeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionParameterTypeMatcher
 * @see ReceptionParameterTypeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionParameterTypeMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Reception fReception;
  
  private Parameter fParameter;
  
  private Type fType;
  
  private Boolean fOrdered;
  
  private Boolean fUnique;
  
  private static List<String> parameterNames = makeImmutableList("cls", "reception", "parameter", "type", "ordered", "unique");
  
  private ReceptionParameterTypeMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    this.fCls = pCls;
    this.fReception = pReception;
    this.fParameter = pParameter;
    this.fType = pType;
    this.fOrdered = pOrdered;
    this.fUnique = pUnique;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("reception".equals(parameterName)) return this.fReception;
    if ("parameter".equals(parameterName)) return this.fParameter;
    if ("type".equals(parameterName)) return this.fType;
    if ("ordered".equals(parameterName)) return this.fOrdered;
    if ("unique".equals(parameterName)) return this.fUnique;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public Reception getReception() {
    return this.fReception;
    
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
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("reception".equals(parameterName) ) {
    	this.fReception = (org.eclipse.uml2.uml.Reception) newValue;
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
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setReception(final Reception pReception) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fReception = pReception;
    
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
    return "hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterType";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionParameterTypeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fReception, fParameter, fType, fOrdered, fUnique};
    
  }
  
  @Override
  public ReceptionParameterTypeMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fReception, fParameter, fType, fOrdered, fUnique) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"reception\"=" + prettyPrintValue(fReception) + ", ");
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
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fReception == null) ? 0 : fReception.hashCode());
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
    if (!(obj instanceof ReceptionParameterTypeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ReceptionParameterTypeMatch other = (ReceptionParameterTypeMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fReception == null) {if (other.fReception != null) return false;}
    else if (!fReception.equals(other.fReception)) return false;
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
  public ReceptionParameterTypeQuerySpecification specification() {
    try {
    	return ReceptionParameterTypeQuerySpecification.instance();
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
  public static ReceptionParameterTypeMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionParameterTypeMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Mutable(pCls, pReception, pParameter, pType, pOrdered, pUnique);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionParameterTypeMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return new Immutable(pCls, pReception, pParameter, pType, pOrdered, pUnique);
    
  }
  
  private static final class Mutable extends ReceptionParameterTypeMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pCls, pReception, pParameter, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionParameterTypeMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
      super(pCls, pReception, pParameter, pType, pOrdered, pUnique);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
