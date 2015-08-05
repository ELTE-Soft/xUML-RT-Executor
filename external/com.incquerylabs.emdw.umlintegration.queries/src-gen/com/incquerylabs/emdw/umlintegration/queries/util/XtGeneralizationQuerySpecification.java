package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtGeneralizationMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtGeneralizationMatcher;
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
 * A pattern-specific query specification that can instantiate XtGeneralizationMatcher in a type-safe way.
 * 
 * @see XtGeneralizationMatcher
 * @see XtGeneralizationMatch
 * 
 */
@SuppressWarnings("all")
public final class XtGeneralizationQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtGeneralizationMatcher> {
  private XtGeneralizationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtGeneralizationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtGeneralizationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtGeneralizationMatcher.on(engine);
  }
  
  @Override
  public XtGeneralizationMatch newEmptyMatch() {
    return XtGeneralizationMatch.newEmptyMatch();
  }
  
  @Override
  public XtGeneralizationMatch newMatch(final Object... parameters) {
    return XtGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Generalization) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtGeneralizationQuerySpecification INSTANCE = make();
    
    public static XtGeneralizationQuerySpecification make() {
      return new XtGeneralizationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtGeneralizationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtGeneralization";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("subClass","generalization");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("subClass", "org.eclipse.uml2.uml.Class"),new PParameter("generalization", "org.eclipse.uml2.uml.Generalization"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_subClass = body.getOrCreateVariableByName("subClass");
      	PVariable var_generalization = body.getOrCreateVariableByName("generalization");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_subClass, "subClass"),
      				
      		new ExportedParameter(body, var_generalization, "generalization")
      	));
      	new TypeConstraint(body, new FlatTuple(var_subClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new PositivePatternCall(body, new FlatTuple(var_subClass), XtClassQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_subClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_subClass, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier", "generalization")));
      	new Equality(body, var__virtual_0_, var_generalization);
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
