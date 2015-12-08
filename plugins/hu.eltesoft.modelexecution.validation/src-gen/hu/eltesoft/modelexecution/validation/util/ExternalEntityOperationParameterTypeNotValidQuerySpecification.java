package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValidMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValidMatcher;
import hu.eltesoft.modelexecution.validation.util.CallableQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityOpParamQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PrimitiveType_QuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityOperationParameterTypeNotValidMatcher in a type-safe way.
 * 
 * @see ExternalEntityOperationParameterTypeNotValidMatcher
 * @see ExternalEntityOperationParameterTypeNotValidMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityOperationParameterTypeNotValidQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityOperationParameterTypeNotValidMatcher> {
  private ExternalEntityOperationParameterTypeNotValidQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityOperationParameterTypeNotValidQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityOperationParameterTypeNotValidMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityOperationParameterTypeNotValidMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityOperationParameterTypeNotValidMatch newEmptyMatch() {
    return ExternalEntityOperationParameterTypeNotValidMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityOperationParameterTypeNotValidMatch newMatch(final Object... parameters) {
    return ExternalEntityOperationParameterTypeNotValidMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityOperationParameterTypeNotValidQuerySpecification INSTANCE = make();
    
    public static ExternalEntityOperationParameterTypeNotValidQuerySpecification make() {
      return new ExternalEntityOperationParameterTypeNotValidQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityOperationParameterTypeNotValidQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityOperationParameterTypeNotValid";
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
      		PVariable var_ty = body.getOrCreateVariableByName("ty");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pm, "pm")
      		));
      		// 	find ExternalEntityOpParam(pm)
      		new PositivePatternCall(body, new FlatTuple(var_pm), ExternalEntityOpParamQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Parameter.type(pm, ty)
      		new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pm, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      		new Equality(body, var__virtual_0_, var_ty);
      		// 	neg find PrimitiveType_(ty)
      		new NegativePatternCall(body, new FlatTuple(var_ty), PrimitiveType_QuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Callable(ty, _)
      		new NegativePatternCall(body, new FlatTuple(var_ty, var___0_), CallableQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Type of a parameter on an external entity operation must be a primitive type, or a class with Callable stereotype applied");
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
}
