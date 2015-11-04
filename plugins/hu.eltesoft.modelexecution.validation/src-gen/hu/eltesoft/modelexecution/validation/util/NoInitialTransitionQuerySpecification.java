package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.NoInitialTransitionMatch;
import hu.eltesoft.modelexecution.validation.NoInitialTransitionMatcher;
import hu.eltesoft.modelexecution.validation.util.InitialStateQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.InitialTransitionQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NoInitialTransitionMatcher in a type-safe way.
 * 
 * @see NoInitialTransitionMatcher
 * @see NoInitialTransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class NoInitialTransitionQuerySpecification extends BaseGeneratedEMFQuerySpecification<NoInitialTransitionMatcher> {
  private NoInitialTransitionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NoInitialTransitionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NoInitialTransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NoInitialTransitionMatcher.on(engine);
  }
  
  @Override
  public NoInitialTransitionMatch newEmptyMatch() {
    return NoInitialTransitionMatch.newEmptyMatch();
  }
  
  @Override
  public NoInitialTransitionMatch newMatch(final Object... parameters) {
    return NoInitialTransitionMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static NoInitialTransitionQuerySpecification INSTANCE = make();
    
    public static NoInitialTransitionQuerySpecification make() {
      return new NoInitialTransitionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NoInitialTransitionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.NoInitialTransition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("src");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("src", "org.eclipse.uml2.uml.Pseudostate"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_src = body.getOrCreateVariableByName("src");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_src, "src")
      	));
      	new TypeConstraint(body, new FlatTuple(var_src), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_src), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_src, var___1_), InitialTransitionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "No transition from an initial pseudostate");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"src"
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
