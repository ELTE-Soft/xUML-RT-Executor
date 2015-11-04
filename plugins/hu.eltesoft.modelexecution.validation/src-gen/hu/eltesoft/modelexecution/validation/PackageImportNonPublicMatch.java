package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.util.PackageImportNonPublicQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.PackageImport;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.validation.PackageImportNonPublic pattern,
 * to be used in conjunction with {@link PackageImportNonPublicMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PackageImportNonPublicMatcher
 * @see PackageImportNonPublicProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PackageImportNonPublicMatch extends BasePatternMatch {
  private PackageImport fPi;
  
  private static List<String> parameterNames = makeImmutableList("pi");
  
  private PackageImportNonPublicMatch(final PackageImport pPi) {
    this.fPi = pPi;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("pi".equals(parameterName)) return this.fPi;
    return null;
  }
  
  public PackageImport getPi() {
    return this.fPi;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("pi".equals(parameterName) ) {
    	this.fPi = (org.eclipse.uml2.uml.PackageImport) newValue;
    	return true;
    }
    return false;
  }
  
  public void setPi(final PackageImport pPi) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPi = pPi;
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.validation.PackageImportNonPublic";
  }
  
  @Override
  public List<String> parameterNames() {
    return PackageImportNonPublicMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPi};
  }
  
  @Override
  public PackageImportNonPublicMatch toImmutable() {
    return isMutable() ? newMatch(fPi) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"pi\"=" + prettyPrintValue(fPi)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPi == null) ? 0 : fPi.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PackageImportNonPublicMatch)) { // this should be infrequent
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
    PackageImportNonPublicMatch other = (PackageImportNonPublicMatch) obj;
    if (fPi == null) {if (other.fPi != null) return false;}
    else if (!fPi.equals(other.fPi)) return false;
    return true;
  }
  
  @Override
  public PackageImportNonPublicQuerySpecification specification() {
    try {
    	return PackageImportNonPublicQuerySpecification.instance();
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
  public static PackageImportNonPublicMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PackageImportNonPublicMatch newMutableMatch(final PackageImport pPi) {
    return new Mutable(pPi);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPi the fixed value of pattern parameter pi, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PackageImportNonPublicMatch newMatch(final PackageImport pPi) {
    return new Immutable(pPi);
  }
  
  private static final class Mutable extends PackageImportNonPublicMatch {
    Mutable(final PackageImport pPi) {
      super(pPi);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PackageImportNonPublicMatch {
    Immutable(final PackageImport pPi) {
      super(pPi);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
