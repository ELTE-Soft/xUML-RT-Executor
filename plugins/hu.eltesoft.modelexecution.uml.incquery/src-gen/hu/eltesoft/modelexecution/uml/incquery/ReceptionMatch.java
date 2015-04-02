package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Reception pattern,
 * to be used in conjunction with {@link ReceptionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionMatcher
 * @see ReceptionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fCls;
  
  private String fReceptionName;
  
  private String fSignalName;
  
  private static List<String> parameterNames = makeImmutableList("cls", "receptionName", "signalName");
  
  private ReceptionMatch(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName) {
    this.fCls = pCls;
    this.fReceptionName = pReceptionName;
    this.fSignalName = pSignalName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cls".equals(parameterName)) return this.fCls;
    if ("receptionName".equals(parameterName)) return this.fReceptionName;
    if ("signalName".equals(parameterName)) return this.fSignalName;
    return null;
    
  }
  
  public org.eclipse.uml2.uml.Class getCls() {
    return this.fCls;
    
  }
  
  public String getReceptionName() {
    return this.fReceptionName;
    
  }
  
  public String getSignalName() {
    return this.fSignalName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cls".equals(parameterName) ) {
    	this.fCls = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("receptionName".equals(parameterName) ) {
    	this.fReceptionName = (java.lang.String) newValue;
    	return true;
    }
    if ("signalName".equals(parameterName) ) {
    	this.fSignalName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setCls(final org.eclipse.uml2.uml.Class pCls) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCls = pCls;
    
  }
  
  public void setReceptionName(final String pReceptionName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fReceptionName = pReceptionName;
    
  }
  
  public void setSignalName(final String pSignalName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSignalName = pSignalName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Reception";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCls, fReceptionName, fSignalName};
    
  }
  
  @Override
  public ReceptionMatch toImmutable() {
    return isMutable() ? newMatch(fCls, fReceptionName, fSignalName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cls\"=" + prettyPrintValue(fCls) + ", ");
    result.append("\"receptionName\"=" + prettyPrintValue(fReceptionName) + ", ");
    result.append("\"signalName\"=" + prettyPrintValue(fSignalName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCls == null) ? 0 : fCls.hashCode());
    result = prime * result + ((fReceptionName == null) ? 0 : fReceptionName.hashCode());
    result = prime * result + ((fSignalName == null) ? 0 : fSignalName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReceptionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ReceptionMatch other = (ReceptionMatch) obj;
    if (fCls == null) {if (other.fCls != null) return false;}
    else if (!fCls.equals(other.fCls)) return false;
    if (fReceptionName == null) {if (other.fReceptionName != null) return false;}
    else if (!fReceptionName.equals(other.fReceptionName)) return false;
    if (fSignalName == null) {if (other.fSignalName != null) return false;}
    else if (!fSignalName.equals(other.fSignalName)) return false;
    return true;
  }
  
  @Override
  public ReceptionQuerySpecification specification() {
    try {
    	return ReceptionQuerySpecification.instance();
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
  public static ReceptionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReceptionName the fixed value of pattern parameter receptionName, or null if not bound.
   * @param pSignalName the fixed value of pattern parameter signalName, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionMatch newMutableMatch(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName) {
    return new Mutable(pCls, pReceptionName, pSignalName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pReceptionName the fixed value of pattern parameter receptionName, or null if not bound.
   * @param pSignalName the fixed value of pattern parameter signalName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName) {
    return new Immutable(pCls, pReceptionName, pSignalName);
    
  }
  
  private static final class Mutable extends ReceptionMatch {
    Mutable(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName) {
      super(pCls, pReceptionName, pSignalName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionMatch {
    Immutable(final org.eclipse.uml2.uml.Class pCls, final String pReceptionName, final String pSignalName) {
      super(pCls, pReceptionName, pSignalName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
