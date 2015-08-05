package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtComponentInPackageMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtComponentInPackageMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPackageQuerySpecification;
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
 * A pattern-specific query specification that can instantiate XtComponentInPackageMatcher in a type-safe way.
 * 
 * @see XtComponentInPackageMatcher
 * @see XtComponentInPackageMatch
 * 
 */
@SuppressWarnings("all")
public final class XtComponentInPackageQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtComponentInPackageMatcher> {
  private XtComponentInPackageQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtComponentInPackageQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtComponentInPackageMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtComponentInPackageMatcher.on(engine);
  }
  
  @Override
  public XtComponentInPackageMatch newEmptyMatch() {
    return XtComponentInPackageMatch.newEmptyMatch();
  }
  
  @Override
  public XtComponentInPackageMatch newMatch(final Object... parameters) {
    return XtComponentInPackageMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0], (org.eclipse.uml2.uml.Component) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtComponentInPackageQuerySpecification INSTANCE = make();
    
    public static XtComponentInPackageQuerySpecification make() {
      return new XtComponentInPackageQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtComponentInPackageQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtComponentInPackage";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlPackage","component");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlPackage", "org.eclipse.uml2.uml.Package"),new PParameter("component", "org.eclipse.uml2.uml.Component"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlPackage = body.getOrCreateVariableByName("umlPackage");
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlPackage, "umlPackage"),
      				
      		new ExportedParameter(body, var_component, "component")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
      	new Equality(body, var__virtual_0_, var_component);
      	new PositivePatternCall(body, new FlatTuple(var_component), XtComponentQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_umlPackage), XtPackageQuerySpecification.instance().getInternalQueryRepresentation());
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
