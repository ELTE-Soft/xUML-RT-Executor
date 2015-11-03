package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.MultipleInitialStateMatch;
import hu.eltesoft.modelexecution.validation.MultipleInitialStateMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate MultipleInitialStateMatcher in a type-safe way.
 * 
 * @see MultipleInitialStateMatcher
 * @see MultipleInitialStateMatch
 * 
 */
@SuppressWarnings("all")
public final class MultipleInitialStateQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultipleInitialStateMatcher> {
  private MultipleInitialStateQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultipleInitialStateQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultipleInitialStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultipleInitialStateMatcher.on(engine);
  }
  
  @Override
  public MultipleInitialStateMatch newEmptyMatch() {
    return MultipleInitialStateMatch.newEmptyMatch();
  }
  
  @Override
  public MultipleInitialStateMatch newMatch(final Object... parameters) {
    return MultipleInitialStateMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.Pseudostate) parameters[1], (org.eclipse.uml2.uml.Pseudostate) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static MultipleInitialStateQuerySpecification INSTANCE = make();
    
    public static MultipleInitialStateQuerySpecification make() {
      return new MultipleInitialStateQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MultipleInitialStateQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.MultipleInitialState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rg","init1","init2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rg", "org.eclipse.uml2.uml.Region"),new PParameter("init1", "org.eclipse.uml2.uml.Pseudostate"),new PParameter("init2", "org.eclipse.uml2.uml.Pseudostate"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_rg = body.getOrCreateVariableByName("rg");
      	PVariable var_init1 = body.getOrCreateVariableByName("init1");
      	PVariable var_init2 = body.getOrCreateVariableByName("init2");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_rg, "rg"),
      				
      		new ExportedParameter(body, var_init1, "init1"),
      				
      		new ExportedParameter(body, var_init2, "init2")
      	));
      	new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_init1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new TypeConstraint(body, new FlatTuple(var_init2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new PositivePatternCall(body, new FlatTuple(var_rg, var_init1), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_rg, var_init2), InitialStateQuerySpecification.instance().getInternalQueryRepresentation());
      	new Inequality(body, var_init1, var_init2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "State machine regions cannot have multiple initial pseudostate");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"init1", 
      					"init2"
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
