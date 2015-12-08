package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.PropertyAggregationMatch;
import hu.eltesoft.modelexecution.validation.PropertyAggregationMatcher;
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
 * A pattern-specific query specification that can instantiate PropertyAggregationMatcher in a type-safe way.
 * 
 * @see PropertyAggregationMatcher
 * @see PropertyAggregationMatch
 * 
 */
@SuppressWarnings("all")
public final class PropertyAggregationQuerySpecification extends BaseGeneratedEMFQuerySpecification<PropertyAggregationMatcher> {
  private PropertyAggregationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PropertyAggregationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertyAggregationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PropertyAggregationMatcher.on(engine);
  }
  
  @Override
  public PropertyAggregationMatch newEmptyMatch() {
    return PropertyAggregationMatch.newEmptyMatch();
  }
  
  @Override
  public PropertyAggregationMatch newMatch(final Object... parameters) {
    return PropertyAggregationMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static PropertyAggregationQuerySpecification INSTANCE = make();
    
    public static PropertyAggregationQuerySpecification make() {
      return new PropertyAggregationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PropertyAggregationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.PropertyAggregation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pr");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pr", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_pr = body.getOrCreateVariableByName("pr");
      		PVariable var_ag = body.getOrCreateVariableByName("ag");
      		new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pr, "pr")
      		));
      		// 	Property.aggregation(pr, ag)
      		new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property", "aggregation")));
      		new Equality(body, var__virtual_0_, var_ag);
      		// 	ag != AggregationKind::none
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.AggregationKind.get("none"));
      		new Inequality(body, var_ag, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Aggregation is not supported");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "pr"
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
