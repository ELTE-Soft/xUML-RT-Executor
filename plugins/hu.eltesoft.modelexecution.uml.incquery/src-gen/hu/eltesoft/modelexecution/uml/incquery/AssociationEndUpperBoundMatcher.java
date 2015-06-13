package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndUpperBoundQuerySpecification;
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
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBound pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationEndUpperBoundMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern AssociationEndUpperBound(association: Association, end: Property, cls: Class, upperBound: ValueSpecification) {
 * 	find AssociationEndType(association, end, cls);
 * 	Property.lowerValue(end, upperBound);
 * }
 * </pre></code>
 * 
 * @see AssociationEndUpperBoundMatch
 * @see AssociationEndUpperBoundProcessor
 * @see AssociationEndUpperBoundQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationEndUpperBoundMatcher extends BaseMatcher<AssociationEndUpperBoundMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AssociationEndUpperBoundMatcher> querySpecification() throws IncQueryException {
    return AssociationEndUpperBoundQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationEndUpperBoundMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationEndUpperBoundMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationEndUpperBoundMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ASSOCIATION = 0;
  
  private final static int POSITION_END = 1;
  
  private final static int POSITION_CLS = 2;
  
  private final static int POSITION_UPPERBOUND = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationEndUpperBoundMatcher.class);
  
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
  public AssociationEndUpperBoundMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationEndUpperBoundMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return matches represented as a AssociationEndUpperBoundMatch object.
   * 
   */
  public Collection<AssociationEndUpperBoundMatch> getAllMatches(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawGetAllMatches(new Object[]{pAssociation, pEnd, pCls, pUpperBound});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return a match represented as a AssociationEndUpperBoundMatch object, or null if no match is found.
   * 
   */
  public AssociationEndUpperBoundMatch getOneArbitraryMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawGetOneArbitraryMatch(new Object[]{pAssociation, pEnd, pCls, pUpperBound});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawHasMatch(new Object[]{pAssociation, pEnd, pCls, pUpperBound});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawCountMatches(new Object[]{pAssociation, pEnd, pCls, pUpperBound});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound, final IMatchProcessor<? super AssociationEndUpperBoundMatch> processor) {
    rawForEachMatch(new Object[]{pAssociation, pEnd, pCls, pUpperBound}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound, final IMatchProcessor<? super AssociationEndUpperBoundMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAssociation, pEnd, pCls, pUpperBound}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<AssociationEndUpperBoundMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pAssociation, pEnd, pCls, pUpperBound});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pUpperBound the fixed value of pattern parameter upperBound, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationEndUpperBoundMatch newMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return AssociationEndUpperBoundMatch.newMatch(pAssociation, pEnd, pCls, pUpperBound);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Association> rawAccumulateAllValuesOfassociation(final Object[] parameters) {
    Set<Association> results = new HashSet<Association>();
    rawAccumulateAllValues(POSITION_ASSOCIATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation() {
    return rawAccumulateAllValuesOfassociation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final AssociationEndUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfassociation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfassociation(new Object[]{null, pEnd, pCls, pUpperBound});
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
  public Set<Property> getAllValuesOfend(final AssociationEndUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfend(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfend(final Association pAssociation, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfend(new Object[]{pAssociation, null, pCls, pUpperBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcls(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CLS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls() {
    return rawAccumulateAllValuesOfcls(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final AssociationEndUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Association pAssociation, final Property pEnd, final ValueSpecification pUpperBound) {
    return rawAccumulateAllValuesOfcls(new Object[]{pAssociation, pEnd, null, pUpperBound});
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOfupperBound(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_UPPERBOUND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound() {
    return rawAccumulateAllValuesOfupperBound(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound(final AssociationEndUpperBoundMatch partialMatch) {
    return rawAccumulateAllValuesOfupperBound(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upperBound.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupperBound(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawAccumulateAllValuesOfupperBound(new Object[]{pAssociation, pEnd, pCls, null});
  }
  
  @Override
  protected AssociationEndUpperBoundMatch tupleToMatch(final Tuple t) {
    try {
      return AssociationEndUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Association) t.get(POSITION_ASSOCIATION), (org.eclipse.uml2.uml.Property) t.get(POSITION_END), (org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_UPPERBOUND));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationEndUpperBoundMatch arrayToMatch(final Object[] match) {
    try {
      return AssociationEndUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationEndUpperBoundMatch arrayToMatchMutable(final Object[] match) {
    try {
      return AssociationEndUpperBoundMatch.newMutableMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPERBOUND]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
