package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
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
 * A pattern-specific query specification that can instantiate TransitionOfRegionMatcher in a type-safe way.
 * 
 * @see TransitionOfRegionMatcher
 * @see TransitionOfRegionMatch
 * 
 */
@SuppressWarnings("all")
final class TransitionOfRegionQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private TransitionOfRegionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionOfRegionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncQueryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  private static class LazyHolder {
    private final static TransitionOfRegionQuerySpecification INSTANCE = make();
    
    public static TransitionOfRegionQuerySpecification make() {
      return new TransitionOfRegionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TransitionOfRegionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.transitionOfRegion";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("region","transition","sourceState","targetState");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("sourceState", "org.eclipse.uml2.uml.Vertex"),new PParameter("targetState", "org.eclipse.uml2.uml.Vertex"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_region = body.getOrCreateVariableByName("region");
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_sourceState = body.getOrCreateVariableByName("sourceState");
      	PVariable var_targetState = body.getOrCreateVariableByName("targetState");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_region, "region"),
      				
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_sourceState, "sourceState"),
      				
      		new ExportedParameter(body, var_targetState, "targetState")
      	));
      	new TypeConstraint(body, new FlatTuple(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_sourceState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_targetState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex")));
      	new TypeConstraint(body, new FlatTuple(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_region, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region", "transition")));
      	new Equality(body, var__virtual_0_, var_transition);
      	new TypeConstraint(body, new FlatTuple(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_region, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region", "subvertex")));
      	new Equality(body, var__virtual_1_, var_sourceState);
      	new TypeConstraint(body, new FlatTuple(var_region), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_region, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region", "subvertex")));
      	new Equality(body, var__virtual_2_, var_targetState);
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_transition, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source")));
      	new Equality(body, var__virtual_3_, var_sourceState);
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_transition, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "target")));
      	new Equality(body, var__virtual_4_, var_targetState);
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
