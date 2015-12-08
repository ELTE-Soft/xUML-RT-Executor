package hu.eltesoft.modelexecution.validation.util;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.NumericValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.HighBoundZeroMatch;
import hu.eltesoft.modelexecution.validation.HighBoundZeroMatcher;
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
 * A pattern-specific query specification that can instantiate HighBoundZeroMatcher in a type-safe way.
 * 
 * @see HighBoundZeroMatcher
 * @see HighBoundZeroMatch
 * 
 */
@SuppressWarnings("all")
public final class HighBoundZeroQuerySpecification extends BaseGeneratedEMFQuerySpecification<HighBoundZeroMatcher> {
  private HighBoundZeroQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HighBoundZeroQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected HighBoundZeroMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HighBoundZeroMatcher.on(engine);
  }
  
  @Override
  public HighBoundZeroMatch newEmptyMatch() {
    return HighBoundZeroMatch.newEmptyMatch();
  }
  
  @Override
  public HighBoundZeroMatch newMatch(final Object... parameters) {
    return HighBoundZeroMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static HighBoundZeroQuerySpecification INSTANCE = make();
    
    public static HighBoundZeroQuerySpecification make() {
      return new HighBoundZeroQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static HighBoundZeroQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.HighBoundZero";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("me");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("me", "org.eclipse.uml2.uml.MultiplicityElement"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_me = body.getOrCreateVariableByName("me");
      		PVariable var_high = body.getOrCreateVariableByName("high");
      		PVariable var_hv = body.getOrCreateVariableByName("hv");
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_me, "me")
      		));
      		// 	MultiplicityElement.upperValue(me, high)
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_me, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue")));
      		new Equality(body, var__virtual_0_, var_high);
      		// 	find NumericValue(high, hv)
      		new PositivePatternCall(body, new FlatTuple(var_high, var_hv), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	check (1 > hv as Integer && hv != (-1))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern HighBoundZero";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("hv");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.Object hv = (java.lang.Object) provider.getValue("hv");
      		                                    return evaluateExpression_1_1(hv);
      		                                }
      		
      		                        },  null); 
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "High bound cannot be lower than one");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "me"
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
  
  private static boolean evaluateExpression_1_1(final Object hv) {
    boolean _and = false;
    boolean _greaterThan = (1 > (((Integer) hv)).intValue());
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(hv, Integer.valueOf((-1))));
      _and = _notEquals;
    }
    return _and;
  }
}
