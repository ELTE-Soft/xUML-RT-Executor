package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionParameterNotInMatch;
import hu.eltesoft.modelexecution.validation.ReceptionParameterNotInMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReceptionParameterNotInMatcher in a type-safe way.
 * 
 * @see ReceptionParameterNotInMatcher
 * @see ReceptionParameterNotInMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionParameterNotInQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionParameterNotInMatcher> {
  private ReceptionParameterNotInQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionParameterNotInQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionParameterNotInMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterNotInMatcher.on(engine);
  }
  
  @Override
  public ReceptionParameterNotInMatch newEmptyMatch() {
    return ReceptionParameterNotInMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionParameterNotInMatch newMatch(final Object... parameters) {
    return ReceptionParameterNotInMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReceptionParameterNotInQuerySpecification INSTANCE = make();
    
    public static ReceptionParameterNotInQuerySpecification make() {
      return new ReceptionParameterNotInQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionParameterNotInQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionParameterNotIn";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("param");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("param", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_param = body.getOrCreateVariableByName("param");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var_dir = body.getOrCreateVariableByName("dir");
      		new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_param, "param")
      		));
      		// 	Reception.ownedParameter(_, param)
      		new TypeConstraint(body, new FlatTuple(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_0_, var_param);
      		// 	Parameter.direction(param, dir)
      		new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_param, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_1_, var_dir);
      		// 	dir != ParameterDirectionKind::in
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new ConstantValue(body, var__virtual_2_, org.eclipse.uml2.uml.ParameterDirectionKind.get("in"));
      		new Inequality(body, var_dir, var__virtual_2_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Reception parameters must have 'in' direction");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "param"
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
