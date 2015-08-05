package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ActionChainMatch;
import com.incquerylabs.emdw.umlintegration.queries.ActionChainMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.TransitionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ActionChainMatcher in a type-safe way.
 * 
 * @see ActionChainMatcher
 * @see ActionChainMatch
 * 
 */
@SuppressWarnings("all")
public final class ActionChainQuerySpecification extends BaseGeneratedEMFQuerySpecification<ActionChainMatcher> {
  private ActionChainQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ActionChainQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ActionChainMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ActionChainMatcher.on(engine);
  }
  
  @Override
  public ActionChainMatch newEmptyMatch() {
    return ActionChainMatch.newEmptyMatch();
  }
  
  @Override
  public ActionChainMatch newMatch(final Object... parameters) {
    return ActionChainMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0], (org.eclipse.uml2.uml.Behavior) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ActionChainQuerySpecification INSTANCE = make();
    
    public static ActionChainQuerySpecification make() {
      return new ActionChainQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ActionChainQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.actionChain";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","effect");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("effect", "org.eclipse.uml2.uml.Behavior"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_effect = body.getOrCreateVariableByName("effect");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_effect, "effect")
      	));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_effect), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior")));
      	new PositivePatternCall(body, new FlatTuple(var_transition, var___0_, var___1_), TransitionQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "effect")));
      	new Equality(body, var__virtual_0_, var_effect);
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
