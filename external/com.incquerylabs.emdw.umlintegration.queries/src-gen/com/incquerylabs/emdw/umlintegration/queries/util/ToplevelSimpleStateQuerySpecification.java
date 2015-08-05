package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelSimpleStateMatch;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelSimpleStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.RegionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StateMachineQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ToplevelSimpleStateMatcher in a type-safe way.
 * 
 * @see ToplevelSimpleStateMatcher
 * @see ToplevelSimpleStateMatch
 * 
 */
@SuppressWarnings("all")
public final class ToplevelSimpleStateQuerySpecification extends BaseGeneratedEMFQuerySpecification<ToplevelSimpleStateMatcher> {
  private ToplevelSimpleStateQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ToplevelSimpleStateQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ToplevelSimpleStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelSimpleStateMatcher.on(engine);
  }
  
  @Override
  public ToplevelSimpleStateMatch newEmptyMatch() {
    return ToplevelSimpleStateMatch.newEmptyMatch();
  }
  
  @Override
  public ToplevelSimpleStateMatch newMatch(final Object... parameters) {
    return ToplevelSimpleStateMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0], (org.eclipse.uml2.uml.State) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ToplevelSimpleStateQuerySpecification INSTANCE = make();
    
    public static ToplevelSimpleStateQuerySpecification make() {
      return new ToplevelSimpleStateQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ToplevelSimpleStateQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.toplevelSimpleState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","state");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("stateMachine", "org.eclipse.uml2.uml.StateMachine"),new PParameter("state", "org.eclipse.uml2.uml.State"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      	PVariable var_state = body.getOrCreateVariableByName("state");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var_region = body.getOrCreateVariableByName("region");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_stateMachine, "stateMachine"),
      				
      		new ExportedParameter(body, var_state, "state")
      	));
      	new TypeConstraint(body, new FlatTuple(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_stateMachine), StateMachineQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_stateMachine, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine", "region")));
      	new Equality(body, var__virtual_0_, var_region);
      	new TypeConstraint(body, new FlatTuple(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_region, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region", "subvertex")));
      	new Equality(body, var__virtual_1_, var_state);
      	new NegativePatternCall(body, new FlatTuple(var_state, var___1_), RegionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
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
