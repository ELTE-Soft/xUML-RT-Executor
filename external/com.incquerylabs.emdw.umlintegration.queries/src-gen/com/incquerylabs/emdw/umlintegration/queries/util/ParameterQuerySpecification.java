package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ParameterMatch;
import com.incquerylabs.emdw.umlintegration.queries.ParameterMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.ParameterInOperationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ParameterMatcher in a type-safe way.
 * 
 * @see ParameterMatcher
 * @see ParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class ParameterQuerySpecification extends BaseGeneratedEMFQuerySpecification<ParameterMatcher> {
  private ParameterQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParameterQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ParameterMatcher.on(engine);
  }
  
  @Override
  public ParameterMatch newEmptyMatch() {
    return ParameterMatch.newEmptyMatch();
  }
  
  @Override
  public ParameterMatch newMatch(final Object... parameters) {
    return ParameterMatch.newMatch((org.eclipse.uml2.uml.Parameter) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ParameterQuerySpecification INSTANCE = make();
    
    public static ParameterQuerySpecification make() {
      return new ParameterQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParameterQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.parameter";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("parameter");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_parameter, "parameter")
      	));
      	new PositivePatternCall(body, new FlatTuple(var___0_, var_parameter), ParameterInOperationQuerySpecification.instance().getInternalQueryRepresentation());
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
