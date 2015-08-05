package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtSignalEventMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtSignalEventQuerySpecification;
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

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtSignalEvent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtSignalEventMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // Events
 * // FIXME Signal Event is related to protocol, so this is incorrect
 * pattern xtSignalEvent(umlClass: Class, signal: Signal) {
 * 	Interface.nestedClassifier(_, signal);
 * 
 * 	Class.classifierBehavior(umlClass, stateMachine);
 * 	find transitionInStateMachine(stateMachine, transition);
 * 	Transition.trigger(transition, trigger);
 * 	Trigger.event(trigger, signalEvent);
 * 	SignalEvent.signal(signalEvent, signal);
 * }
 * </pre></code>
 * 
 * @see XtSignalEventMatch
 * @see XtSignalEventProcessor
 * @see XtSignalEventQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtSignalEventMatcher extends BaseMatcher<XtSignalEventMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtSignalEventMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtSignalEventMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtSignalEventMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_UMLCLASS = 0;
  
  private final static int POSITION_SIGNAL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtSignalEventMatcher.class);
  
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
  public XtSignalEventMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtSignalEventMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return matches represented as a XtSignalEventMatch object.
   * 
   */
  public Collection<XtSignalEventMatch> getAllMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return rawGetAllMatches(new Object[]{pUmlClass, pSignal});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return a match represented as a XtSignalEventMatch object, or null if no match is found.
   * 
   */
  public XtSignalEventMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return rawGetOneArbitraryMatch(new Object[]{pUmlClass, pSignal});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return rawHasMatch(new Object[]{pUmlClass, pSignal});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return rawCountMatches(new Object[]{pUmlClass, pSignal});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal, final IMatchProcessor<? super XtSignalEventMatch> processor) {
    rawForEachMatch(new Object[]{pUmlClass, pSignal}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal, final IMatchProcessor<? super XtSignalEventMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUmlClass, pSignal}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtSignalEventMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Signal pSignal) {
    return XtSignalEventMatch.newMatch(pUmlClass, pSignal);
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfumlClass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_UMLCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass() {
    return rawAccumulateAllValuesOfumlClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final XtSignalEventMatch partialMatch) {
    return rawAccumulateAllValuesOfumlClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final Signal pSignal) {
    return rawAccumulateAllValuesOfumlClass(new Object[]{
    null, 
    pSignal
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsignal(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SIGNAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal() {
    return rawAccumulateAllValuesOfsignal(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final XtSignalEventMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    pUmlClass, 
    null
    });
  }
  
  @Override
  protected XtSignalEventMatch tupleToMatch(final Tuple t) {
    try {
    	return XtSignalEventMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS), (org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtSignalEventMatch arrayToMatch(final Object[] match) {
    try {
    	return XtSignalEventMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtSignalEventMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtSignalEventMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL]);
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
  public static IQuerySpecification<XtSignalEventMatcher> querySpecification() throws IncQueryException {
    return XtSignalEventQuerySpecification.instance();
  }
}
