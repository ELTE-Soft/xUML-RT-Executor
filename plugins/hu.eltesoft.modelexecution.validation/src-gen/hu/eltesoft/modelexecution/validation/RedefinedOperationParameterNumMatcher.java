package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNumMatch;
import hu.eltesoft.modelexecution.validation.util.RedefinedOperationParameterNumQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNum pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link RedefinedOperationParameterNumMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Number of parameters ({redefinerParams}) does not the same as of redefined {redefined} ({redefinedParams})", mark = { "redefiner" })
 * pattern RedefinedOperationParameterNum(redefined : Operation, redefiner : Operation, redefinerParams, redefinedParams) {
 * 	Operation.redefinedOperation(redefiner, redefined);
 * 	redefinerParams == count find ParameterOfOperation(redefiner, _);
 * 	redefinedParams == count find ParameterOfOperation(redefined, _);
 * 	redefinerParams != redefinedParams;
 * }
 * </pre></code>
 * 
 * @see RedefinedOperationParameterNumMatch
 * @see RedefinedOperationParameterNumProcessor
 * @see RedefinedOperationParameterNumQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class RedefinedOperationParameterNumMatcher extends BaseMatcher<RedefinedOperationParameterNumMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RedefinedOperationParameterNumMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    RedefinedOperationParameterNumMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new RedefinedOperationParameterNumMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REDEFINED = 0;
  
  private final static int POSITION_REDEFINER = 1;
  
  private final static int POSITION_REDEFINERPARAMS = 2;
  
  private final static int POSITION_REDEFINEDPARAMS = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(RedefinedOperationParameterNumMatcher.class);
  
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
  public RedefinedOperationParameterNumMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public RedefinedOperationParameterNumMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return matches represented as a RedefinedOperationParameterNumMatch object.
   * 
   */
  public Collection<RedefinedOperationParameterNumMatch> getAllMatches(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawGetAllMatches(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return a match represented as a RedefinedOperationParameterNumMatch object, or null if no match is found.
   * 
   */
  public RedefinedOperationParameterNumMatch getOneArbitraryMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawGetOneArbitraryMatch(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawHasMatch(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawCountMatches(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams, final IMatchProcessor<? super RedefinedOperationParameterNumMatch> processor) {
    rawForEachMatch(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams, final IMatchProcessor<? super RedefinedOperationParameterNumMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRedefined the fixed value of pattern parameter redefined, or null if not bound.
   * @param pRedefiner the fixed value of pattern parameter redefiner, or null if not bound.
   * @param pRedefinerParams the fixed value of pattern parameter redefinerParams, or null if not bound.
   * @param pRedefinedParams the fixed value of pattern parameter redefinedParams, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public RedefinedOperationParameterNumMatch newMatch(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return RedefinedOperationParameterNumMatch.newMatch(pRedefined, pRedefiner, pRedefinerParams, pRedefinedParams);
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfredefined(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_REDEFINED, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined() {
    return rawAccumulateAllValuesOfredefined(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined(final RedefinedOperationParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfredefined(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefined.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefined(final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawAccumulateAllValuesOfredefined(new Object[]{
    null, 
    pRedefiner, 
    pRedefinerParams, 
    pRedefinedParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfredefiner(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_REDEFINER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner() {
    return rawAccumulateAllValuesOfredefiner(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner(final RedefinedOperationParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfredefiner(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefiner.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfredefiner(final Operation pRedefined, final Integer pRedefinerParams, final Integer pRedefinedParams) {
    return rawAccumulateAllValuesOfredefiner(new Object[]{
    pRedefined, 
    null, 
    pRedefinerParams, 
    pRedefinedParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinerParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfredefinerParams(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_REDEFINERPARAMS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinerParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinerParams() {
    return rawAccumulateAllValuesOfredefinerParams(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinerParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinerParams(final RedefinedOperationParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfredefinerParams(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinerParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinerParams(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinedParams) {
    return rawAccumulateAllValuesOfredefinerParams(new Object[]{
    pRedefined, 
    pRedefiner, 
    null, 
    pRedefinedParams
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinedParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOfredefinedParams(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_REDEFINEDPARAMS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinedParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinedParams() {
    return rawAccumulateAllValuesOfredefinedParams(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinedParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinedParams(final RedefinedOperationParameterNumMatch partialMatch) {
    return rawAccumulateAllValuesOfredefinedParams(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for redefinedParams.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOfredefinedParams(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams) {
    return rawAccumulateAllValuesOfredefinedParams(new Object[]{
    pRedefined, 
    pRedefiner, 
    pRedefinerParams, 
    null
    });
  }
  
  @Override
  protected RedefinedOperationParameterNumMatch tupleToMatch(final Tuple t) {
    try {
    	return RedefinedOperationParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_REDEFINED), (org.eclipse.uml2.uml.Operation) t.get(POSITION_REDEFINER), (java.lang.Integer) t.get(POSITION_REDEFINERPARAMS), (java.lang.Integer) t.get(POSITION_REDEFINEDPARAMS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RedefinedOperationParameterNumMatch arrayToMatch(final Object[] match) {
    try {
    	return RedefinedOperationParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINED], (org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINER], (java.lang.Integer) match[POSITION_REDEFINERPARAMS], (java.lang.Integer) match[POSITION_REDEFINEDPARAMS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RedefinedOperationParameterNumMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return RedefinedOperationParameterNumMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINED], (org.eclipse.uml2.uml.Operation) match[POSITION_REDEFINER], (java.lang.Integer) match[POSITION_REDEFINERPARAMS], (java.lang.Integer) match[POSITION_REDEFINEDPARAMS]);
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
  public static IQuerySpecification<RedefinedOperationParameterNumMatcher> querySpecification() throws IncQueryException {
    return RedefinedOperationParameterNumQuerySpecification.instance();
  }
}
