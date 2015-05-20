package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectQuerySpecification;
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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.TransitionEffect pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TransitionEffectMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * TransitionEffect(region : Region, transition : Transition, effect : Behavior, effectName) {
 * 	Transition.container(transition, region);
 * 	Transition.effect(transition, effect);
 * 	Behavior.name(effect, effectName);
 * }
 * </pre></code>
 * 
 * @see TransitionEffectMatch
 * @see TransitionEffectProcessor
 * @see TransitionEffectQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TransitionEffectMatcher extends BaseMatcher<TransitionEffectMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<TransitionEffectMatcher> querySpecification() throws IncQueryException {
    return TransitionEffectQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TransitionEffectMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TransitionEffectMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TransitionEffectMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REGION = 0;
  
  private final static int POSITION_TRANSITION = 1;
  
  private final static int POSITION_EFFECT = 2;
  
  private final static int POSITION_EFFECTNAME = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TransitionEffectMatcher.class);
  
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
  public TransitionEffectMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TransitionEffectMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return matches represented as a TransitionEffectMatch object.
   * 
   */
  public Collection<TransitionEffectMatch> getAllMatches(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawGetAllMatches(new Object[]{pRegion, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return a match represented as a TransitionEffectMatch object, or null if no match is found.
   * 
   */
  public TransitionEffectMatch getOneArbitraryMatch(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawGetOneArbitraryMatch(new Object[]{pRegion, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawHasMatch(new Object[]{pRegion, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawCountMatches(new Object[]{pRegion, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName, final IMatchProcessor<? super TransitionEffectMatch> processor) {
    rawForEachMatch(new Object[]{pRegion, pTransition, pEffect, pEffectName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName, final IMatchProcessor<? super TransitionEffectMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRegion, pTransition, pEffect, pEffectName}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<TransitionEffectMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRegion, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pTransition the fixed value of pattern parameter transition, or null if not bound.
   * @param pEffect the fixed value of pattern parameter effect, or null if not bound.
   * @param pEffectName the fixed value of pattern parameter effectName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TransitionEffectMatch newMatch(final Region pRegion, final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return TransitionEffectMatch.newMatch(pRegion, pTransition, pEffect, pEffectName);
    
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
  public Set<Region> getAllValuesOfregion(final TransitionEffectMatch partialMatch) {
    return rawAccumulateAllValuesOfregion(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final Transition pTransition, final Behavior pEffect, final String pEffectName) {
    return rawAccumulateAllValuesOfregion(new Object[]{null, pTransition, pEffect, pEffectName});
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOftransition(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_TRANSITION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition() {
    return rawAccumulateAllValuesOftransition(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition(final TransitionEffectMatch partialMatch) {
    return rawAccumulateAllValuesOftransition(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for transition.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftransition(final Region pRegion, final Behavior pEffect, final String pEffectName) {
    return rawAccumulateAllValuesOftransition(new Object[]{pRegion, null, pEffect, pEffectName});
  }
  
  /**
   * Retrieve the set of values that occur in matches for effect.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Behavior> rawAccumulateAllValuesOfeffect(final Object[] parameters) {
    Set<Behavior> results = new HashSet<Behavior>();
    rawAccumulateAllValues(POSITION_EFFECT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for effect.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfeffect() {
    return rawAccumulateAllValuesOfeffect(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for effect.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfeffect(final TransitionEffectMatch partialMatch) {
    return rawAccumulateAllValuesOfeffect(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for effect.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfeffect(final Region pRegion, final Transition pTransition, final String pEffectName) {
    return rawAccumulateAllValuesOfeffect(new Object[]{pRegion, pTransition, null, pEffectName});
  }
  
  /**
   * Retrieve the set of values that occur in matches for effectName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfeffectName(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_EFFECTNAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for effectName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeffectName() {
    return rawAccumulateAllValuesOfeffectName(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for effectName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeffectName(final TransitionEffectMatch partialMatch) {
    return rawAccumulateAllValuesOfeffectName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for effectName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfeffectName(final Region pRegion, final Transition pTransition, final Behavior pEffect) {
    return rawAccumulateAllValuesOfeffectName(new Object[]{pRegion, pTransition, pEffect, null});
  }
  
  @Override
  protected TransitionEffectMatch tupleToMatch(final Tuple t) {
    try {
      return TransitionEffectMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_REGION), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TRANSITION), (org.eclipse.uml2.uml.Behavior) t.get(POSITION_EFFECT), (java.lang.String) t.get(POSITION_EFFECTNAME));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected TransitionEffectMatch arrayToMatch(final Object[] match) {
    try {
      return TransitionEffectMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Behavior) match[POSITION_EFFECT], (java.lang.String) match[POSITION_EFFECTNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected TransitionEffectMatch arrayToMatchMutable(final Object[] match) {
    try {
      return TransitionEffectMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (org.eclipse.uml2.uml.Transition) match[POSITION_TRANSITION], (org.eclipse.uml2.uml.Behavior) match[POSITION_EFFECT], (java.lang.String) match[POSITION_EFFECTNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
