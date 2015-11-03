package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.LeafRedefinedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.RedefinableElement;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.LeafRedefined pattern,
 * to be used in conjunction with {@link LeafRedefinedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LeafRedefinedMatcher
 * @see LeafRedefinedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LeafRedefinedMatch extends BasePatternMatch {
  private RedefinableElement fElem;
  
  private RedefinableElement fRedefining;
  
  private static List<String> parameterNames = makeImmutableList("elem", "redefining");
  
  private LeafRedefinedMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    this.fElem = pElem;
    this.fRedefining = pRedefining;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("elem".equals(parameterName)) return this.fElem;
    if ("redefining".equals(parameterName)) return this.fRedefining;
    return null;
  }
  
  public RedefinableElement getElem() {
    return this.fElem;
  }
  
  public RedefinableElement getRedefining() {
    return this.fRedefining;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("elem".equals(parameterName) ) {
    	this.fElem = (org.eclipse.uml2.uml.RedefinableElement) newValue;
    	return true;
    }
    if ("redefining".equals(parameterName) ) {
    	this.fRedefining = (org.eclipse.uml2.uml.RedefinableElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setElem(final RedefinableElement pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
  }
  
  public void setRedefining(final RedefinableElement pRedefining) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRedefining = pRedefining;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.LeafRedefined";
  }
  
  @Override
  public List<String> parameterNames() {
    return LeafRedefinedMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fElem, fRedefining};
  }
  
  @Override
  public LeafRedefinedMatch toImmutable() {
    return isMutable() ? newMatch(fElem, fRedefining) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"elem\"=" + prettyPrintValue(fElem) + ", ");
    
    result.append("\"redefining\"=" + prettyPrintValue(fRedefining)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    result = prime * result + ((fRedefining == null) ? 0 : fRedefining.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LeafRedefinedMatch)) { // this should be infrequent
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
    LeafRedefinedMatch other = (LeafRedefinedMatch) obj;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    if (fRedefining == null) {if (other.fRedefining != null) return false;}
    else if (!fRedefining.equals(other.fRedefining)) return false;
    return true;
  }
  
  @Override
  public LeafRedefinedQuerySpecification specification() {
    try {
    	return LeafRedefinedQuerySpecification.instance();
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
  public static LeafRedefinedMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LeafRedefinedMatch newMutableMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return new Mutable(pElem, pRedefining);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pRedefining the fixed value of pattern parameter redefining, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LeafRedefinedMatch newMatch(final RedefinableElement pElem, final RedefinableElement pRedefining) {
    return new Immutable(pElem, pRedefining);
  }
  
  private static final class Mutable extends LeafRedefinedMatch {
    Mutable(final RedefinableElement pElem, final RedefinableElement pRedefining) {
      super(pElem, pRedefining);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LeafRedefinedMatch {
    Immutable(final RedefinableElement pElem, final RedefinableElement pRedefining) {
      super(pElem, pRedefining);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
