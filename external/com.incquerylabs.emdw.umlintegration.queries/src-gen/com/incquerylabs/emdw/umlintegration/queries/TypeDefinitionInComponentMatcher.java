package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionInComponentQuerySpecification;
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
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInComponent pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TypeDefinitionInComponentMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern typeDefinitionInComponent(umlComponent: Component, type : uml::Type) {
 * 	find typeDefinition(type);
 * 	Component.packagedElement(umlComponent, type);
 * }
 * </pre></code>
 * 
 * @see TypeDefinitionInComponentMatch
 * @see TypeDefinitionInComponentProcessor
 * @see TypeDefinitionInComponentQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TypeDefinitionInComponentMatcher extends BaseMatcher<TypeDefinitionInComponentMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static TypeDefinitionInComponentMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    TypeDefinitionInComponentMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new TypeDefinitionInComponentMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_UMLCOMPONENT = 0;
  
  private final static int POSITION_TYPE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(TypeDefinitionInComponentMatcher.class);
  
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
  public TypeDefinitionInComponentMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public TypeDefinitionInComponentMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a TypeDefinitionInComponentMatch object.
   * 
   */
  public Collection<TypeDefinitionInComponentMatch> getAllMatches(final Component pUmlComponent, final Type pType) {
    return rawGetAllMatches(new Object[]{pUmlComponent, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a TypeDefinitionInComponentMatch object, or null if no match is found.
   * 
   */
  public TypeDefinitionInComponentMatch getOneArbitraryMatch(final Component pUmlComponent, final Type pType) {
    return rawGetOneArbitraryMatch(new Object[]{pUmlComponent, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Component pUmlComponent, final Type pType) {
    return rawHasMatch(new Object[]{pUmlComponent, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Component pUmlComponent, final Type pType) {
    return rawCountMatches(new Object[]{pUmlComponent, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Component pUmlComponent, final Type pType, final IMatchProcessor<? super TypeDefinitionInComponentMatch> processor) {
    rawForEachMatch(new Object[]{pUmlComponent, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Component pUmlComponent, final Type pType, final IMatchProcessor<? super TypeDefinitionInComponentMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUmlComponent, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlComponent the fixed value of pattern parameter umlComponent, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TypeDefinitionInComponentMatch newMatch(final Component pUmlComponent, final Type pType) {
    return TypeDefinitionInComponentMatch.newMatch(pUmlComponent, pType);
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
  public Set<Component> getAllValuesOfumlComponent(final TypeDefinitionInComponentMatch partialMatch) {
    return rawAccumulateAllValuesOfumlComponent(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlComponent.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Component> getAllValuesOfumlComponent(final Type pType) {
    return rawAccumulateAllValuesOfumlComponent(new Object[]{
    null, 
    pType
    });
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
  public Set<Type> getAllValuesOftype(final TypeDefinitionInComponentMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Component pUmlComponent) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pUmlComponent, 
    null
    });
  }
  
  @Override
  protected TypeDefinitionInComponentMatch tupleToMatch(final Tuple t) {
    try {
    	return TypeDefinitionInComponentMatch.newMatch((org.eclipse.uml2.uml.Component) t.get(POSITION_UMLCOMPONENT), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TypeDefinitionInComponentMatch arrayToMatch(final Object[] match) {
    try {
    	return TypeDefinitionInComponentMatch.newMatch((org.eclipse.uml2.uml.Component) match[POSITION_UMLCOMPONENT], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected TypeDefinitionInComponentMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return TypeDefinitionInComponentMatch.newMutableMatch((org.eclipse.uml2.uml.Component) match[POSITION_UMLCOMPONENT], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE]);
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
  public static IQuerySpecification<TypeDefinitionInComponentMatcher> querySpecification() throws IncQueryException {
    return TypeDefinitionInComponentQuerySpecification.instance();
  }
}
