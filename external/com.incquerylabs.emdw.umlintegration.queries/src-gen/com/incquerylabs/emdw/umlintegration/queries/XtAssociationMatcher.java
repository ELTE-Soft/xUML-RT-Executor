package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.XtAssociationMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationQuerySpecification;
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
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.xtAssociation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link XtAssociationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * // Relations
 * 
 * pattern xtAssociation(association: Association, sourceEnd: Property, targetEnd: Property) {
 * 	count find associationOwnedEnd(association, _) == 2;
 * 	Association.ownedEnd(association, sourceEnd);
 * 	Association.ownedEnd(association, targetEnd);
 * 	sourceEnd != targetEnd;
 * }
 * </pre></code>
 * 
 * @see XtAssociationMatch
 * @see XtAssociationProcessor
 * @see XtAssociationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class XtAssociationMatcher extends BaseMatcher<XtAssociationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static XtAssociationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    XtAssociationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new XtAssociationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ASSOCIATION = 0;
  
  private final static int POSITION_SOURCEEND = 1;
  
  private final static int POSITION_TARGETEND = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(XtAssociationMatcher.class);
  
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
  public XtAssociationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public XtAssociationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return matches represented as a XtAssociationMatch object.
   * 
   */
  public Collection<XtAssociationMatch> getAllMatches(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return rawGetAllMatches(new Object[]{pAssociation, pSourceEnd, pTargetEnd});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return a match represented as a XtAssociationMatch object, or null if no match is found.
   * 
   */
  public XtAssociationMatch getOneArbitraryMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return rawGetOneArbitraryMatch(new Object[]{pAssociation, pSourceEnd, pTargetEnd});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return rawHasMatch(new Object[]{pAssociation, pSourceEnd, pTargetEnd});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return rawCountMatches(new Object[]{pAssociation, pSourceEnd, pTargetEnd});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd, final IMatchProcessor<? super XtAssociationMatch> processor) {
    rawForEachMatch(new Object[]{pAssociation, pSourceEnd, pTargetEnd}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd, final IMatchProcessor<? super XtAssociationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAssociation, pSourceEnd, pTargetEnd}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAssociation the fixed value of pattern parameter association, or null if not bound.
   * @param pSourceEnd the fixed value of pattern parameter sourceEnd, or null if not bound.
   * @param pTargetEnd the fixed value of pattern parameter targetEnd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public XtAssociationMatch newMatch(final Association pAssociation, final Property pSourceEnd, final Property pTargetEnd) {
    return XtAssociationMatch.newMatch(pAssociation, pSourceEnd, pTargetEnd);
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
  public Set<Association> getAllValuesOfassociation(final XtAssociationMatch partialMatch) {
    return rawAccumulateAllValuesOfassociation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for association.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfassociation(final Property pSourceEnd, final Property pTargetEnd) {
    return rawAccumulateAllValuesOfassociation(new Object[]{
    null, 
    pSourceEnd, 
    pTargetEnd
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfsourceEnd(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_SOURCEEND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfsourceEnd() {
    return rawAccumulateAllValuesOfsourceEnd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfsourceEnd(final XtAssociationMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceEnd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfsourceEnd(final Association pAssociation, final Property pTargetEnd) {
    return rawAccumulateAllValuesOfsourceEnd(new Object[]{
    pAssociation, 
    null, 
    pTargetEnd
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOftargetEnd(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_TARGETEND, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOftargetEnd() {
    return rawAccumulateAllValuesOftargetEnd(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOftargetEnd(final XtAssociationMatch partialMatch) {
    return rawAccumulateAllValuesOftargetEnd(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetEnd.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOftargetEnd(final Association pAssociation, final Property pSourceEnd) {
    return rawAccumulateAllValuesOftargetEnd(new Object[]{
    pAssociation, 
    pSourceEnd, 
    null
    });
  }
  
  @Override
  protected XtAssociationMatch tupleToMatch(final Tuple t) {
    try {
    	return XtAssociationMatch.newMatch((org.eclipse.uml2.uml.Association) t.get(POSITION_ASSOCIATION), (org.eclipse.uml2.uml.Property) t.get(POSITION_SOURCEEND), (org.eclipse.uml2.uml.Property) t.get(POSITION_TARGETEND));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtAssociationMatch arrayToMatch(final Object[] match) {
    try {
    	return XtAssociationMatch.newMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_SOURCEEND], (org.eclipse.uml2.uml.Property) match[POSITION_TARGETEND]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected XtAssociationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return XtAssociationMatch.newMutableMatch((org.eclipse.uml2.uml.Association) match[POSITION_ASSOCIATION], (org.eclipse.uml2.uml.Property) match[POSITION_SOURCEEND], (org.eclipse.uml2.uml.Property) match[POSITION_TARGETEND]);
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
  public static IQuerySpecification<XtAssociationMatcher> querySpecification() throws IncQueryException {
    return XtAssociationQuerySpecification.instance();
  }
}
