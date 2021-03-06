package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.PackageNonPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.PackageNonPublic pattern,
 * to be used in conjunction with {@link PackageNonPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PackageNonPublicMatcher
 * @see PackageNonPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PackageNonPublicMatch extends BasePatternMatch {
  private org.eclipse.uml2.uml.Package fPk;
  
  private static List<String> parameterNames = makeImmutableList("pk");
  
  private PackageNonPublicMatch(final org.eclipse.uml2.uml.Package pPk) {
    this.fPk = pPk;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pk".equals(parameterName)) return this.fPk;
    return null;
  }
  
  public org.eclipse.uml2.uml.Package getPk() {
    return this.fPk;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pk".equals(parameterName) ) {
    	this.fPk = (org.eclipse.uml2.uml.Package) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPk(final org.eclipse.uml2.uml.Package pPk) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPk = pPk;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.PackageNonPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return PackageNonPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPk};
  }
  
  @Override
  public PackageNonPublicMatch toImmutable() {
    return isMutable() ? newMatch(fPk) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pk\"=" + prettyPrintValue(fPk)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPk == null) ? 0 : fPk.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PackageNonPublicMatch)) { // this should be infrequent
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
    PackageNonPublicMatch other = (PackageNonPublicMatch) obj;
    if (fPk == null) {if (other.fPk != null) return false;}
    else if (!fPk.equals(other.fPk)) return false;
    return true;
  }
  
  @Override
  public PackageNonPublicQuerySpecification specification() {
    try {
    	return PackageNonPublicQuerySpecification.instance();
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
  public static PackageNonPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PackageNonPublicMatch newMutableMatch(final org.eclipse.uml2.uml.Package pPk) {
    return new Mutable(pPk);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPk the fixed value of pattern parameter pk, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PackageNonPublicMatch newMatch(final org.eclipse.uml2.uml.Package pPk) {
    return new Immutable(pPk);
  }
  
  private static final class Mutable extends PackageNonPublicMatch {
    Mutable(final org.eclipse.uml2.uml.Package pPk) {
      super(pPk);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PackageNonPublicMatch {
    Immutable(final org.eclipse.uml2.uml.Package pPk) {
      super(pPk);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
