package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.util.EntryQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;

/**
 * Pattern-specific match representation of the hu.eltesoft.modelexecution.uml.incquery.Entry pattern,
 * to be used in conjunction with {@link EntryMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EntryMatcher
 * @see EntryProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class EntryMatch extends BasePatternMatch {
  private Region fRegion;
  
  private State fState;
  
  private Behavior fEntry;
  
  private static List<String> parameterNames = makeImmutableList("region", "state", "entry");
  
  private EntryMatch(final Region pRegion, final State pState, final Behavior pEntry) {
    this.fRegion = pRegion;
    this.fState = pState;
    this.fEntry = pEntry;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("region".equals(parameterName)) return this.fRegion;
    if ("state".equals(parameterName)) return this.fState;
    if ("entry".equals(parameterName)) return this.fEntry;
    return null;
    
  }
  
  public Region getRegion() {
    return this.fRegion;
    
  }
  
  public State getState() {
    return this.fState;
    
  }
  
  public Behavior getEntry() {
    return this.fEntry;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("region".equals(parameterName) ) {
    	this.fRegion = (org.eclipse.uml2.uml.Region) newValue;
    	return true;
    }
    if ("state".equals(parameterName) ) {
    	this.fState = (org.eclipse.uml2.uml.State) newValue;
    	return true;
    }
    if ("entry".equals(parameterName) ) {
    	this.fEntry = (org.eclipse.uml2.uml.Behavior) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setRegion(final Region pRegion) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRegion = pRegion;
    
  }
  
  public void setState(final State pState) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fState = pState;
    
  }
  
  public void setEntry(final Behavior pEntry) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEntry = pEntry;
    
  }
  
  @Override
  public String patternName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Entry";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return EntryMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fRegion, fState, fEntry};
    
  }
  
  @Override
  public EntryMatch toImmutable() {
    return isMutable() ? newMatch(fRegion, fState, fEntry) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"region\"=" + prettyPrintValue(fRegion) + ", ");
    result.append("\"state\"=" + prettyPrintValue(fState) + ", ");
    result.append("\"entry\"=" + prettyPrintValue(fEntry));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fRegion == null) ? 0 : fRegion.hashCode());
    result = prime * result + ((fState == null) ? 0 : fState.hashCode());
    result = prime * result + ((fEntry == null) ? 0 : fEntry.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EntryMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EntryMatch other = (EntryMatch) obj;
    if (fRegion == null) {if (other.fRegion != null) return false;}
    else if (!fRegion.equals(other.fRegion)) return false;
    if (fState == null) {if (other.fState != null) return false;}
    else if (!fState.equals(other.fState)) return false;
    if (fEntry == null) {if (other.fEntry != null) return false;}
    else if (!fEntry.equals(other.fEntry)) return false;
    return true;
  }
  
  @Override
  public EntryQuerySpecification specification() {
    try {
    	return EntryQuerySpecification.instance();
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
  public static EntryMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pEntry the fixed value of pattern parameter entry, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static EntryMatch newMutableMatch(final Region pRegion, final State pState, final Behavior pEntry) {
    return new Mutable(pRegion, pState, pEntry);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param pEntry the fixed value of pattern parameter entry, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static EntryMatch newMatch(final Region pRegion, final State pState, final Behavior pEntry) {
    return new Immutable(pRegion, pState, pEntry);
    
  }
  
  private static final class Mutable extends EntryMatch {
    Mutable(final Region pRegion, final State pState, final Behavior pEntry) {
      super(pRegion, pState, pEntry);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends EntryMatch {
    Immutable(final Region pRegion, final State pState, final Behavior pEntry) {
      super(pRegion, pState, pEntry);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
