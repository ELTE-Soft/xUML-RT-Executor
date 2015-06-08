package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeQuerySpecification;
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
import org.eclipse.uml2.uml.Type;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.uml.incquery.Attribute pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AttributeMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern Attribute(cls: Class, attribute : Property, isStatic, type : Type)  {
 * 	find Cls(cls);
 * 	Class.ownedAttribute(cls, attribute);
 * 	Property.isStatic(attribute, isStatic);
 * 	Property.type(attribute, type);
 * }
 * </pre></code>
 * 
 * @see AttributeMatch
 * @see AttributeProcessor
 * @see AttributeQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AttributeMatcher extends BaseMatcher<AttributeMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<AttributeMatcher> querySpecification() throws IncQueryException {
    return AttributeQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AttributeMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AttributeMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AttributeMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CLS = 0;
  
  private final static int POSITION_ATTRIBUTE = 1;
  
  private final static int POSITION_ISSTATIC = 2;
  
  private final static int POSITION_TYPE = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AttributeMatcher.class);
  
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
  public AttributeMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AttributeMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a AttributeMatch object.
   * 
   */
  public Collection<AttributeMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawGetAllMatches(new Object[]{pCls, pAttribute, pIsStatic, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a AttributeMatch object, or null if no match is found.
   * 
   */
  public AttributeMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawGetOneArbitraryMatch(new Object[]{pCls, pAttribute, pIsStatic, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawHasMatch(new Object[]{pCls, pAttribute, pIsStatic, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawCountMatches(new Object[]{pCls, pAttribute, pIsStatic, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType, final IMatchProcessor<? super AttributeMatch> processor) {
    rawForEachMatch(new Object[]{pCls, pAttribute, pIsStatic, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType, final IMatchProcessor<? super AttributeMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCls, pAttribute, pIsStatic, pType}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<AttributeMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pCls, pAttribute, pIsStatic, pType});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCls the fixed value of pattern parameter cls, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @param pIsStatic the fixed value of pattern parameter isStatic, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AttributeMatch newMatch(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return AttributeMatch.newMatch(pCls, pAttribute, pIsStatic, pType);
    
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfcls(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cls.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcls(final Property pAttribute, final Boolean pIsStatic, final Type pType) {
    return rawAccumulateAllValuesOfcls(new Object[]{null, pAttribute, pIsStatic, pType});
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
  public Set<Property> getAllValuesOfattribute(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute(final org.eclipse.uml2.uml.Class pCls, final Boolean pIsStatic, final Type pType) {
    return rawAccumulateAllValuesOfattribute(new Object[]{pCls, null, pIsStatic, pType});
  }
  
  /**
   * Retrieve the set of values that occur in matches for isStatic.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Boolean> rawAccumulateAllValuesOfisStatic(final Object[] parameters) {
    Set<Boolean> results = new HashSet<Boolean>();
    rawAccumulateAllValues(POSITION_ISSTATIC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for isStatic.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfisStatic() {
    return rawAccumulateAllValuesOfisStatic(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for isStatic.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfisStatic(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOfisStatic(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for isStatic.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Boolean> getAllValuesOfisStatic(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType) {
    return rawAccumulateAllValuesOfisStatic(new Object[]{pCls, pAttribute, null, pType});
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
  public Set<Type> getAllValuesOftype(final AttributeMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic) {
    return rawAccumulateAllValuesOftype(new Object[]{pCls, pAttribute, pIsStatic, null});
  }
  
  @Override
  protected AttributeMatch tupleToMatch(final Tuple t) {
    try {
      return AttributeMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CLS), (org.eclipse.uml2.uml.Property) t.get(POSITION_ATTRIBUTE), (java.lang.Boolean) t.get(POSITION_ISSTATIC), (org.eclipse.uml2.uml.Type) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AttributeMatch arrayToMatch(final Object[] match) {
    try {
      return AttributeMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (java.lang.Boolean) match[POSITION_ISSTATIC], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected AttributeMatch arrayToMatchMutable(final Object[] match) {
    try {
      return AttributeMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CLS], (org.eclipse.uml2.uml.Property) match[POSITION_ATTRIBUTE], (java.lang.Boolean) match[POSITION_ISSTATIC], (org.eclipse.uml2.uml.Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
