package hu.eltesoft.modelexecution.validation.util;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.NumericValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBoundMatch;
import hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBoundMatcher;
import hu.eltesoft.modelexecution.validation.util.HighBoundQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate LowBoundHigherThanHighBoundMatcher in a type-safe way.
 * 
 * @see LowBoundHigherThanHighBoundMatcher
 * @see LowBoundHigherThanHighBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class LowBoundHigherThanHighBoundQuerySpecification extends BaseGeneratedEMFQuerySpecification<LowBoundHigherThanHighBoundMatcher> {
  private LowBoundHigherThanHighBoundQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LowBoundHigherThanHighBoundQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LowBoundHigherThanHighBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LowBoundHigherThanHighBoundMatcher.on(engine);
  }
  
  @Override
  public LowBoundHigherThanHighBoundMatch newEmptyMatch() {
    return LowBoundHigherThanHighBoundMatch.newEmptyMatch();
  }
  
  @Override
  public LowBoundHigherThanHighBoundMatch newMatch(final Object... parameters) {
    return LowBoundHigherThanHighBoundMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static LowBoundHigherThanHighBoundQuerySpecification INSTANCE = make();
    
    public static LowBoundHigherThanHighBoundQuerySpecification make() {
      return new LowBoundHigherThanHighBoundQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LowBoundHigherThanHighBoundQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.LowBoundHigherThanHighBound";
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
      		PVariable var_low = body.getOrCreateVariableByName("low");
      		PVariable var_lv = body.getOrCreateVariableByName("lv");
      		PVariable var_high = body.getOrCreateVariableByName("high");
      		PVariable var_hv = body.getOrCreateVariableByName("hv");
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_me, "me")
      		));
      		// 	MultiplicityElement.lowerValue(me, low)
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_me, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue")));
      		new Equality(body, var__virtual_0_, var_low);
      		// 	find NumericValue(low, lv)
      		new PositivePatternCall(body, new FlatTuple(var_low, var_lv), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	MultiplicityElement.upperValue(me, high)
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_me, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue")));
      		new Equality(body, var__virtual_1_, var_high);
      		// 	find NumericValue(high, hv)
      		new PositivePatternCall(body, new FlatTuple(var_high, var_hv), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	check (lv as Integer > hv as Integer && hv != (-1))
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern LowBoundHigherThanHighBound";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("hv", "lv");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.Object hv = (java.lang.Object) provider.getValue("hv");
      		                                    java.lang.Object lv = (java.lang.Object) provider.getValue("lv");
      		                                    return evaluateExpression_1_1(hv, lv);
      		                                }
      		
      		                        },  null); 
      		bodies.add(body);
      	}
      	{
      		PBody body = new PBody(this);
      		PVariable var_me = body.getOrCreateVariableByName("me");
      		PVariable var_low = body.getOrCreateVariableByName("low");
      		PVariable var_lv = body.getOrCreateVariableByName("lv");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_me, "me")
      		));
      		// 	MultiplicityElement.lowerValue(me, low)
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_me, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue")));
      		new Equality(body, var__virtual_0_, var_low);
      		// 	find NumericValue(low, lv)
      		new PositivePatternCall(body, new FlatTuple(var_low, var_lv), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find HighBound(me, _)
      		new NegativePatternCall(body, new FlatTuple(var_me, var___0_), HighBoundQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	check (lv as Integer > 1)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern LowBoundHigherThanHighBound";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("lv");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.Object lv = (java.lang.Object) provider.getValue("lv");
      		                                    return evaluateExpression_2_1(lv);
      		                                }
      		
      		                        },  null); 
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "High bound must be higher than lower bound");
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
  
  private static boolean evaluateExpression_1_1(final Object hv, final Object lv) {
    boolean _and = false;
    boolean _greaterThan = (((Integer) lv).compareTo(((Integer) hv)) > 0);
    if (!_greaterThan) {
      _and = false;
    } else {
      boolean _notEquals = (!Objects.equal(hv, Integer.valueOf((-1))));
      _and = _notEquals;
    }
    return _and;
  }
  
  private static boolean evaluateExpression_2_1(final Object lv) {
    return ((((Integer) lv)).intValue() > 1);
  }
}
