package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.TypeDefinitionInPackageMatcher;
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
 * A pattern-specific query specification that can instantiate TypeDefinitionInPackageMatcher in a type-safe way.
 * 
 * @see TypeDefinitionInPackageMatcher
 * @see TypeDefinitionInPackageMatch
 * 
 */
@SuppressWarnings("all")
public final class TypeDefinitionInPackageQuerySpecification extends BaseGeneratedEMFQuerySpecification<TypeDefinitionInPackageMatcher> {
  private TypeDefinitionInPackageQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TypeDefinitionInPackageQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TypeDefinitionInPackageMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TypeDefinitionInPackageMatcher.on(engine);
  }
  
  @Override
  public TypeDefinitionInPackageMatch newEmptyMatch() {
    return TypeDefinitionInPackageMatch.newEmptyMatch();
  }
  
  @Override
  public TypeDefinitionInPackageMatch newMatch(final Object... parameters) {
    return TypeDefinitionInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0], (org.eclipse.uml2.uml.Type) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static TypeDefinitionInPackageQuerySpecification INSTANCE = make();
    
    public static TypeDefinitionInPackageQuerySpecification make() {
      return new TypeDefinitionInPackageQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TypeDefinitionInPackageQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.typeDefinitionInPackage";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlPackage","type");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlPackage", "org.eclipse.uml2.uml.Package"),new PParameter("type", "org.eclipse.uml2.uml.Type"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlPackage = body.getOrCreateVariableByName("umlPackage");
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlPackage, "umlPackage"),
      				
      		new ExportedParameter(body, var_type, "type")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type")));
      	new PositivePatternCall(body, new FlatTuple(var_type), TypeDefinitionQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
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
