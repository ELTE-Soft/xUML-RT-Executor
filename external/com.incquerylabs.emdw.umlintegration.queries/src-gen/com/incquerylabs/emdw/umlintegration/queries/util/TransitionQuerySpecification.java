package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.TransitionMatch;
import com.incquerylabs.emdw.umlintegration.queries.TransitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildTransitionQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelTransitionQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TransitionMatcher in a type-safe way.
 * 
 * @see TransitionMatcher
 * @see TransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionQuerySpecification extends BaseGeneratedEMFQuerySpecification<TransitionMatcher> {
  private TransitionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  @Override
  public TransitionMatch newEmptyMatch() {
    return TransitionMatch.newEmptyMatch();
  }
  
  @Override
  public TransitionMatch newMatch(final Object... parameters) {
    return TransitionMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0], (org.eclipse.uml2.uml.Vertex) parameters[1], (org.eclipse.uml2.uml.Vertex) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static TransitionQuerySpecification INSTANCE = make();
    
    public static TransitionQuerySpecification make() {
      return new TransitionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TransitionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.transition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","sourceState","targetState");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("sourceState", "org.eclipse.uml2.uml.Vertex"),new PParameter("targetState", "org.eclipse.uml2.uml.Vertex"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_sourceState = body.getOrCreateVariableByName("sourceState");
      	PVariable var_targetState = body.getOrCreateVariableByName("targetState");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_sourceState, "sourceState"),
      				
      		new ExportedParameter(body, var_targetState, "targetState")
      	));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_sourceState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_targetState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_transition, var_sourceState, var_targetState), ToplevelTransitionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_sourceState = body.getOrCreateVariableByName("sourceState");
      	PVariable var_targetState = body.getOrCreateVariableByName("targetState");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_sourceState, "sourceState"),
      				
      		new ExportedParameter(body, var_targetState, "targetState")
      	));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_sourceState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_targetState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_transition, var_sourceState, var_targetState), ChildTransitionQuerySpecification.instance().getInternalQueryRepresentation());
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
