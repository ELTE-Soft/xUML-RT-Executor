package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.AlfCodeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.AlfCode pattern,
 * to be used in conjunction with {@link AlfCodeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AlfCodeMatcher
 * @see AlfCodeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AlfCodeMatch extends BasePatternMatch {
  private Behavior fBehavior;
  
  private org.eclipse.uml2.uml.Class fContainerClass;
  
  private String fAlfCode;
  
  private static List<String> parameterNames = makeImmutableList("behavior", "containerClass", "alfCode");
  
  private AlfCodeMatch(final Behavior pBehavior, final org.eclipse.uml2.uml.Class pContainerClass, final String pAlfCode) {
    this.fBehavior = pBehavior;
    this.fContainerClass = pContainerClass;
    this.fAlfCode = pAlfCode;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("behavior".equals(parameterName)) return this.fBehavior;
    if ("containerClass".equals(parameterName)) return this.fContainerClass;
    if ("alfCode".equals(parameterName)) return this.fAlfCode;
    return null;
    
  }
  
  public Behavior getBehavior() {
    return this.fBehavior;
    
  }
  
  public org.eclipse.uml2.uml.Class getContainerClass() {
    return this.fContainerClass;
    
  }
  
  public String getAlfCode() {
    return this.fAlfCode;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("behavior".equals(parameterName) ) {
    	this.fBehavior = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    if ("containerClass".equals(parameterName) ) {
    	this.fContainerClass = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    if ("alfCode".equals(parameterName) ) {
    	this.fAlfCode = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBehavior(final Behavior pBehavior) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBehavior = pBehavior;
    
  }
  
  public void setContainerClass(final org.eclipse.uml2.uml.Class pContainerClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fContainerClass = pContainerClass;
    
  }
  
  public void setAlfCode(final String pAlfCode) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAlfCode = pAlfCode;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AlfCode";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return AlfCodeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBehavior, fContainerClass, fAlfCode};
    
  }
  
  @Override
  public AlfCodeMatch toImmutable() {
    return isMutable() ? newMatch(fBehavior, fContainerClass, fAlfCode) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"behavior\"=" + prettyPrintValue(fBehavior) + ", ");
    result.append("\"containerClass\"=" + prettyPrintValue(fContainerClass) + ", ");
    result.append("\"alfCode\"=" + prettyPrintValue(fAlfCode));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBehavior == null) ? 0 : fBehavior.hashCode());
    result = prime * result + ((fContainerClass == null) ? 0 : fContainerClass.hashCode());
    result = prime * result + ((fAlfCode == null) ? 0 : fAlfCode.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AlfCodeMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AlfCodeMatch other = (AlfCodeMatch) obj;
    if (fBehavior == null) {if (other.fBehavior != null) return false;}
    else if (!fBehavior.equals(other.fBehavior)) return false;
    if (fContainerClass == null) {if (other.fContainerClass != null) return false;}
    else if (!fContainerClass.equals(other.fContainerClass)) return false;
    if (fAlfCode == null) {if (other.fAlfCode != null) return false;}
    else if (!fAlfCode.equals(other.fAlfCode)) return false;
    return true;
  }
  
  @Override
  public AlfCodeQuerySpecification specification() {
    try {
    	return AlfCodeQuerySpecification.instance();
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
  public static AlfCodeMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClass the fixed value of pattern parameter containerClass, or null if not bound.
   * @param pAlfCode the fixed value of pattern parameter alfCode, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AlfCodeMatch newMutableMatch(final Behavior pBehavior, final org.eclipse.uml2.uml.Class pContainerClass, final String pAlfCode) {
    return new Mutable(pBehavior, pContainerClass, pAlfCode);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClass the fixed value of pattern parameter containerClass, or null if not bound.
   * @param pAlfCode the fixed value of pattern parameter alfCode, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AlfCodeMatch newMatch(final Behavior pBehavior, final org.eclipse.uml2.uml.Class pContainerClass, final String pAlfCode) {
    return new Immutable(pBehavior, pContainerClass, pAlfCode);
    
  }
  
  private static final class Mutable extends AlfCodeMatch {
    Mutable(final Behavior pBehavior, final org.eclipse.uml2.uml.Class pContainerClass, final String pAlfCode) {
      super(pBehavior, pContainerClass, pAlfCode);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AlfCodeMatch {
    Immutable(final Behavior pBehavior, final org.eclipse.uml2.uml.Class pContainerClass, final String pAlfCode) {
      super(pBehavior, pContainerClass, pAlfCode);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
