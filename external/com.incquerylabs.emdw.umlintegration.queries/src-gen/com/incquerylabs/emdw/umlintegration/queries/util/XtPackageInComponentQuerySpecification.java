package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtPackageInComponentMatcher;
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
 * A pattern-specific query specification that can instantiate XtPackageInComponentMatcher in a type-safe way.
 * 
 * @see XtPackageInComponentMatcher
 * @see XtPackageInComponentMatch
 * 
 */
@SuppressWarnings("all")
public final class XtPackageInComponentQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtPackageInComponentMatcher> {
  private XtPackageInComponentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtPackageInComponentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtPackageInComponentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtPackageInComponentMatcher.on(engine);
  }
  
  @Override
  public XtPackageInComponentMatch newEmptyMatch() {
    return XtPackageInComponentMatch.newEmptyMatch();
  }
  
  @Override
  public XtPackageInComponentMatch newMatch(final Object... parameters) {
    return XtPackageInComponentMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0], (org.eclipse.uml2.uml.Package) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtPackageInComponentQuerySpecification INSTANCE = make();
    
    public static XtPackageInComponentQuerySpecification make() {
      return new XtPackageInComponentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtPackageInComponentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtPackageInComponent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("component","umlPackage");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("component", "org.eclipse.uml2.uml.Component"),new PParameter("umlPackage", "org.eclipse.uml2.uml.Package"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var_umlPackage = body.getOrCreateVariableByName("umlPackage");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_component, "component"),
      				
      		new ExportedParameter(body, var_umlPackage, "umlPackage")
      	));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlPackage), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component", "packagedElement")));
      	new Equality(body, var__virtual_0_, var_umlPackage);
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
