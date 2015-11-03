package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.EventWithoutReceptionMatch;
import hu.eltesoft.modelexecution.validation.EventWithoutReceptionMatcher;
import hu.eltesoft.modelexecution.validation.util.TransitionEventQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate EventWithoutReceptionMatcher in a type-safe way.
 * 
 * @see EventWithoutReceptionMatcher
 * @see EventWithoutReceptionMatch
 * 
 */
@SuppressWarnings("all")
public final class EventWithoutReceptionQuerySpecification extends BaseGeneratedEMFQuerySpecification<EventWithoutReceptionMatcher> {
  private EventWithoutReceptionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventWithoutReceptionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EventWithoutReceptionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventWithoutReceptionMatcher.on(engine);
  }
  
  @Override
  public EventWithoutReceptionMatch newEmptyMatch() {
    return EventWithoutReceptionMatch.newEmptyMatch();
  }
  
  @Override
  public EventWithoutReceptionMatch newMatch(final Object... parameters) {
    return EventWithoutReceptionMatch.newMatch((org.eclipse.uml2.uml.Transition) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1], (org.eclipse.uml2.uml.Signal) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static EventWithoutReceptionQuerySpecification INSTANCE = make();
    
    public static EventWithoutReceptionQuerySpecification make() {
      return new EventWithoutReceptionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EventWithoutReceptionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.EventWithoutReception";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("tr","cl","sg");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("tr", "org.eclipse.uml2.uml.Transition"),new PParameter("cl", "org.eclipse.uml2.uml.Class"),new PParameter("sg", "org.eclipse.uml2.uml.Signal"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_tr = body.getOrCreateVariableByName("tr");
      	PVariable var_cl = body.getOrCreateVariableByName("cl");
      	PVariable var_sg = body.getOrCreateVariableByName("sg");
      	PVariable var_rg = body.getOrCreateVariableByName("rg");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var_sm = body.getOrCreateVariableByName("sm");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var_ev = body.getOrCreateVariableByName("ev");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_tr, "tr"),
      				
      		new ExportedParameter(body, var_cl, "cl"),
      				
      		new ExportedParameter(body, var_sg, "sg")
      	));
      	new TypeConstraint(body, new FlatTuple(var_tr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_tr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition")));
      	new TypeConstraint(body, new FlatTuple(var_tr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "container")));
      	new Equality(body, var__virtual_0_, var_rg);
      	new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_rg, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region", "stateMachine")));
      	new Equality(body, var__virtual_1_, var_sm);
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "classifierBehavior")));
      	new Equality(body, var__virtual_2_, var_sm);
      	new PositivePatternCall(body, new FlatTuple(var_tr, var_ev), TransitionEventQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_ev), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      	new TypeConstraint(body, new FlatTuple(var_ev, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent", "signal")));
      	new Equality(body, var__virtual_3_, var_sg);
      	new NegativePatternCall(body, new FlatTuple(var_cl, var___0_, var_sg), ReceptionQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Class {cl} must contain the reception for {sg}");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"tr"
      				}));
      	addAnnotation(annotation);
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
