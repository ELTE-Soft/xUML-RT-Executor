package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ChildTransitionMatch;
import com.incquerylabs.emdw.umlintegration.queries.ChildTransitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.TransitionOfRegionQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ChildTransitionMatcher in a type-safe way.
 * 
 * @see ChildTransitionMatcher
 * @see ChildTransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildTransitionQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildTransitionMatcher> {
  private ChildTransitionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildTransitionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildTransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildTransitionMatcher.on(engine);
  }
  
  @Override
  public ChildTransitionMatch newEmptyMatch() {
    return ChildTransitionMatch.newEmptyMatch();
  }
  
  @Override
  public ChildTransitionMatch newMatch(final Object... parameters) {
    return ChildTransitionMatch.newMatch((org.eclipse.uml2.uml.State) parameters[0], (org.eclipse.uml2.uml.Transition) parameters[1], (org.eclipse.uml2.uml.Vertex) parameters[2], (org.eclipse.uml2.uml.Vertex) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static ChildTransitionQuerySpecification INSTANCE = make();
    
    public static ChildTransitionQuerySpecification make() {
      return new ChildTransitionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildTransitionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.childTransition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("parentState","transition","sourceState","targetState");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("parentState", "org.eclipse.uml2.uml.State"),new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("sourceState", "org.eclipse.uml2.uml.Vertex"),new PParameter("targetState", "org.eclipse.uml2.uml.Vertex"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_parentState = body.getOrCreateVariableByName("parentState");
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_sourceState = body.getOrCreateVariableByName("sourceState");
      	PVariable var_targetState = body.getOrCreateVariableByName("targetState");
      	PVariable var_region = body.getOrCreateVariableByName("region");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_parentState, "parentState"),
      				
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_sourceState, "sourceState"),
      				
      		new ExportedParameter(body, var_targetState, "targetState")
      	));
      	new TypeConstraint(body, new FlatTuple(var_parentState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_sourceState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_targetState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_parentState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_parentState, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "region")));
      	new Equality(body, var__virtual_0_, var_region);
      	new PositivePatternCall(body, new FlatTuple(var_region, var_transition, var_sourceState, var_targetState), TransitionOfRegionQuerySpecification.instance().getInternalQueryRepresentation());
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
