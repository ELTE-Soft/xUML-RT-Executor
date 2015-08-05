package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.CapsulePartMatch;
import com.incquerylabs.emdw.umlintegration.queries.CapsulePartMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.XtPortQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate CapsulePartMatcher in a type-safe way.
 * 
 * @see CapsulePartMatcher
 * @see CapsulePartMatch
 * 
 */
@SuppressWarnings("all")
public final class CapsulePartQuerySpecification extends BaseGeneratedEMFQuerySpecification<CapsulePartMatcher> {
  private CapsulePartQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CapsulePartQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CapsulePartMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CapsulePartMatcher.on(engine);
  }
  
  @Override
  public CapsulePartMatch newEmptyMatch() {
    return CapsulePartMatch.newEmptyMatch();
  }
  
  @Override
  public CapsulePartMatch newMatch(final Object... parameters) {
    return CapsulePartMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static CapsulePartQuerySpecification INSTANCE = make();
    
    public static CapsulePartQuerySpecification make() {
      return new CapsulePartQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static CapsulePartQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.capsulePart";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("component","property");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("component", "org.eclipse.uml2.uml.Component"),new PParameter("property", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_component = body.getOrCreateVariableByName("component");
      	PVariable var_property = body.getOrCreateVariableByName("property");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_component, "component"),
      				
      		new ExportedParameter(body, var_property, "property")
      	));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
      	new Equality(body, var__virtual_0_, var_property);
      	new NegativePatternCall(body, new FlatTuple(var_component, var_property), XtPortQuerySpecification.instance().getInternalQueryRepresentation());
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
