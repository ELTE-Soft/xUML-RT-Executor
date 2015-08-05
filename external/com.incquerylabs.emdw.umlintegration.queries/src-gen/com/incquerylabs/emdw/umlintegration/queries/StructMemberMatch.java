package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.StructMemberQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.structMember pattern,
 * to be used in conjunction with {@link StructMemberMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StructMemberMatcher
 * @see StructMemberProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StructMemberMatch extends BasePatternMatch {
  private DataType fStructType;
  
  private Property fMember;
  
  private static List<String> parameterNames = makeImmutableList("structType", "member");
  
  private StructMemberMatch(final DataType pStructType, final Property pMember) {
    this.fStructType = pStructType;
    this.fMember = pMember;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("structType".equals(parameterName)) return this.fStructType;
    if ("member".equals(parameterName)) return this.fMember;
    return null;
  }
  
  public DataType getStructType() {
    return this.fStructType;
  }
  
  public Property getMember() {
    return this.fMember;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("structType".equals(parameterName) ) {
    	this.fStructType = (org.eclipse.uml2.uml.DataType) newValue;
    	return true;
    }
    if ("member".equals(parameterName) ) {
    	this.fMember = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setStructType(final DataType pStructType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStructType = pStructType;
  }
  
  public void setMember(final Property pMember) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMember = pMember;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.structMember";
  }
  
  @Override
  public List<String> parameterNames() {
    return StructMemberMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStructType, fMember};
  }
  
  @Override
  public StructMemberMatch toImmutable() {
    return isMutable() ? newMatch(fStructType, fMember) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"structType\"=" + prettyPrintValue(fStructType) + ", ");
    
    result.append("\"member\"=" + prettyPrintValue(fMember)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStructType == null) ? 0 : fStructType.hashCode());
    result = prime * result + ((fMember == null) ? 0 : fMember.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StructMemberMatch)) { // this should be infrequent
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
    StructMemberMatch other = (StructMemberMatch) obj;
    if (fStructType == null) {if (other.fStructType != null) return false;}
    else if (!fStructType.equals(other.fStructType)) return false;
    if (fMember == null) {if (other.fMember != null) return false;}
    else if (!fMember.equals(other.fMember)) return false;
    return true;
  }
  
  @Override
  public StructMemberQuerySpecification specification() {
    try {
    	return StructMemberQuerySpecification.instance();
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
  public static StructMemberMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StructMemberMatch newMutableMatch(final DataType pStructType, final Property pMember) {
    return new Mutable(pStructType, pMember);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StructMemberMatch newMatch(final DataType pStructType, final Property pMember) {
    return new Immutable(pStructType, pMember);
  }
  
  private static final class Mutable extends StructMemberMatch {
    Mutable(final DataType pStructType, final Property pMember) {
      super(pStructType, pMember);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StructMemberMatch {
    Immutable(final DataType pStructType, final Property pMember) {
      super(pStructType, pMember);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
