package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeMatch;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.PackagedElementQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.PrimitiveTypeQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StructTypeMatcher in a type-safe way.
 * 
 * @see StructTypeMatcher
 * @see StructTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class StructTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<StructTypeMatcher> {
  private StructTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StructTypeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StructTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeMatcher.on(engine);
  }
  
  @Override
  public StructTypeMatch newEmptyMatch() {
    return StructTypeMatch.newEmptyMatch();
  }
  
  @Override
  public StructTypeMatch newMatch(final Object... parameters) {
    return StructTypeMatch.newMatch((org.eclipse.uml2.uml.DataType) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static StructTypeQuerySpecification INSTANCE = make();
    
    public static StructTypeQuerySpecification make() {
      return new StructTypeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StructTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.structType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("structType");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("structType", "org.eclipse.uml2.uml.DataType"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_structType = body.getOrCreateVariableByName("structType");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_structType, "structType")
      	));
      	new TypeConstraint(body, new FlatTuple(var_structType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
      	new PositivePatternCall(body, new FlatTuple(var_structType), PackagedElementQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_structType), PrimitiveTypeQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_structType), EnumerationQuerySpecification.instance().getInternalQueryRepresentation());
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
