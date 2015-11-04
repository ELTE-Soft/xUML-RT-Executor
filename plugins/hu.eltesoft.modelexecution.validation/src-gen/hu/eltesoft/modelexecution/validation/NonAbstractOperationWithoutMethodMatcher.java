package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethodMatch;
import hu.eltesoft.modelexecution.validation.util.NonAbstractOperationWithoutMethodQuerySpecification;
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
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethod pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NonAbstractOperationWithoutMethodMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //// MOVED HERE from ClassValidation.eiq
 * 
 * {@literal @}Violation(message = "If the operation is not abstract it must have a method", mark = { "op" })
 * pattern NonAbstractOperationWithoutMethod(op : Operation) {
 * 	Operation.isAbstract(op, false);
 * 	Operation.class(op, cls);
 * 	neg find ExternalEntity(cls, _);
 * 	neg find HasMethod(op);
 * }
 * </pre></code>
 * 
 * @see NonAbstractOperationWithoutMethodMatch
 * @see NonAbstractOperationWithoutMethodProcessor
 * @see NonAbstractOperationWithoutMethodQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NonAbstractOperationWithoutMethodMatcher extends BaseMatcher<NonAbstractOperationWithoutMethodMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NonAbstractOperationWithoutMethodMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NonAbstractOperationWithoutMethodMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NonAbstractOperationWithoutMethodMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OP = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NonAbstractOperationWithoutMethodMatcher.class);
  
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
  public NonAbstractOperationWithoutMethodMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NonAbstractOperationWithoutMethodMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return matches represented as a NonAbstractOperationWithoutMethodMatch object.
   * 
   */
  public Collection<NonAbstractOperationWithoutMethodMatch> getAllMatches(final Operation pOp) {
    return rawGetAllMatches(new Object[]{pOp});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return a match represented as a NonAbstractOperationWithoutMethodMatch object, or null if no match is found.
   * 
   */
  public NonAbstractOperationWithoutMethodMatch getOneArbitraryMatch(final Operation pOp) {
    return rawGetOneArbitraryMatch(new Object[]{pOp});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Operation pOp) {
    return rawHasMatch(new Object[]{pOp});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Operation pOp) {
    return rawCountMatches(new Object[]{pOp});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Operation pOp, final IMatchProcessor<? super NonAbstractOperationWithoutMethodMatch> processor) {
    rawForEachMatch(new Object[]{pOp}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Operation pOp, final IMatchProcessor<? super NonAbstractOperationWithoutMethodMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOp}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOp the fixed value of pattern parameter op, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NonAbstractOperationWithoutMethodMatch newMatch(final Operation pOp) {
    return NonAbstractOperationWithoutMethodMatch.newMatch(pOp);
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Operation> rawAccumulateAllValuesOfop(final Object[] parameters) {
    Set<Operation> results = new HashSet<Operation>();
    rawAccumulateAllValues(POSITION_OP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for op.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Operation> getAllValuesOfop() {
    return rawAccumulateAllValuesOfop(emptyArray());
  }
  
  @Override
  protected NonAbstractOperationWithoutMethodMatch tupleToMatch(final Tuple t) {
    try {
    	return NonAbstractOperationWithoutMethodMatch.newMatch((org.eclipse.uml2.uml.Operation) t.get(POSITION_OP));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NonAbstractOperationWithoutMethodMatch arrayToMatch(final Object[] match) {
    try {
    	return NonAbstractOperationWithoutMethodMatch.newMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OP]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected NonAbstractOperationWithoutMethodMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return NonAbstractOperationWithoutMethodMatch.newMutableMatch((org.eclipse.uml2.uml.Operation) match[POSITION_OP]);
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
  public static IQuerySpecification<NonAbstractOperationWithoutMethodMatcher> querySpecification() throws IncQueryException {
    return NonAbstractOperationWithoutMethodQuerySpecification.instance();
  }
}
