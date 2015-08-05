package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * Pattern-specific match representation of the com.incquerylabs.emdw.umlintegration.queries.xtAssociation pattern,
 * to be used in conjunction with {@link XtAssociationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see XtAssociationMatcher
 * @see XtAssociationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class XtAssociationMatch extends BasePatternMatch {
  private Association fAssociation;
  
  private Property fSourceEnd;
  
  private Property fTargetEnd;
  
  private static List<String> parameterNames = makeImmutableList("association", "sourceEnd", "targetEnd");
  
  private XtAssociationMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    this.fAssociation = pAssociation;
    this.fSourceEnd = pSourceEnd;
    this.fTargetEnd = pTargetEnd;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("association".equals(parameterName)) return this.fAssociation;
    if ("sourceEnd".equals(parameterName)) return this.fSourceEnd;
    if ("targetEnd".equals(parameterName)) return this.fTargetEnd;
    return null;
  }
  
  public Association getAssociation() {
    return this.fAssociation;
  }
  
  public Property getSourceEnd() {
    return this.fSourceEnd;
  }
  
  public Property getTargetEnd() {
    return this.fTargetEnd;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("association".equals(parameterName) ) {
    	this.fAssociation = (org.eclipse.uml2.uml.Association) newValue;
    	return true;
    }
    if ("sourceEnd".equals(parameterName) ) {
    	this.fSourceEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    if ("targetEnd".equals(parameterName) ) {
    	this.fTargetEnd = (org.eclipse.uml2.uml.Property) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAssociation(final Association pAssociation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAssociation = pAssociation;
  }
  
  public void setSourceEnd(final Property pSourceEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceEnd = pSourceEnd;
  }
  
  public void setTargetEnd(final Property pTargetEnd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetEnd = pTargetEnd;
  }
  
  @Override
  public String patternName() {
    return "com.incquerylabs.emdw.umlintegration.queries.xtAssociation";
  }
  
  @Override
  public List<String> parameterNames() {
    return XtAssociationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAssociation, fSourceEnd, fTargetEnd};
  }
  
  @Override
  public XtAssociationMatch toImmutable() {
    return isMutable() ? newMatch(fAssociation, fSourceEnd, fTargetEnd) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"association\"=" + prettyPrintValue(fAssociation) + ", ");
    
    result.append("\"sourceEnd\"=" + prettyPrintValue(fSourceEnd) + ", ");
    
    result.append("\"targetEnd\"=" + prettyPrintValue(fTargetEnd)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAssociation == null) ? 0 : fAssociation.hashCode());
    result = prime * result + ((fSourceEnd == null) ? 0 : fSourceEnd.hashCode());
    result = prime * result + ((fTargetEnd == null) ? 0 : fTargetEnd.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof XtAssociationMatch)) { // this should be infrequent
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
    XtAssociationMatch other = (XtAssociationMatch) obj;
    if (fAssociation == null) {if (other.fAssociation != null) return false;}
    else if (!fAssociation.equals(other.fAssociation)) return false;
    if (fSourceEnd == null) {if (other.fSourceEnd != null) return false;}
    else if (!fSourceEnd.equals(other.fSourceEnd)) return false;
    if (fTargetEnd == null) {if (other.fTargetEnd != null) return false;}
    else if (!fTargetEnd.equals(other.fTargetEnd)) return false;
    return true;
  }
  
  @Override
  public XtAssociationQuerySpecification specification() {
    try {
    	return XtAssociationQuerySpecification.instance();
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
  public static XtAssociationMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static XtAssociationMatch newMutableMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return new Mutable(pAssociation, pSourceEnd, pTargetEnd);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static XtAssociationMatch newMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return new Immutable(pAssociation, pSourceEnd, pTargetEnd);
  }
  
  private static final class Mutable extends XtAssociationMatch {
    Mutable(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
      super(pAssociation, pSourceEnd, pTargetEnd);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends XtAssociationMatch {
    Immutable(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
      super(pAssociation, pSourceEnd, pTargetEnd);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
