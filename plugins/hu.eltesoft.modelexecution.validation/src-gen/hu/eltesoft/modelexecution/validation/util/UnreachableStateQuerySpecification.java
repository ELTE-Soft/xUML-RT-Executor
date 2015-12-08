package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.UnreachableStateMatch;
import hu.eltesoft.modelexecution.validation.UnreachableStateMatcher;
import hu.eltesoft.modelexecution.validation.util.InitialStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReachableStateQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate UnreachableStateMatcher in a type-safe way.
 * 
 * @see UnreachableStateMatcher
 * @see UnreachableStateMatch
 * 
 */
@SuppressWarnings("all")
public final class UnreachableStateQuerySpecification extends BaseGeneratedEMFQuerySpecification<UnreachableStateMatcher> {
  private UnreachableStateQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnreachableStateQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnreachableStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UnreachableStateMatcher.on(engine);
  }
  
  @Override
  public UnreachableStateMatch newEmptyMatch() {
    return UnreachableStateMatch.newEmptyMatch();
  }
  
  @Override
  public UnreachableStateMatch newMatch(final Object... parameters) {
    return UnreachableStateMatch.newMatch((org.eclipse.uml2.uml.State) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static UnreachableStateQuerySpecification INSTANCE = make();
    
    public static UnreachableStateQuerySpecification make() {
      return new UnreachableStateQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UnreachableStateQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.UnreachableState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("st");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("st", "org.eclipse.uml2.uml.State"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_st = body.getOrCreateVariableByName("st");
      		PVariable var_rg = body.getOrCreateVariableByName("rg");
      		PVariable var_init = body.getOrCreateVariableByName("init");
      		new TypeConstraint(body, new FlatTuple(var_st), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_st, "st")
      		));
      		// 	State.container(st, rg)
      		new TypeConstraint(body, new FlatTuple(var_st), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_st, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container")));
      		new Equality(body, var__virtual_0_, var_rg);
      		// 	find InitialState(rg, init)
      		new PositivePatternCall(body, new FlatTuple(var_rg, var_init), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find ReachableState(init, st)
      		new NegativePatternCall(body, new FlatTuple(var_init, var_st), ReachableStateQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Unreachable state");
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
