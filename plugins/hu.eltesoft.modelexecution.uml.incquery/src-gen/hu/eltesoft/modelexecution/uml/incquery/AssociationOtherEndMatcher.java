package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationOtherEndQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEnd pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationOtherEndMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern AssociationOtherEnd(end : Property, otherEnd : Property) {
 * 	Association.ownedEnd(association, end);
 * 	Association.ownedEnd(association, otherEnd);
 * 	end != otherEnd;
 * }
 * </pre></code>
 * 
 * @see AssociationOtherEndMatch
 * @see AssociationOtherEndProcessor
 * @see AssociationOtherEndQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationOtherEndMatcher extends BaseMatcher<AssociationOtherEndMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AssociationOtherEndMatcher> querySpecification() throws IncQueryException {
    return AssociationOtherEndQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationOtherEndMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationOtherEndMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationOtherEndMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_END = 0;
  
  private final static int POSITION_OTHEREND = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationOtherEndMatcher.class);
  
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
  public AssociationOtherEndMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationOtherEndMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return matches represented as a AssociationOtherEndMatch object.
   * 
   */
  public Collection<AssociationOtherEndMatch> getAllMatches(final Property pEnd, final Property pOtherEnd) {
    return rawGetAllMatches(new Object[]{pEnd, pOtherEnd});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return a match represented as a AssociationOtherEndMatch object, or null if no match is found.
   * 
   */
  public AssociationOtherEndMatch getOneArbitraryMatch(final Property pEnd, final Property pOtherEnd) {
    return rawGetOneArbitraryMatch(new Object[]{pEnd, pOtherEnd});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Property pEnd, final Property pOtherEnd) {
    return rawHasMatch(new Object[]{pEnd, pOtherEnd});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Property pEnd, final Property pOtherEnd) {
    return rawCountMatches(new Object[]{pEnd, pOtherEnd});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Property pEnd, final Property pOtherEnd, final IMatchProcessor<? super AssociationOtherEndMatch> processor) {
    rawForEachMatch(new Object[]{pEnd, pOtherEnd}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Property pEnd, final Property pOtherEnd, final IMatchProcessor<? super AssociationOtherEndMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEnd, pOtherEnd}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<AssociationOtherEndMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Property pEnd, final Property pOtherEnd) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pEnd, pOtherEnd});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pOtherEnd the fixed value of pattern parameter otherEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationOtherEndMatch newMatch(final Property pEnd, final Property pOtherEnd) {
    return AssociationOtherEndMatch.newMatch(pEnd, pOtherEnd);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfend(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_END, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfend() {
    return rawAccumulateAllValuesOfend(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfend(final AssociationOtherEndMatch partialMatch) {
    return rawAccumulateAllValuesOfend(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfend(final Property pOtherEnd) {
    return rawAccumulateAllValuesOfend(new Object[]{null, pOtherEnd});
  }
  
  /**
   * Retrieve the set of values that occur in matches for otherEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfotherEnd(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_OTHEREND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for otherEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfotherEnd() {
    return rawAccumulateAllValuesOfotherEnd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for otherEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfotherEnd(final AssociationOtherEndMatch partialMatch) {
    return rawAccumulateAllValuesOfotherEnd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for otherEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfotherEnd(final Property pEnd) {
    return rawAccumulateAllValuesOfotherEnd(new Object[]{pEnd, null});
  }
  
  @Override
  protected AssociationOtherEndMatch tupleToMatch(final Tuple t) {
    try {
      return AssociationOtherEndMatch.newMatch((org.eclipse.uml2.uml.Property) t.get(POSITION_END), (org.eclipse.uml2.uml.Property) t.get(POSITION_OTHEREND));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationOtherEndMatch arrayToMatch(final Object[] match) {
    try {
      return AssociationOtherEndMatch.newMatch((org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Property) match[POSITION_OTHEREND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationOtherEndMatch arrayToMatchMutable(final Object[] match) {
    try {
      return AssociationOtherEndMatch.newMutableMatch((org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Property) match[POSITION_OTHEREND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
