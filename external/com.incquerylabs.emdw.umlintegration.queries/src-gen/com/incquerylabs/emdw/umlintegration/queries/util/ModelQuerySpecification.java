package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.ModelMatch;
import com.incquerylabs.emdw.umlintegration.queries.ModelMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ModelMatcher in a type-safe way.
 * 
 * @see ModelMatcher
 * @see ModelMatch
 * 
 */
@SuppressWarnings("all")
public final class ModelQuerySpecification extends BaseGeneratedEMFQuerySpecification<ModelMatcher> {
  private ModelQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ModelQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ModelMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ModelMatcher.on(engine);
  }
  
  @Override
  public ModelMatch newEmptyMatch() {
    return ModelMatch.newEmptyMatch();
  }
  
  @Override
  public ModelMatch newMatch(final Object... parameters) {
    return ModelMatch.newMatch((org.eclipse.uml2.uml.Model) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ModelQuerySpecification INSTANCE = make();
    
    public static ModelQuerySpecification make() {
      return new ModelQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ModelQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.model";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("model");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("model", "org.eclipse.uml2.uml.Model"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_model = body.getOrCreateVariableByName("model");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_model, "model")
      	));
      	new TypeConstraint(body, new FlatTuple(var_model), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Model")));
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
