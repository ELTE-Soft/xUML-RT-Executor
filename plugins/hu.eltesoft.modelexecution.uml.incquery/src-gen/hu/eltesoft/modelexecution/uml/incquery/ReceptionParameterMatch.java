package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Reception;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.ReceptionParameter pattern,
 * to be used in conjunction with {@link ReceptionParameterMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionParameterMatcher
 * @see ReceptionParameterProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionParameterMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private Reception fReception;
  
  private Parameter fParameter;
  
  private static List<String> parameterNames = makeImmutableList("cls", "reception", "parameter");
  
  private ReceptionParameterMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter) {
    this.fCls = pCls;
    this.fReception = pReception;
    this.fParameter = pParameter;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("reception".equals(parameterName)) return this.fReception;
    if ("parameter".equals(parameterName)) return this.fParameter;
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
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ReceptionParameter";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionParameterMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fReception, fParameter};
    
  }
  
  @Override
  public ReceptionParameterMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fReception, fParameter) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"reception\"=" + prettyPrintValue(fReception) + ", ");
    result.append("\"parameter\"=" + prettyPrintValue(fParameter));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fReception == null) ? 0 : fReception.hashCode());
    result = prime * result + ((fParameter == null) ? 0 : fParameter.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReceptionParameterMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ReceptionParameterMatch other = (ReceptionParameterMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fReception == null) {if (other.fReception != null) return false;}
    else if (!fReception.equals(other.fReception)) return false;
    if (fParameter == null) {if (other.fParameter != null) return false;}
    else if (!fParameter.equals(other.fParameter)) return false;
    return true;
  }
  
  @Override
  public ReceptionParameterQuerySpecification specification() {
    try {
    	return ReceptionParameterQuerySpecification.instance();
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
  public static ReceptionParameterMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionParameterMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter) {
    return new Mutable(pCls, pReception, pParameter);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionParameterMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter) {
    return new Immutable(pCls, pReception, pParameter);
    
  }
  
  private static final class Mutable extends ReceptionParameterMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter) {
      super(pCls, pReception, pParameter);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionParameterMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final Reception pReception, final Parameter pParameter) {
      super(pCls, pReception, pParameter);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
