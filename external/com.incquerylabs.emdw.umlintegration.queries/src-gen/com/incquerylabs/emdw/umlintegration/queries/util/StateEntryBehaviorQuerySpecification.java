package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StateEntryBehaviorMatch;
import com.incquerylabs.emdw.umlintegration.queries.StateEntryBehaviorMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.UmlStateQuerySpecification;
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
 * A pattern-specific query specification that can instantiate StateEntryBehaviorMatcher in a type-safe way.
 * 
 * @see StateEntryBehaviorMatcher
 * @see StateEntryBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class StateEntryBehaviorQuerySpecification extends BaseGeneratedEMFQuerySpecification<StateEntryBehaviorMatcher> {
  private StateEntryBehaviorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateEntryBehaviorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StateEntryBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateEntryBehaviorMatcher.on(engine);
  }
  
  @Override
  public StateEntryBehaviorMatch newEmptyMatch() {
    return StateEntryBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public StateEntryBehaviorMatch newMatch(final Object... parameters) {
    return StateEntryBehaviorMatch.newMatch((org.eclipse.uml2.uml.State) parameters[0], (org.eclipse.uml2.uml.Behavior) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static StateEntryBehaviorQuerySpecification INSTANCE = make();
    
    public static StateEntryBehaviorQuerySpecification make() {
      return new StateEntryBehaviorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StateEntryBehaviorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.stateEntryBehavior";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("state","entry");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("entry", "org.eclipse.uml2.uml.Behavior"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_state = body.getOrCreateVariableByName("state");
      	PVariable var_entry = body.getOrCreateVariableByName("entry");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_state, "state"),
      				
      		new ExportedParameter(body, var_entry, "entry")
      	));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_entry), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior")));
      	new PositivePatternCall(body, new FlatTuple(var_state), UmlStateQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new TypeConstraint(body, new FlatTuple(var_state, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "entry")));
      	new Equality(body, var__virtual_0_, var_entry);
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
