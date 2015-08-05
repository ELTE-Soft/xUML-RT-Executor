package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.SignalAttributeMatch;
import com.incquerylabs.emdw.umlintegration.queries.SignalAttributeMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.XtClassEventQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SignalAttributeMatcher in a type-safe way.
 * 
 * @see SignalAttributeMatcher
 * @see SignalAttributeMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalAttributeQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalAttributeMatcher> {
  private SignalAttributeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalAttributeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalAttributeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeMatcher.on(engine);
  }
  
  @Override
  public SignalAttributeMatch newEmptyMatch() {
    return SignalAttributeMatch.newEmptyMatch();
  }
  
  @Override
  public SignalAttributeMatch newMatch(final Object... parameters) {
    return SignalAttributeMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SignalAttributeQuerySpecification INSTANCE = make();
    
    public static SignalAttributeQuerySpecification make() {
      return new SignalAttributeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalAttributeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.signalAttribute";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlSignal","property");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("umlSignal", "org.eclipse.uml2.uml.Signal"),new PParameter("property", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_umlSignal = body.getOrCreateVariableByName("umlSignal");
      	PVariable var_property = body.getOrCreateVariableByName("property");
      	PVariable var__class = body.getOrCreateVariableByName("_class");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_umlSignal, "umlSignal"),
      				
      		new ExportedParameter(body, var_property, "property")
      	));
      	new TypeConstraint(body, new FlatTuple(var_umlSignal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new PositivePatternCall(body, new FlatTuple(var__class, var_umlSignal), XtClassEventQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_umlSignal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_umlSignal, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal", "ownedAttribute")));
      	new Equality(body, var__virtual_0_, var_property);
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
