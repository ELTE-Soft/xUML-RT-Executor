package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.NamedDataTypeMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.NamedDataTypeQuerySpecification;
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

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.namedDataType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NamedDataTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern namedDataType(dataType : DataType, name) {
 * 	DataType.name(dataType, name);
 * }
 * </pre></code>
 * 
 * @see NamedDataTypeMatch
 * @see NamedDataTypeProcessor
 * @see NamedDataTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NamedDataTypeMatcher extends BaseMatcher<NamedDataTypeMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NamedDataTypeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NamedDataTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NamedDataTypeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_DATATYPE = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NamedDataTypeMatcher.class);
  
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
  public NamedDataTypeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NamedDataTypeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a NamedDataTypeMatch object.
   * 
   */
  public Collection<NamedDataTypeMatch> getAllMatches(final DataType pDataType, final String pName) {
    return rawGetAllMatches(new Object[]{pDataType, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a NamedDataTypeMatch object, or null if no match is found.
   * 
   */
  public NamedDataTypeMatch getOneArbitraryMatch(final DataType pDataType, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pDataType, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final DataType pDataType, final String pName) {
    return rawHasMatch(new Object[]{pDataType, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final DataType pDataType, final String pName) {
    return rawCountMatches(new Object[]{pDataType, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final DataType pDataType, final String pName, final IMatchProcessor<? super NamedDataTypeMatch> processor) {
    rawForEachMatch(new Object[]{pDataType, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final DataType pDataType, final String pName, final IMatchProcessor<? super NamedDataTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pDataType, pName}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pDataType the fixed value of pattern parameter dataType, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NamedDataTypeMatch newMatch(final DataType pDataType, final String pName) {
    return NamedDataTypeMatch.newMatch(pDataType, pName);
  }
  
  /**
   * Retrieve the set of values that occur in matches for dataType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<DataType> rawAccumulateAllValuesOfdataType(final Object[] parameters) {
    Set<DataType> results = new HashSet<DataType>();
    rawAccumulateAllValues(POSITION_DATATYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for dataType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfdataType() {
    return rawAccumulateAllValuesOfdataType(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for dataType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfdataType(final NamedDataTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfdataType(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for dataType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfdataType(final String pName) {
    return rawAccumulateAllValuesOfdataType(new Object[]{
    null, 
    pName
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final NamedDataTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final DataType pDataType) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pDataType, 
    null
    });
  }
  
  @Override
  protected NamedDataTypeMatch tupleToMatch(final Tuple t) {
    try {
    	return NamedDataTypeMatch.newMatch((org.eclipse.uml2.uml.DataType) t.get(POSITION_DATATYPE), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NamedDataTypeMatch arrayToMatch(final Object[] match) {
    try {
    	return NamedDataTypeMatch.newMatch((org.eclipse.uml2.uml.DataType) match[POSITION_DATATYPE], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NamedDataTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NamedDataTypeMatch.newMutableMatch((org.eclipse.uml2.uml.DataType) match[POSITION_DATATYPE], (java.lang.String) match[POSITION_NAME]);
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
  public static IQuerySpecification<NamedDataTypeMatcher> querySpecification() throws IncQueryException {
    return NamedDataTypeQuerySpecification.instance();
  }
}
