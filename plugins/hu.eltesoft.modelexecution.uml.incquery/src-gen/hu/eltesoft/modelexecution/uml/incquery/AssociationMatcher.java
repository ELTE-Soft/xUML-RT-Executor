package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
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
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.Association pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern Association(cls: Class, association : Association, type : Type, lower, upper)  {
 * 	find Cls(cls);
 * 	Association.memberEnd(association, property);
 * 	Class.ownedAttribute(cls, property);
 * 	Property.type(property, type);
 * 	Property.lowerValue(property, lower);
 * 	Property.upperValue(property, upper);
 * }
 * </pre></code>
 * 
 * @see AssociationMatch
 * @see AssociationProcessor
 * @see AssociationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationMatcher extends BaseMatcher<AssociationMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AssociationMatcher> querySpecification() throws IncQueryException {
    return AssociationQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLS = 0;
  
  private final static int POSITION_ASSOCIATION = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static int POSITION_LOWER = 3;
  
  private final static int POSITION_UPPER = 4;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationMatcher.class);
  
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
  public AssociationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return matches represented as a AssociationMatch object.
   * 
   */
  public Collection<AssociationMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawGetAllMatches(new Object[]{pCls, pAssociation, pType, pLower, pUpper});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return a match represented as a AssociationMatch object, or null if no match is found.
   * 
   */
  public AssociationMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawGetOneArbitraryMatch(new Object[]{pCls, pAssociation, pType, pLower, pUpper});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawHasMatch(new Object[]{pCls, pAssociation, pType, pLower, pUpper});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawCountMatches(new Object[]{pCls, pAssociation, pType, pLower, pUpper});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper, final IMatchProcessor<? super AssociationMatch> processor) {
    rawForEachMatch(new Object[]{pCls, pAssociation, pType, pLower, pUpper}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper, final IMatchProcessor<? super AssociationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCls, pAssociation, pType, pLower, pUpper}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<AssociationMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pCls, pAssociation, pType, pLower, pUpper});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pUpper the fixed value of pattern parameter upper, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return AssociationMatch.newMatch(pCls, pAssociation, pType, pLower, pUpper);
    
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final AssociationMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawAccumulateAllValuesOfcls(new Object[]{null, pAssociation, pType, pLower, pUpper});
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
  public Set<Association> getAllValuesOfassociation(final AssociationMatch partialMatch) {
    return rawAccumulateAllValuesOfassociation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final org.eclipse.uml2.uml.Class pCls, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawAccumulateAllValuesOfassociation(new Object[]{pCls, null, pType, pLower, pUpper});
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
  public Set<Type> getAllValuesOftype(final AssociationMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final ValueSpecification pLower, final ValueSpecification pUpper) {
    return rawAccumulateAllValuesOftype(new Object[]{pCls, pAssociation, null, pLower, pUpper});
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOflower(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_LOWER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflower() {
    return rawAccumulateAllValuesOflower(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflower(final AssociationMatch partialMatch) {
    return rawAccumulateAllValuesOflower(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOflower(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pUpper) {
    return rawAccumulateAllValuesOflower(new Object[]{pCls, pAssociation, pType, null, pUpper});
  }
  
  /**
   * Retrieve the set of values that occur in matches for upper.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOfupper(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_UPPER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for upper.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupper() {
    return rawAccumulateAllValuesOfupper(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upper.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupper(final AssociationMatch partialMatch) {
    return rawAccumulateAllValuesOfupper(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for upper.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfupper(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower) {
    return rawAccumulateAllValuesOfupper(new Object[]{pCls, pAssociation, pType, pLower, null});
  }
  
  @Override
  protected AssociationMatch tupleToMatch(final Tuple t) {
    try {
      return AssociationMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.Association) t.get(POSITION_ASSOCIATION), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_LOWER), (org.eclipse.uml2.uml.ValueSpecification) t.get(POSITION_UPPER));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationMatch arrayToMatch(final Object[] match) {
    try {
      return AssociationMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWER], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPER]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AssociationMatch arrayToMatchMutable(final Object[] match) {
    try {
      return AssociationMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_LOWER], (org.eclipse.uml2.uml.ValueSpecification) match[POSITION_UPPER]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
