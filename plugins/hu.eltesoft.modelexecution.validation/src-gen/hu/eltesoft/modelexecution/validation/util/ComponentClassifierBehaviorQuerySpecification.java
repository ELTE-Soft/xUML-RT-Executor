package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ComponentClassifierBehaviorMatch;
import hu.eltesoft.modelexecution.validation.ComponentClassifierBehaviorMatcher;
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
 * A pattern-specific query specification that can instantiate ComponentClassifierBehaviorMatcher in a type-safe way.
 * 
 * @see ComponentClassifierBehaviorMatcher
 * @see ComponentClassifierBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentClassifierBehaviorQuerySpecification extends BaseGeneratedEMFQuerySpecification<ComponentClassifierBehaviorMatcher> {
  private ComponentClassifierBehaviorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentClassifierBehaviorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ComponentClassifierBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentClassifierBehaviorMatcher.on(engine);
  }
  
  @Override
  public ComponentClassifierBehaviorMatch newEmptyMatch() {
    return ComponentClassifierBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public ComponentClassifierBehaviorMatch newMatch(final Object... parameters) {
    return ComponentClassifierBehaviorMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ComponentClassifierBehaviorQuerySpecification INSTANCE = make();
    
    public static ComponentClassifierBehaviorQuerySpecification make() {
      return new ComponentClassifierBehaviorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ComponentClassifierBehaviorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ComponentClassifierBehavior";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cp");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cp", "org.eclipse.uml2.uml.Component"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_cp = body.getOrCreateVariableByName("cp");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cp, "cp")
      		));
      		// 	Component.classifierBehavior(cp, _)
      		new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cp, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "classifierBehavior")));
      		new Equality(body, var__virtual_0_, var___0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Component classifier behaviors are not supported");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "cp"
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
