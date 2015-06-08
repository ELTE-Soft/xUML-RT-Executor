package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterQuerySpecification;
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
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.BehaviorParameter pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BehaviorParameterMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * BehaviorParameter(behavior : Behavior, parameter : Parameter, type : Type, direction : ParameterDirectionKind) {
 * 	Behavior.ownedParameter(behavior, parameter);
 * 	Parameter.direction(parameter, direction);
 * 	Parameter.type(parameter, type);
 * 	direction != ParameterDirectionKind::^return;
 * }
 * </pre></code>
 * 
 * @see BehaviorParameterMatch
 * @see BehaviorParameterProcessor
 * @see BehaviorParameterQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BehaviorParameterMatcher extends BaseMatcher<BehaviorParameterMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BehaviorParameterMatcher> querySpecification() throws IncQueryException {
    return BehaviorParameterQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BehaviorParameterMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BehaviorParameterMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BehaviorParameterMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BEHAVIOR = 0;
  
  private final static int POSITION_PARAMETER = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_DIRECTION = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BehaviorParameterMatcher.class);
  
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
  public BehaviorParameterMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BehaviorParameterMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return matches represented as a BehaviorParameterMatch object.
   * 
   */
  public Collection<BehaviorParameterMatch> getAllMatches(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawGetAllMatches(new Object[]{pBehavior, pParameter, pType, pDirection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return a match represented as a BehaviorParameterMatch object, or null if no match is found.
   * 
   */
  public BehaviorParameterMatch getOneArbitraryMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawGetOneArbitraryMatch(new Object[]{pBehavior, pParameter, pType, pDirection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawHasMatch(new Object[]{pBehavior, pParameter, pType, pDirection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawCountMatches(new Object[]{pBehavior, pParameter, pType, pDirection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection, final IMatchProcessor<? super BehaviorParameterMatch> processor) {
    rawForEachMatch(new Object[]{pBehavior, pParameter, pType, pDirection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection, final IMatchProcessor<? super BehaviorParameterMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBehavior, pParameter, pType, pDirection}, processor);
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
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<BehaviorParameterMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pBehavior, pParameter, pType, pDirection});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBehavior the fixed value of pattern parameter behavior, or null if not bound.
   * @param pParameter the fixed value of pattern parameter parameter, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pDirection the fixed value of pattern parameter direction, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BehaviorParameterMatch newMatch(final Behavior pBehavior, final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return BehaviorParameterMatch.newMatch(pBehavior, pParameter, pType, pDirection);
    
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
  public Set<Behavior> getAllValuesOfbehavior(final BehaviorParameterMatch partialMatch) {
    return rawAccumulateAllValuesOfbehavior(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for behavior.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Behavior> getAllValuesOfbehavior(final Parameter pParameter, final Type pType, final ParameterDirectionKind pDirection) {
    return rawAccumulateAllValuesOfbehavior(new Object[]{null, pParameter, pType, pDirection});
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
  public Set<Parameter> getAllValuesOfparameter(final BehaviorParameterMatch partialMatch) {
    return rawAccumulateAllValuesOfparameter(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parameter.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Parameter> getAllValuesOfparameter(final Behavior pBehavior, final Type pType, final ParameterDirectionKind pDirection) {
    return rawAccumulateAllValuesOfparameter(new Object[]{pBehavior, null, pType, pDirection});
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
  public Set<Type> getAllValuesOftype(final BehaviorParameterMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Behavior pBehavior, final Parameter pParameter, final ParameterDirectionKind pDirection) {
    return rawAccumulateAllValuesOftype(new Object[]{pBehavior, pParameter, null, pDirection});
  }
  
  /**
   * Retrieve the set of values that occur in matches for direction.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ParameterDirectionKind> rawAccumulateAllValuesOfdirection(final Object[] parameters) {
    Set<ParameterDirectionKind> results = new HashSet<ParameterDirectionKind>();
    rawAccumulateAllValues(POSITION_DIRECTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for direction.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ParameterDirectionKind> getAllValuesOfdirection() {
    return rawAccumulateAllValuesOfdirection(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for direction.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ParameterDirectionKind> getAllValuesOfdirection(final BehaviorParameterMatch partialMatch) {
    return rawAccumulateAllValuesOfdirection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for direction.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ParameterDirectionKind> getAllValuesOfdirection(final Behavior pBehavior, final Parameter pParameter, final Type pType) {
    return rawAccumulateAllValuesOfdirection(new Object[]{pBehavior, pParameter, pType, null});
  }
  
  @Override
  protected BehaviorParameterMatch tupleToMatch(final Tuple t) {
    try {
      return BehaviorParameterMatch.newMatch((org.eclipse.uml2.uml.Behavior) t.get(POSITION_BEHAVIOR), (org.eclipse.uml2.uml.Parameter) t.get(POSITION_PARAMETER), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (org.eclipse.uml2.uml.ParameterDirectionKind) t.get(POSITION_DIRECTION));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BehaviorParameterMatch arrayToMatch(final Object[] match) {
    try {
      return BehaviorParameterMatch.newMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ParameterDirectionKind) match[POSITION_DIRECTION]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected BehaviorParameterMatch arrayToMatchMutable(final Object[] match) {
    try {
      return BehaviorParameterMatch.newMutableMatch((org.eclipse.uml2.uml.Behavior) match[POSITION_BEHAVIOR], (org.eclipse.uml2.uml.Parameter) match[POSITION_PARAMETER], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ParameterDirectionKind) match[POSITION_DIRECTION]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
