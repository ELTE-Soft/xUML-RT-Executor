package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtClassMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.BehaviorQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.NodeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.StereotypeQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtAssociationClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.XtComponentQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate XtClassMatcher in a type-safe way.
 * 
 * @see XtClassMatcher
 * @see XtClassMatch
 * 
 */
@SuppressWarnings("all")
public final class XtClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtClassMatcher> {
  private XtClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtClassMatcher.on(engine);
  }
  
  @Override
  public XtClassMatch newEmptyMatch() {
    return XtClassMatch.newEmptyMatch();
  }
  
  @Override
  public XtClassMatch newMatch(final Object... parameters) {
    return XtClassMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static XtClassQuerySpecification INSTANCE = make();
    
    public static XtClassQuerySpecification make() {
      return new XtClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlClass");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlClass", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlClass, "umlClass")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new NegativePatternCall(body, new FlatTuple(var_umlClass), XtAssociationClassQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_umlClass), BehaviorQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_umlClass), XtComponentQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_umlClass), NodeQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_umlClass), StereotypeQuerySpecification.instance().getInternalQueryRepresentation());
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
