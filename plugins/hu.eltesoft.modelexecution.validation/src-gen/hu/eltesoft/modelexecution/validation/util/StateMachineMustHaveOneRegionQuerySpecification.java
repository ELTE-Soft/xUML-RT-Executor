package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegionMatch;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegionMatcher;
import hu.eltesoft.modelexecution.validation.util.StateMachineRegionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate StateMachineMustHaveOneRegionMatcher in a type-safe way.
 * 
 * @see StateMachineMustHaveOneRegionMatcher
 * @see StateMachineMustHaveOneRegionMatch
 * 
 */
@SuppressWarnings("all")
public final class StateMachineMustHaveOneRegionQuerySpecification extends BaseGeneratedEMFQuerySpecification<StateMachineMustHaveOneRegionMatcher> {
  private StateMachineMustHaveOneRegionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateMachineMustHaveOneRegionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateMachineMustHaveOneRegionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMustHaveOneRegionMatcher.on(engine);
  }
  
  @Override
  public StateMachineMustHaveOneRegionMatch newEmptyMatch() {
    return StateMachineMustHaveOneRegionMatch.newEmptyMatch();
  }
  
  @Override
  public StateMachineMustHaveOneRegionMatch newMatch(final Object... parameters) {
    return StateMachineMustHaveOneRegionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0], (org.eclipse.uml2.uml.Region) parameters[1], (org.eclipse.uml2.uml.Region) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static StateMachineMustHaveOneRegionQuerySpecification INSTANCE = make();
    
    public static StateMachineMustHaveOneRegionQuerySpecification make() {
      return new StateMachineMustHaveOneRegionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StateMachineMustHaveOneRegionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sm","rg1","rg2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sm", "org.eclipse.uml2.uml.StateMachine"),new PParameter("rg1", "org.eclipse.uml2.uml.Region"),new PParameter("rg2", "org.eclipse.uml2.uml.Region"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sm = body.getOrCreateVariableByName("sm");
      	PVariable var_rg1 = body.getOrCreateVariableByName("rg1");
      	PVariable var_rg2 = body.getOrCreateVariableByName("rg2");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sm, "sm"),
      				
      		new ExportedParameter(body, var_rg1, "rg1"),
      				
      		new ExportedParameter(body, var_rg2, "rg2")
      	));
      	new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_rg1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_rg2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new PositivePatternCall(body, new FlatTuple(var_sm, var_rg1), StateMachineRegionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_sm, var_rg2), StateMachineRegionQuerySpecification.instance().getInternalQueryRepresentation());
      	new Inequality(body, var_rg1, var_rg2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Multiple regions for a state machine");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"rg1", 
      					"rg2"
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
