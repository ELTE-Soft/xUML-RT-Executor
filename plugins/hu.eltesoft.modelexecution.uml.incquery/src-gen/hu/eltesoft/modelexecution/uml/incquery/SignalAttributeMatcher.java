package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeQuerySpecification;
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
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.SignalAttribute pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SignalAttributeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern SignalAttribute(signal : Signal, attribute : Property, type, ordered, unique) {
 * 	find Signal(signal);
 * 	Signal.ownedAttribute(signal, attribute);
 * 	Property.type(attribute, type);
 * 	Property.isOrdered(attribute, ordered);
 * 	Property.isUnique(attribute, unique);
 * }
 * </pre></code>
 * 
 * @see SignalAttributeMatch
 * @see SignalAttributeProcessor
 * @see SignalAttributeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SignalAttributeMatcher extends BaseMatcher<SignalAttributeMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SignalAttributeMatcher> querySpecification() throws IncQueryException {
    return SignalAttributeQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SignalAttributeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SignalAttributeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SignalAttributeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SIGNAL = 0;
  
  private final static int POSITION_ATTRIBUTE = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_ORDERED = 3;
  
  private final static int POSITION_UNIQUE = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SignalAttributeMatcher.class);
  
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
  public SignalAttributeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SignalAttributeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return matches represented as a SignalAttributeMatch object.
   * 
   */
  public Collection<SignalAttributeMatch> getAllMatches(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetAllMatches(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return a match represented as a SignalAttributeMatch object, or null if no match is found.
   * 
   */
  public SignalAttributeMatch getOneArbitraryMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawGetOneArbitraryMatch(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawHasMatch(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawCountMatches(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super SignalAttributeMatch> processor) {
    rawForEachMatch(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique, final IMatchProcessor<? super SignalAttributeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique}, processor);
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
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SignalAttributeMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSignal, pAttribute, pType, pOrdered, pUnique});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSignal the fixed value of pattern parameter signal, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pOrdered the fixed value of pattern parameter ordered, or null if not bound.
   * @param pUnique the fixed value of pattern parameter unique, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SignalAttributeMatch newMatch(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return SignalAttributeMatch.newMatch(pSignal, pAttribute, pType, pOrdered, pUnique);
    
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
  public Set<Signal> getAllValuesOfsignal(final SignalAttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfsignal(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for signal.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsignal(final Property pAttribute, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfsignal(new Object[]{null, pAttribute, pType, pOrdered, pUnique});
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
  public Set<Property> getAllValuesOfattribute(final SignalAttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute(final Signal pSignal, final Type pType, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOfattribute(new Object[]{pSignal, null, pType, pOrdered, pUnique});
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
  public Set<Type> getAllValuesOftype(final SignalAttributeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Signal pSignal, final Property pAttribute, final Boolean pOrdered, final Boolean pUnique) {
    return rawAccumulateAllValuesOftype(new Object[]{pSignal, pAttribute, null, pOrdered, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfordered(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_ORDERED, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered() {
    return rawAccumulateAllValuesOfordered(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final SignalAttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfordered(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ordered.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfordered(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pUnique) {
    return rawAccumulateAllValuesOfordered(new Object[]{pSignal, pAttribute, pType, null, pUnique});
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfunique(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_UNIQUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique() {
    return rawAccumulateAllValuesOfunique(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final SignalAttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfunique(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for unique.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfunique(final Signal pSignal, final Property pAttribute, final Type pType, final Boolean pOrdered) {
    return rawAccumulateAllValuesOfunique(new Object[]{pSignal, pAttribute, pType, pOrdered, null});
  }
  
  @Override
  protected SignalAttributeMatch tupleToMatch(final Tuple t) {
    try {
      return SignalAttributeMatch.newMatch((org.eclipse.uml2.uml.Signal) t.get(POSITION_SIGNAL), (org.eclipse.uml2.uml.Property) t.get(POSITION_ATTRIBUTE), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (java.lang.Boolean) t.get(POSITION_ORDERED), (java.lang.Boolean) t.get(POSITION_UNIQUE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalAttributeMatch arrayToMatch(final Object[] match) {
    try {
      return SignalAttributeMatch.newMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SignalAttributeMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SignalAttributeMatch.newMutableMatch((org.eclipse.uml2.uml.Signal) match[POSITION_SIGNAL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (java.lang.Boolean) match[POSITION_ORDERED], (java.lang.Boolean) match[POSITION_UNIQUE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}