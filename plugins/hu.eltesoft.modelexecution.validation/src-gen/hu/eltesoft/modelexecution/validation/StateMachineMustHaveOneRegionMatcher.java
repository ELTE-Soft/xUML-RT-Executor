package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegionMatch;
import hu.eltesoft.modelexecution.validation.util.StateMachineMustHaveOneRegionQuerySpecification;
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
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegion pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StateMachineMustHaveOneRegionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Multiple regions for a state machine", mark = { "rg1", "rg2" })
 * pattern StateMachineMustHaveOneRegion(sm : StateMachine, rg1 : Region, rg2 : Region) {
 * 	find StateMachineRegion(sm, rg1);
 * 	find StateMachineRegion(sm, rg2);
 * 	rg1 != rg2;
 * }
 * </pre></code>
 * 
 * @see StateMachineMustHaveOneRegionMatch
 * @see StateMachineMustHaveOneRegionProcessor
 * @see StateMachineMustHaveOneRegionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StateMachineMustHaveOneRegionMatcher extends BaseMatcher<StateMachineMustHaveOneRegionMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StateMachineMustHaveOneRegionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    StateMachineMustHaveOneRegionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new StateMachineMustHaveOneRegionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SM = 0;
  
  private final static int POSITION_RG1 = 1;
  
  private final static int POSITION_RG2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(StateMachineMustHaveOneRegionMatcher.class);
  
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
  public StateMachineMustHaveOneRegionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public StateMachineMustHaveOneRegionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return matches represented as a StateMachineMustHaveOneRegionMatch object.
   * 
   */
  public Collection<StateMachineMustHaveOneRegionMatch> getAllMatches(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return rawGetAllMatches(new Object[]{pSm, pRg1, pRg2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return a match represented as a StateMachineMustHaveOneRegionMatch object, or null if no match is found.
   * 
   */
  public StateMachineMustHaveOneRegionMatch getOneArbitraryMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return rawGetOneArbitraryMatch(new Object[]{pSm, pRg1, pRg2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return rawHasMatch(new Object[]{pSm, pRg1, pRg2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return rawCountMatches(new Object[]{pSm, pRg1, pRg2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pSm, final Region pRg1, final Region pRg2, final IMatchProcessor<? super StateMachineMustHaveOneRegionMatch> processor) {
    rawForEachMatch(new Object[]{pSm, pRg1, pRg2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pSm, final Region pRg1, final Region pRg2, final IMatchProcessor<? super StateMachineMustHaveOneRegionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSm, pRg1, pRg2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSm the fixed value of pattern parameter sm, or null if not bound.
   * @param pRg1 the fixed value of pattern parameter rg1, or null if not bound.
   * @param pRg2 the fixed value of pattern parameter rg2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public StateMachineMustHaveOneRegionMatch newMatch(final StateMachine pSm, final Region pRg1, final Region pRg2) {
    return StateMachineMustHaveOneRegionMatch.newMatch(pSm, pRg1, pRg2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<StateMachine> rawAccumulateAllValuesOfsm(final Object[] parameters) {
    Set<StateMachine> results = new HashSet<StateMachine>();
    rawAccumulateAllValues(POSITION_SM, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm() {
    return rawAccumulateAllValuesOfsm(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm(final StateMachineMustHaveOneRegionMatch partialMatch) {
    return rawAccumulateAllValuesOfsm(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sm.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfsm(final Region pRg1, final Region pRg2) {
    return rawAccumulateAllValuesOfsm(new Object[]{
    null, 
    pRg1, 
    pRg2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Region> rawAccumulateAllValuesOfrg1(final Object[] parameters) {
    Set<Region> results = new HashSet<Region>();
    rawAccumulateAllValues(POSITION_RG1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg1() {
    return rawAccumulateAllValuesOfrg1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg1(final StateMachineMustHaveOneRegionMatch partialMatch) {
    return rawAccumulateAllValuesOfrg1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg1(final StateMachine pSm, final Region pRg2) {
    return rawAccumulateAllValuesOfrg1(new Object[]{
    pSm, 
    null, 
    pRg2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Region> rawAccumulateAllValuesOfrg2(final Object[] parameters) {
    Set<Region> results = new HashSet<Region>();
    rawAccumulateAllValues(POSITION_RG2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg2() {
    return rawAccumulateAllValuesOfrg2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg2(final StateMachineMustHaveOneRegionMatch partialMatch) {
    return rawAccumulateAllValuesOfrg2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for rg2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfrg2(final StateMachine pSm, final Region pRg1) {
    return rawAccumulateAllValuesOfrg2(new Object[]{
    pSm, 
    pRg1, 
    null
    });
  }
  
  @Override
  protected StateMachineMustHaveOneRegionMatch tupleToMatch(final Tuple t) {
    try {
    	return StateMachineMustHaveOneRegionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) t.get(POSITION_SM), (org.eclipse.uml2.uml.Region) t.get(POSITION_RG1), (org.eclipse.uml2.uml.Region) t.get(POSITION_RG2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateMachineMustHaveOneRegionMatch arrayToMatch(final Object[] match) {
    try {
    	return StateMachineMustHaveOneRegionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_SM], (org.eclipse.uml2.uml.Region) match[POSITION_RG1], (org.eclipse.uml2.uml.Region) match[POSITION_RG2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StateMachineMustHaveOneRegionMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return StateMachineMustHaveOneRegionMatch.newMutableMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_SM], (org.eclipse.uml2.uml.Region) match[POSITION_RG1], (org.eclipse.uml2.uml.Region) match[POSITION_RG2]);
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
  public static IQuerySpecification<StateMachineMustHaveOneRegionMatcher> querySpecification() throws IncQueryException {
    return StateMachineMustHaveOneRegionQuerySpecification.instance();
  }
}
