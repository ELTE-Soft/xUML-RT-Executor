package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ComponentClassifierBehaviorMatch;
import hu.eltesoft.modelexecution.validation.util.ComponentClassifierBehaviorQuerySpecification;
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
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ComponentClassifierBehavior pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ComponentClassifierBehaviorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Component classifier behaviors are not supported", mark = { "cp" })
 * pattern ComponentClassifierBehavior(cp : Component) {
 * 	Component.classifierBehavior(cp, _);
 * }
 * </pre></code>
 * 
 * @see ComponentClassifierBehaviorMatch
 * @see ComponentClassifierBehaviorProcessor
 * @see ComponentClassifierBehaviorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ComponentClassifierBehaviorMatcher extends BaseMatcher<ComponentClassifierBehaviorMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ComponentClassifierBehaviorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ComponentClassifierBehaviorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ComponentClassifierBehaviorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CP = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ComponentClassifierBehaviorMatcher.class);
  
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
  public ComponentClassifierBehaviorMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ComponentClassifierBehaviorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return matches represented as a ComponentClassifierBehaviorMatch object.
   * 
   */
  public Collection<ComponentClassifierBehaviorMatch> getAllMatches(final Component pCp) {
    return rawGetAllMatches(new Object[]{pCp});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCp the fixed value of pattern parameter cp, or null if not bound.
   * @return a match represented as a ComponentClassifierBehaviorMatch object, or null if no match is found.
   * 
   */
  public ComponentClassifierBehaviorMatch getOneArbitraryMatch(final Component pCp) {
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
  public void forEachMatch(final Component pCp, final IMatchProcessor<? super ComponentClassifierBehaviorMatch> processor) {
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
  public boolean forOneArbitraryMatch(final Component pCp, final IMatchProcessor<? super ComponentClassifierBehaviorMatch> processor) {
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
  public ComponentClassifierBehaviorMatch newMatch(final Component pCp) {
    return ComponentClassifierBehaviorMatch.newMatch(pCp);
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
  protected ComponentClassifierBehaviorMatch tupleToMatch(final Tuple t) {
    try {
    	return ComponentClassifierBehaviorMatch.newMatch((org.eclipse.uml2.uml.Component) t.get(POSITION_CP));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ComponentClassifierBehaviorMatch arrayToMatch(final Object[] match) {
    try {
    	return ComponentClassifierBehaviorMatch.newMatch((org.eclipse.uml2.uml.Component) match[POSITION_CP]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ComponentClassifierBehaviorMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ComponentClassifierBehaviorMatch.newMutableMatch((org.eclipse.uml2.uml.Component) match[POSITION_CP]);
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
  public static IQuerySpecification<ComponentClassifierBehaviorMatcher> querySpecification() throws IncQueryException {
    return ComponentClassifierBehaviorQuerySpecification.instance();
  }
}
