package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.DirectMultipleGeneralizationMatch;
import hu.eltesoft.modelexecution.validation.DirectMultipleGeneralizationMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate DirectMultipleGeneralizationMatcher in a type-safe way.
 * 
 * @see DirectMultipleGeneralizationMatcher
 * @see DirectMultipleGeneralizationMatch
 * 
 */
@SuppressWarnings("all")
public final class DirectMultipleGeneralizationQuerySpecification extends BaseGeneratedEMFQuerySpecification<DirectMultipleGeneralizationMatcher> {
  private DirectMultipleGeneralizationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static DirectMultipleGeneralizationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected DirectMultipleGeneralizationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return DirectMultipleGeneralizationMatcher.on(engine);
  }
  
  @Override
  public DirectMultipleGeneralizationMatch newEmptyMatch() {
    return DirectMultipleGeneralizationMatch.newEmptyMatch();
  }
  
  @Override
  public DirectMultipleGeneralizationMatch newMatch(final Object... parameters) {
    return DirectMultipleGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static DirectMultipleGeneralizationQuerySpecification INSTANCE = make();
    
    public static DirectMultipleGeneralizationQuerySpecification make() {
      return new DirectMultipleGeneralizationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static DirectMultipleGeneralizationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.DirectMultipleGeneralization";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("spec");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("spec", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_spec = body.getOrCreateVariableByName("spec");
      	PVariable var_gen1 = body.getOrCreateVariableByName("gen1");
      	PVariable var_cl = body.getOrCreateVariableByName("cl");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_gen2 = body.getOrCreateVariableByName("gen2");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_spec, "spec")
      	));
      	new TypeConstraint(body, new FlatTuple(var_spec), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_gen1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_gen1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "general")));
      	new Equality(body, var__virtual_0_, var_cl);
      	new TypeConstraint(body, new FlatTuple(var_gen1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_gen1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "specific")));
      	new Equality(body, var__virtual_1_, var_spec);
      	new TypeConstraint(body, new FlatTuple(var_gen2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_gen2, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "general")));
      	new Equality(body, var__virtual_2_, var_cl);
      	new TypeConstraint(body, new FlatTuple(var_gen2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_gen2, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "specific")));
      	new Equality(body, var__virtual_3_, var_spec);
      	new Inequality(body, var_gen1, var_gen2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Multiple direct generalization is not allowed");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"spec"
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
