package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ReceptionWithoutSignalQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Reception;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ReceptionWithoutSignal pattern,
 * to be used in conjunction with {@link ReceptionWithoutSignalMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReceptionWithoutSignalMatcher
 * @see ReceptionWithoutSignalProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionWithoutSignalMatch extends BasePatternMatch {
  private Reception fRc;
  
  private static List<String> parameterNames = makeImmutableList("rc");
  
  private ReceptionWithoutSignalMatch(final Reception pRc) {
    this.fRc = pRc;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("rc".equals(parameterName)) return this.fRc;
    return null;
  }
  
  public Reception getRc() {
    return this.fRc;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("rc".equals(parameterName) ) {
    	this.fRc = (org.eclipse.uml2.uml.Reception) newValue;
    	return true;
    }
    return false;
  }
  
  public void setRc(final Reception pRc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRc = pRc;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ReceptionWithoutSignal";
  }
  
  @Override
  public List<String> parameterNames() {
    return ReceptionWithoutSignalMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRc};
  }
  
  @Override
  public ReceptionWithoutSignalMatch toImmutable() {
    return isMutable() ? newMatch(fRc) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"rc\"=" + prettyPrintValue(fRc)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRc == null) ? 0 : fRc.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReceptionWithoutSignalMatch)) { // this should be infrequent
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
    ReceptionWithoutSignalMatch other = (ReceptionWithoutSignalMatch) obj;
    if (fRc == null) {if (other.fRc != null) return false;}
    else if (!fRc.equals(other.fRc)) return false;
    return true;
  }
  
  @Override
  public ReceptionWithoutSignalQuerySpecification specification() {
    try {
    	return ReceptionWithoutSignalQuerySpecification.instance();
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
  public static ReceptionWithoutSignalMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReceptionWithoutSignalMatch newMutableMatch(final Reception pRc) {
    return new Mutable(pRc);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRc the fixed value of pattern parameter rc, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReceptionWithoutSignalMatch newMatch(final Reception pRc) {
    return new Immutable(pRc);
  }
  
  private static final class Mutable extends ReceptionWithoutSignalMatch {
    Mutable(final Reception pRc) {
      super(pRc);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReceptionWithoutSignalMatch {
    Immutable(final Reception pRc) {
      super(pRc);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
