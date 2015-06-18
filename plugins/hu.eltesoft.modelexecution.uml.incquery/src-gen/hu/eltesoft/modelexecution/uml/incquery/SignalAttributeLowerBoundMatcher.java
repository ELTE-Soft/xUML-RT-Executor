package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeLowerBoundQuerySpecification;
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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBound pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalAttributeLowerBoundMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern SignalAttributeLowerBound(signal : Signal, attribute : Property, lowerBound : ValueSpecification) {
 * 	find SignalAttribute(signal, attribute, _, _, _);
 * 	Property.lowerValue(attribute, lowerBound);
 * }
 * </pre></code>
 * 
 * @see SignalAttributeLowerBoundMatch
 * @see SignalAttributeLowerBoundProcessor
 * @see SignalAttributeLowerBoundQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalAttributeLowerBoundMatcher extends BaseMatcher<SignalAttributeLowerBoundMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SignalAttributeLowerBoundMatcher> querySpecification() throws IncQueryException {
    return SignalAttributeLowerBoundQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalAttributeLowerBoundMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalAttributeLowerBoundMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalAttributeLowerBoundMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_ATTRIBUTE = 1;
  
  private final static int POSITION_LOWERBOUND = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalAttributeLowerBoundMatcher.class);
  
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
  public SignalAttributeLowerBoundMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalAttributeLowerBoundMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return matches represented as a SignalAttributeLowerBoundMatch object.
   * 
   */
  public Collection<SignalAttributeLowerBoundMatch> getAllMatches(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawGetAllMatches(new Object[]{pSignal, pAttribute, pLowerBound});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return a match represented as a SignalAttributeLowerBoundMatch object, or null if no match is found.
   * 
   */
  public SignalAttributeLowerBoundMatch getOneArbitraryMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pAttribute, pLowerBound});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawHasMatch(new Object[]{pSignal, pAttribute, pLowerBound});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawCountMatches(new Object[]{pSignal, pAttribute, pLowerBound});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound, final IMatchProcessor<? super SignalAttributeLowerBoundMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pAttribute, pLowerBound}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound, final IMatchProcessor<? super SignalAttributeLowerBoundMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pAttribute, pLowerBound}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SignalAttributeLowerBoundMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSignal, pAttribute, pLowerBound});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pLowerBound the fixed value of pattern parameter lowerBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalAttributeLowerBoundMatch newMatch(final Signal pSignal, final Property pAttribute, final ValueSpecification pLowerBound) {
    return SignalAttributeLowerBoundMatch.newMatch(pSignal, pAttribute, pLowerBound);
    
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
  public Set<Signal> getAllValuesOfsignal(final SignalAttributeLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Property pAttribute, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOfsignal(new Object[]{null, pAttribute, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfattribute(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_ATTRIBUTE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute() {
    return rawAccumulateAllValuesOfattribute(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute(final SignalAttributeLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute(final Signal pSignal, final ValueSpecification pLowerBound) {
    return rawAccumulateAllValuesOfattribute(new Object[]{pSignal, null, pLowerBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOflowerBound(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_LOWERBOUND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound() {
    return rawAccumulateAllValuesOflowerBound(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound(final SignalAttributeLowerBoundMatch partialMatch) {
    return rawAccumulateAllValuesOflowerBound(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lowerBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflowerBound(final Signal pSignal, final Property pAttribute) {
    return rawAccumulateAllValuesOflowerBound(new Object[]{pSignal, pAttribute, null});
  }
  
  @Override
  protected SignalAttributeLowerBoundMatch tupleToMatch(final Tuple t) {
    try {
      return SignalAttributeLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL), (org.eclipse.uml2.uml.Property) t.get(POSITION_ATTRIBUTE), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_LOWERBOUND));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalAttributeLowerBoundMatch arrayToMatch(final Object[] match) {
    try {
      return SignalAttributeLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalAttributeLowerBoundMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SignalAttributeLowerBoundMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
