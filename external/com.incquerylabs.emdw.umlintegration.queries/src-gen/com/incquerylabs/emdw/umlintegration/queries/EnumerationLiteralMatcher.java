package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.EnumerationLiteralMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationLiteralQuerySpecification;
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
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.enumerationLiteral pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EnumerationLiteralMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern enumerationLiteral(
 * 	enumeration : Enumeration,
 * 	enumerationLiteral : EnumerationLiteral
 * ) {
 * 	find enumeration(enumeration);
 * 	Enumeration.ownedLiteral(enumeration, enumerationLiteral);
 * }
 * </pre></code>
 * 
 * @see EnumerationLiteralMatch
 * @see EnumerationLiteralProcessor
 * @see EnumerationLiteralQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EnumerationLiteralMatcher extends BaseMatcher<EnumerationLiteralMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EnumerationLiteralMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    EnumerationLiteralMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EnumerationLiteralMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ENUMERATION = 0;
  
  private final static int POSITION_ENUMERATIONLITERAL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(EnumerationLiteralMatcher.class);
  
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
  public EnumerationLiteralMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public EnumerationLiteralMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return matches represented as a EnumerationLiteralMatch object.
   * 
   */
  public Collection<EnumerationLiteralMatch> getAllMatches(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return rawGetAllMatches(new Object[]{pEnumeration, pEnumerationLiteral});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return a match represented as a EnumerationLiteralMatch object, or null if no match is found.
   * 
   */
  public EnumerationLiteralMatch getOneArbitraryMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return rawGetOneArbitraryMatch(new Object[]{pEnumeration, pEnumerationLiteral});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return rawHasMatch(new Object[]{pEnumeration, pEnumerationLiteral});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return rawCountMatches(new Object[]{pEnumeration, pEnumerationLiteral});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral, final IMatchProcessor<? super EnumerationLiteralMatch> processor) {
    rawForEachMatch(new Object[]{pEnumeration, pEnumerationLiteral}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral, final IMatchProcessor<? super EnumerationLiteralMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEnumeration, pEnumerationLiteral}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEnumeration the fixed value of pattern parameter enumeration, or null if not bound.
   * @param pEnumerationLiteral the fixed value of pattern parameter enumerationLiteral, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EnumerationLiteralMatch newMatch(final Enumeration pEnumeration, final EnumerationLiteral pEnumerationLiteral) {
    return EnumerationLiteralMatch.newMatch(pEnumeration, pEnumerationLiteral);
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumeration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Enumeration> rawAccumulateAllValuesOfenumeration(final Object[] parameters) {
    Set<Enumeration> results = new HashSet<Enumeration>();
    rawAccumulateAllValues(POSITION_ENUMERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumeration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enumeration> getAllValuesOfenumeration() {
    return rawAccumulateAllValuesOfenumeration(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumeration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enumeration> getAllValuesOfenumeration(final EnumerationLiteralMatch partialMatch) {
    return rawAccumulateAllValuesOfenumeration(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumeration.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Enumeration> getAllValuesOfenumeration(final EnumerationLiteral pEnumerationLiteral) {
    return rawAccumulateAllValuesOfenumeration(new Object[]{
    null, 
    pEnumerationLiteral
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumerationLiteral.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EnumerationLiteral> rawAccumulateAllValuesOfenumerationLiteral(final Object[] parameters) {
    Set<EnumerationLiteral> results = new HashSet<EnumerationLiteral>();
    rawAccumulateAllValues(POSITION_ENUMERATIONLITERAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumerationLiteral.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EnumerationLiteral> getAllValuesOfenumerationLiteral() {
    return rawAccumulateAllValuesOfenumerationLiteral(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumerationLiteral.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EnumerationLiteral> getAllValuesOfenumerationLiteral(final EnumerationLiteralMatch partialMatch) {
    return rawAccumulateAllValuesOfenumerationLiteral(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for enumerationLiteral.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EnumerationLiteral> getAllValuesOfenumerationLiteral(final Enumeration pEnumeration) {
    return rawAccumulateAllValuesOfenumerationLiteral(new Object[]{
    pEnumeration, 
    null
    });
  }
  
  @Override
  protected EnumerationLiteralMatch tupleToMatch(final Tuple t) {
    try {
    	return EnumerationLiteralMatch.newMatch((org.eclipse.uml2.uml.Enumeration) t.get(POSITION_ENUMERATION), (org.eclipse.uml2.uml.EnumerationLiteral) t.get(POSITION_ENUMERATIONLITERAL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnumerationLiteralMatch arrayToMatch(final Object[] match) {
    try {
    	return EnumerationLiteralMatch.newMatch((org.eclipse.uml2.uml.Enumeration) match[POSITION_ENUMERATION], (org.eclipse.uml2.uml.EnumerationLiteral) match[POSITION_ENUMERATIONLITERAL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnumerationLiteralMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EnumerationLiteralMatch.newMutableMatch((org.eclipse.uml2.uml.Enumeration) match[POSITION_ENUMERATION], (org.eclipse.uml2.uml.EnumerationLiteral) match[POSITION_ENUMERATIONLITERAL]);
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
  public static IQuerySpecification<EnumerationLiteralMatcher> querySpecification() throws IncQueryException {
    return EnumerationLiteralQuerySpecification.instance();
  }
}
