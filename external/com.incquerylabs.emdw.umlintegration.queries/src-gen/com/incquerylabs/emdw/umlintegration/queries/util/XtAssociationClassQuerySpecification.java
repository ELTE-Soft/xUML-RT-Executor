package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationClassMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtAssociationClassMatcher;
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
 * A pattern-specific query specification that can instantiate XtAssociationClassMatcher in a type-safe way.
 * 
 * @see XtAssociationClassMatcher
 * @see XtAssociationClassMatch
 * 
 */
@SuppressWarnings("all")
public final class XtAssociationClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtAssociationClassMatcher> {
  private XtAssociationClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtAssociationClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtAssociationClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtAssociationClassMatcher.on(engine);
  }
  
  @Override
  public XtAssociationClassMatch newEmptyMatch() {
    return XtAssociationClassMatch.newEmptyMatch();
  }
  
  @Override
  public XtAssociationClassMatch newMatch(final Object... parameters) {
    return XtAssociationClassMatch.newMatch((org.eclipse.uml2.uml.AssociationClass) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static XtAssociationClassQuerySpecification INSTANCE = make();
    
    public static XtAssociationClassQuerySpecification make() {
      return new XtAssociationClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtAssociationClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtAssociationClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("associationClass");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("associationClass", "org.eclipse.uml2.uml.AssociationClass"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_associationClass = body.getOrCreateVariableByName("associationClass");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_associationClass, "associationClass")
      	));
      	new TypeConstraint(body, new FlatTuple(var_associationClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "AssociationClass")));
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
