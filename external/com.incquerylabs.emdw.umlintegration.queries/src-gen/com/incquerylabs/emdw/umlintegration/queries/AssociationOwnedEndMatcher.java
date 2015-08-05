package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.AssociationOwnedEndMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.AssociationOwnedEndQuerySpecification;
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
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.associationOwnedEnd pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationOwnedEndMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern associationOwnedEnd(association: Association, ownedEnd: Property) {
 * 	Association.ownedEnd(association, ownedEnd);
 * }
 * </pre></code>
 * 
 * @see AssociationOwnedEndMatch
 * @see AssociationOwnedEndProcessor
 * @see AssociationOwnedEndQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationOwnedEndMatcher extends BaseMatcher<AssociationOwnedEndMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationOwnedEndMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationOwnedEndMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationOwnedEndMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ASSOCIATION = 0;
  
  private final static int POSITION_OWNEDEND = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationOwnedEndMatcher.class);
  
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
  public AssociationOwnedEndMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationOwnedEndMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return matches represented as a AssociationOwnedEndMatch object.
   * 
   */
  public Collection<AssociationOwnedEndMatch> getAllMatches(final Association pAssociation, final Property pOwnedEnd) {
    return rawGetAllMatches(new Object[]{pAssociation, pOwnedEnd});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return a match represented as a AssociationOwnedEndMatch object, or null if no match is found.
   * 
   */
  public AssociationOwnedEndMatch getOneArbitraryMatch(final Association pAssociation, final Property pOwnedEnd) {
    return rawGetOneArbitraryMatch(new Object[]{pAssociation, pOwnedEnd});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Association pAssociation, final Property pOwnedEnd) {
    return rawHasMatch(new Object[]{pAssociation, pOwnedEnd});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Association pAssociation, final Property pOwnedEnd) {
    return rawCountMatches(new Object[]{pAssociation, pOwnedEnd});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Association pAssociation, final Property pOwnedEnd, final IMatchProcessor<? super AssociationOwnedEndMatch> processor) {
    rawForEachMatch(new Object[]{pAssociation, pOwnedEnd}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Association pAssociation, final Property pOwnedEnd, final IMatchProcessor<? super AssociationOwnedEndMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAssociation, pOwnedEnd}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pOwnedEnd the fixed value of pattern parameter ownedEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationOwnedEndMatch newMatch(final Association pAssociation, final Property pOwnedEnd) {
    return AssociationOwnedEndMatch.newMatch(pAssociation, pOwnedEnd);
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
  public Set<Association> getAllValuesOfassociation(final AssociationOwnedEndMatch partialMatch) {
    return rawAccumulateAllValuesOfassociation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final Property pOwnedEnd) {
    return rawAccumulateAllValuesOfassociation(new Object[]{
    null, 
    pOwnedEnd
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for ownedEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfownedEnd(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_OWNEDEND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ownedEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfownedEnd() {
    return rawAccumulateAllValuesOfownedEnd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ownedEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfownedEnd(final AssociationOwnedEndMatch partialMatch) {
    return rawAccumulateAllValuesOfownedEnd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ownedEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfownedEnd(final Association pAssociation) {
    return rawAccumulateAllValuesOfownedEnd(new Object[]{
    pAssociation, 
    null
    });
  }
  
  @Override
  protected AssociationOwnedEndMatch tupleToMatch(final Tuple t) {
    try {
    	return AssociationOwnedEndMatch.newMatch((org.eclipse.uml2.uml.Association) t.get(POSITION_ASSOCIATION), (org.eclipse.uml2.uml.Property) t.get(POSITION_OWNEDEND));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AssociationOwnedEndMatch arrayToMatch(final Object[] match) {
    try {
    	return AssociationOwnedEndMatch.newMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_OWNEDEND]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AssociationOwnedEndMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AssociationOwnedEndMatch.newMutableMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_OWNEDEND]);
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
  public static IQuerySpecification<AssociationOwnedEndMatcher> querySpecification() throws IncQueryException {
    return AssociationOwnedEndQuerySpecification.instance();
  }
}
