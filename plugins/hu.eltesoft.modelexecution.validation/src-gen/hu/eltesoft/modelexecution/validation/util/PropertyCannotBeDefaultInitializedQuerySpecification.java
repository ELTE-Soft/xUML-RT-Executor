package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.NumericValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitializedMatch;
import hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitializedMatcher;
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
 * A pattern-specific query specification that can instantiate PropertyCannotBeDefaultInitializedMatcher in a type-safe way.
 * 
 * @see PropertyCannotBeDefaultInitializedMatcher
 * @see PropertyCannotBeDefaultInitializedMatch
 * 
 */
@SuppressWarnings("all")
public final class PropertyCannotBeDefaultInitializedQuerySpecification extends BaseGeneratedEMFQuerySpecification<PropertyCannotBeDefaultInitializedMatcher> {
  private PropertyCannotBeDefaultInitializedQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PropertyCannotBeDefaultInitializedQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertyCannotBeDefaultInitializedMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PropertyCannotBeDefaultInitializedMatcher.on(engine);
  }
  
  @Override
  public PropertyCannotBeDefaultInitializedMatch newEmptyMatch() {
    return PropertyCannotBeDefaultInitializedMatch.newEmptyMatch();
  }
  
  @Override
  public PropertyCannotBeDefaultInitializedMatch newMatch(final Object... parameters) {
    return PropertyCannotBeDefaultInitializedMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static PropertyCannotBeDefaultInitializedQuerySpecification INSTANCE = make();
    
    public static PropertyCannotBeDefaultInitializedQuerySpecification make() {
      return new PropertyCannotBeDefaultInitializedQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PropertyCannotBeDefaultInitializedQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.PropertyCannotBeDefaultInitialized";
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
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_low = body.getOrCreateVariableByName("low");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var_v = body.getOrCreateVariableByName("v");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pr, "pr")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new ConstantValue(body, var__virtual_0_, true);
      	new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_pr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isUnique")));
      	new Equality(body, var__virtual_1_, var__virtual_0_);
      	new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_pr, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue")));
      	new Equality(body, var__virtual_2_, var_low);
      	new PositivePatternCall(body, new FlatTuple(var_low, var_v), NumericValueQuerySpecification.instance().getInternalQueryRepresentation());
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern PropertyCannotBeDefaultInitialized";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("v");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.Object v = (java.lang.Object) provider.getValue("v");
      			return evaluateExpression_1_1(v);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Unique properties cannot have lower bound higher than 1, because they could not be default initialized");
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
  
  private static boolean evaluateExpression_1_1(final Object v) {
    return (1 < (((Integer) v)).intValue());
  }
}
