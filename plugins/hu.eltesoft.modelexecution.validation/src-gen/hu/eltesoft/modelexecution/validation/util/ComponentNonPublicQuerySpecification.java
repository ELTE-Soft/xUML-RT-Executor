package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ComponentNonPublicMatch;
import hu.eltesoft.modelexecution.validation.ComponentNonPublicMatcher;
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
 * A pattern-specific query specification that can instantiate ComponentNonPublicMatcher in a type-safe way.
 * 
 * @see ComponentNonPublicMatcher
 * @see ComponentNonPublicMatch
 * 
 */
@SuppressWarnings("all")
public final class ComponentNonPublicQuerySpecification extends BaseGeneratedEMFQuerySpecification<ComponentNonPublicMatcher> {
  private ComponentNonPublicQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ComponentNonPublicQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ComponentNonPublicMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ComponentNonPublicMatcher.on(engine);
  }
  
  @Override
  public ComponentNonPublicMatch newEmptyMatch() {
    return ComponentNonPublicMatch.newEmptyMatch();
  }
  
  @Override
  public ComponentNonPublicMatch newMatch(final Object... parameters) {
    return ComponentNonPublicMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ComponentNonPublicQuerySpecification INSTANCE = make();
    
    public static ComponentNonPublicQuerySpecification make() {
      return new ComponentNonPublicQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ComponentNonPublicQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ComponentNonPublic";
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
      		PVariable var_visibility = body.getOrCreateVariableByName("visibility");
      		new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cp, "cp")
      		));
      		// 	Component.visibility(cp, visibility)
      		new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cp, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "visibility")));
      		new Equality(body, var__virtual_0_, var_visibility);
      		// 	visibility != VisibilityKind::public
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.VisibilityKind.get("public"));
      		new Inequality(body, var_visibility, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Components must be public");
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
