package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.FinalStateMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.FinalStateQuerySpecification;
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
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.FinalState pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FinalStateMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern FinalState(region : Region, state : State) {
 * 	find State(region, state);
 * 	FinalState(state);
 * }
 * </pre></code>
 * 
 * @see FinalStateMatch
 * @see FinalStateProcessor
 * @see FinalStateQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FinalStateMatcher extends BaseMatcher<FinalStateMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<FinalStateMatcher> querySpecification() throws IncQueryException {
    return FinalStateQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static FinalStateMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    FinalStateMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new FinalStateMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REGION = 0;
  
  private final static int POSITION_STATE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(FinalStateMatcher.class);
  
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
  public FinalStateMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public FinalStateMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return matches represented as a FinalStateMatch object.
   * 
   */
  public Collection<FinalStateMatch> getAllMatches(final Region pRegion, final State pState) {
    return rawGetAllMatches(new Object[]{pRegion, pState});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return a match represented as a FinalStateMatch object, or null if no match is found.
   * 
   */
  public FinalStateMatch getOneArbitraryMatch(final Region pRegion, final State pState) {
    return rawGetOneArbitraryMatch(new Object[]{pRegion, pState});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRegion, final State pState) {
    return rawHasMatch(new Object[]{pRegion, pState});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRegion, final State pState) {
    return rawCountMatches(new Object[]{pRegion, pState});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRegion, final State pState, final IMatchProcessor<? super FinalStateMatch> processor) {
    rawForEachMatch(new Object[]{pRegion, pState}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRegion, final State pState, final IMatchProcessor<? super FinalStateMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRegion, pState}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<FinalStateMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Region pRegion, final State pState) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRegion, pState});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pState the fixed value of pattern parameter state, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FinalStateMatch newMatch(final Region pRegion, final State pState) {
    return FinalStateMatch.newMatch(pRegion, pState);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Region> rawAccumulateAllValuesOfregion(final Object[] parameters) {
    Set<Region> results = new HashSet<Region>();
    rawAccumulateAllValues(POSITION_REGION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion() {
    return rawAccumulateAllValuesOfregion(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final FinalStateMatch partialMatch) {
    return rawAccumulateAllValuesOfregion(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final State pState) {
    return rawAccumulateAllValuesOfregion(new Object[]{null, pState});
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfstate(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_STATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate() {
    return rawAccumulateAllValuesOfstate(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate(final FinalStateMatch partialMatch) {
    return rawAccumulateAllValuesOfstate(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for state.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfstate(final Region pRegion) {
    return rawAccumulateAllValuesOfstate(new Object[]{pRegion, null});
  }
  
  @Override
  protected FinalStateMatch tupleToMatch(final Tuple t) {
    try {
      return FinalStateMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_REGION), (org.eclipse.uml2.uml.State) t.get(POSITION_STATE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected FinalStateMatch arrayToMatch(final Object[] match) {
    try {
      return FinalStateMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.State) match[POSITION_STATE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected FinalStateMatch arrayToMatchMutable(final Object[] match) {
    try {
      return FinalStateMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.State) match[POSITION_STATE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}