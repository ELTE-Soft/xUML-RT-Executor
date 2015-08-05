package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.TypeDefinitionQuerySpecification;
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
 * A pattern-specific query specification that can instantiate TypeDefinitionInComponentMatcher in a type-safe way.
 * 
 * @see TypeDefinitionInComponentMatcher
 * @see TypeDefinitionInComponentMatch
 * 
 */
@SuppressWarnings("all")
public final class TypeDefinitionInComponentQuerySpecification extends BaseGeneratedEMFQuerySpecification<TypeDefinitionInComponentMatcher> {
  private TypeDefinitionInComponentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TypeDefinitionInComponentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TypeDefinitionInComponentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionInComponentMatcher.on(engine);
  }
  
  @Override
  public TypeDefinitionInComponentMatch newEmptyMatch() {
    return TypeDefinitionInComponentMatch.newEmptyMatch();
  }
  
  @Override
  public TypeDefinitionInComponentMatch newMatch(final Object... parameters) {
    return TypeDefinitionInComponentMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0], (org.eclipse.uml2.uml.Type) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TypeDefinitionInComponentQuerySpecification INSTANCE = make();
    
    public static TypeDefinitionInComponentQuerySpecification make() {
      return new TypeDefinitionInComponentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TypeDefinitionInComponentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInComponent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlComponent","type");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlComponent", "org.eclipse.uml2.uml.Component"),new PParameter("type", "org.eclipse.uml2.uml.Type"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlComponent = body.getOrCreateVariableByName("umlComponent");
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlComponent, "umlComponent"),
      				
      		new ExportedParameter(body, var_type, "type")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlComponent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
      	new PositivePatternCall(body, new FlatTuple(var_type), TypeDefinitionQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_umlComponent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlComponent, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component", "packagedElement")));
      	new Equality(body, var__virtual_0_, var_type);
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
