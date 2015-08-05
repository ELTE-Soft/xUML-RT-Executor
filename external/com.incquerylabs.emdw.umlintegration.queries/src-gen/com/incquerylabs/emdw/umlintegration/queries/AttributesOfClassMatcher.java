package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.AttributesOfClassMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.AttributesOfClassQuerySpecification;
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
import org.eclipse.uml2.uml.Property;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.attributesOfClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AttributesOfClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern attributesOfClass(cl : Class, attribute : Property) {
 *     Class.ownedAttribute(cl, attribute);
 * }
 * </pre></code>
 * 
 * @see AttributesOfClassMatch
 * @see AttributesOfClassProcessor
 * @see AttributesOfClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AttributesOfClassMatcher extends BaseMatcher<AttributesOfClassMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AttributesOfClassMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AttributesOfClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AttributesOfClassMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CL = 0;
  
  private final static int POSITION_ATTRIBUTE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AttributesOfClassMatcher.class);
  
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
  public AttributesOfClassMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AttributesOfClassMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return matches represented as a AttributesOfClassMatch object.
   * 
   */
  public Collection<AttributesOfClassMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return rawGetAllMatches(new Object[]{pCl, pAttribute});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return a match represented as a AttributesOfClassMatch object, or null if no match is found.
   * 
   */
  public AttributesOfClassMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return rawGetOneArbitraryMatch(new Object[]{pCl, pAttribute});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return rawHasMatch(new Object[]{pCl, pAttribute});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return rawCountMatches(new Object[]{pCl, pAttribute});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute, final IMatchProcessor<? super AttributesOfClassMatch> processor) {
    rawForEachMatch(new Object[]{pCl, pAttribute}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute, final IMatchProcessor<? super AttributesOfClassMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCl, pAttribute}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AttributesOfClassMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final Property pAttribute) {
    return AttributesOfClassMatch.newMatch(pCl, pAttribute);
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfcl(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_CL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl() {
    return rawAccumulateAllValuesOfcl(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl(final AttributesOfClassMatch partialMatch) {
    return rawAccumulateAllValuesOfcl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl(final Property pAttribute) {
    return rawAccumulateAllValuesOfcl(new Object[]{
    null, 
    pAttribute
    });
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
  public Set<Property> getAllValuesOfattribute(final AttributesOfClassMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute(final org.eclipse.uml2.uml.Class pCl) {
    return rawAccumulateAllValuesOfattribute(new Object[]{
    pCl, 
    null
    });
  }
  
  @Override
  protected AttributesOfClassMatch tupleToMatch(final Tuple t) {
    try {
    	return AttributesOfClassMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CL), (org.eclipse.uml2.uml.Property) t.get(POSITION_ATTRIBUTE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AttributesOfClassMatch arrayToMatch(final Object[] match) {
    try {
    	return AttributesOfClassMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AttributesOfClassMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AttributesOfClassMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE]);
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
  public static IQuerySpecification<AttributesOfClassMatcher> querySpecification() throws IncQueryException {
    return AttributesOfClassQuerySpecification.instance();
  }
}
