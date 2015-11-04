package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MultipleInitialTransitionsMatch;
import hu.eltesoft.modelexecution.validation.MultipleInitialTransitionsMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MultipleInitialTransitionsMatcher in a type-safe way.
 * 
 * @see MultipleInitialTransitionsMatcher
 * @see MultipleInitialTransitionsMatch
 * 
 */
@SuppressWarnings("all")
public final class MultipleInitialTransitionsQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultipleInitialTransitionsMatcher> {
  private MultipleInitialTransitionsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultipleInitialTransitionsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultipleInitialTransitionsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultipleInitialTransitionsMatcher.on(engine);
  }
  
  @Override
  public MultipleInitialTransitionsMatch newEmptyMatch() {
    return MultipleInitialTransitionsMatch.newEmptyMatch();
  }
  
  @Override
  public MultipleInitialTransitionsMatch newMatch(final Object... parameters) {
    return MultipleInitialTransitionsMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) parameters[0], (org.eclipse.uml2.uml.Transition) parameters[1], (org.eclipse.uml2.uml.Transition) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static MultipleInitialTransitionsQuerySpecification INSTANCE = make();
    
    public static MultipleInitialTransitionsQuerySpecification make() {
      return new MultipleInitialTransitionsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MultipleInitialTransitionsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MultipleInitialTransitions";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("src","tr1","tr2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("src", "org.eclipse.uml2.uml.Pseudostate"),new PParameter("tr1", "org.eclipse.uml2.uml.Transition"),new PParameter("tr2", "org.eclipse.uml2.uml.Transition"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_src = body.getOrCreateVariableByName("src");
      	PVariable var_tr1 = body.getOrCreateVariableByName("tr1");
      	PVariable var_tr2 = body.getOrCreateVariableByName("tr2");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_src, "src"),
      				
      		new ExportedParameter(body, var_tr1, "tr1"),
      				
      		new ExportedParameter(body, var_tr2, "tr2")
      	));
      	new TypeConstraint(body, new FlatTuple(var_src), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new TypeConstraint(body, new FlatTuple(var_tr1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_tr2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_src), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_src, var_tr1), InitialTransitionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_src, var_tr2), InitialTransitionQuerySpecification.instance().getInternalQueryRepresentation());
      	new Inequality(body, var_tr1, var_tr2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Multiple initial transitions from an initial pseudostate");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"tr1", 
      					"tr2"
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
