package hu.eltesoft.modelexecution.validation.util;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMultiplicityNotOneMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMultiplicityNotOneMatcher;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOpParamQuerySpecification;
import hu.eltesoft.modelexecution.validation.util._NumericValueQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityOperationParameterMultiplicityNotOneMatcher in a type-safe way.
 * 
 * @see ExternalEntityOperationParameterMultiplicityNotOneMatcher
 * @see ExternalEntityOperationParameterMultiplicityNotOneMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityOperationParameterMultiplicityNotOneMatcher> {
  private ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityOperationParameterMultiplicityNotOneMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterMultiplicityNotOneMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityOperationParameterMultiplicityNotOneMatch newEmptyMatch() {
    return ExternalEntityOperationParameterMultiplicityNotOneMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityOperationParameterMultiplicityNotOneMatch newMatch(final Object... parameters) {
    return ExternalEntityOperationParameterMultiplicityNotOneMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification INSTANCE = make();
    
    public static ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification make() {
      return new ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityOperationParameterMultiplicityNotOneQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterMultiplicityNotOne";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pm");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pm", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_pm = body.getOrCreateVariableByName("pm");
      	PVariable var_lower = body.getOrCreateVariableByName("lower");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var_lv = body.getOrCreateVariableByName("lv");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pm, "pm")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new PositivePatternCall(body, new FlatTuple(var_pm), ExternalEntityOpParamQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_pm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue")));
      	new Equality(body, var__virtual_0_, var_lower);
      	new PositivePatternCall(body, new FlatTuple(var_lower, var_lv), _NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern ExternalEntityOperationParameterMultiplicityNotOne";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("lv");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.Object lv = (java.lang.Object) provider.getValue("lv");
      			return evaluateExpression_1_1(lv);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_pm = body.getOrCreateVariableByName("pm");
      	PVariable var_upper = body.getOrCreateVariableByName("upper");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var_uv = body.getOrCreateVariableByName("uv");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pm, "pm")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new PositivePatternCall(body, new FlatTuple(var_pm), ExternalEntityOpParamQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_pm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue")));
      	new Equality(body, var__virtual_0_, var_upper);
      	new PositivePatternCall(body, new FlatTuple(var_upper, var_uv), _NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern ExternalEntityOperationParameterMultiplicityNotOne";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("uv");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.Object uv = (java.lang.Object) provider.getValue("uv");
      			return evaluateExpression_2_1(uv);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Multiplicity of an operation parameter on an external entity must be 1");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"pm"
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
  
  private static boolean evaluateExpression_1_1(final Object lv) {
    boolean _notEquals = (!Objects.equal(lv, Integer.valueOf(1)));
    return _notEquals;
  }
  
  private static boolean evaluateExpression_2_1(final Object uv) {
    boolean _notEquals = (!Objects.equal(uv, Integer.valueOf(1)));
    return _notEquals;
  }
}
