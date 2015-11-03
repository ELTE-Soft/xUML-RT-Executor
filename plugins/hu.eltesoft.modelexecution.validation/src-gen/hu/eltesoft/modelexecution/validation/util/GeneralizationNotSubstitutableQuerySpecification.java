package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutableMatch;
import hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutableMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate GeneralizationNotSubstitutableMatcher in a type-safe way.
 * 
 * @see GeneralizationNotSubstitutableMatcher
 * @see GeneralizationNotSubstitutableMatch
 * 
 */
@SuppressWarnings("all")
public final class GeneralizationNotSubstitutableQuerySpecification extends BaseGeneratedEMFQuerySpecification<GeneralizationNotSubstitutableMatcher> {
  private GeneralizationNotSubstitutableQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GeneralizationNotSubstitutableQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected GeneralizationNotSubstitutableMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationNotSubstitutableMatcher.on(engine);
  }
  
  @Override
  public GeneralizationNotSubstitutableMatch newEmptyMatch() {
    return GeneralizationNotSubstitutableMatch.newEmptyMatch();
  }
  
  @Override
  public GeneralizationNotSubstitutableMatch newMatch(final Object... parameters) {
    return GeneralizationNotSubstitutableMatch.newMatch((org.eclipse.uml2.uml.Generalization) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static GeneralizationNotSubstitutableQuerySpecification INSTANCE = make();
    
    public static GeneralizationNotSubstitutableQuerySpecification make() {
      return new GeneralizationNotSubstitutableQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static GeneralizationNotSubstitutableQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.GeneralizationNotSubstitutable";
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
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_gen, "gen")
      	));
      	new TypeConstraint(body, new FlatTuple(var_gen), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new ConstantValue(body, var__virtual_0_, false);
      	new TypeConstraint(body, new FlatTuple(var_gen), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_gen, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "isSubstitutable")));
      	new Equality(body, var__virtual_1_, var__virtual_0_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Generalizations must be substitutable");
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
