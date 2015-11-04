package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.FinalStateWithEntryActionMatch;
import hu.eltesoft.modelexecution.validation.FinalStateWithEntryActionMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate FinalStateWithEntryActionMatcher in a type-safe way.
 * 
 * @see FinalStateWithEntryActionMatcher
 * @see FinalStateWithEntryActionMatch
 * 
 */
@SuppressWarnings("all")
public final class FinalStateWithEntryActionQuerySpecification extends BaseGeneratedEMFQuerySpecification<FinalStateWithEntryActionMatcher> {
  private FinalStateWithEntryActionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinalStateWithEntryActionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected FinalStateWithEntryActionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateWithEntryActionMatcher.on(engine);
  }
  
  @Override
  public FinalStateWithEntryActionMatch newEmptyMatch() {
    return FinalStateWithEntryActionMatch.newEmptyMatch();
  }
  
  @Override
  public FinalStateWithEntryActionMatch newMatch(final Object... parameters) {
    return FinalStateWithEntryActionMatch.newMatch((org.eclipse.uml2.uml.FinalState) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static FinalStateWithEntryActionQuerySpecification INSTANCE = make();
    
    public static FinalStateWithEntryActionQuerySpecification make() {
      return new FinalStateWithEntryActionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static FinalStateWithEntryActionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.FinalStateWithEntryAction";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("st");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("st", "org.eclipse.uml2.uml.FinalState"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_st = body.getOrCreateVariableByName("st");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_st, "st")
      	));
      	new TypeConstraint(body, new FlatTuple(var_st), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "FinalState")));
      	new TypeConstraint(body, new FlatTuple(var_st), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "FinalState")));
      	new TypeConstraint(body, new FlatTuple(var_st, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "entry")));
      	new Equality(body, var__virtual_0_, var___0_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Final states cannot have entry action");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"st"
      				}));
      	addAnnotation(annotation);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
