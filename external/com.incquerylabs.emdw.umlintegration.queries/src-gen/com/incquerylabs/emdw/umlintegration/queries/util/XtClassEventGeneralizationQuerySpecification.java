package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtClassEventGeneralizationMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtClassEventGeneralizationMatcher;
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
 * A pattern-specific query specification that can instantiate XtClassEventGeneralizationMatcher in a type-safe way.
 * 
 * @see XtClassEventGeneralizationMatcher
 * @see XtClassEventGeneralizationMatch
 * 
 */
@SuppressWarnings("all")
public final class XtClassEventGeneralizationQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtClassEventGeneralizationMatcher> {
  private XtClassEventGeneralizationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtClassEventGeneralizationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtClassEventGeneralizationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtClassEventGeneralizationMatcher.on(engine);
  }
  
  @Override
  public XtClassEventGeneralizationMatch newEmptyMatch() {
    return XtClassEventGeneralizationMatch.newEmptyMatch();
  }
  
  @Override
  public XtClassEventGeneralizationMatch newMatch(final Object... parameters) {
    return XtClassEventGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Signal) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtClassEventGeneralizationQuerySpecification INSTANCE = make();
    
    public static XtClassEventGeneralizationQuerySpecification make() {
      return new XtClassEventGeneralizationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtClassEventGeneralizationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtClassEventGeneralization";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","superSignal");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("superSignal", "org.eclipse.uml2.uml.Signal"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_signal = body.getOrCreateVariableByName("signal");
      	PVariable var_superSignal = body.getOrCreateVariableByName("superSignal");
      	PVariable var__class1 = body.getOrCreateVariableByName("_class1");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__class2 = body.getOrCreateVariableByName("_class2");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_generalization = body.getOrCreateVariableByName("generalization");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_signal, "signal"),
      				
      		new ExportedParameter(body, var_superSignal, "superSignal")
      	));
      	new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_superSignal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var__class1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var__class1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "nestedClassifier")));
      	new Equality(body, var__virtual_0_, var_signal);
      	new TypeConstraint(body, new FlatTuple(var__class2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var__class2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "nestedClassifier")));
      	new Equality(body, var__virtual_1_, var_superSignal);
      	new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_signal, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier", "generalization")));
      	new Equality(body, var__virtual_2_, var_generalization);
      	new TypeConstraint(body, new FlatTuple(var_generalization), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization")));
      	new TypeConstraint(body, new FlatTuple(var_generalization, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Generalization", "general")));
      	new Equality(body, var__virtual_3_, var_superSignal);
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
