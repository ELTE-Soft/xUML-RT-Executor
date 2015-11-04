package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MethodReentrantMatch;
import hu.eltesoft.modelexecution.validation.MethodReentrantMatcher;
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
 * A pattern-specific query specification that can instantiate MethodReentrantMatcher in a type-safe way.
 * 
 * @see MethodReentrantMatcher
 * @see MethodReentrantMatch
 * 
 */
@SuppressWarnings("all")
public final class MethodReentrantQuerySpecification extends BaseGeneratedEMFQuerySpecification<MethodReentrantMatcher> {
  private MethodReentrantQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MethodReentrantQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MethodReentrantMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MethodReentrantMatcher.on(engine);
  }
  
  @Override
  public MethodReentrantMatch newEmptyMatch() {
    return MethodReentrantMatch.newEmptyMatch();
  }
  
  @Override
  public MethodReentrantMatch newMatch(final Object... parameters) {
    return MethodReentrantMatch.newMatch((org.eclipse.uml2.uml.OpaqueBehavior) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static MethodReentrantQuerySpecification INSTANCE = make();
    
    public static MethodReentrantQuerySpecification make() {
      return new MethodReentrantQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MethodReentrantQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MethodReentrant";
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
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_me, "me")
      	));
      	new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      	new ConstantValue(body, var__virtual_0_, false);
      	new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      	new TypeConstraint(body, new FlatTuple(var_me, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior", "isReentrant")));
      	new Equality(body, var__virtual_1_, var__virtual_0_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Method must be reentrant");
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
