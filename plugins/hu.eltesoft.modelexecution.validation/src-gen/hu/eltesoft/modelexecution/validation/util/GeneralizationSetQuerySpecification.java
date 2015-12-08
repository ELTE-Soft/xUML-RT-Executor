package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.GeneralizationSetMatch;
import hu.eltesoft.modelexecution.validation.GeneralizationSetMatcher;
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
 * A pattern-specific query specification that can instantiate GeneralizationSetMatcher in a type-safe way.
 * 
 * @see GeneralizationSetMatcher
 * @see GeneralizationSetMatch
 * 
 */
@SuppressWarnings("all")
public final class GeneralizationSetQuerySpecification extends BaseGeneratedEMFQuerySpecification<GeneralizationSetMatcher> {
  private GeneralizationSetQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GeneralizationSetQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected GeneralizationSetMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationSetMatcher.on(engine);
  }
  
  @Override
  public GeneralizationSetMatch newEmptyMatch() {
    return GeneralizationSetMatch.newEmptyMatch();
  }
  
  @Override
  public GeneralizationSetMatch newMatch(final Object... parameters) {
    return GeneralizationSetMatch.newMatch((org.eclipse.uml2.uml.Generalization) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static GeneralizationSetQuerySpecification INSTANCE = make();
    
    public static GeneralizationSetQuerySpecification make() {
      return new GeneralizationSetQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static GeneralizationSetQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.GeneralizationSet";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("gen");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("gen", "org.eclipse.uml2.uml.Generalization"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_gen = body.getOrCreateVariableByName("gen");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_gen), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_gen, "gen")
      		));
      		// 	Generalization.generalizationSet(gen, _)
      		new TypeConstraint(body, new FlatTuple(var_gen), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_gen, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "generalizationSet")));
      		new Equality(body, var__virtual_0_, var___0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Generalization sets are not supported");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "gen"
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
