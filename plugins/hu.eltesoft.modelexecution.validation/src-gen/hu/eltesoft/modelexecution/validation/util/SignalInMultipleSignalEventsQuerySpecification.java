package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEventsMatch;
import hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEventsMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalInMultipleSignalEventsMatcher in a type-safe way.
 * 
 * @see SignalInMultipleSignalEventsMatcher
 * @see SignalInMultipleSignalEventsMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalInMultipleSignalEventsQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalInMultipleSignalEventsMatcher> {
  private SignalInMultipleSignalEventsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalInMultipleSignalEventsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalInMultipleSignalEventsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalInMultipleSignalEventsMatcher.on(engine);
  }
  
  @Override
  public SignalInMultipleSignalEventsMatch newEmptyMatch() {
    return SignalInMultipleSignalEventsMatch.newEmptyMatch();
  }
  
  @Override
  public SignalInMultipleSignalEventsMatch newMatch(final Object... parameters) {
    return SignalInMultipleSignalEventsMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.SignalEvent) parameters[1], (org.eclipse.uml2.uml.SignalEvent) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static SignalInMultipleSignalEventsQuerySpecification INSTANCE = make();
    
    public static SignalInMultipleSignalEventsQuerySpecification make() {
      return new SignalInMultipleSignalEventsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalInMultipleSignalEventsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEvents";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","ev1","ev2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sg", "org.eclipse.uml2.uml.Signal"),new PParameter("ev1", "org.eclipse.uml2.uml.SignalEvent"),new PParameter("ev2", "org.eclipse.uml2.uml.SignalEvent"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sg = body.getOrCreateVariableByName("sg");
      	PVariable var_ev1 = body.getOrCreateVariableByName("ev1");
      	PVariable var_ev2 = body.getOrCreateVariableByName("ev2");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sg, "sg"),
      				
      		new ExportedParameter(body, var_ev1, "ev1"),
      				
      		new ExportedParameter(body, var_ev2, "ev2")
      	));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_ev1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      	new TypeConstraint(body, new FlatTuple(var_ev2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      	new TypeConstraint(body, new FlatTuple(var_ev1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      	new TypeConstraint(body, new FlatTuple(var_ev1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent", "signal")));
      	new Equality(body, var__virtual_0_, var_sg);
      	new TypeConstraint(body, new FlatTuple(var_ev2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      	new TypeConstraint(body, new FlatTuple(var_ev2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent", "signal")));
      	new Equality(body, var__virtual_1_, var_sg);
      	new Inequality(body, var_ev1, var_ev2);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "The signal {sg} cannot appear as signal of two signal events");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"ev1", 
      					"ev2"
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
