package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ComponentDirectlyInstantiatedMatch;
import hu.eltesoft.modelexecution.validation.util.ComponentDirectlyInstantiatedQuerySpecification;
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
import org.eclipse.uml2.uml.Component;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ComponentDirectlyInstantiated pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ComponentDirectlyInstantiatedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Directly instantiated components are not supported", mark = { "cp" })
 * pattern ComponentDirectlyInstantiated(cp : Component) {
 * 	Component.isIndirectlyInstantiated(cp, false);
 * }
 * </pre></code>
 * 
 * @see ComponentDirectlyInstantiatedMatch
 * @see ComponentDirectlyInstantiatedProcessor
 * @see ComponentDirectlyInstantiatedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ComponentDirectlyInstantiatedMatcher extends BaseMatcher<ComponentDirectlyInstantiatedMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ComponentDirectlyInstantiatedMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ComponentDirectlyInstantiatedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ComponentDirectlyInstantiatedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CP = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ComponentDirectlyInstantiatedMatcher.class);
  
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
  public ComponentDirectlyInstantiatedMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ComponentDirectlyInstantiatedMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return matches represented as a ComponentDirectlyInstantiatedMatch object.
   * 
   */
  public Collection<ComponentDirectlyInstantiatedMatch> getAllMatches(final Component pCp) {
    return rawGetAllMatches(new Object[]{pCp});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return a match represented as a ComponentDirectlyInstantiatedMatch object, or null if no match is found.
   * 
   */
  public ComponentDirectlyInstantiatedMatch getOneArbitraryMatch(final Component pCp) {
    return rawGetOneArbitraryMatch(new Object[]{pCp});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Component pCp) {
    return rawHasMatch(new Object[]{pCp});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Component pCp) {
    return rawCountMatches(new Object[]{pCp});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Component pCp, final IMatchProcessor<? super ComponentDirectlyInstantiatedMatch> processor) {
    rawForEachMatch(new Object[]{pCp}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Component pCp, final IMatchProcessor<? super ComponentDirectlyInstantiatedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCp}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ComponentDirectlyInstantiatedMatch newMatch(final Component pCp) {
    return ComponentDirectlyInstantiatedMatch.newMatch(pCp);
  }
  
  /**
   * Retrieve the set of values that occur in matches for cp.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Component> rawAccumulateAllValuesOfcp(final Object[] parameters) {
    Set<Component> results = new HashSet<Component>();
    rawAccumulateAllValues(POSITION_CP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cp.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfcp() {
    return rawAccumulateAllValuesOfcp(emptyArray());
  }
  
  @Override
  protected ComponentDirectlyInstantiatedMatch tupleToMatch(final Tuple t) {
    try {
    	return ComponentDirectlyInstantiatedMatch.newMatch((org.eclipse.uml2.uml.Component) t.get(POSITION_CP));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ComponentDirectlyInstantiatedMatch arrayToMatch(final Object[] match) {
    try {
    	return ComponentDirectlyInstantiatedMatch.newMatch((org.eclipse.uml2.uml.Component) match[POSITION_CP]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ComponentDirectlyInstantiatedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ComponentDirectlyInstantiatedMatch.newMutableMatch((org.eclipse.uml2.uml.Component) match[POSITION_CP]);
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
  public static IQuerySpecification<ComponentDirectlyInstantiatedMatcher> querySpecification() throws IncQueryException {
    return ComponentDirectlyInstantiatedQuerySpecification.instance();
  }
}
