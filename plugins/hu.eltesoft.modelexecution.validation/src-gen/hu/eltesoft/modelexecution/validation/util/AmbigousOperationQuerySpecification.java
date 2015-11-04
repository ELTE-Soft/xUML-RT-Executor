package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationOverrideQuerySpecification;
import hu.eltesoft.modelexecution.validation.AmbigousOperationMatch;
import hu.eltesoft.modelexecution.validation.AmbigousOperationMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AmbigousOperationMatcher in a type-safe way.
 * 
 * @see AmbigousOperationMatcher
 * @see AmbigousOperationMatch
 * 
 */
@SuppressWarnings("all")
public final class AmbigousOperationQuerySpecification extends BaseGeneratedEMFQuerySpecification<AmbigousOperationMatcher> {
  private AmbigousOperationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AmbigousOperationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AmbigousOperationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AmbigousOperationMatcher.on(engine);
  }
  
  @Override
  public AmbigousOperationMatch newEmptyMatch() {
    return AmbigousOperationMatch.newEmptyMatch();
  }
  
  @Override
  public AmbigousOperationMatch newMatch(final Object... parameters) {
    return AmbigousOperationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static AmbigousOperationQuerySpecification INSTANCE = make();
    
    public static AmbigousOperationQuerySpecification make() {
      return new AmbigousOperationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AmbigousOperationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.AmbigousOperation";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cl","overridden");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cl", "org.eclipse.uml2.uml.Class"),new PParameter("overridden", "org.eclipse.uml2.uml.Operation"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_cl = body.getOrCreateVariableByName("cl");
      	PVariable var_overridden = body.getOrCreateVariableByName("overridden");
      	PVariable var_overrider1 = body.getOrCreateVariableByName("overrider1");
      	PVariable var_overrider2 = body.getOrCreateVariableByName("overrider2");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_cl, "cl"),
      				
      		new ExportedParameter(body, var_overridden, "overridden")
      	));
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_overridden), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      	new PositivePatternCall(body, new FlatTuple(var_cl, var_overridden, var_overrider1), OperationOverrideQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_cl, var_overridden, var_overrider2), OperationOverrideQuerySpecification.instance().getInternalQueryRepresentation());
      	new Inequality(body, var_overrider1, var_overrider2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Multiple possible overrides for operation {overridden}");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"cl"
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
