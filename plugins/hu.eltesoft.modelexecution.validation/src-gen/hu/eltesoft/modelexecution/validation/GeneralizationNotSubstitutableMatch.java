package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.GeneralizationNotSubstitutableQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Generalization;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutable pattern,
 * to be used in conjunction with {@link GeneralizationNotSubstitutableMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GeneralizationNotSubstitutableMatcher
 * @see GeneralizationNotSubstitutableProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationNotSubstitutableMatch extends BasePatternMatch {
  private Generalization fGen;
  
  private static List<String> parameterNames = makeImmutableList("gen");
  
  private GeneralizationNotSubstitutableMatch(final Generalization pGen) {
    this.fGen = pGen;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("gen".equals(parameterName)) return this.fGen;
    return null;
  }
  
  public Generalization getGen() {
    return this.fGen;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("gen".equals(parameterName) ) {
    	this.fGen = (org.eclipse.uml2.uml.Generalization) newValue;
    	return true;
    }
    return false;
  }
  
  public void setGen(final Generalization pGen) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGen = pGen;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutable";
  }
  
  @Override
  public List<String> parameterNames() {
    return GeneralizationNotSubstitutableMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fGen};
  }
  
  @Override
  public GeneralizationNotSubstitutableMatch toImmutable() {
    return isMutable() ? newMatch(fGen) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"gen\"=" + prettyPrintValue(fGen)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fGen == null) ? 0 : fGen.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof GeneralizationNotSubstitutableMatch)) { // this should be infrequent
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
    GeneralizationNotSubstitutableMatch other = (GeneralizationNotSubstitutableMatch) obj;
    if (fGen == null) {if (other.fGen != null) return false;}
    else if (!fGen.equals(other.fGen)) return false;
    return true;
  }
  
  @Override
  public GeneralizationNotSubstitutableQuerySpecification specification() {
    try {
    	return GeneralizationNotSubstitutableQuerySpecification.instance();
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
  public static GeneralizationNotSubstitutableMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pGen the fixed value of pattern parameter gen, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GeneralizationNotSubstitutableMatch newMutableMatch(final Generalization pGen) {
    return new Mutable(pGen);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGen the fixed value of pattern parameter gen, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GeneralizationNotSubstitutableMatch newMatch(final Generalization pGen) {
    return new Immutable(pGen);
  }
  
  private static final class Mutable extends GeneralizationNotSubstitutableMatch {
    Mutable(final Generalization pGen) {
      super(pGen);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GeneralizationNotSubstitutableMatch {
    Immutable(final Generalization pGen) {
      super(pGen);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
