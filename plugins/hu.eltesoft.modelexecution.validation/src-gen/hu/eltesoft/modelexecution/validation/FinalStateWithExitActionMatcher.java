package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.FinalStateWithExitActionMatch;
import hu.eltesoft.modelexecution.validation.util.FinalStateWithExitActionQuerySpecification;
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
import org.eclipse.uml2.uml.FinalState;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.FinalStateWithExitAction pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FinalStateWithExitActionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Final states cannot have exit action", mark = { "st" })
 * pattern FinalStateWithExitAction(st : FinalState) {
 * 	FinalState.exit(st, _);
 * }
 * </pre></code>
 * 
 * @see FinalStateWithExitActionMatch
 * @see FinalStateWithExitActionProcessor
 * @see FinalStateWithExitActionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FinalStateWithExitActionMatcher extends BaseMatcher<FinalStateWithExitActionMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FinalStateWithExitActionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FinalStateWithExitActionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FinalStateWithExitActionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ST = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(FinalStateWithExitActionMatcher.class);
  
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
  public FinalStateWithExitActionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public FinalStateWithExitActionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return matches represented as a FinalStateWithExitActionMatch object.
   * 
   */
  public Collection<FinalStateWithExitActionMatch> getAllMatches(final FinalState pSt) {
    return rawGetAllMatches(new Object[]{pSt});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return a match represented as a FinalStateWithExitActionMatch object, or null if no match is found.
   * 
   */
  public FinalStateWithExitActionMatch getOneArbitraryMatch(final FinalState pSt) {
    return rawGetOneArbitraryMatch(new Object[]{pSt});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final FinalState pSt) {
    return rawHasMatch(new Object[]{pSt});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final FinalState pSt) {
    return rawCountMatches(new Object[]{pSt});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final FinalState pSt, final IMatchProcessor<? super FinalStateWithExitActionMatch> processor) {
    rawForEachMatch(new Object[]{pSt}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final FinalState pSt, final IMatchProcessor<? super FinalStateWithExitActionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSt}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSt the fixed value of pattern parameter st, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FinalStateWithExitActionMatch newMatch(final FinalState pSt) {
    return FinalStateWithExitActionMatch.newMatch(pSt);
  }
  
  /**
   * Retrieve the set of values that occur in matches for st.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<FinalState> rawAccumulateAllValuesOfst(final Object[] parameters) {
    Set<FinalState> results = new HashSet<FinalState>();
    rawAccumulateAllValues(POSITION_ST, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for st.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<FinalState> getAllValuesOfst() {
    return rawAccumulateAllValuesOfst(emptyArray());
  }
  
  @Override
  protected FinalStateWithExitActionMatch tupleToMatch(final Tuple t) {
    try {
    	return FinalStateWithExitActionMatch.newMatch((org.eclipse.uml2.uml.FinalState) t.get(POSITION_ST));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FinalStateWithExitActionMatch arrayToMatch(final Object[] match) {
    try {
    	return FinalStateWithExitActionMatch.newMatch((org.eclipse.uml2.uml.FinalState) match[POSITION_ST]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected FinalStateWithExitActionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return FinalStateWithExitActionMatch.newMutableMatch((org.eclipse.uml2.uml.FinalState) match[POSITION_ST]);
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
  public static IQuerySpecification<FinalStateWithExitActionMatcher> querySpecification() throws IncQueryException {
    return FinalStateWithExitActionQuerySpecification.instance();
  }
}