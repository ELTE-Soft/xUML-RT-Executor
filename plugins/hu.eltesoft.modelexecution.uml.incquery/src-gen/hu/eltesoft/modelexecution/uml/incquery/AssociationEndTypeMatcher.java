package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndTypeQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.AssociationEndType pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationEndTypeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern
 * AssociationEndType(association : Association, end : Property, cls : Class) {
 * 	find AssociationEnd(association, end);
 * 	Property.type(end, cls);
 * }
 * </pre></code>
 * 
 * @see AssociationEndTypeMatch
 * @see AssociationEndTypeProcessor
 * @see AssociationEndTypeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationEndTypeMatcher extends BaseMatcher<AssociationEndTypeMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AssociationEndTypeMatcher> querySpecification() throws IncQueryException {
    return AssociationEndTypeQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationEndTypeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationEndTypeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationEndTypeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ASSOCIATION = 0;
  
  private final static int POSITION_END = 1;
  
  private final static int POSITION_CLS = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationEndTypeMatcher.class);
  
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
  public AssociationEndTypeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationEndTypeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return matches represented as a AssociationEndTypeMatch object.
   * 
   */
  public Collection<AssociationEndTypeMatch> getAllMatches(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawGetAllMatches(new Object[]{pAssociation, pEnd, pCls});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return a match represented as a AssociationEndTypeMatch object, or null if no match is found.
   * 
   */
  public AssociationEndTypeMatch getOneArbitraryMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawGetOneArbitraryMatch(new Object[]{pAssociation, pEnd, pCls});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawHasMatch(new Object[]{pAssociation, pEnd, pCls});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawCountMatches(new Object[]{pAssociation, pEnd, pCls});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final IMatchProcessor<? super AssociationEndTypeMatch> processor) {
    rawForEachMatch(new Object[]{pAssociation, pEnd, pCls}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final IMatchProcessor<? super AssociationEndTypeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAssociation, pEnd, pCls}, processor);
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
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<AssociationEndTypeMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pAssociation, pEnd, pCls});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pEnd the fixed value of pattern parameter end, or null if not bound.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationEndTypeMatch newMatch(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return AssociationEndTypeMatch.newMatch(pAssociation, pEnd, pCls);
    
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
  public Set<Association> getAllValuesOfassociation(final AssociationEndTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfassociation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final Property pEnd, final org.eclipse.uml2.uml.Class pCls) {
    return rawAccumulateAllValuesOfassociation(new Object[]{null, pEnd, pCls});
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
  public Set<Property> getAllValuesOfend(final AssociationEndTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfend(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for end.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfend(final Association pAssociation, final org.eclipse.uml2.uml.Class pCls) {
    return rawAccumulateAllValuesOfend(new Object[]{pAssociation, null, pCls});
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final AssociationEndTypeMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Association pAssociation, final Property pEnd) {
    return rawAccumulateAllValuesOfcls(new Object[]{pAssociation, pEnd, null});
  }
  
  @Override
  protected AssociationEndTypeMatch tupleToMatch(final Tuple t) {
    try {
      return AssociationEndTypeMatch.newMatch((org.eclipse.uml2.uml.Association) t.get(POSITION_ASSOCIATION), (org.eclipse.uml2.uml.Property) t.get(POSITION_END), (org.eclipse.uml2.uml.Class) t.get(POSITION_CLS));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationEndTypeMatch arrayToMatch(final Object[] match) {
    try {
      return AssociationEndTypeMatch.newMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Class) match[POSITION_CLS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationEndTypeMatch arrayToMatchMutable(final Object[] match) {
    try {
      return AssociationEndTypeMatch.newMutableMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_END], (org.eclipse.uml2.uml.Class) match[POSITION_CLS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
