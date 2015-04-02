package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehavior pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ContainerClassOfBehaviorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern ContainerClassOfBehavior(behavior : Behavior, containerClassName) {
 * // operation
 * 	Operation.method(operation, behavior);
 * 
 * 	Class.ownedOperation(cls, operation);
 * 	Class.name(cls, containerClassName);
 * } or {
 * // entry
 * 	State.entry(state, behavior);
 * 
 * 	find ContainerClassOfVertex(state, containerClassName);
 * 
 * } or {
 * // exit
 * 	State.exit(state, behavior);
 * 
 * 	find ContainerClassOfVertex(state, containerClassName);
 * 
 * } or {
 * // effect
 * 	Transition.effect(transition, behavior);
 * 	Transition.container(transition, region);
 * 
 * 	find ContainerClassOfRegion(region, containerClassName); // from region.eiq
 * }
 * </pre></code>
 * 
 * @see ContainerClassOfBehaviorMatch
 * @see ContainerClassOfBehaviorProcessor
 * @see ContainerClassOfBehaviorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ContainerClassOfBehaviorMatcher extends BaseMatcher<ContainerClassOfBehaviorMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ContainerClassOfBehaviorMatcher> querySpecification() throws IncQueryException {
    return ContainerClassOfBehaviorQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ContainerClassOfBehaviorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ContainerClassOfBehaviorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ContainerClassOfBehaviorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BEHAVIOR = 0;
  
  private final static int POSITION_CONTAINERCLASSNAME = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ContainerClassOfBehaviorMatcher.class);
  
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
  public ContainerClassOfBehaviorMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ContainerClassOfBehaviorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return matches represented as a ContainerClassOfBehaviorMatch object.
   * 
   */
  public Collection<ContainerClassOfBehaviorMatch> getAllMatches(final Behavior pBehavior, final String pContainerClassName) {
    return rawGetAllMatches(new Object[]{pBehavior, pContainerClassName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return a match represented as a ContainerClassOfBehaviorMatch object, or null if no match is found.
   * 
   */
  public ContainerClassOfBehaviorMatch getOneArbitraryMatch(final Behavior pBehavior, final String pContainerClassName) {
    return rawGetOneArbitraryMatch(new Object[]{pBehavior, pContainerClassName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Behavior pBehavior, final String pContainerClassName) {
    return rawHasMatch(new Object[]{pBehavior, pContainerClassName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Behavior pBehavior, final String pContainerClassName) {
    return rawCountMatches(new Object[]{pBehavior, pContainerClassName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Behavior pBehavior, final String pContainerClassName, final IMatchProcessor<? super ContainerClassOfBehaviorMatch> processor) {
    rawForEachMatch(new Object[]{pBehavior, pContainerClassName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Behavior pBehavior, final String pContainerClassName, final IMatchProcessor<? super ContainerClassOfBehaviorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBehavior, pContainerClassName}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ContainerClassOfBehaviorMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Behavior pBehavior, final String pContainerClassName) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pBehavior, pContainerClassName});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pContainerClassName the fixed value of pattern parameter containerClassName, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ContainerClassOfBehaviorMatch newMatch(final Behavior pBehavior, final String pContainerClassName) {
    return ContainerClassOfBehaviorMatch.newMatch(pBehavior, pContainerClassName);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Behavior> rawAccumulateAllValuesOfbehavior(final Object[] parameters) {
    Set<Behavior> results = new HashSet<Behavior>();
    rawAccumulateAllValues(POSITION_BEHAVIOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfbehavior() {
    return rawAccumulateAllValuesOfbehavior(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfbehavior(final ContainerClassOfBehaviorMatch partialMatch) {
    return rawAccumulateAllValuesOfbehavior(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfbehavior(final String pContainerClassName) {
    return rawAccumulateAllValuesOfbehavior(new Object[]{null, pContainerClassName});
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
  public Set<String> getAllValuesOfcontainerClassName(final ContainerClassOfBehaviorMatch partialMatch) {
    return rawAccumulateAllValuesOfcontainerClassName(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for containerClassName.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfcontainerClassName(final Behavior pBehavior) {
    return rawAccumulateAllValuesOfcontainerClassName(new Object[]{pBehavior, null});
  }
  
  @Override
  protected ContainerClassOfBehaviorMatch tupleToMatch(final Tuple t) {
    try {
      return ContainerClassOfBehaviorMatch.newMatch((org.eclipse.uml2.uml.Behavior) t.get(POSITION_BEHAVIOR), (java.lang.String) t.get(POSITION_CONTAINERCLASSNAME));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ContainerClassOfBehaviorMatch arrayToMatch(final Object[] match) {
    try {
      return ContainerClassOfBehaviorMatch.newMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (java.lang.String) match[POSITION_CONTAINERCLASSNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ContainerClassOfBehaviorMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ContainerClassOfBehaviorMatch.newMutableMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (java.lang.String) match[POSITION_CONTAINERCLASSNAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
