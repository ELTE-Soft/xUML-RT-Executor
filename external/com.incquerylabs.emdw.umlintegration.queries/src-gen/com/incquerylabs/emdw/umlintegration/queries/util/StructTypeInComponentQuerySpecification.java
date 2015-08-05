package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInComponentMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate StructTypeInComponentMatcher in a type-safe way.
 * 
 * @see StructTypeInComponentMatcher
 * @see StructTypeInComponentMatch
 * 
 */
@SuppressWarnings("all")
public final class StructTypeInComponentQuerySpecification extends BaseGeneratedEMFQuerySpecification<StructTypeInComponentMatcher> {
  private StructTypeInComponentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StructTypeInComponentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StructTypeInComponentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeInComponentMatcher.on(engine);
  }
  
  @Override
  public StructTypeInComponentMatch newEmptyMatch() {
    return StructTypeInComponentMatch.newEmptyMatch();
  }
  
  @Override
  public StructTypeInComponentMatch newMatch(final Object... parameters) {
    return StructTypeInComponentMatch.newMatch((org.eclipse.uml2.uml.DataType) parameters[0], (org.eclipse.uml2.uml.Component) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static StructTypeInComponentQuerySpecification INSTANCE = make();
    
    public static StructTypeInComponentQuerySpecification make() {
      return new StructTypeInComponentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StructTypeInComponentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.structTypeInComponent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("structType","umlComponent");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("structType", "org.eclipse.uml2.uml.DataType"),new PParameter("umlComponent", "org.eclipse.uml2.uml.Component"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_structType = body.getOrCreateVariableByName("structType");
      	PVariable var_umlComponent = body.getOrCreateVariableByName("umlComponent");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_structType, "structType"),
      				
      		new ExportedParameter(body, var_umlComponent, "umlComponent")
      	));
      	new TypeConstraint(body, new FlatTuple(var_structType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
      	new TypeConstraint(body, new FlatTuple(var_umlComponent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlComponent), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlComponent, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component", "packagedElement")));
      	new Equality(body, var__virtual_0_, var_structType);
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
