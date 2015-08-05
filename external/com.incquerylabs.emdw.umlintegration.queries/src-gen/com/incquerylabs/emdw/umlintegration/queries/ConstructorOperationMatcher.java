package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.ConstructorOperationMatch;
import com.incquerylabs.emdw.umlintegration.queries.util.ConstructorOperationQuerySpecification;
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
import org.eclipse.uml2.uml.Operation;

/**
 * Generated pattern matcher API of the com.incquerylabs.emdw.umlintegration.queries.constructorOperation pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ConstructorOperationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern constructorOperation(umlClass: Class, operation: Operation) {
 * // not checked since there are issues with Maven compilation
 * //	standard::Create.base_BehavioralFeature(_, operation);
 * 	find constructorByName(umlClass, operation);
 * }
 * </pre></code>
 * 
 * @see ConstructorOperationMatch
 * @see ConstructorOperationProcessor
 * @see ConstructorOperationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ConstructorOperationMatcher extends BaseMatcher<ConstructorOperationMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ConstructorOperationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ConstructorOperationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ConstructorOperationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_UMLCLASS = 0;
  
  private final static int POSITION_OPERATION = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ConstructorOperationMatcher.class);
  
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
  public ConstructorOperationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ConstructorOperationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return matches represented as a ConstructorOperationMatch object.
   * 
   */
  public Collection<ConstructorOperationMatch> getAllMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return rawGetAllMatches(new Object[]{pUmlClass, pOperation});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return a match represented as a ConstructorOperationMatch object, or null if no match is found.
   * 
   */
  public ConstructorOperationMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return rawGetOneArbitraryMatch(new Object[]{pUmlClass, pOperation});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return rawHasMatch(new Object[]{pUmlClass, pOperation});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return rawCountMatches(new Object[]{pUmlClass, pOperation});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation, final IMatchProcessor<? super ConstructorOperationMatch> processor) {
    rawForEachMatch(new Object[]{pUmlClass, pOperation}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation, final IMatchProcessor<? super ConstructorOperationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pUmlClass, pOperation}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ConstructorOperationMatch newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Operation pOperation) {
    return ConstructorOperationMatch.newMatch(pUmlClass, pOperation);
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfumlClass(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_UMLCLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass() {
    return rawAccumulateAllValuesOfumlClass(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final ConstructorOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfumlClass(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for umlClass.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final Operation pOperation) {
    return rawAccumulateAllValuesOfumlClass(new Object[]{
    null, 
    pOperation
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfoperation(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OPERATION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation() {
    return rawAccumulateAllValuesOfoperation(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final ConstructorOperationMatch partialMatch) {
    return rawAccumulateAllValuesOfoperation(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for operation.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfoperation(final org.eclipse.uml2.uml.Class pUmlClass) {
    return rawAccumulateAllValuesOfoperation(new Object[]{
    pUmlClass, 
    null
    });
  }
  
  @Override
  protected ConstructorOperationMatch tupleToMatch(final Tuple t) {
    try {
    	return ConstructorOperationMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS), (org.eclipse.uml2.uml.Operation) t.get(POSITION_OPERATION));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConstructorOperationMatch arrayToMatch(final Object[] match) {
    try {
    	return ConstructorOperationMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConstructorOperationMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ConstructorOperationMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (org.eclipse.uml2.uml.Operation) match[POSITION_OPERATION]);
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
  public static IQuerySpecification<ConstructorOperationMatcher> querySpecification() throws IncQueryException {
    return ConstructorOperationQuerySpecification.instance();
  }
}
