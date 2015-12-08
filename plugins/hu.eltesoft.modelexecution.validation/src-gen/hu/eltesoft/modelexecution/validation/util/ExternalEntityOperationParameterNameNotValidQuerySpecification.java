package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValidMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValidMatcher;
import hu.eltesoft.modelexecution.validation.Helpers;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOpParamQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ExternalEntityOperationParameterNameNotValidMatcher in a type-safe way.
 * 
 * @see ExternalEntityOperationParameterNameNotValidMatcher
 * @see ExternalEntityOperationParameterNameNotValidMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityOperationParameterNameNotValidQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityOperationParameterNameNotValidMatcher> {
  private ExternalEntityOperationParameterNameNotValidQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityOperationParameterNameNotValidQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityOperationParameterNameNotValidMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterNameNotValidMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityOperationParameterNameNotValidMatch newEmptyMatch() {
    return ExternalEntityOperationParameterNameNotValidMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityOperationParameterNameNotValidMatch newMatch(final Object... parameters) {
    return ExternalEntityOperationParameterNameNotValidMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityOperationParameterNameNotValidQuerySpecification INSTANCE = make();
    
    public static ExternalEntityOperationParameterNameNotValidQuerySpecification make() {
      return new ExternalEntityOperationParameterNameNotValidQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityOperationParameterNameNotValidQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterNameNotValid";
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
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pm, "pm")
      		));
      		// 	find ExternalEntityOpParam(pm)
      		new PositivePatternCall(body, new FlatTuple(var_pm), ExternalEntityOpParamQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Parameter.name(pm, name)
      		new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name);
      		// 	check(!Helpers.validJavaIdentifierName(name))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern ExternalEntityOperationParameterNameNotValid";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("name");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.String name = (java.lang.String) provider.getValue("name");
      		                                    return evaluateExpression_1_1(name);
      		                                }
      		
      		                        },  null); 
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Name of an operation parameter on an external entity must be a valid Java identifier");
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
  
  private static boolean evaluateExpression_1_1(final String name) {
    boolean _validJavaIdentifierName = Helpers.validJavaIdentifierName(name);
    boolean _not = (!_validJavaIdentifierName);
    return _not;
  }
}
