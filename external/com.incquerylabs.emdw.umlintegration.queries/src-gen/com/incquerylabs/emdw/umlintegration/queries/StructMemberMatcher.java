package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.StructMemberMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.StructMemberQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.structMember pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StructMemberMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern structMember(structType: DataType, member: Property) {
 * 	DataType.ownedAttribute(structType, member);
 * }
 * </pre></code>
 * 
 * @see StructMemberMatch
 * @see StructMemberProcessor
 * @see StructMemberQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StructMemberMatcher extends BaseMatcher<StructMemberMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StructMemberMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    StructMemberMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new StructMemberMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_STRUCTTYPE = 0;
  
  private final static int POSITION_MEMBER = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(StructMemberMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public StructMemberMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public StructMemberMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return matches represented as a StructMemberMatch object.
   * 
   */
  public Collection<StructMemberMatch> getAllMatches(final DataType pStructType, final Property pMember) {
    return rawGetAllMatches(new Object[]{pStructType, pMember});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return a match represented as a StructMemberMatch object, or null if no match is found.
   * 
   */
  public StructMemberMatch getOneArbitraryMatch(final DataType pStructType, final Property pMember) {
    return rawGetOneArbitraryMatch(new Object[]{pStructType, pMember});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final DataType pStructType, final Property pMember) {
    return rawHasMatch(new Object[]{pStructType, pMember});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final DataType pStructType, final Property pMember) {
    return rawCountMatches(new Object[]{pStructType, pMember});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final DataType pStructType, final Property pMember, final IMatchProcessor<? super StructMemberMatch> processor) {
    rawForEachMatch(new Object[]{pStructType, pMember}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pMember the fixed value of pattern parameter member, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final DataType pStructType, final Property pMember, final IMatchProcessor<? super StructMemberMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pStructType, pMember}, processor);
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
  public StructMemberMatch newMatch(final DataType pStructType, final Property pMember) {
    return StructMemberMatch.newMatch(pStructType, pMember);
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<DataType> rawAccumulateAllValuesOfstructType(final Object[] parameters) {
    Set<DataType> results = new HashSet<DataType>();
    rawAccumulateAllValues(POSITION_STRUCTTYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType() {
    return rawAccumulateAllValuesOfstructType(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType(final StructMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfstructType(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType(final Property pMember) {
    return rawAccumulateAllValuesOfstructType(new Object[]{
    null, 
    pMember
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfmember(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_MEMBER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfmember() {
    return rawAccumulateAllValuesOfmember(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfmember(final StructMemberMatch partialMatch) {
    return rawAccumulateAllValuesOfmember(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for member.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfmember(final DataType pStructType) {
    return rawAccumulateAllValuesOfmember(new Object[]{
    pStructType, 
    null
    });
  }
  
  @Override
  protected StructMemberMatch tupleToMatch(final Tuple t) {
    try {
    	return StructMemberMatch.newMatch((org.eclipse.uml2.uml.DataType) t.get(POSITION_STRUCTTYPE), (org.eclipse.uml2.uml.Property) t.get(POSITION_MEMBER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StructMemberMatch arrayToMatch(final Object[] match) {
    try {
    	return StructMemberMatch.newMatch((org.eclipse.uml2.uml.DataType) match[POSITION_STRUCTTYPE], (org.eclipse.uml2.uml.Property) match[POSITION_MEMBER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StructMemberMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return StructMemberMatch.newMutableMatch((org.eclipse.uml2.uml.DataType) match[POSITION_STRUCTTYPE], (org.eclipse.uml2.uml.Property) match[POSITION_MEMBER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<StructMemberMatcher> querySpecification() throws IncQueryException {
    return StructMemberQuerySpecification.instance();
  }
}
