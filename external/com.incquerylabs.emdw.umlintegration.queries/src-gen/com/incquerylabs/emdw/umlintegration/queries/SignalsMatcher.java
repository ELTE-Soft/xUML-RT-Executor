package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.SignalsMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalsQuerySpecification;
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
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.signals pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern signals(sig : Signal) {
 *     Signal(sig);
 * }
 * </pre></code>
 * 
 * @see SignalsMatch
 * @see SignalsProcessor
 * @see SignalsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalsMatcher extends BaseMatcher<SignalsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIG = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalsMatcher.class);
  
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
  public SignalsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @return matches represented as a SignalsMatch object.
   * 
   */
  public Collection<SignalsMatch> getAllMatches(final Signal pSig) {
    return rawGetAllMatches(new Object[]{pSig});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @return a match represented as a SignalsMatch object, or null if no match is found.
   * 
   */
  public SignalsMatch getOneArbitraryMatch(final Signal pSig) {
    return rawGetOneArbitraryMatch(new Object[]{pSig});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSig) {
    return rawHasMatch(new Object[]{pSig});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSig) {
    return rawCountMatches(new Object[]{pSig});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSig, final IMatchProcessor<? super SignalsMatch> processor) {
    rawForEachMatch(new Object[]{pSig}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSig, final IMatchProcessor<? super SignalsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSig}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSig the fixed value of pattern parameter sig, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalsMatch newMatch(final Signal pSig) {
    return SignalsMatch.newMatch(pSig);
  }
  
  /**
   * Retrieve the set of values that occur in matches for sig.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsig(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SIG, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sig.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsig() {
    return rawAccumulateAllValuesOfsig(emptyArray());
  }
  
  @Override
  protected SignalsMatch tupleToMatch(final Tuple t) {
    try {
    	return SignalsMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SIG));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalsMatch arrayToMatch(final Object[] match) {
    try {
    	return SignalsMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIG]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SignalsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SignalsMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIG]);
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
  public static IQuerySpecification<SignalsMatcher> querySpecification() throws IncQueryException {
    return SignalsQuerySpecification.instance();
  }
}
