package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegionMatch;
import hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegionMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StateMachineMustHaveRegionMatcher in a type-safe way.
 * 
 * @see StateMachineMustHaveRegionMatcher
 * @see StateMachineMustHaveRegionMatch
 * 
 */
@SuppressWarnings("all")
public final class StateMachineMustHaveRegionQuerySpecification extends BaseGeneratedEMFQuerySpecification<StateMachineMustHaveRegionMatcher> {
  private StateMachineMustHaveRegionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateMachineMustHaveRegionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateMachineMustHaveRegionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMustHaveRegionMatcher.on(engine);
  }
  
  @Override
  public StateMachineMustHaveRegionMatch newEmptyMatch() {
    return StateMachineMustHaveRegionMatch.newEmptyMatch();
  }
  
  @Override
  public StateMachineMustHaveRegionMatch newMatch(final Object... parameters) {
    return StateMachineMustHaveRegionMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static StateMachineMustHaveRegionQuerySpecification INSTANCE = make();
    
    public static StateMachineMustHaveRegionQuerySpecification make() {
      return new StateMachineMustHaveRegionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StateMachineMustHaveRegionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sm");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sm", "org.eclipse.uml2.uml.StateMachine"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sm = body.getOrCreateVariableByName("sm");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sm, "sm")
      	));
      	new TypeConstraint(body, new FlatTuple(var_sm), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new NegativePatternCall(body, new FlatTuple(var_sm, var___0_), StateMachineRegionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "State machine without region");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"sm"
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
