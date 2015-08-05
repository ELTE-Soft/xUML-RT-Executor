package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ChildTerminatePointMatch;
import com.incquerylabs.emdw.umlintegration.queries.ChildTerminatePointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.PseudostateOfRegionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ChildTerminatePointMatcher in a type-safe way.
 * 
 * @see ChildTerminatePointMatcher
 * @see ChildTerminatePointMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildTerminatePointQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildTerminatePointMatcher> {
  private ChildTerminatePointQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildTerminatePointQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildTerminatePointMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildTerminatePointMatcher.on(engine);
  }
  
  @Override
  public ChildTerminatePointMatch newEmptyMatch() {
    return ChildTerminatePointMatch.newEmptyMatch();
  }
  
  @Override
  public ChildTerminatePointMatch newMatch(final Object... parameters) {
    return ChildTerminatePointMatch.newMatch((org.eclipse.uml2.uml.State) parameters[0], (org.eclipse.uml2.uml.Pseudostate) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ChildTerminatePointQuerySpecification INSTANCE = make();
    
    public static ChildTerminatePointQuerySpecification make() {
      return new ChildTerminatePointQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildTerminatePointQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.childTerminatePoint";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("state","pseudostate");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("pseudostate", "org.eclipse.uml2.uml.Pseudostate"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_state = body.getOrCreateVariableByName("state");
      	PVariable var_pseudostate = body.getOrCreateVariableByName("pseudostate");
      	PVariable var_region = body.getOrCreateVariableByName("region");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_state, "state"),
      				
      		new ExportedParameter(body, var_pseudostate, "pseudostate")
      	));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_pseudostate), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_state, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "region")));
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
