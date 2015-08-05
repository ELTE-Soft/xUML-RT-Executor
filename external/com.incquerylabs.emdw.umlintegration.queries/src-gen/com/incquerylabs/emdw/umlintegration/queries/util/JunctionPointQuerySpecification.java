package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.JunctionPointMatch;
import com.incquerylabs.emdw.umlintegration.queries.JunctionPointMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ChildJunctionPointQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.ToplevelJunctionPointQuerySpecification;
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
 * A pattern-specific query specification that can instantiate JunctionPointMatcher in a type-safe way.
 * 
 * @see JunctionPointMatcher
 * @see JunctionPointMatch
 * 
 */
@SuppressWarnings("all")
public final class JunctionPointQuerySpecification extends BaseGeneratedEMFQuerySpecification<JunctionPointMatcher> {
  private JunctionPointQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static JunctionPointQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected JunctionPointMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return JunctionPointMatcher.on(engine);
  }
  
  @Override
  public JunctionPointMatch newEmptyMatch() {
    return JunctionPointMatch.newEmptyMatch();
  }
  
  @Override
  public JunctionPointMatch newMatch(final Object... parameters) {
    return JunctionPointMatch.newMatch((org.eclipse.uml2.uml.Pseudostate) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static JunctionPointQuerySpecification INSTANCE = make();
    
    public static JunctionPointQuerySpecification make() {
      return new JunctionPointQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static JunctionPointQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.junctionPoint";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pseudostate");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pseudostate", "org.eclipse.uml2.uml.Pseudostate"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_pseudostate = body.getOrCreateVariableByName("pseudostate");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pseudostate, "pseudostate")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pseudostate), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_pseudostate), ToplevelJunctionPointQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_pseudostate = body.getOrCreateVariableByName("pseudostate");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pseudostate, "pseudostate")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pseudostate), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate")));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_pseudostate), ChildJunctionPointQuerySpecification.instance().getInternalQueryRepresentation());
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
