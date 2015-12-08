package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.validation.OperationMethodParameterNumMatch;
import hu.eltesoft.modelexecution.validation.OperationMethodParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.util.ParameterOfBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ParameterOfOperationQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate OperationMethodParameterNumMatcher in a type-safe way.
 * 
 * @see OperationMethodParameterNumMatcher
 * @see OperationMethodParameterNumMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationMethodParameterNumQuerySpecification extends BaseGeneratedEMFQuerySpecification<OperationMethodParameterNumMatcher> {
  private OperationMethodParameterNumQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationMethodParameterNumQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected OperationMethodParameterNumMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationMethodParameterNumMatcher.on(engine);
  }
  
  @Override
  public OperationMethodParameterNumMatch newEmptyMatch() {
    return OperationMethodParameterNumMatch.newEmptyMatch();
  }
  
  @Override
  public OperationMethodParameterNumMatch newMatch(final Object... parameters) {
    return OperationMethodParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (org.eclipse.uml2.uml.Behavior) parameters[1], (java.lang.Integer) parameters[2], (java.lang.Integer) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static OperationMethodParameterNumQuerySpecification INSTANCE = make();
    
    public static OperationMethodParameterNumQuerySpecification make() {
      return new OperationMethodParameterNumQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static OperationMethodParameterNumQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.OperationMethodParameterNum";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("op","method","opParams","methodParams");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("op", "org.eclipse.uml2.uml.Operation"),new PParameter("method", "org.eclipse.uml2.uml.Behavior"),new PParameter("opParams", "java.lang.Integer"),new PParameter("methodParams", "java.lang.Integer"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_op = body.getOrCreateVariableByName("op");
      		PVariable var_method = body.getOrCreateVariableByName("method");
      		PVariable var_opParams = body.getOrCreateVariableByName("opParams");
      		PVariable var_methodParams = body.getOrCreateVariableByName("methodParams");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		new TypeConstraint(body, new FlatTuple(var_method), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op"),
      		   new ExportedParameter(body, var_method, "method"),
      		   new ExportedParameter(body, var_opParams, "opParams"),
      		   new ExportedParameter(body, var_methodParams, "methodParams")
      		));
      		// 	find Method(_, op, method)
      		new PositivePatternCall(body, new FlatTuple(var___0_, var_op, var_method), MethodQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	opParams == count find ParameterOfOperation(op, _)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new PatternMatchCounter(body, new FlatTuple(var_op, var___1_), ParameterOfOperationQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_0_);
      		new Equality(body, var_opParams, var__virtual_0_);
      		// 	methodParams == count find ParameterOfBehavior(method, _)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new PatternMatchCounter(body, new FlatTuple(var_method, var___2_), ParameterOfBehaviorQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_1_);
      		new Equality(body, var_methodParams, var__virtual_1_);
      		// 	opParams != methodParams
      		new Inequality(body, var_opParams, var_methodParams);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Number of parameters ({methodParams}) does not the same as specification {op} ({opParams})");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "method"
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
