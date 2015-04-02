package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegion pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ContainerClassOfRegionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern ContainerClassOfRegion(region : Region, containerClassName) {
 * 	Class.name(containerClass, containerClassName);
 * 	Class.ownedBehavior(containerClass, stateMachine);
 * 	StateMachine.region(stateMachine, region);	
 * }
 * </pre></code>
 * 
 * @see ContainerClassOfRegionMatch
 * @see ContainerClassOfRegionProcessor
 * @see ContainerClassOfRegionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ContainerClassOfRegionMatcher extends BaseMatcher<ContainerClassOfRegionMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ContainerClassOfRegionMatcher> querySpecification() throws IncQueryException {
    return ContainerClassOfRegionQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ContainerClassOfRegionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ContainerClassOfRegionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ContainerClassOfRegionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_REGION = 0;
  
  private final static int POSITION_CONTAINERCLASSNAME = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ContainerClassOfRegionMatcher.class);
  
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
  public ContainerClassOfRegionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ContainerClassOfRegionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return matches represented as a ContainerClassOfRegionMatch object.
   * 
   */
  public Collection<ContainerClassOfRegionMatch> getAllMatches(final Region pRegion, final String pContainerClassName) {
    return rawGetAllMatches(new Object[]{pRegion, pContainerClassName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return a match represented as a ContainerClassOfRegionMatch object, or null if no match is found.
   * 
   */
  public ContainerClassOfRegionMatch getOneArbitraryMatch(final Region pRegion, final String pContainerClassName) {
    return rawGetOneArbitraryMatch(new Object[]{pRegion, pContainerClassName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Region pRegion, final String pContainerClassName) {
    return rawHasMatch(new Object[]{pRegion, pContainerClassName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Region pRegion, final String pContainerClassName) {
    return rawCountMatches(new Object[]{pRegion, pContainerClassName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Region pRegion, final String pContainerClassName, final IMatchProcessor<? super ContainerClassOfRegionMatch> processor) {
    rawForEachMatch(new Object[]{pRegion, pContainerClassName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Region pRegion, final String pContainerClassName, final IMatchProcessor<? super ContainerClassOfRegionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pRegion, pContainerClassName}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ContainerClassOfRegionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Region pRegion, final String pContainerClassName) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pRegion, pContainerClassName});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pRegion the fixed value of pattern parameter region, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ContainerClassOfRegionMatch newMatch(final Region pRegion, final String pContainerClassName) {
    return ContainerClassOfRegionMatch.newMatch(pRegion, pContainerClassName);
    
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
  public Set<Region> getAllValuesOfregion(final ContainerClassOfRegionMatch partialMatch) {
    return rawAccumulateAllValuesOfregion(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for region.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Region> getAllValuesOfregion(final String pContainerClassName) {
    return rawAccumulateAllValuesOfregion(new Object[]{null, pContainerClassName});
  }
  
  /**
   * Retrieve the set of values that occur in matches for containerClassName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfcontainerClassName(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_CONTAINERCLASSNAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for containerClassName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcontainerClassName() {
    return rawAccumulateAllValuesOfcontainerClassName(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for containerClassName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcontainerClassName(final ContainerClassOfRegionMatch partialMatch) {
    return rawAccumulateAllValuesOfcontainerClassName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for containerClassName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcontainerClassName(final Region pRegion) {
    return rawAccumulateAllValuesOfcontainerClassName(new Object[]{pRegion, null});
  }
  
  @Override
  protected ContainerClassOfRegionMatch tupleToMatch(final Tuple t) {
    try {
      return ContainerClassOfRegionMatch.newMatch((org.eclipse.uml2.uml.Region) t.get(POSITION_REGION), (java.lang.String) t.get(POSITION_CONTAINERCLASSNAME));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ContainerClassOfRegionMatch arrayToMatch(final Object[] match) {
    try {
      return ContainerClassOfRegionMatch.newMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (java.lang.String) match[POSITION_CONTAINERCLASSNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ContainerClassOfRegionMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ContainerClassOfRegionMatch.newMutableMatch((org.eclipse.uml2.uml.Region) match[POSITION_REGION], (java.lang.String) match[POSITION_CONTAINERCLASSNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
