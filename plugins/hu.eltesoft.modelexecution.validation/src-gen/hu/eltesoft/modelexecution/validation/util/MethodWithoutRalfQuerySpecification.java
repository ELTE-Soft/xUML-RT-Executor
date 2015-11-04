package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MethodWithoutRalfMatch;
import hu.eltesoft.modelexecution.validation.MethodWithoutRalfMatcher;
import hu.eltesoft.modelexecution.validation.util.MethodRalfQuerySpecification;
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
 * A pattern-specific query specification that can instantiate MethodWithoutRalfMatcher in a type-safe way.
 * 
 * @see MethodWithoutRalfMatcher
 * @see MethodWithoutRalfMatch
 * 
 */
@SuppressWarnings("all")
public final class MethodWithoutRalfQuerySpecification extends BaseGeneratedEMFQuerySpecification<MethodWithoutRalfMatcher> {
  private MethodWithoutRalfQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MethodWithoutRalfQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MethodWithoutRalfMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MethodWithoutRalfMatcher.on(engine);
  }
  
  @Override
  public MethodWithoutRalfMatch newEmptyMatch() {
    return MethodWithoutRalfMatch.newEmptyMatch();
  }
  
  @Override
  public MethodWithoutRalfMatch newMatch(final Object... parameters) {
    return MethodWithoutRalfMatch.newMatch((org.eclipse.uml2.uml.OpaqueBehavior) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static MethodWithoutRalfQuerySpecification INSTANCE = make();
    
    public static MethodWithoutRalfQuerySpecification make() {
      return new MethodWithoutRalfQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MethodWithoutRalfQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MethodWithoutRalf";
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
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_me, "me")
      	));
      	new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior")));
      	new NegativePatternCall(body, new FlatTuple(var_me), MethodRalfQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "The method must have rALF language implementation");
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
