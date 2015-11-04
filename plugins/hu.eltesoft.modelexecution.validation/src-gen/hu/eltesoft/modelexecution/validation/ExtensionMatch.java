package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ExtensionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.Extension pattern,
 * to be used in conjunction with {@link ExtensionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ExtensionMatcher
 * @see ExtensionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ExtensionMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Class fElem;
  
  private static List<String> parameterNames = makeImmutableList("elem");
  
  private ExtensionMatch(final org.eclipse.uml2.uml.Class pElem) {
    this.fElem = pElem;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("elem".equals(parameterName)) return this.fElem;
    return null;
  }
  
  public org.eclipse.uml2.uml.Class getElem() {
    return this.fElem;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.Class) newValue;
    	return true;
    }
    return false;
  }
  
  public void setElem(final org.eclipse.uml2.uml.Class pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.Extension";
  }
  
  @Override
  public List<String> parameterNames() {
    return ExtensionMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fElem};
  }
  
  @Override
  public ExtensionMatch toImmutable() {
    return isMutable() ? newMatch(fElem) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"elem\"=" + prettyPrintValue(fElem)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ExtensionMatch)) { // this should be infrequent
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
    ExtensionMatch other = (ExtensionMatch) obj;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    return true;
  }
  
  @Override
  public ExtensionQuerySpecification specification() {
    try {
    	return ExtensionQuerySpecification.instance();
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
  public static ExtensionMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ExtensionMatch newMutableMatch(final org.eclipse.uml2.uml.Class pElem) {
    return new Mutable(pElem);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ExtensionMatch newMatch(final org.eclipse.uml2.uml.Class pElem) {
    return new Immutable(pElem);
  }
  
  private static final class Mutable extends ExtensionMatch {
    Mutable(final org.eclipse.uml2.uml.Class pElem) {
      super(pElem);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ExtensionMatch {
    Immutable(final org.eclipse.uml2.uml.Class pElem) {
      super(pElem);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
