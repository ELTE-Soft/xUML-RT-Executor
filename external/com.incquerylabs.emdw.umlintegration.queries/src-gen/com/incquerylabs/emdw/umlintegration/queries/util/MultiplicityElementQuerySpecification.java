package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.MultiplicityElementMatch;
import com.incquerylabs.emdw.umlintegration.queries.MultiplicityElementMatcher;
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
 * A pattern-specific query specification that can instantiate MultiplicityElementMatcher in a type-safe way.
 * 
 * @see MultiplicityElementMatcher
 * @see MultiplicityElementMatch
 * 
 */
@SuppressWarnings("all")
public final class MultiplicityElementQuerySpecification extends BaseGeneratedEMFQuerySpecification<MultiplicityElementMatcher> {
  private MultiplicityElementQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MultiplicityElementQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultiplicityElementMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MultiplicityElementMatcher.on(engine);
  }
  
  @Override
  public MultiplicityElementMatch newEmptyMatch() {
    return MultiplicityElementMatch.newEmptyMatch();
  }
  
  @Override
  public MultiplicityElementMatch newMatch(final Object... parameters) {
    return MultiplicityElementMatch.newMatch((org.eclipse.uml2.uml.MultiplicityElement) parameters[0], (org.eclipse.uml2.uml.ValueSpecification) parameters[1], (org.eclipse.uml2.uml.ValueSpecification) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static MultiplicityElementQuerySpecification INSTANCE = make();
    
    public static MultiplicityElementQuerySpecification make() {
      return new MultiplicityElementQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static MultiplicityElementQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.multiplicityElement";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("multiplicityElement","lowerValue","upperValue");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("multiplicityElement", "org.eclipse.uml2.uml.MultiplicityElement"),new PParameter("lowerValue", "org.eclipse.uml2.uml.ValueSpecification"),new PParameter("upperValue", "org.eclipse.uml2.uml.ValueSpecification"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_multiplicityElement = body.getOrCreateVariableByName("multiplicityElement");
      	PVariable var_lowerValue = body.getOrCreateVariableByName("lowerValue");
      	PVariable var_upperValue = body.getOrCreateVariableByName("upperValue");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_multiplicityElement, "multiplicityElement"),
      				
      		new ExportedParameter(body, var_lowerValue, "lowerValue"),
      				
      		new ExportedParameter(body, var_upperValue, "upperValue")
      	));
      	new TypeConstraint(body, new FlatTuple(var_multiplicityElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      	new TypeConstraint(body, new FlatTuple(var_lowerValue), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ValueSpecification")));
      	new TypeConstraint(body, new FlatTuple(var_upperValue), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ValueSpecification")));
      	new TypeConstraint(body, new FlatTuple(var_multiplicityElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      	new TypeConstraint(body, new FlatTuple(var_multiplicityElement, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue")));
      	new Equality(body, var__virtual_0_, var_lowerValue);
      	new TypeConstraint(body, new FlatTuple(var_multiplicityElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement")));
      	new TypeConstraint(body, new FlatTuple(var_multiplicityElement, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue")));
      	new Equality(body, var__virtual_1_, var_upperValue);
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
