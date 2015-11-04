package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicityMatch;
import hu.eltesoft.modelexecution.validation.util.ReturnTypeMultiplicityQuerySpecification;
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
import org.eclipse.uml2.uml.Parameter;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicity pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReturnTypeMultiplicityMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //////////////////////////////
 * // operations
 * //////////////////////////////
 * {@literal @}Violation(message = "Return type cannot have multiplicity", mark = { "param" })
 * pattern ReturnTypeMultiplicity(param : Parameter) {
 * 	Operation.ownedParameter(_, param);
 * 	Parameter.direction(param, ParameterDirectionKind::^return);
 * 	Parameter.upperValue(param, high);
 * 	find NumericValue(high, uv);
 * 	check(uv != 1);
 * }
 * </pre></code>
 * 
 * @see ReturnTypeMultiplicityMatch
 * @see ReturnTypeMultiplicityProcessor
 * @see ReturnTypeMultiplicityQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReturnTypeMultiplicityMatcher extends BaseMatcher<ReturnTypeMultiplicityMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReturnTypeMultiplicityMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReturnTypeMultiplicityMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReturnTypeMultiplicityMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_PARAM = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReturnTypeMultiplicityMatcher.class);
  
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
  public ReturnTypeMultiplicityMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReturnTypeMultiplicityMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @return matches represented as a ReturnTypeMultiplicityMatch object.
   * 
   */
  public Collection<ReturnTypeMultiplicityMatch> getAllMatches(final Parameter pParam) {
    return rawGetAllMatches(new Object[]{pParam});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @return a match represented as a ReturnTypeMultiplicityMatch object, or null if no match is found.
   * 
   */
  public ReturnTypeMultiplicityMatch getOneArbitraryMatch(final Parameter pParam) {
    return rawGetOneArbitraryMatch(new Object[]{pParam});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Parameter pParam) {
    return rawHasMatch(new Object[]{pParam});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Parameter pParam) {
    return rawCountMatches(new Object[]{pParam});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Parameter pParam, final IMatchProcessor<? super ReturnTypeMultiplicityMatch> processor) {
    rawForEachMatch(new Object[]{pParam}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Parameter pParam, final IMatchProcessor<? super ReturnTypeMultiplicityMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParam}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParam the fixed value of pattern parameter param, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReturnTypeMultiplicityMatch newMatch(final Parameter pParam) {
    return ReturnTypeMultiplicityMatch.newMatch(pParam);
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparam(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for param.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparam() {
    return rawAccumulateAllValuesOfparam(emptyArray());
  }
  
  @Override
  protected ReturnTypeMultiplicityMatch tupleToMatch(final Tuple t) {
    try {
    	return ReturnTypeMultiplicityMatch.newMatch((org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAM));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReturnTypeMultiplicityMatch arrayToMatch(final Object[] match) {
    try {
    	return ReturnTypeMultiplicityMatch.newMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_PARAM]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReturnTypeMultiplicityMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ReturnTypeMultiplicityMatch.newMutableMatch((org.eclipse.uml2.uml.Parameter) match[POSITION_PARAM]);
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
  public static IQuerySpecification<ReturnTypeMultiplicityMatcher> querySpecification() throws IncQueryException {
    return ReturnTypeMultiplicityQuerySpecification.instance();
  }
}
