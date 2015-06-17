package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnTypeQuerySpecification;
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
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BehaviorReturnTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * BehaviorReturnType(behavior : Behavior, parameter : Parameter, type, ordered, unique) {
 * 	Behavior.ownedParameter(behavior, parameter);
 * 	Parameter.direction(parameter, ParameterDirectionKind::^return);
 * 	Parameter.type(parameter, type);
 * 	Parameter.isOrdered(parameter, ordered);
 * 	Parameter.isUnique(parameter, unique);
 * }
 * </pre></code>
 * 
 * @see BehaviorReturnTypeMatch
 * @see BehaviorReturnTypeProcessor
 * @see BehaviorReturnTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BehaviorReturnTypeMatcher extends BaseMatcher<BehaviorReturnTypeMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BehaviorReturnTypeMatcher> querySpecification() throws IncQueryException {
    return BehaviorReturnTypeQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BehaviorReturnTypeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BehaviorReturnTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BehaviorReturnTypeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BEHAVIOR = 0;
  
  private final static int POSITION_PARAMETER = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_ORDERED = 3;
  
  private final static int POSITION_UNIQUE = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BehaviorReturnTypeMatcher.class);
  
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
  public BehaviorReturnTypeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BehaviorReturnTypeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return matches represented as a BehaviorReturnTypeMatch object.
   * 
   */
  public Collection<BehaviorReturnTypeMatch> getAllMatches(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetAllMatches(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return a match represented as a BehaviorReturnTypeMatch object, or null if no match is found.
   * 
   */
  public BehaviorReturnTypeMatch getOneArbitraryMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetOneArbitraryMatch(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawHasMatch(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawCountMatches(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super BehaviorReturnTypeMatch> processor) {
    rawForEachMatch(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super BehaviorReturnTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BehaviorReturnTypeMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pBehavior, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BehaviorReturnTypeMatch newMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return BehaviorReturnTypeMatch.newMatch(pBehavior, pParameter, pType, pOrdered, pUnique);
    
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
  public Set<Behavior> getAllValuesOfbehavior(final BehaviorReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfbehavior(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfbehavior(final Parameter pParameter, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfbehavior(new Object[]{null, pParameter, pType, pOrdered, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Parameter> rawAccumulateAllValuesOfparameter(final Object[] parameters) {
    Set<Parameter> results = new HashSet<Parameter>();
    rawAccumulateAllValues(POSITION_PARAMETER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter() {
    return rawAccumulateAllValuesOfparameter(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final BehaviorReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final Behavior pBehavior, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfparameter(new Object[]{pBehavior, null, pType, pOrdered, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Type> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<Type> results = new HashSet<Type>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final BehaviorReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Behavior pBehavior, final Parameter pParameter, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOftype(new Object[]{pBehavior, pParameter, null, pOrdered, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfordered(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_ORDERED, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered() {
    return rawAccumulateAllValuesOfordered(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final BehaviorReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfordered(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pUnique) {
    return rawAccumulateAllValuesOfordered(new Object[]{pBehavior, pParameter, pType, null, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfunique(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_UNIQUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique() {
    return rawAccumulateAllValuesOfunique(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final BehaviorReturnTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfunique(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final Behavior pBehavior, final Parameter pParameter, final Type pType, final Boolean pOrdered) {
    return rawAccumulateAllValuesOfunique(new Object[]{pBehavior, pParameter, pType, pOrdered, null});
  }
  
  @Override
  protected BehaviorReturnTypeMatch tupleToMatch(final Tuple t) {
    try {
      return BehaviorReturnTypeMatch.newMatch((org.eclipse.uml2.uml.Behavior) t.get(POSITION_BEHAVIOR), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAMETER), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (java.lang.Boolean) t.get(POSITION_ORDERED), (java.lang.Boolean) t.get(POSITION_UNIQUE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BehaviorReturnTypeMatch arrayToMatch(final Object[] match) {
    try {
      return BehaviorReturnTypeMatch.newMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BehaviorReturnTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
      return BehaviorReturnTypeMatch.newMutableMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
