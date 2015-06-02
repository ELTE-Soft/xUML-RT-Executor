package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.InitialsMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.InitialsQuerySpecification;
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
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.Initials pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InitialsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * Initials(region : Region, initPseudostate : Pseudostate, initTransition : Transition, firstState : State) {
 * 	Pseudostate.container(initPseudostate, region);
 * 	Pseudostate.kind(initPseudostate, ::initial);
 * 
 * 	Transition.source(initTransition, initPseudostate);
 * 	Transition.target(initTransition, firstState);
 * }
 * </pre></code>
 * 
 * @see InitialsMatch
 * @see InitialsProcessor
 * @see InitialsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InitialsMatcher extends BaseMatcher<InitialsMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<InitialsMatcher> querySpecification() throws IncQueryException {
    return InitialsQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InitialsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InitialsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InitialsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REGION = 0;
  
  private final static int POSITION_INITPSEUDOSTATE = 1;
  
  private final static int POSITION_INITTRANSITION = 2;
  
  private final static int POSITION_FIRSTSTATE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InitialsMatcher.class);
  
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
  public InitialsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InitialsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return matches represented as a InitialsMatch object.
   * 
   */
  public Collection<InitialsMatch> getAllMatches(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawGetAllMatches(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return a match represented as a InitialsMatch object, or null if no match is found.
   * 
   */
  public InitialsMatch getOneArbitraryMatch(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawGetOneArbitraryMatch(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawHasMatch(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawCountMatches(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState, final IMatchProcessor<? super InitialsMatch> processor) {
    rawForEachMatch(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState, final IMatchProcessor<? super InitialsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<InitialsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRegion, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pInitPseudostate the fixed value of pattern parameter initPseudostate, or null if not bound.
   * @param pInitTransition the fixed value of pattern parameter initTransition, or null if not bound.
   * @param pFirstState the fixed value of pattern parameter firstState, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InitialsMatch newMatch(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return InitialsMatch.newMatch(pRegion, pInitPseudostate, pInitTransition, pFirstState);
    
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
  public Set<Region> getAllValuesOfregion(final InitialsMatch partialMatch) {
    return rawAccumulateAllValuesOfregion(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState) {
    return rawAccumulateAllValuesOfregion(new Object[]{null, pInitPseudostate, pInitTransition, pFirstState});
  }
  
  /**
   * Retrieve the set of values that occur in matches for initPseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfinitPseudostate(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_INITPSEUDOSTATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for initPseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinitPseudostate() {
    return rawAccumulateAllValuesOfinitPseudostate(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for initPseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinitPseudostate(final InitialsMatch partialMatch) {
    return rawAccumulateAllValuesOfinitPseudostate(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for initPseudostate.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfinitPseudostate(final Region pRegion, final Transition pInitTransition, final State pFirstState) {
    return rawAccumulateAllValuesOfinitPseudostate(new Object[]{pRegion, null, pInitTransition, pFirstState});
  }
  
  /**
   * Retrieve the set of values that occur in matches for initTransition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOfinitTransition(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_INITTRANSITION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for initTransition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfinitTransition() {
    return rawAccumulateAllValuesOfinitTransition(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for initTransition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfinitTransition(final InitialsMatch partialMatch) {
    return rawAccumulateAllValuesOfinitTransition(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for initTransition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOfinitTransition(final Region pRegion, final Pseudostate pInitPseudostate, final State pFirstState) {
    return rawAccumulateAllValuesOfinitTransition(new Object[]{pRegion, pInitPseudostate, null, pFirstState});
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOffirstState(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_FIRSTSTATE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOffirstState() {
    return rawAccumulateAllValuesOffirstState(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOffirstState(final InitialsMatch partialMatch) {
    return rawAccumulateAllValuesOffirstState(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstState.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOffirstState(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition) {
    return rawAccumulateAllValuesOffirstState(new Object[]{pRegion, pInitPseudostate, pInitTransition, null});
  }
  
  @Override
  protected InitialsMatch tupleToMatch(final Tuple t) {
    try {
      return InitialsMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_REGION), (org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_INITPSEUDOSTATE), (org.eclipse.uml2.uml.Transition) t.get(POSITION_INITTRANSITION), (org.eclipse.uml2.uml.State) t.get(POSITION_FIRSTSTATE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InitialsMatch arrayToMatch(final Object[] match) {
    try {
      return InitialsMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INITPSEUDOSTATE], (org.eclipse.uml2.uml.Transition) match[POSITION_INITTRANSITION], (org.eclipse.uml2.uml.State) match[POSITION_FIRSTSTATE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected InitialsMatch arrayToMatchMutable(final Object[] match) {
    try {
      return InitialsMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.Pseudostate) match[POSITION_INITPSEUDOSTATE], (org.eclipse.uml2.uml.Transition) match[POSITION_INITTRANSITION], (org.eclipse.uml2.uml.State) match[POSITION_FIRSTSTATE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
