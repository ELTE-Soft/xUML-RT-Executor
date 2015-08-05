package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.StructTypeInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeInComponentQuerySpecification;
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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.structTypeInComponent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StructTypeInComponentMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern structTypeInComponent(
 * 	structType : DataType,
 * 	umlComponent : Component
 * ) {
 * 	Component.packagedElement(umlComponent, structType);
 * }
 * </pre></code>
 * 
 * @see StructTypeInComponentMatch
 * @see StructTypeInComponentProcessor
 * @see StructTypeInComponentQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StructTypeInComponentMatcher extends BaseMatcher<StructTypeInComponentMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StructTypeInComponentMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    StructTypeInComponentMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new StructTypeInComponentMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_STRUCTTYPE = 0;
  
  private final static int POSITION_UMLCOMPONENT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(StructTypeInComponentMatcher.class);
  
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
  public StructTypeInComponentMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public StructTypeInComponentMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return matches represented as a StructTypeInComponentMatch object.
   * 
   */
  public Collection<StructTypeInComponentMatch> getAllMatches(final DataType pStructType, final Component pUmlComponent) {
    return rawGetAllMatches(new Object[]{pStructType, pUmlComponent});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return a match represented as a StructTypeInComponentMatch object, or null if no match is found.
   * 
   */
  public StructTypeInComponentMatch getOneArbitraryMatch(final DataType pStructType, final Component pUmlComponent) {
    return rawGetOneArbitraryMatch(new Object[]{pStructType, pUmlComponent});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final DataType pStructType, final Component pUmlComponent) {
    return rawHasMatch(new Object[]{pStructType, pUmlComponent});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final DataType pStructType, final Component pUmlComponent) {
    return rawCountMatches(new Object[]{pStructType, pUmlComponent});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final DataType pStructType, final Component pUmlComponent, final IMatchProcessor<? super StructTypeInComponentMatch> processor) {
    rawForEachMatch(new Object[]{pStructType, pUmlComponent}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final DataType pStructType, final Component pUmlComponent, final IMatchProcessor<? super StructTypeInComponentMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pStructType, pUmlComponent}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStructType the fixed value of pattern parameter structType, or null if not bound.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public StructTypeInComponentMatch newMatch(final DataType pStructType, final Component pUmlComponent) {
    return StructTypeInComponentMatch.newMatch(pStructType, pUmlComponent);
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<DataType> rawAccumulateAllValuesOfstructType(final Object[] parameters) {
    Set<DataType> results = new HashSet<DataType>();
    rawAccumulateAllValues(POSITION_STRUCTTYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType() {
    return rawAccumulateAllValuesOfstructType(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType(final StructTypeInComponentMatch partialMatch) {
    return rawAccumulateAllValuesOfstructType(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for structType.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<DataType> getAllValuesOfstructType(final Component pUmlComponent) {
    return rawAccumulateAllValuesOfstructType(new Object[]{
    null, 
    pUmlComponent
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlComponent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Component> rawAccumulateAllValuesOfumlComponent(final Object[] parameters) {
    Set<Component> results = new HashSet<Component>();
    rawAccumulateAllValues(POSITION_UMLCOMPONENT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlComponent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfumlComponent() {
    return rawAccumulateAllValuesOfumlComponent(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlComponent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfumlComponent(final StructTypeInComponentMatch partialMatch) {
    return rawAccumulateAllValuesOfumlComponent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlComponent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfumlComponent(final DataType pStructType) {
    return rawAccumulateAllValuesOfumlComponent(new Object[]{
    pStructType, 
    null
    });
  }
  
  @Override
  protected StructTypeInComponentMatch tupleToMatch(final Tuple t) {
    try {
    	return StructTypeInComponentMatch.newMatch((org.eclipse.uml2.uml.DataType) t.get(POSITION_STRUCTTYPE), (org.eclipse.uml2.uml.Component) t.get(POSITION_UMLCOMPONENT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StructTypeInComponentMatch arrayToMatch(final Object[] match) {
    try {
    	return StructTypeInComponentMatch.newMatch((org.eclipse.uml2.uml.DataType) match[POSITION_STRUCTTYPE], (org.eclipse.uml2.uml.Component) match[POSITION_UMLCOMPONENT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected StructTypeInComponentMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return StructTypeInComponentMatch.newMutableMatch((org.eclipse.uml2.uml.DataType) match[POSITION_STRUCTTYPE], (org.eclipse.uml2.uml.Component) match[POSITION_UMLCOMPONENT]);
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
  public static IQuerySpecification<StructTypeInComponentMatcher> querySpecification() throws IncQueryException {
    return StructTypeInComponentQuerySpecification.instance();
  }
}
