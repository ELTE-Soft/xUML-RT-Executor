package com.incquerylabs.emdw.umlintegration.queries.util;

import com.google.common.collect.Sets;
import com.incquerylabs.emdw.umlintegration.queries.XtEventTriggerMatch;
import com.incquerylabs.emdw.umlintegration.queries.XtEventTriggerMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalWithReceptionInClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TransitionInStateMachineQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.TriggerSignalQuerySpecification;
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
 * A pattern-specific query specification that can instantiate XtEventTriggerMatcher in a type-safe way.
 * 
 * @see XtEventTriggerMatcher
 * @see XtEventTriggerMatch
 * 
 */
@SuppressWarnings("all")
public final class XtEventTriggerQuerySpecification extends BaseGeneratedEMFQuerySpecification<XtEventTriggerMatcher> {
  private XtEventTriggerQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static XtEventTriggerQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected XtEventTriggerMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return XtEventTriggerMatcher.on(engine);
  }
  
  @Override
  public XtEventTriggerMatch newEmptyMatch() {
    return XtEventTriggerMatch.newEmptyMatch();
  }
  
  @Override
  public XtEventTriggerMatch newMatch(final Object... parameters) {
    return XtEventTriggerMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0], (org.eclipse.uml2.uml.Trigger) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static XtEventTriggerQuerySpecification INSTANCE = make();
    
    public static XtEventTriggerQuerySpecification make() {
      return new XtEventTriggerQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static XtEventTriggerQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.emdw.umlintegration.queries.xtEventTrigger";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("transition","trigger");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("trigger", "org.eclipse.uml2.uml.Trigger"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_transition = body.getOrCreateVariableByName("transition");
      	PVariable var_trigger = body.getOrCreateVariableByName("trigger");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var_signal = body.getOrCreateVariableByName("signal");
      	PVariable var__reception = body.getOrCreateVariableByName("_reception");
      	PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
      	PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_transition, "transition"),
      				
      		new ExportedParameter(body, var_trigger, "trigger")
      	));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_trigger), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Trigger")));
      	new TypeConstraint(body, new FlatTuple(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "trigger")));
      	new Equality(body, var__virtual_0_, var_trigger);
      	new PositivePatternCall(body, new FlatTuple(var_trigger, var_signal), TriggerSignalQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_signal, var__reception, var_umlClass), SignalWithReceptionInClassQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_umlClass, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "classifierBehavior")));
      	new Equality(body, var__virtual_1_, var_stateMachine);
      	new PositivePatternCall(body, new FlatTuple(var_stateMachine, var_transition), TransitionInStateMachineQuerySpecification.instance().getInternalQueryRepresentation());
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
