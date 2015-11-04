package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.LeafClassGeneralizedMatch;
import hu.eltesoft.modelexecution.validation.util.LeafClassGeneralizedQuerySpecification;
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

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.LeafClassGeneralized pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link LeafClassGeneralizedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Violation(message = "Leaf class {cl} cannot be generalized", mark = { "spec" })
 * pattern LeafClassGeneralized(cl : Class, spec : Class) {
 * 	Class.isLeaf(cl, true);
 * 	Generalization.general(gen, cl);
 * 	Generalization.specific(gen, spec);
 * }
 * </pre></code>
 * 
 * @see LeafClassGeneralizedMatch
 * @see LeafClassGeneralizedProcessor
 * @see LeafClassGeneralizedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class LeafClassGeneralizedMatcher extends BaseMatcher<LeafClassGeneralizedMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static LeafClassGeneralizedMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    LeafClassGeneralizedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new LeafClassGeneralizedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CL = 0;
  
  private final static int POSITION_SPEC = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(LeafClassGeneralizedMatcher.class);
  
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
  public LeafClassGeneralizedMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public LeafClassGeneralizedMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return matches represented as a LeafClassGeneralizedMatch object.
   * 
   */
  public Collection<LeafClassGeneralizedMatch> getAllMatches(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return rawGetAllMatches(new Object[]{pCl, pSpec});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return a match represented as a LeafClassGeneralizedMatch object, or null if no match is found.
   * 
   */
  public LeafClassGeneralizedMatch getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return rawGetOneArbitraryMatch(new Object[]{pCl, pSpec});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return rawHasMatch(new Object[]{pCl, pSpec});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return rawCountMatches(new Object[]{pCl, pSpec});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec, final IMatchProcessor<? super LeafClassGeneralizedMatch> processor) {
    rawForEachMatch(new Object[]{pCl, pSpec}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec, final IMatchProcessor<? super LeafClassGeneralizedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCl, pSpec}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCl the fixed value of pattern parameter cl, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public LeafClassGeneralizedMatch newMatch(final org.eclipse.uml2.uml.Class pCl, final org.eclipse.uml2.uml.Class pSpec) {
    return LeafClassGeneralizedMatch.newMatch(pCl, pSpec);
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl(final LeafClassGeneralizedMatch partialMatch) {
    return rawAccumulateAllValuesOfcl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for cl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfcl(final org.eclipse.uml2.uml.Class pSpec) {
    return rawAccumulateAllValuesOfcl(new Object[]{
    null, 
    pSpec
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for spec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<org.eclipse.uml2.uml.Class> rawAccumulateAllValuesOfspec(final Object[] parameters) {
    Set<org.eclipse.uml2.uml.Class> results = new HashSet<org.eclipse.uml2.uml.Class>();
    rawAccumulateAllValues(POSITION_SPEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for spec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfspec() {
    return rawAccumulateAllValuesOfspec(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for spec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfspec(final LeafClassGeneralizedMatch partialMatch) {
    return rawAccumulateAllValuesOfspec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for spec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfspec(final org.eclipse.uml2.uml.Class pCl) {
    return rawAccumulateAllValuesOfspec(new Object[]{
    pCl, 
    null
    });
  }
  
  @Override
  protected LeafClassGeneralizedMatch tupleToMatch(final Tuple t) {
    try {
    	return LeafClassGeneralizedMatch.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_CL), (org.eclipse.uml2.uml.Class) t.get(POSITION_SPEC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LeafClassGeneralizedMatch arrayToMatch(final Object[] match) {
    try {
    	return LeafClassGeneralizedMatch.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL], (org.eclipse.uml2.uml.Class) match[POSITION_SPEC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected LeafClassGeneralizedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return LeafClassGeneralizedMatch.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_CL], (org.eclipse.uml2.uml.Class) match[POSITION_SPEC]);
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
  public static IQuerySpecification<LeafClassGeneralizedMatcher> querySpecification() throws IncQueryException {
    return LeafClassGeneralizedQuerySpecification.instance();
  }
}
