package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ReceptionSignalChecksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ReceptionSignalChecks pattern,
 * to be used in conjunction with {@link ReceptionSignalChecksMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionSignalChecksMatcher
 * @see ReceptionSignalChecksProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionSignalChecksMatch extends BasePatternMatch {
  private Parameter fParam;
  
  private Property fProperty;
  
  private Reception fRc;
  
  private Signal fSg;
  
  private static List<String> parameterNames = makeImmutableList("param", "property", "rc", "sg");
  
  private ReceptionSignalChecksMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    this.fParam = pParam;
    this.fProperty = pProperty;
    this.fRc = pRc;
    this.fSg = pSg;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("param".equals(parameterName)) return this.fParam;
    if ("property".equals(parameterName)) return this.fProperty;
    if ("rc".equals(parameterName)) return this.fRc;
    if ("sg".equals(parameterName)) return this.fSg;
    return null;
  }
  
  public Parameter getParam() {
    return this.fParam;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  public Reception getRc() {
    return this.fRc;
  }
  
  public Signal getSg() {
    return this.fSg;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("param".equals(parameterName) ) {
    	this.fParam = (org.eclipse.uml2.uml.Parameter) newValue;
    	return true;
    }
    if ("property".equals(parameterName) ) {
    	this.fProperty = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("rc".equals(parameterName) ) {
    	this.fRc = (org.eclipse.uml2.uml.Reception) newValue;
    	return true;
    }
    if ("sg".equals(parameterName) ) {
    	this.fSg = (org.eclipse.uml2.uml.Signal) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParam(final Parameter pParam) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParam = pParam;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  public void setRc(final Reception pRc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRc = pRc;
  }
  
  public void setSg(final Signal pSg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSg = pSg;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ReceptionSignalChecks";
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionSignalChecksMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParam, fProperty, fRc, fSg};
  }
  
  @Override
  public ReceptionSignalChecksMatch toImmutable() {
    return isMutable() ? newMatch(fParam, fProperty, fRc, fSg) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"param\"=" + prettyPrintValue(fParam) + ", ");
    
    result.append("\"property\"=" + prettyPrintValue(fProperty) + ", ");
    
    result.append("\"rc\"=" + prettyPrintValue(fRc) + ", ");
    
    result.append("\"sg\"=" + prettyPrintValue(fSg)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParam == null) ? 0 : fParam.hashCode());
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    result = prime * result + ((fRc == null) ? 0 : fRc.hashCode());
    result = prime * result + ((fSg == null) ? 0 : fSg.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReceptionSignalChecksMatch)) { // this should be infrequent
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
    ReceptionSignalChecksMatch other = (ReceptionSignalChecksMatch) obj;
    if (fParam == null) {if (other.fParam != null) return false;}
    else if (!fParam.equals(other.fParam)) return false;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    if (fRc == null) {if (other.fRc != null) return false;}
    else if (!fRc.equals(other.fRc)) return false;
    if (fSg == null) {if (other.fSg != null) return false;}
    else if (!fSg.equals(other.fSg)) return false;
    return true;
  }
  
  @Override
  public ReceptionSignalChecksQuerySpecification specification() {
    try {
    	return ReceptionSignalChecksQuerySpecification.instance();
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
  public static ReceptionSignalChecksMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionSignalChecksMatch newMutableMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return new Mutable(pParam, pProperty, pRc, pSg);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionSignalChecksMatch newMatch(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
    return new Immutable(pParam, pProperty, pRc, pSg);
  }
  
  private static final class Mutable extends ReceptionSignalChecksMatch {
    Mutable(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
      super(pParam, pProperty, pRc, pSg);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionSignalChecksMatch {
    Immutable(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg) {
      super(pParam, pProperty, pRc, pSg);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
