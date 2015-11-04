package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEventMatch;
import hu.eltesoft.modelexecution.validation.util.MultipleTransitionsWithAnEventQuerySpecification;
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
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEvent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultipleTransitionsWithAnEventMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Multiple transitions from a single state with a single event are not supported", mark = { "src" })
 * pattern MultipleTransitionsWithAnEvent(tr1 : Transition, tr2 : Transition, src : State, ev : Event) {
 * 	Transition.source(tr1, src);
 * 	find TransitionEvent(tr1, ev);
 * 	Transition.source(tr2, src);
 * 	find TransitionEvent(tr2, ev);
 * 	tr1 != tr2;
 * }
 * </pre></code>
 * 
 * @see MultipleTransitionsWithAnEventMatch
 * @see MultipleTransitionsWithAnEventProcessor
 * @see MultipleTransitionsWithAnEventQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultipleTransitionsWithAnEventMatcher extends BaseMatcher<MultipleTransitionsWithAnEventMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultipleTransitionsWithAnEventMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultipleTransitionsWithAnEventMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultipleTransitionsWithAnEventMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_TR1 = 0;
  
  private final static int POSITION_TR2 = 1;
  
  private final static int POSITION_SRC = 2;
  
  private final static int POSITION_EV = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultipleTransitionsWithAnEventMatcher.class);
  
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
  public MultipleTransitionsWithAnEventMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultipleTransitionsWithAnEventMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return matches represented as a MultipleTransitionsWithAnEventMatch object.
   * 
   */
  public Collection<MultipleTransitionsWithAnEventMatch> getAllMatches(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return rawGetAllMatches(new Object[]{pTr1, pTr2, pSrc, pEv});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return a match represented as a MultipleTransitionsWithAnEventMatch object, or null if no match is found.
   * 
   */
  public MultipleTransitionsWithAnEventMatch getOneArbitraryMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return rawGetOneArbitraryMatch(new Object[]{pTr1, pTr2, pSrc, pEv});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return rawHasMatch(new Object[]{pTr1, pTr2, pSrc, pEv});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return rawCountMatches(new Object[]{pTr1, pTr2, pSrc, pEv});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv, final IMatchProcessor<? super MultipleTransitionsWithAnEventMatch> processor) {
    rawForEachMatch(new Object[]{pTr1, pTr2, pSrc, pEv}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv, final IMatchProcessor<? super MultipleTransitionsWithAnEventMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pTr1, pTr2, pSrc, pEv}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTr1 the fixed value of pattern parameter tr1, or null if not bound.
   * @param pTr2 the fixed value of pattern parameter tr2, or null if not bound.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pEv the fixed value of pattern parameter ev, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultipleTransitionsWithAnEventMatch newMatch(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv) {
    return MultipleTransitionsWithAnEventMatch.newMatch(pTr1, pTr2, pSrc, pEv);
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
  public Set<Transition> getAllValuesOftr1(final MultipleTransitionsWithAnEventMatch partialMatch) {
    return rawAccumulateAllValuesOftr1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr1(final Transition pTr2, final State pSrc, final Event pEv) {
    return rawAccumulateAllValuesOftr1(new Object[]{
    null, 
    pTr2, 
    pSrc, 
    pEv
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
  public Set<Transition> getAllValuesOftr2(final MultipleTransitionsWithAnEventMatch partialMatch) {
    return rawAccumulateAllValuesOftr2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for tr2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Transition> getAllValuesOftr2(final Transition pTr1, final State pSrc, final Event pEv) {
    return rawAccumulateAllValuesOftr2(new Object[]{
    pTr1, 
    null, 
    pSrc, 
    pEv
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<State> rawAccumulateAllValuesOfsrc(final Object[] parameters) {
    Set<State> results = new HashSet<State>();
    rawAccumulateAllValues(POSITION_SRC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsrc() {
    return rawAccumulateAllValuesOfsrc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsrc(final MultipleTransitionsWithAnEventMatch partialMatch) {
    return rawAccumulateAllValuesOfsrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<State> getAllValuesOfsrc(final Transition pTr1, final Transition pTr2, final Event pEv) {
    return rawAccumulateAllValuesOfsrc(new Object[]{
    pTr1, 
    pTr2, 
    null, 
    pEv
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Event> rawAccumulateAllValuesOfev(final Object[] parameters) {
    Set<Event> results = new HashSet<Event>();
    rawAccumulateAllValues(POSITION_EV, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Event> getAllValuesOfev() {
    return rawAccumulateAllValuesOfev(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Event> getAllValuesOfev(final MultipleTransitionsWithAnEventMatch partialMatch) {
    return rawAccumulateAllValuesOfev(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Event> getAllValuesOfev(final Transition pTr1, final Transition pTr2, final State pSrc) {
    return rawAccumulateAllValuesOfev(new Object[]{
    pTr1, 
    pTr2, 
    pSrc, 
    null
    });
  }
  
  @Override
  protected MultipleTransitionsWithAnEventMatch tupleToMatch(final Tuple t) {
    try {
    	return MultipleTransitionsWithAnEventMatch.newMatch((org.eclipse.uml2.uml.Transition) t.get(POSITION_TR1), (org.eclipse.uml2.uml.Transition) t.get(POSITION_TR2), (org.eclipse.uml2.uml.State) t.get(POSITION_SRC), (org.eclipse.uml2.uml.Event) t.get(POSITION_EV));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleTransitionsWithAnEventMatch arrayToMatch(final Object[] match) {
    try {
    	return MultipleTransitionsWithAnEventMatch.newMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TR1], (org.eclipse.uml2.uml.Transition) match[POSITION_TR2], (org.eclipse.uml2.uml.State) match[POSITION_SRC], (org.eclipse.uml2.uml.Event) match[POSITION_EV]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MultipleTransitionsWithAnEventMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MultipleTransitionsWithAnEventMatch.newMutableMatch((org.eclipse.uml2.uml.Transition) match[POSITION_TR1], (org.eclipse.uml2.uml.Transition) match[POSITION_TR2], (org.eclipse.uml2.uml.State) match[POSITION_SRC], (org.eclipse.uml2.uml.Event) match[POSITION_EV]);
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
  public static IQuerySpecification<MultipleTransitionsWithAnEventMatcher> querySpecification() throws IncQueryException {
    return MultipleTransitionsWithAnEventQuerySpecification.instance();
  }
}
