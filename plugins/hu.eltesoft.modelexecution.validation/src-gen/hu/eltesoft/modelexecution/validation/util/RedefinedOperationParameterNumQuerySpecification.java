package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNumMatch;
import hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.util.ParameterOfOperationQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate RedefinedOperationParameterNumMatcher in a type-safe way.
 * 
 * @see RedefinedOperationParameterNumMatcher
 * @see RedefinedOperationParameterNumMatch
 * 
 */
@SuppressWarnings("all")
public final class RedefinedOperationParameterNumQuerySpecification extends BaseGeneratedEMFQuerySpecification<RedefinedOperationParameterNumMatcher> {
  private RedefinedOperationParameterNumQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RedefinedOperationParameterNumQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RedefinedOperationParameterNumMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedOperationParameterNumMatcher.on(engine);
  }
  
  @Override
  public RedefinedOperationParameterNumMatch newEmptyMatch() {
    return RedefinedOperationParameterNumMatch.newEmptyMatch();
  }
  
  @Override
  public RedefinedOperationParameterNumMatch newMatch(final Object... parameters) {
    return RedefinedOperationParameterNumMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (java.lang.Integer) parameters[2], (java.lang.Integer) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static RedefinedOperationParameterNumQuerySpecification INSTANCE = make();
    
    public static RedefinedOperationParameterNumQuerySpecification make() {
      return new RedefinedOperationParameterNumQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RedefinedOperationParameterNumQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNum";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("redefined","redefiner","redefinerParams","redefinedParams");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("redefined", "org.eclipse.uml2.uml.Operation"),new PParameter("redefiner", "org.eclipse.uml2.uml.Operation"),new PParameter("redefinerParams", "java.lang.Integer"),new PParameter("redefinedParams", "java.lang.Integer"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_redefined = body.getOrCreateVariableByName("redefined");
      		PVariable var_redefiner = body.getOrCreateVariableByName("redefiner");
      		PVariable var_redefinerParams = body.getOrCreateVariableByName("redefinerParams");
      		PVariable var_redefinedParams = body.getOrCreateVariableByName("redefinedParams");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		new TypeConstraint(body, new FlatTuple(var_redefiner), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_redefined, "redefined"),
      		   new ExportedParameter(body, var_redefiner, "redefiner"),
      		   new ExportedParameter(body, var_redefinerParams, "redefinerParams"),
      		   new ExportedParameter(body, var_redefinedParams, "redefinedParams")
      		));
      		// 	Operation.redefinedOperation(redefiner, redefined)
      		new TypeConstraint(body, new FlatTuple(var_redefiner), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_redefiner, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "redefinedOperation")));
      		new Equality(body, var__virtual_0_, var_redefined);
      		// 	redefinerParams == count find ParameterOfOperation(redefiner, _)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new PatternMatchCounter(body, new FlatTuple(var_redefiner, var___0_), ParameterOfOperationQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_1_);
      		new Equality(body, var_redefinerParams, var__virtual_1_);
      		// 	redefinedParams == count find ParameterOfOperation(redefined, _)
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new PatternMatchCounter(body, new FlatTuple(var_redefined, var___1_), ParameterOfOperationQuerySpecification.instance().getInternalQueryRepresentation(), var__virtual_2_);
      		new Equality(body, var_redefinedParams, var__virtual_2_);
      		// 	redefinerParams != redefinedParams
      		new Inequality(body, var_redefinerParams, var_redefinedParams);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Number of parameters ({redefinerParams}) does not the same as of redefined {redefined} ({redefinedParams})");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "redefiner"
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
