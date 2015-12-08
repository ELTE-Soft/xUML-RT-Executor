package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RegionWithoutInitialStateMatch;
import hu.eltesoft.modelexecution.validation.RegionWithoutInitialStateMatcher;
import hu.eltesoft.modelexecution.validation.util.InitialStateQuerySpecification;
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
 * A pattern-specific query specification that can instantiate RegionWithoutInitialStateMatcher in a type-safe way.
 * 
 * @see RegionWithoutInitialStateMatcher
 * @see RegionWithoutInitialStateMatch
 * 
 */
@SuppressWarnings("all")
public final class RegionWithoutInitialStateQuerySpecification extends BaseGeneratedEMFQuerySpecification<RegionWithoutInitialStateMatcher> {
  private RegionWithoutInitialStateQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RegionWithoutInitialStateQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RegionWithoutInitialStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RegionWithoutInitialStateMatcher.on(engine);
  }
  
  @Override
  public RegionWithoutInitialStateMatch newEmptyMatch() {
    return RegionWithoutInitialStateMatch.newEmptyMatch();
  }
  
  @Override
  public RegionWithoutInitialStateMatch newMatch(final Object... parameters) {
    return RegionWithoutInitialStateMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static RegionWithoutInitialStateQuerySpecification INSTANCE = make();
    
    public static RegionWithoutInitialStateQuerySpecification make() {
      return new RegionWithoutInitialStateQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RegionWithoutInitialStateQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RegionWithoutInitialState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rg");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rg", "org.eclipse.uml2.uml.Region"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_rg = body.getOrCreateVariableByName("rg");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_rg, "rg")
      		));
      		// 	neg find InitialState(rg, _)
      		new NegativePatternCall(body, new FlatTuple(var_rg, var___0_), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "State machine regions must have an initial pseudostate");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "rg"
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
