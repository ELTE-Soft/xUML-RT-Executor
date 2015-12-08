package hu.eltesoft.modelexecution.validation.util;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.NumericValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicityMatch;
import hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicityMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReturnTypeMultiplicityMatcher in a type-safe way.
 * 
 * @see ReturnTypeMultiplicityMatcher
 * @see ReturnTypeMultiplicityMatch
 * 
 */
@SuppressWarnings("all")
public final class ReturnTypeMultiplicityQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReturnTypeMultiplicityMatcher> {
  private ReturnTypeMultiplicityQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReturnTypeMultiplicityQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReturnTypeMultiplicityMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReturnTypeMultiplicityMatcher.on(engine);
  }
  
  @Override
  public ReturnTypeMultiplicityMatch newEmptyMatch() {
    return ReturnTypeMultiplicityMatch.newEmptyMatch();
  }
  
  @Override
  public ReturnTypeMultiplicityMatch newMatch(final Object... parameters) {
    return ReturnTypeMultiplicityMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReturnTypeMultiplicityQuerySpecification INSTANCE = make();
    
    public static ReturnTypeMultiplicityQuerySpecification make() {
      return new ReturnTypeMultiplicityQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReturnTypeMultiplicityQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReturnTypeMultiplicity";
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
      		PVariable var_high = body.getOrCreateVariableByName("high");
      		PVariable var_uv = body.getOrCreateVariableByName("uv");
      		new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_param, "param")
      		));
      		// 	Operation.ownedParameter(_, param)
      		new TypeConstraint(body, new FlatTuple(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_0_, var_param);
      		// 	Parameter.direction(param, ParameterDirectionKind::return)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      		new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_param, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_2_, var__virtual_1_);
      		// 	Parameter.upperValue(param, high)
      		new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_param, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue")));
      		new Equality(body, var__virtual_3_, var_high);
      		// 	find NumericValue(high, uv)
      		new PositivePatternCall(body, new FlatTuple(var_high, var_uv), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	check(uv != 1)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern ReturnTypeMultiplicity";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("uv");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.Object uv = (java.lang.Object) provider.getValue("uv");
      		                                    return evaluateExpression_1_1(uv);
      		                                }
      		
      		                        },  null); 
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Return type cannot have multiplicity");
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
  
  private static boolean evaluateExpression_1_1(final Object uv) {
    boolean _notEquals = (!Objects.equal(uv, Integer.valueOf(1)));
    return _notEquals;
  }
}
