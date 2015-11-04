package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClassMatch;
import hu.eltesoft.modelexecution.validation.util.GeneralizationOfAssocClassQuerySpecification;
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
import org.eclipse.uml2.uml.AssociationClass;

/**
 * Generated pattern matcher API of the hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GeneralizationOfAssocClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //////////////////////////////
 * // association class
 * //////////////////////////////
 * {@literal @}Violation(message = "Generalization of association class {ac} is not supported", mark = { "spec" })
 * pattern GeneralizationOfAssocClass(ac : AssociationClass, spec : Class) {
 * 	find Parent(spec, ac);
 * }
 * </pre></code>
 * 
 * @see GeneralizationOfAssocClassMatch
 * @see GeneralizationOfAssocClassProcessor
 * @see GeneralizationOfAssocClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GeneralizationOfAssocClassMatcher extends BaseMatcher<GeneralizationOfAssocClassMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GeneralizationOfAssocClassMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    GeneralizationOfAssocClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new GeneralizationOfAssocClassMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_AC = 0;
  
  private final static int POSITION_SPEC = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(GeneralizationOfAssocClassMatcher.class);
  
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
  public GeneralizationOfAssocClassMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public GeneralizationOfAssocClassMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return matches represented as a GeneralizationOfAssocClassMatch object.
   * 
   */
  public Collection<GeneralizationOfAssocClassMatch> getAllMatches(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return rawGetAllMatches(new Object[]{pAc, pSpec});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return a match represented as a GeneralizationOfAssocClassMatch object, or null if no match is found.
   * 
   */
  public GeneralizationOfAssocClassMatch getOneArbitraryMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return rawGetOneArbitraryMatch(new Object[]{pAc, pSpec});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return rawHasMatch(new Object[]{pAc, pSpec});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return rawCountMatches(new Object[]{pAc, pSpec});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec, final IMatchProcessor<? super GeneralizationOfAssocClassMatch> processor) {
    rawForEachMatch(new Object[]{pAc, pSpec}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec, final IMatchProcessor<? super GeneralizationOfAssocClassMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pAc, pSpec}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAc the fixed value of pattern parameter ac, or null if not bound.
   * @param pSpec the fixed value of pattern parameter spec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GeneralizationOfAssocClassMatch newMatch(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec) {
    return GeneralizationOfAssocClassMatch.newMatch(pAc, pSpec);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<AssociationClass> rawAccumulateAllValuesOfac(final Object[] parameters) {
    Set<AssociationClass> results = new HashSet<AssociationClass>();
    rawAccumulateAllValues(POSITION_AC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AssociationClass> getAllValuesOfac() {
    return rawAccumulateAllValuesOfac(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AssociationClass> getAllValuesOfac(final GeneralizationOfAssocClassMatch partialMatch) {
    return rawAccumulateAllValuesOfac(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ac.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<AssociationClass> getAllValuesOfac(final org.eclipse.uml2.uml.Class pSpec) {
    return rawAccumulateAllValuesOfac(new Object[]{
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
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfspec(final GeneralizationOfAssocClassMatch partialMatch) {
    return rawAccumulateAllValuesOfspec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for spec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<org.eclipse.uml2.uml.Class> getAllValuesOfspec(final AssociationClass pAc) {
    return rawAccumulateAllValuesOfspec(new Object[]{
    pAc, 
    null
    });
  }
  
  @Override
  protected GeneralizationOfAssocClassMatch tupleToMatch(final Tuple t) {
    try {
    	return GeneralizationOfAssocClassMatch.newMatch((org.eclipse.uml2.uml.AssociationClass) t.get(POSITION_AC), (org.eclipse.uml2.uml.Class) t.get(POSITION_SPEC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GeneralizationOfAssocClassMatch arrayToMatch(final Object[] match) {
    try {
    	return GeneralizationOfAssocClassMatch.newMatch((org.eclipse.uml2.uml.AssociationClass) match[POSITION_AC], (org.eclipse.uml2.uml.Class) match[POSITION_SPEC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GeneralizationOfAssocClassMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return GeneralizationOfAssocClassMatch.newMutableMatch((org.eclipse.uml2.uml.AssociationClass) match[POSITION_AC], (org.eclipse.uml2.uml.Class) match[POSITION_SPEC]);
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
  public static IQuerySpecification<GeneralizationOfAssocClassMatcher> querySpecification() throws IncQueryException {
    return GeneralizationOfAssocClassQuerySpecification.instance();
  }
}
