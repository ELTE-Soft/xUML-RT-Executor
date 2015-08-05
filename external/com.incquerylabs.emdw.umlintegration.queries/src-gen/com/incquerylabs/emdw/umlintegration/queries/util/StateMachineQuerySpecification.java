package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StateMachineMatch;
import com.incquerylabs.emdw.umlintegration.queries.StateMachineMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StateMachineMatcher in a type-safe way.
 * 
 * @see StateMachineMatcher
 * @see StateMachineMatch
 * 
 */
@SuppressWarnings("all")
public final class StateMachineQuerySpecification extends BaseGeneratedEMFQuerySpecification<StateMachineMatcher> {
  private StateMachineQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateMachineQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateMachineMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateMachineMatcher.on(engine);
  }
  
  @Override
  public StateMachineMatch newEmptyMatch() {
    return StateMachineMatch.newEmptyMatch();
  }
  
  @Override
  public StateMachineMatch newMatch(final Object... parameters) {
    return StateMachineMatch.newMatch((org.eclipse.uml2.uml.BehavioredClassifier) parameters[0], (org.eclipse.uml2.uml.StateMachine) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static StateMachineQuerySpecification INSTANCE = make();
    
    public static StateMachineQuerySpecification make() {
      return new StateMachineQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StateMachineQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.stateMachine";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("behavioredClassifier","stateMachine");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("behavioredClassifier", "org.eclipse.uml2.uml.BehavioredClassifier"),new PParameter("stateMachine", "org.eclipse.uml2.uml.StateMachine"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_behavioredClassifier = body.getOrCreateVariableByName("behavioredClassifier");
      	PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_behavioredClassifier, "behavioredClassifier"),
      				
      		new ExportedParameter(body, var_stateMachine, "stateMachine")
      	));
      	new TypeConstraint(body, new FlatTuple(var_behavioredClassifier), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier")));
      	new TypeConstraint(body, new FlatTuple(var_stateMachine), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine")));
      	new TypeConstraint(body, new FlatTuple(var_behavioredClassifier), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier")));
      	new TypeConstraint(body, new FlatTuple(var_behavioredClassifier, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "classifierBehavior")));
      	new Equality(body, var__virtual_0_, var_stateMachine);
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
