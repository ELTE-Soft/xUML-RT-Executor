package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ParameterWithoutTypeMatch;
import hu.eltesoft.modelexecution.validation.ParameterWithoutTypeMatcher;
import hu.eltesoft.modelexecution.validation.util.ParameterTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ParameterWithoutTypeMatcher in a type-safe way.
 * 
 * @see ParameterWithoutTypeMatcher
 * @see ParameterWithoutTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class ParameterWithoutTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<ParameterWithoutTypeMatcher> {
  private ParameterWithoutTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParameterWithoutTypeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ParameterWithoutTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ParameterWithoutTypeMatcher.on(engine);
  }
  
  @Override
  public ParameterWithoutTypeMatch newEmptyMatch() {
    return ParameterWithoutTypeMatch.newEmptyMatch();
  }
  
  @Override
  public ParameterWithoutTypeMatch newMatch(final Object... parameters) {
    return ParameterWithoutTypeMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ParameterWithoutTypeQuerySpecification INSTANCE = make();
    
    public static ParameterWithoutTypeQuerySpecification make() {
      return new ParameterWithoutTypeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParameterWithoutTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ParameterWithoutType";
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
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_pm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pm, "pm")
      		));
      		// 	neg find ParameterType(pm, _)
      		new NegativePatternCall(body, new FlatTuple(var_pm, var___0_), ParameterTypeQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "A parameter must have a type");
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
