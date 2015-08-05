package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.SignalWithReceptionInClassMatch;
import com.incquerylabs.emdw.umlintegration.queries.SignalWithReceptionInClassMatcher;
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
 * A pattern-specific query specification that can instantiate SignalWithReceptionInClassMatcher in a type-safe way.
 * 
 * @see SignalWithReceptionInClassMatcher
 * @see SignalWithReceptionInClassMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalWithReceptionInClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalWithReceptionInClassMatcher> {
  private SignalWithReceptionInClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalWithReceptionInClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalWithReceptionInClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalWithReceptionInClassMatcher.on(engine);
  }
  
  @Override
  public SignalWithReceptionInClassMatch newEmptyMatch() {
    return SignalWithReceptionInClassMatch.newEmptyMatch();
  }
  
  @Override
  public SignalWithReceptionInClassMatch newMatch(final Object... parameters) {
    return SignalWithReceptionInClassMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (org.eclipse.uml2.uml.Class) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static SignalWithReceptionInClassQuerySpecification INSTANCE = make();
    
    public static SignalWithReceptionInClassQuerySpecification make() {
      return new SignalWithReceptionInClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalWithReceptionInClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.signalWithReceptionInClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("signal","reception","umlClass");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("umlClass", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_signal = body.getOrCreateVariableByName("signal");
      	PVariable var_reception = body.getOrCreateVariableByName("reception");
      	PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_signal, "signal"),
      				
      		new ExportedParameter(body, var_reception, "reception"),
      				
      		new ExportedParameter(body, var_umlClass, "umlClass")
      	));
      	new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_reception), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedReception")));
      	new Equality(body, var__virtual_0_, var_reception);
      	new TypeConstraint(body, new FlatTuple(var_reception), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_reception, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception", "signal")));
      	new Equality(body, var__virtual_1_, var_signal);
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
