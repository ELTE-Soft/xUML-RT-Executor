package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ReceptionSignalParameterNumQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNum pattern,
 * to be used in conjunction with {@link ReceptionSignalParameterNumMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionSignalParameterNumMatcher
 * @see ReceptionSignalParameterNumProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionSignalParameterNumMatch extends BasePatternMatch {
  private Reception fRc;
  
  private Signal fSg;
  
  private Integer fParams;
  
  private Integer fProperties;
  
  private static List<String> parameterNames = makeImmutableList("rc", "sg", "params", "properties");
  
  private ReceptionSignalParameterNumMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    this.fRc = pRc;
    this.fSg = pSg;
    this.fParams = pParams;
    this.fProperties = pProperties;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rc".equals(parameterName)) return this.fRc;
    if ("sg".equals(parameterName)) return this.fSg;
    if ("params".equals(parameterName)) return this.fParams;
    if ("properties".equals(parameterName)) return this.fProperties;
    return null;
  }
  
  public Reception getRc() {
    return this.fRc;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  public Integer getParams() {
    return this.fParams;
  }
  
  public Integer getProperties() {
    return this.fProperties;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rc".equals(parameterName) ) {
    	this.fRc = (org.eclipse.uml2.uml.Reception) newValue;
    	return true;
    }
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    if ("params".equals(parameterName) ) {
    	this.fParams = (java.lang.Integer) newValue;
    	return true;
    }
    if ("properties".equals(parameterName) ) {
    	this.fProperties = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRc(final Reception pRc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRc = pRc;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  public void setParams(final Integer pParams) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParams = pParams;
  }
  
  public void setProperties(final Integer pProperties) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperties = pProperties;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNum";
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionSignalParameterNumMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRc, fSg, fParams, fProperties};
  }
  
  @Override
  public ReceptionSignalParameterNumMatch toImmutable() {
    return isMutable() ? newMatch(fRc, fSg, fParams, fProperties) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rc\"=" + prettyPrintValue(fRc) + ", ");
    
    result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
    
    result.append("\"params\"=" + prettyPrintValue(fParams) + ", ");
    
    result.append("\"properties\"=" + prettyPrintValue(fProperties)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRc == null) ? 0 : fRc.hashCode());
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    result = prime * result + ((fParams == null) ? 0 : fParams.hashCode());
    result = prime * result + ((fProperties == null) ? 0 : fProperties.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReceptionSignalParameterNumMatch)) { // this should be infrequent
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
    ReceptionSignalParameterNumMatch other = (ReceptionSignalParameterNumMatch) obj;
    if (fRc == null) {if (other.fRc != null) return false;}
    else if (!fRc.equals(other.fRc)) return false;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    if (fParams == null) {if (other.fParams != null) return false;}
    else if (!fParams.equals(other.fParams)) return false;
    if (fProperties == null) {if (other.fProperties != null) return false;}
    else if (!fProperties.equals(other.fProperties)) return false;
    return true;
  }
  
  @Override
  public ReceptionSignalParameterNumQuerySpecification specification() {
    try {
    	return ReceptionSignalParameterNumQuerySpecification.instance();
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
  public static ReceptionSignalParameterNumMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionSignalParameterNumMatch newMutableMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return new Mutable(pRc, pSg, pParams, pProperties);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pParams the fixed value of pattern parameter params, or null if not bound.
   * @param pProperties the fixed value of pattern parameter properties, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionSignalParameterNumMatch newMatch(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
    return new Immutable(pRc, pSg, pParams, pProperties);
  }
  
  private static final class Mutable extends ReceptionSignalParameterNumMatch {
    Mutable(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
      super(pRc, pSg, pParams, pProperties);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionSignalParameterNumMatch {
    Immutable(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties) {
      super(pRc, pSg, pParams, pProperties);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
