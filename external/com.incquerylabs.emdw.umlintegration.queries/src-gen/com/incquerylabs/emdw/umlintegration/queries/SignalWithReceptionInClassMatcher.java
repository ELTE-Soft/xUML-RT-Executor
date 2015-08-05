package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.SignalWithReceptionInClassMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalWithReceptionInClassQuerySpecification;
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
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.signalWithReceptionInClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalWithReceptionInClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern signalWithReceptionInClass(signal: Signal, reception: Reception, umlClass: Class) {
 * 	Class.ownedReception(umlClass, reception);
 * 	Reception.signal(reception, signal);
 * }
 * </pre></code>
 * 
 * @see SignalWithReceptionInClassMatch
 * @see SignalWithReceptionInClassProcessor
 * @see SignalWithReceptionInClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalWithReceptionInClassMatcher extends BaseMatcher<SignalWithReceptionInClassMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalWithReceptionInClassMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalWithReceptionInClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalWithReceptionInClassMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_RECEPTION = 1;
  
  private final static int POSITION_UMLCLASS = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalWithReceptionInClassMatcher.class);
  
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
  public SignalWithReceptionInClassMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalWithReceptionInClassMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return matches represented as a SignalWithReceptionInClassMatch object.
   * 
   */
  public Collection<SignalWithReceptionInClassMatch> getAllMatches(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawGetAllMatches(new Object[]{pSignal, pReception, pUmlClass});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return a match represented as a SignalWithReceptionInClassMatch object, or null if no match is found.
   * 
   */
  public SignalWithReceptionInClassMatch getOneArbitraryMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pReception, pUmlClass});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawHasMatch(new Object[]{pSignal, pReception, pUmlClass});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawCountMatches(new Object[]{pSignal, pReception, pUmlClass});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass, final IMatchProcessor<? super SignalWithReceptionInClassMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pReception, pUmlClass}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass, final IMatchProcessor<? super SignalWithReceptionInClassMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pReception, pUmlClass}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pReception the fixed value of pattern parameter reception, or null if not bound.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalWithReceptionInClassMatch newMatch(final Signal pSignal, final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return SignalWithReceptionInClassMatch.newMatch(pSignal, pReception, pUmlClass);
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
  public Set<Signal> getAllValuesOfsignal(final SignalWithReceptionInClassMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Reception pReception, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    null, 
    pReception, 
    pUmlClass
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Reception> rawAccumulateAllValuesOfreception(final Object[] parameters) {
    Set<Reception> results = new HashSet<Reception>();
    rawAccumulateAllValues(POSITION_RECEPTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception() {
    return rawAccumulateAllValuesOfreception(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception(final SignalWithReceptionInClassMatch partialMatch) {
    return rawAccumulateAllValuesOfreception(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for reception.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reception> getAllValuesOfreception(final Signal pSignal, final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawAccumulateAllValuesOfreception(new Object[]{
    pSignal, 
    null, 
    pUmlClass
    });
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final SignalWithReceptionInClassMatch partialMatch) {
    return rawAccumulateAllValuesOfumlClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final Signal pSignal, final Reception pReception) {
    return rawAccumulateAllValuesOfumlClass(new Object[]{
    pSignal, 
    pReception, 
    null
    });
  }
  
  @Override
  protected SignalWithReceptionInClassMatch tupleToMatch(final Tuple t) {
    try {
    	return SignalWithReceptionInClassMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL), (org.eclipse.uml2.uml.Reception) t.get(POSITION_RECEPTION), (org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalWithReceptionInClassMatch arrayToMatch(final Object[] match) {
    try {
    	return SignalWithReceptionInClassMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Reception) match[POSITION_RECEPTION], (org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalWithReceptionInClassMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SignalWithReceptionInClassMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Reception) match[POSITION_RECEPTION], (org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
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
  public static IQuerySpecification<SignalWithReceptionInClassMatcher> querySpecification() throws IncQueryException {
    return SignalWithReceptionInClassQuerySpecification.instance();
  }
}
