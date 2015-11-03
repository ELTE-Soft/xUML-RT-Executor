package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEventsMatch;
import hu.eltesoft.modelexecution.validation.util.SignalInMultipleSignalEventsQuerySpecification;
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
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEvents pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalInMultipleSignalEventsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "The signal {sg} cannot appear as signal of two signal events", mark = { "ev1", "ev2" })
 * pattern SignalInMultipleSignalEvents(sg : Signal, ev1 : SignalEvent, ev2 : SignalEvent) {
 * 	SignalEvent.signal(ev1, sg);
 * 	SignalEvent.signal(ev2, sg);
 * 	ev1 != ev2;
 * }
 * </pre></code>
 * 
 * @see SignalInMultipleSignalEventsMatch
 * @see SignalInMultipleSignalEventsProcessor
 * @see SignalInMultipleSignalEventsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalInMultipleSignalEventsMatcher extends BaseMatcher<SignalInMultipleSignalEventsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalInMultipleSignalEventsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalInMultipleSignalEventsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalInMultipleSignalEventsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SG = 0;
  
  private final static int POSITION_EV1 = 1;
  
  private final static int POSITION_EV2 = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalInMultipleSignalEventsMatcher.class);
  
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
  public SignalInMultipleSignalEventsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalInMultipleSignalEventsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return matches represented as a SignalInMultipleSignalEventsMatch object.
   * 
   */
  public Collection<SignalInMultipleSignalEventsMatch> getAllMatches(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return rawGetAllMatches(new Object[]{pSg, pEv1, pEv2});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return a match represented as a SignalInMultipleSignalEventsMatch object, or null if no match is found.
   * 
   */
  public SignalInMultipleSignalEventsMatch getOneArbitraryMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return rawGetOneArbitraryMatch(new Object[]{pSg, pEv1, pEv2});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return rawHasMatch(new Object[]{pSg, pEv1, pEv2});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return rawCountMatches(new Object[]{pSg, pEv1, pEv2});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2, final IMatchProcessor<? super SignalInMultipleSignalEventsMatch> processor) {
    rawForEachMatch(new Object[]{pSg, pEv1, pEv2}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2, final IMatchProcessor<? super SignalInMultipleSignalEventsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSg, pEv1, pEv2}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSg the fixed value of pattern parameter sg, or null if not bound.
   * @param pEv1 the fixed value of pattern parameter ev1, or null if not bound.
   * @param pEv2 the fixed value of pattern parameter ev2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalInMultipleSignalEventsMatch newMatch(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2) {
    return SignalInMultipleSignalEventsMatch.newMatch(pSg, pEv1, pEv2);
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsg(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SG, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg() {
    return rawAccumulateAllValuesOfsg(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final SignalInMultipleSignalEventsMatch partialMatch) {
    return rawAccumulateAllValuesOfsg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsg(final SignalEvent pEv1, final SignalEvent pEv2) {
    return rawAccumulateAllValuesOfsg(new Object[]{
    null, 
    pEv1, 
    pEv2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SignalEvent> rawAccumulateAllValuesOfev1(final Object[] parameters) {
    Set<SignalEvent> results = new HashSet<SignalEvent>();
    rawAccumulateAllValues(POSITION_EV1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev1() {
    return rawAccumulateAllValuesOfev1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev1(final SignalInMultipleSignalEventsMatch partialMatch) {
    return rawAccumulateAllValuesOfev1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev1(final Signal pSg, final SignalEvent pEv2) {
    return rawAccumulateAllValuesOfev1(new Object[]{
    pSg, 
    null, 
    pEv2
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SignalEvent> rawAccumulateAllValuesOfev2(final Object[] parameters) {
    Set<SignalEvent> results = new HashSet<SignalEvent>();
    rawAccumulateAllValues(POSITION_EV2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev2() {
    return rawAccumulateAllValuesOfev2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev2(final SignalInMultipleSignalEventsMatch partialMatch) {
    return rawAccumulateAllValuesOfev2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ev2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SignalEvent> getAllValuesOfev2(final Signal pSg, final SignalEvent pEv1) {
    return rawAccumulateAllValuesOfev2(new Object[]{
    pSg, 
    pEv1, 
    null
    });
  }
  
  @Override
  protected SignalInMultipleSignalEventsMatch tupleToMatch(final Tuple t) {
    try {
    	return SignalInMultipleSignalEventsMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SG), (org.eclipse.uml2.uml.SignalEvent) t.get(POSITION_EV1), (org.eclipse.uml2.uml.SignalEvent) t.get(POSITION_EV2));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalInMultipleSignalEventsMatch arrayToMatch(final Object[] match) {
    try {
    	return SignalInMultipleSignalEventsMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SG], (org.eclipse.uml2.uml.SignalEvent) match[POSITION_EV1], (org.eclipse.uml2.uml.SignalEvent) match[POSITION_EV2]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalInMultipleSignalEventsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SignalInMultipleSignalEventsMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SG], (org.eclipse.uml2.uml.SignalEvent) match[POSITION_EV1], (org.eclipse.uml2.uml.SignalEvent) match[POSITION_EV2]);
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
  public static IQuerySpecification<SignalInMultipleSignalEventsMatcher> querySpecification() throws IncQueryException {
    return SignalInMultipleSignalEventsQuerySpecification.instance();
  }
}
