package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.MultipleInitialTransitionsMatch;
import hu.eltesoft.modelexecution.validation.util.MultipleInitialTransitionsQuerySpecification;
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
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Transition;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.MultipleInitialTransitions pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultipleInitialTransitionsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Multiple initial transitions from an initial pseudostate", mark = { "tr1", "tr2" })
 * pattern MultipleInitialTransitions(src : Pseudostate, tr1 : Transition, tr2 : Transition) {
 * 	find InitialState(_, src);
 * 	find InitialTransition(src, tr1);
 * 	find InitialTransition(src, tr2);
 * 	tr1 != tr2;
 * }
 * </pre></code>
 * 
 * @see MultipleInitialTransitionsMatch
 * @see MultipleInitialTransitionsProcessor
 * @see MultipleInitialTransitionsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultipleInitialTransitionsMatcher extends BaseMatcher<MultipleInitialTransitionsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultipleInitialTransitionsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultipleInitialTransitionsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultipleInitialTransitionsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SRC = 0;
  
  private final static int POSITION_TR1 = 1;
  
  private final static int POSITION_TR2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultipleInitialTransitionsMatcher.class);
  
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
  public MultipleInitialTransitionsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultipleInitialTransitionsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return matches represented as a MultipleInitialTransitionsMatch object.
   * 
   */
  public Collection<MultipleInitialTransitionsMatch> getAllMatches(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return rawGetAllMatches(new Object[]{pSrc, pTr1, pTr2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return a match represented as a MultipleInitialTransitionsMatch object, or null if no match is found.
   * 
   */
  public MultipleInitialTransitionsMatch getOneArbitraryMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return rawGetOneArbitraryMatch(new Object[]{pSrc, pTr1, pTr2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return rawHasMatch(new Object[]{pSrc, pTr1, pTr2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return rawCountMatches(new Object[]{pSrc, pTr1, pTr2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2, final IMatchProcessor<? super MultipleInitialTransitionsMatch> processor) {
    rawForEachMatch(new Object[]{pSrc, pTr1, pTr2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2, final IMatchProcessor<? super MultipleInitialTransitionsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSrc, pTr1, pTr2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultipleInitialTransitionsMatch newMatch(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2) {
    return MultipleInitialTransitionsMatch.newMatch(pSrc, pTr1, pTr2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Pseudostate> rawAccumulateAllValuesOfsrc(final Object[] parameters) {
    Set<Pseudostate> results = new HashSet<Pseudostate>();
    rawAccumulateAllValues(POSITION_SRC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfsrc() {
    return rawAccumulateAllValuesOfsrc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfsrc(final MultipleInitialTransitionsMatch partialMatch) {
    return rawAccumulateAllValuesOfsrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Pseudostate> getAllValuesOfsrc(final Transition pTr1, final Transition pTr2) {
    return rawAccumulateAllValuesOfsrc(new Object[]{
    null, 
    pTr1, 
    pTr2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOftr1(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_TR1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr1() {
    return rawAccumulateAllValuesOftr1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr1(final MultipleInitialTransitionsMatch partialMatch) {
    return rawAccumulateAllValuesOftr1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr1(final Pseudostate pSrc, final Transition pTr2) {
    return rawAccumulateAllValuesOftr1(new Object[]{
    pSrc, 
    null, 
    pTr2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Transition> rawAccumulateAllValuesOftr2(final Object[] parameters) {
    Set<Transition> results = new HashSet<Transition>();
    rawAccumulateAllValues(POSITION_TR2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr2() {
    return rawAccumulateAllValuesOftr2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr2(final MultipleInitialTransitionsMatch partialMatch) {
    return rawAccumulateAllValuesOftr2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr2(final Pseudostate pSrc, final Transition pTr1) {
    return rawAccumulateAllValuesOftr2(new Object[]{
    pSrc, 
    pTr1, 
    null
    });
  }
  
  @Override
  protected MultipleInitialTransitionsMatch tupleToMatch(final Tuple t) {
    try {
    	return MultipleInitialTransitionsMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) t.get(POSITION_SRC), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TR1), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TR2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleInitialTransitionsMatch arrayToMatch(final Object[] match) {
    try {
    	return MultipleInitialTransitionsMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_SRC], (org.eclipse.uml2.uml.Transition) match[POSITION_TR1], (org.eclipse.uml2.uml.Transition) match[POSITION_TR2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleInitialTransitionsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultipleInitialTransitionsMatch.newMutableMatch((org.eclipse.uml2.uml.Pseudostate) match[POSITION_SRC], (org.eclipse.uml2.uml.Transition) match[POSITION_TR1], (org.eclipse.uml2.uml.Transition) match[POSITION_TR2]);
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
  public static IQuerySpecification<MultipleInitialTransitionsMatcher> querySpecification() throws IncQueryException {
    return MultipleInitialTransitionsQuerySpecification.instance();
  }
}
