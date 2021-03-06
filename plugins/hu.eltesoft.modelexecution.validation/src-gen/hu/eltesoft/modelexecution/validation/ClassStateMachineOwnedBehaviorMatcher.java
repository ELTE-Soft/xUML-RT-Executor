package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehaviorMatch;
import hu.eltesoft.modelexecution.validation.util.ClassStateMachineOwnedBehaviorQuerySpecification;
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
import org.eclipse.uml2.uml.StateMachine;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.ClassStateMachineOwnedBehavior pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ClassStateMachineOwnedBehaviorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "If state machine is owned by class it must be its classifier behavior", mark = { "beh" })
 * pattern ClassStateMachineOwnedBehavior(beh : StateMachine) {
 * 	Class.ownedBehavior(cl, beh);
 * 	neg find ClassifierBehavior(cl, beh);
 * }
 * </pre></code>
 * 
 * @see ClassStateMachineOwnedBehaviorMatch
 * @see ClassStateMachineOwnedBehaviorProcessor
 * @see ClassStateMachineOwnedBehaviorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ClassStateMachineOwnedBehaviorMatcher extends BaseMatcher<ClassStateMachineOwnedBehaviorMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ClassStateMachineOwnedBehaviorMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ClassStateMachineOwnedBehaviorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ClassStateMachineOwnedBehaviorMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BEH = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ClassStateMachineOwnedBehaviorMatcher.class);
  
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
  public ClassStateMachineOwnedBehaviorMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ClassStateMachineOwnedBehaviorMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return matches represented as a ClassStateMachineOwnedBehaviorMatch object.
   * 
   */
  public Collection<ClassStateMachineOwnedBehaviorMatch> getAllMatches(final StateMachine pBeh) {
    return rawGetAllMatches(new Object[]{pBeh});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return a match represented as a ClassStateMachineOwnedBehaviorMatch object, or null if no match is found.
   * 
   */
  public ClassStateMachineOwnedBehaviorMatch getOneArbitraryMatch(final StateMachine pBeh) {
    return rawGetOneArbitraryMatch(new Object[]{pBeh});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final StateMachine pBeh) {
    return rawHasMatch(new Object[]{pBeh});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final StateMachine pBeh) {
    return rawCountMatches(new Object[]{pBeh});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final StateMachine pBeh, final IMatchProcessor<? super ClassStateMachineOwnedBehaviorMatch> processor) {
    rawForEachMatch(new Object[]{pBeh}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final StateMachine pBeh, final IMatchProcessor<? super ClassStateMachineOwnedBehaviorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBeh}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBeh the fixed value of pattern parameter beh, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ClassStateMachineOwnedBehaviorMatch newMatch(final StateMachine pBeh) {
    return ClassStateMachineOwnedBehaviorMatch.newMatch(pBeh);
  }
  
  /**
   * Retrieve the set of values that occur in matches for beh.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<StateMachine> rawAccumulateAllValuesOfbeh(final Object[] parameters) {
    Set<StateMachine> results = new HashSet<StateMachine>();
    rawAccumulateAllValues(POSITION_BEH, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for beh.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<StateMachine> getAllValuesOfbeh() {
    return rawAccumulateAllValuesOfbeh(emptyArray());
  }
  
  @Override
  protected ClassStateMachineOwnedBehaviorMatch tupleToMatch(final Tuple t) {
    try {
    	return ClassStateMachineOwnedBehaviorMatch.newMatch((org.eclipse.uml2.uml.StateMachine) t.get(POSITION_BEH));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassStateMachineOwnedBehaviorMatch arrayToMatch(final Object[] match) {
    try {
    	return ClassStateMachineOwnedBehaviorMatch.newMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_BEH]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ClassStateMachineOwnedBehaviorMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ClassStateMachineOwnedBehaviorMatch.newMutableMatch((org.eclipse.uml2.uml.StateMachine) match[POSITION_BEH]);
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
  public static IQuerySpecification<ClassStateMachineOwnedBehaviorMatcher> querySpecification() throws IncQueryException {
    return ClassStateMachineOwnedBehaviorQuerySpecification.instance();
  }
}
