package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.StructTypeInPackageMatcher;
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
 * A pattern-specific query specification that can instantiate StructTypeInPackageMatcher in a type-safe way.
 * 
 * @see StructTypeInPackageMatcher
 * @see StructTypeInPackageMatch
 * 
 */
@SuppressWarnings("all")
public final class StructTypeInPackageQuerySpecification extends BaseGeneratedEMFQuerySpecification<StructTypeInPackageMatcher> {
  private StructTypeInPackageQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StructTypeInPackageQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StructTypeInPackageMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StructTypeInPackageMatcher.on(engine);
  }
  
  @Override
  public StructTypeInPackageMatch newEmptyMatch() {
    return StructTypeInPackageMatch.newEmptyMatch();
  }
  
  @Override
  public StructTypeInPackageMatch newMatch(final Object... parameters) {
    return StructTypeInPackageMatch.newMatch((org.eclipse.uml2.uml.DataType) parameters[0], (org.eclipse.uml2.uml.Package) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static StructTypeInPackageQuerySpecification INSTANCE = make();
    
    public static StructTypeInPackageQuerySpecification make() {
      return new StructTypeInPackageQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StructTypeInPackageQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.structTypeInPackage";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("structType","umlPackage");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("structType", "org.eclipse.uml2.uml.DataType"),new PParameter("umlPackage", "org.eclipse.uml2.uml.Package"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_structType = body.getOrCreateVariableByName("structType");
      	PVariable var_umlPackage = body.getOrCreateVariableByName("umlPackage");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_structType, "structType"),
      				
      		new ExportedParameter(body, var_umlPackage, "umlPackage")
      	));
      	new TypeConstraint(body, new FlatTuple(var_structType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
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
