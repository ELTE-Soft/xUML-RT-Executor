package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MethodActiveMatch;
import hu.eltesoft.modelexecution.validation.MethodActiveMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MethodActiveMatcher in a type-safe way.
 * 
 * @see MethodActiveMatcher
 * @see MethodActiveMatch
 * 
 */
@SuppressWarnings("all")
public final class MethodActiveQuerySpecification extends BaseGeneratedEMFQuerySpecification<MethodActiveMatcher> {
  private MethodActiveQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MethodActiveQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MethodActiveMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MethodActiveMatcher.on(engine);
  }
  
  @Override
  public MethodActiveMatch newEmptyMatch() {
    return MethodActiveMatch.newEmptyMatch();
  }
  
  @Override
  public MethodActiveMatch newMatch(final Object... parameters) {
    return MethodActiveMatch.newMatch((org.eclipse.uml2.uml.OpaqueBehavior) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static MethodActiveQuerySpecification INSTANCE = make();
    
    public static MethodActiveQuerySpecification make() {
      return new MethodActiveQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MethodActiveQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MethodActive";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("me");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("me", "org.eclipse.uml2.uml.OpaqueBehavior"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_me = body.getOrCreateVariableByName("me");
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_me, "me")
      		));
      		// 	OpaqueBehavior.isActive(me, true)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, true);
      		new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_me, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "isActive")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Method cannot be active");
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
}
