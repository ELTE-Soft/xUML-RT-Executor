package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtClassInComponentMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtClassInComponentMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassQuerySpecification;
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
 * A pattern-specific query specification that can instantiate XtClassInComponentMatcher in a type-safe way.
 * 
 * @see XtClassInComponentMatcher
 * @see XtClassInComponentMatch
 * 
 */
@SuppressWarnings("all")
public final class XtClassInComponentQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtClassInComponentMatcher> {
  private XtClassInComponentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtClassInComponentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtClassInComponentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtClassInComponentMatcher.on(engine);
  }
  
  @Override
  public XtClassInComponentMatch newEmptyMatch() {
    return XtClassInComponentMatch.newEmptyMatch();
  }
  
  @Override
  public XtClassInComponentMatch newMatch(final Object... parameters) {
    return XtClassInComponentMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtClassInComponentQuerySpecification INSTANCE = make();
    
    public static XtClassInComponentQuerySpecification make() {
      return new XtClassInComponentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtClassInComponentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtClassInComponent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("component","umlClass");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("component", "org.eclipse.uml2.uml.Component"),new PParameter("umlClass", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_component, "component"),
      				
      		new ExportedParameter(body, var_umlClass, "umlClass")
      	));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "nestedClassifier")));
      	new Equality(body, var__virtual_0_, var_umlClass);
      	new PositivePatternCall(body, new FlatTuple(var_umlClass), XtClassQuerySpecification.instance().getInternalQueryRepresentation());
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
