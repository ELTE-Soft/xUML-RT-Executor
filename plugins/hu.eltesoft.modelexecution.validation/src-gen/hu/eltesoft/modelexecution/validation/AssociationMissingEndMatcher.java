package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.AssociationMissingEndMatch;
import hu.eltesoft.modelexecution.validation.util.AssociationMissingEndQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.AssociationMissingEnd pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link AssociationMissingEndMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Association must have two ends", mark = { "ac" })
 * pattern AssociationMissingEnd(ac : Association) {
 * 	neg find AssociationEnds(ac, _, _);
 * } or {
 * 	find AssociationEnds(ac, me1, me2);
 * 	Association.memberEnd(ac, me3);
 * 	me1 != me3;
 * 	me2 != me3;
 * }
 * </pre></code>
 * 
 * @see AssociationMissingEndMatch
 * @see AssociationMissingEndProcessor
 * @see AssociationMissingEndQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class AssociationMissingEndMatcher extends BaseMatcher<AssociationMissingEndMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static AssociationMissingEndMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    AssociationMissingEndMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new AssociationMissingEndMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_AC = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(AssociationMissingEndMatcher.class);
  
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
  public AssociationMissingEndMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public AssociationMissingEndMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return matches represented as a AssociationMissingEndMatch object.
   * 
   */
  public Collection<AssociationMissingEndMatch> getAllMatches(final Association pAc) {
    return rawGetAllMatches(new Object[]{pAc});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return a match represented as a AssociationMissingEndMatch object, or null if no match is found.
   * 
   */
  public AssociationMissingEndMatch getOneArbitraryMatch(final Association pAc) {
    return rawGetOneArbitraryMatch(new Object[]{pAc});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Association pAc) {
    return rawHasMatch(new Object[]{pAc});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Association pAc) {
    return rawCountMatches(new Object[]{pAc});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Association pAc, final IMatchProcessor<? super AssociationMissingEndMatch> processor) {
    rawForEachMatch(new Object[]{pAc}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Association pAc, final IMatchProcessor<? super AssociationMissingEndMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAc}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public AssociationMissingEndMatch newMatch(final Association pAc) {
    return AssociationMissingEndMatch.newMatch(pAc);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Association> rawAccumulateAllValuesOfac(final Object[] parameters) {
    Set<Association> results = new HashSet<Association>();
    rawAccumulateAllValues(POSITION_AC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Association> getAllValuesOfac() {
    return rawAccumulateAllValuesOfac(emptyArray());
  }
  
  @Override
  protected AssociationMissingEndMatch tupleToMatch(final Tuple t) {
    try {
    	return AssociationMissingEndMatch.newMatch((org.eclipse.uml2.uml.Association) t.get(POSITION_AC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AssociationMissingEndMatch arrayToMatch(final Object[] match) {
    try {
    	return AssociationMissingEndMatch.newMatch((org.eclipse.uml2.uml.Association) match[POSITION_AC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected AssociationMissingEndMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return AssociationMissingEndMatch.newMutableMatch((org.eclipse.uml2.uml.Association) match[POSITION_AC]);
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
  public static IQuerySpecification<AssociationMissingEndMatcher> querySpecification() throws IncQueryException {
    return AssociationMissingEndQuerySpecification.instance();
  }
}
