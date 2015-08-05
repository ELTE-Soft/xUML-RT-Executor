package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtClassEventGeneralizationMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventGeneralizationQuerySpecification;
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
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtClassEventGeneralization pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtClassEventGeneralizationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern xtClassEventGeneralization(
 * 	signal: Signal,
 * 	superSignal: Signal
 * ) {
 * 	Class.nestedClassifier(_class1, signal);
 * 	Class.nestedClassifier(_class2, superSignal);
 * 	Signal.generalization(signal, generalization);
 * 	Generalization.general(generalization, superSignal);
 * }
 * </pre></code>
 * 
 * @see XtClassEventGeneralizationMatch
 * @see XtClassEventGeneralizationProcessor
 * @see XtClassEventGeneralizationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtClassEventGeneralizationMatcher extends BaseMatcher<XtClassEventGeneralizationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtClassEventGeneralizationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtClassEventGeneralizationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtClassEventGeneralizationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_SUPERSIGNAL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtClassEventGeneralizationMatcher.class);
  
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
  public XtClassEventGeneralizationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtClassEventGeneralizationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return matches represented as a XtClassEventGeneralizationMatch object.
   * 
   */
  public Collection<XtClassEventGeneralizationMatch> getAllMatches(final Signal pSignal, final Signal pSuperSignal) {
    return rawGetAllMatches(new Object[]{pSignal, pSuperSignal});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return a match represented as a XtClassEventGeneralizationMatch object, or null if no match is found.
   * 
   */
  public XtClassEventGeneralizationMatch getOneArbitraryMatch(final Signal pSignal, final Signal pSuperSignal) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pSuperSignal});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final Signal pSuperSignal) {
    return rawHasMatch(new Object[]{pSignal, pSuperSignal});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final Signal pSuperSignal) {
    return rawCountMatches(new Object[]{pSignal, pSuperSignal});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final Signal pSuperSignal, final IMatchProcessor<? super XtClassEventGeneralizationMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pSuperSignal}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final Signal pSuperSignal, final IMatchProcessor<? super XtClassEventGeneralizationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pSuperSignal}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pSuperSignal the fixed value of pattern parameter superSignal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtClassEventGeneralizationMatch newMatch(final Signal pSignal, final Signal pSuperSignal) {
    return XtClassEventGeneralizationMatch.newMatch(pSignal, pSuperSignal);
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
  public Set<Signal> getAllValuesOfsignal(final XtClassEventGeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Signal pSuperSignal) {
    return rawAccumulateAllValuesOfsignal(new Object[]{
    null, 
    pSuperSignal
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for superSignal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsuperSignal(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SUPERSIGNAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for superSignal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsuperSignal() {
    return rawAccumulateAllValuesOfsuperSignal(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superSignal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsuperSignal(final XtClassEventGeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfsuperSignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for superSignal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsuperSignal(final Signal pSignal) {
    return rawAccumulateAllValuesOfsuperSignal(new Object[]{
    pSignal, 
    null
    });
  }
  
  @Override
  protected XtClassEventGeneralizationMatch tupleToMatch(final Tuple t) {
    try {
    	return XtClassEventGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL), (org.eclipse.uml2.uml.Signal) t.get(POSITION_SUPERSIGNAL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtClassEventGeneralizationMatch arrayToMatch(final Object[] match) {
    try {
    	return XtClassEventGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Signal) match[POSITION_SUPERSIGNAL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtClassEventGeneralizationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtClassEventGeneralizationMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Signal) match[POSITION_SUPERSIGNAL]);
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
  public static IQuerySpecification<XtClassEventGeneralizationMatcher> querySpecification() throws IncQueryException {
    return XtClassEventGeneralizationQuerySpecification.instance();
  }
}
