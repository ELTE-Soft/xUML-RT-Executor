package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.PackageTemplateParameterMatch;
import hu.eltesoft.modelexecution.validation.PackageTemplateParameterMatcher;
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
 * A pattern-specific query specification that can instantiate PackageTemplateParameterMatcher in a type-safe way.
 * 
 * @see PackageTemplateParameterMatcher
 * @see PackageTemplateParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class PackageTemplateParameterQuerySpecification extends BaseGeneratedEMFQuerySpecification<PackageTemplateParameterMatcher> {
  private PackageTemplateParameterQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PackageTemplateParameterQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PackageTemplateParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PackageTemplateParameterMatcher.on(engine);
  }
  
  @Override
  public PackageTemplateParameterMatch newEmptyMatch() {
    return PackageTemplateParameterMatch.newEmptyMatch();
  }
  
  @Override
  public PackageTemplateParameterMatch newMatch(final Object... parameters) {
    return PackageTemplateParameterMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static PackageTemplateParameterQuerySpecification INSTANCE = make();
    
    public static PackageTemplateParameterQuerySpecification make() {
      return new PackageTemplateParameterQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PackageTemplateParameterQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.PackageTemplateParameter";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pk");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pk", "org.eclipse.uml2.uml.Package"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_pk = body.getOrCreateVariableByName("pk");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_pk), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pk, "pk")
      		));
      		// 	Package.templateParameter(pk, _)
      		new TypeConstraint(body, new FlatTuple(var_pk), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pk, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ParameterableElement", "templateParameter")));
      		new Equality(body, var__virtual_0_, var___0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Template parameters are not supported for packages");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "pk"
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
