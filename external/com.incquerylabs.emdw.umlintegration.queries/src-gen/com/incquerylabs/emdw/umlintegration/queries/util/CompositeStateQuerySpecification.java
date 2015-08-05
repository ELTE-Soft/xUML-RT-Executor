package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.CompositeStateMatch;
import com.incquerylabs.emdw.umlintegration.queries.CompositeStateMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildCompositeStateQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelCompositeStateQuerySpecification;
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
 * A pattern-specific query specification that can instantiate CompositeStateMatcher in a type-safe way.
 * 
 * @see CompositeStateMatcher
 * @see CompositeStateMatch
 * 
 */
@SuppressWarnings("all")
public final class CompositeStateQuerySpecification extends BaseGeneratedEMFQuerySpecification<CompositeStateMatcher> {
  private CompositeStateQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CompositeStateQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CompositeStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CompositeStateMatcher.on(engine);
  }
  
  @Override
  public CompositeStateMatch newEmptyMatch() {
    return CompositeStateMatch.newEmptyMatch();
  }
  
  @Override
  public CompositeStateMatch newMatch(final Object... parameters) {
    return CompositeStateMatch.newMatch((org.eclipse.uml2.uml.State) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static CompositeStateQuerySpecification INSTANCE = make();
    
    public static CompositeStateQuerySpecification make() {
      return new CompositeStateQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static CompositeStateQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.compositeState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("state");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("state", "org.eclipse.uml2.uml.State"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_state = body.getOrCreateVariableByName("state");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_state, "state")
      	));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_state), ToplevelCompositeStateQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_state = body.getOrCreateVariableByName("state");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_state, "state")
      	));
      	new TypeConstraint(body, new FlatTuple(var_state), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_state), ChildCompositeStateQuerySpecification.instance().getInternalQueryRepresentation());
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
