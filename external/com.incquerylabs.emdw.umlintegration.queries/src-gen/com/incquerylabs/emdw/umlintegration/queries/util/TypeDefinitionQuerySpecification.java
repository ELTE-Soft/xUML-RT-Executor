package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionMatch;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.EnumerationQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.PrimitiveTypeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StructTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate TypeDefinitionMatcher in a type-safe way.
 * 
 * @see TypeDefinitionMatcher
 * @see TypeDefinitionMatch
 * 
 */
@SuppressWarnings("all")
public final class TypeDefinitionQuerySpecification extends BaseGeneratedEMFQuerySpecification<TypeDefinitionMatcher> {
  private TypeDefinitionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TypeDefinitionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TypeDefinitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionMatcher.on(engine);
  }
  
  @Override
  public TypeDefinitionMatch newEmptyMatch() {
    return TypeDefinitionMatch.newEmptyMatch();
  }
  
  @Override
  public TypeDefinitionMatch newMatch(final Object... parameters) {
    return TypeDefinitionMatch.newMatch((org.eclipse.uml2.uml.Type) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static TypeDefinitionQuerySpecification INSTANCE = make();
    
    public static TypeDefinitionQuerySpecification make() {
      return new TypeDefinitionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TypeDefinitionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.typeDefinition";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("type");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("type", "org.eclipse.uml2.uml.Type"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_type, "type")
      	));
      	new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
      	new PositivePatternCall(body, new FlatTuple(var_type), PrimitiveTypeQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_type, "type")
      	));
      	new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
      	new PositivePatternCall(body, new FlatTuple(var_type), StructTypeQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_type, "type")
      	));
      	new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
      	new PositivePatternCall(body, new FlatTuple(var_type), EnumerationQuerySpecification.instance().getInternalQueryRepresentation());
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
