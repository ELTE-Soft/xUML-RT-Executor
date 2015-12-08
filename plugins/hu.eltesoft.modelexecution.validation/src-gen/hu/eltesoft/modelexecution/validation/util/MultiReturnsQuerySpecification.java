package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MultiReturnsMatch;
import hu.eltesoft.modelexecution.validation.MultiReturnsMatcher;
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
 * A pattern-specific query specification that can instantiate MultiReturnsMatcher in a type-safe way.
 * 
 * @see MultiReturnsMatcher
 * @see MultiReturnsMatch
 * 
 */
@SuppressWarnings("all")
public final class MultiReturnsQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultiReturnsMatcher> {
  private MultiReturnsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultiReturnsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultiReturnsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultiReturnsMatcher.on(engine);
  }
  
  @Override
  public MultiReturnsMatch newEmptyMatch() {
    return MultiReturnsMatch.newEmptyMatch();
  }
  
  @Override
  public MultiReturnsMatch newMatch(final Object... parameters) {
    return MultiReturnsMatch.newMatch((org.eclipse.uml2.uml.BehavioralFeature) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static MultiReturnsQuerySpecification INSTANCE = make();
    
    public static MultiReturnsQuerySpecification make() {
      return new MultiReturnsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MultiReturnsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MultiReturns";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("bf","pm1","pm2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("bf", "org.eclipse.uml2.uml.BehavioralFeature"),new PParameter("pm1", "org.eclipse.uml2.uml.Parameter"),new PParameter("pm2", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_bf = body.getOrCreateVariableByName("bf");
      		PVariable var_pm1 = body.getOrCreateVariableByName("pm1");
      		PVariable var_pm2 = body.getOrCreateVariableByName("pm2");
      		new TypeConstraint(body, new FlatTuple(var_bf), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
      		new TypeConstraint(body, new FlatTuple(var_pm1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		new TypeConstraint(body, new FlatTuple(var_pm2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_bf, "bf"),
      		   new ExportedParameter(body, var_pm1, "pm1"),
      		   new ExportedParameter(body, var_pm2, "pm2")
      		));
      		// 	BehavioralFeature.ownedParameter(bf, pm1)
      		new TypeConstraint(body, new FlatTuple(var_bf), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_bf, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_0_, var_pm1);
      		// 	BehavioralFeature.ownedParameter(bf, pm2)
      		new TypeConstraint(body, new FlatTuple(var_bf), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_bf, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_1_, var_pm2);
      		// 	Parameter.direction(pm1, ::return)
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new ConstantValue(body, var__virtual_2_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      		new TypeConstraint(body, new FlatTuple(var_pm1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_pm1, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_3_, var__virtual_2_);
      		// 	Parameter.direction(pm2, ::return)
      		PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      		new ConstantValue(body, var__virtual_4_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      		new TypeConstraint(body, new FlatTuple(var_pm2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      		new TypeConstraint(body, new FlatTuple(var_pm2, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_5_, var__virtual_4_);
      		// 	pm1 != pm2
      		new Inequality(body, var_pm1, var_pm2);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "{bf} can have at most one return parameter");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "pm1", 
      		                "pm2"
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
