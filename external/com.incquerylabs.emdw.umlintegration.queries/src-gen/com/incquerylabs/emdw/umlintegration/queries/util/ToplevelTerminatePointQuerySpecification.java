package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelTerminatePointMatch;
import com.incquerylabs.emdw.umlintegration.queries.ToplevelTerminatePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.PseudostateOfRegionQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ToplevelTerminatePointMatcher in a type-safe way.
 * 
 * @see ToplevelTerminatePointMatcher
 * @see ToplevelTerminatePointMatch
 * 
 */
@SuppressWarnings("all")
public final class ToplevelTerminatePointQuerySpecification extends BaseGeneratedEMFQuerySpecification<ToplevelTerminatePointMatcher> {
  private ToplevelTerminatePointQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ToplevelTerminatePointQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ToplevelTerminatePointMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ToplevelTerminatePointMatcher.on(engine);
  }
  
  @Override
  public ToplevelTerminatePointMatch newEmptyMatch() {
    return ToplevelTerminatePointMatch.newEmptyMatch();
  }
  
  @Override
  public ToplevelTerminatePointMatch newMatch(final Object... parameters) {
    return ToplevelTerminatePointMatch.newMatch((org.eclipse.uml2.uml.StateMachine) parameters[0], (org.eclipse.uml2.uml.Pseudostate) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ToplevelTerminatePointQuerySpecification INSTANCE = make();
    
    public static ToplevelTerminatePointQuerySpecification make() {
      return new ToplevelTerminatePointQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ToplevelTerminatePointQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.toplevelTerminatePoint";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("stateMachine","pseudostate");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("stateMachine", "org.eclipse.uml2.uml.StateMachine"),new PParameter("pseudostate", "org.eclipse.uml2.uml.Pseudostate"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      	PVariable var_pseudostate = body.getOrCreateVariableByName("pseudostate");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var_region = body.getOrCreateVariableByName("region");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_stateMachine, "stateMachine"),
      				
      		new ExportedParameter(body, var_pseudostate, "pseudostate")
      	));
      	new TypeConstraint(body, new FlatTuple(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_pseudostate), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_stateMachine), StateMachineQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_stateMachine, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine", "region")));
      	new Equality(body, var__virtual_0_, var_region);
      	new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.PseudostateKind.get("terminate"));
      	new PositivePatternCall(body, new FlatTuple(var_region, var_pseudostate, var__virtual_1_), PseudostateOfRegionQuerySpecification.instance().getInternalQueryRepresentation());
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
