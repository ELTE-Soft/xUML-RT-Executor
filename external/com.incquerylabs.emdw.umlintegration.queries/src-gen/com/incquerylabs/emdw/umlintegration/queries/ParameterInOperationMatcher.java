package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ParameterInOperationMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ParameterInOperationQuerySpecification;
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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.parameterInOperation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ParameterInOperationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern parameterInOperation(operation: Operation, parameter: Parameter) {
 * 	find operation(_, operation);
 * 	Operation.ownedParameter(operation, parameter);
 * 	find notReturnParameter(parameter);
 * }
 * </pre></code>
 * 
 * @see ParameterInOperationMatch
 * @see ParameterInOperationProcessor
 * @see ParameterInOperationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ParameterInOperationMatcher extends BaseMatcher<ParameterInOperationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ParameterInOperationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ParameterInOperationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ParameterInOperationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OPERATION = 0;
  
  private final static int POSITION_PARAMETER = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ParameterInOperationMatcher.class);
  
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
  public ParameterInOperationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ParameterInOperationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return matches represented as a ParameterInOperationMatch object.
   * 
   */
  public Collection<ParameterInOperationMatch> getAllMatches(final Operation pOperation, final Parameter pParameter) {
    return rawGetAllMatches(new Object[]{pOperation, pParameter});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return a match represented as a ParameterInOperationMatch object, or null if no match is found.
   * 
   */
  public ParameterInOperationMatch getOneArbitraryMatch(final Operation pOperation, final Parameter pParameter) {
    return rawGetOneArbitraryMatch(new Object[]{pOperation, pParameter});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pOperation, final Parameter pParameter) {
    return rawHasMatch(new Object[]{pOperation, pParameter});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pOperation, final Parameter pParameter) {
    return rawCountMatches(new Object[]{pOperation, pParameter});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pOperation, final Parameter pParameter, final IMatchProcessor<? super ParameterInOperationMatch> processor) {
    rawForEachMatch(new Object[]{pOperation, pParameter}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pOperation, final Parameter pParameter, final IMatchProcessor<? super ParameterInOperationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOperation, pParameter}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ParameterInOperationMatch newMatch(final Operation pOperation, final Parameter pParameter) {
    return ParameterInOperationMatch.newMatch(pOperation, pParameter);
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final ParameterInOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final Parameter pParameter) {
    return rawAccumulateAllValuesOfoperation(new Object[]{
    null, 
    pParameter
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparameter(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAMETER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter() {
    return rawAccumulateAllValuesOfparameter(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final ParameterInOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final Operation pOperation) {
    return rawAccumulateAllValuesOfparameter(new Object[]{
    pOperation, 
    null
    });
  }
  
  @Override
  protected ParameterInOperationMatch tupleToMatch(final Tuple t) {
    try {
    	return ParameterInOperationMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_OPERATION), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAMETER));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ParameterInOperationMatch arrayToMatch(final Object[] match) {
    try {
    	return ParameterInOperationMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ParameterInOperationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ParameterInOperationMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER]);
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
  public static IQuerySpecification<ParameterInOperationMatcher> querySpecification() throws IncQueryException {
    return ParameterInOperationQuerySpecification.instance();
  }
}
