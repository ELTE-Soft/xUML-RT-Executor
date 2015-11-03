package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.ComponentNonPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Component;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.ComponentNonPublic pattern,
 * to be used in conjunction with {@link ComponentNonPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ComponentNonPublicMatcher
 * @see ComponentNonPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentNonPublicMatch extends BasePatternMatch {
  private Component fCp;
  
  private static List<String> parameterNames = makeImmutableList("cp");
  
  private ComponentNonPublicMatch(final Component pCp) {
    this.fCp = pCp;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("cp".equals(parameterName)) return this.fCp;
    return null;
  }
  
  public Component getCp() {
    return this.fCp;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("cp".equals(parameterName) ) {
    	this.fCp = (org.eclipse.uml2.uml.Component) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCp(final Component pCp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCp = pCp;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.ComponentNonPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return ComponentNonPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCp};
  }
  
  @Override
  public ComponentNonPublicMatch toImmutable() {
    return isMutable() ? newMatch(fCp) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"cp\"=" + prettyPrintValue(fCp)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCp == null) ? 0 : fCp.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ComponentNonPublicMatch)) { // this should be infrequent
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
    ComponentNonPublicMatch other = (ComponentNonPublicMatch) obj;
    if (fCp == null) {if (other.fCp != null) return false;}
    else if (!fCp.equals(other.fCp)) return false;
    return true;
  }
  
  @Override
  public ComponentNonPublicQuerySpecification specification() {
    try {
    	return ComponentNonPublicQuerySpecification.instance();
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
  public static ComponentNonPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ComponentNonPublicMatch newMutableMatch(final Component pCp) {
    return new Mutable(pCp);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ComponentNonPublicMatch newMatch(final Component pCp) {
    return new Immutable(pCp);
  }
  
  private static final class Mutable extends ComponentNonPublicMatch {
    Mutable(final Component pCp) {
      super(pCp);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ComponentNonPublicMatch {
    Immutable(final Component pCp) {
      super(pCp);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
