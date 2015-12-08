package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalEventQuerySpecification;
import hu.eltesoft.modelexecution.validation.SignalEventWithNoEventMatch;
import hu.eltesoft.modelexecution.validation.SignalEventWithNoEventMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalEventWithNoEventMatcher in a type-safe way.
 * 
 * @see SignalEventWithNoEventMatcher
 * @see SignalEventWithNoEventMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalEventWithNoEventQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalEventWithNoEventMatcher> {
  private SignalEventWithNoEventQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalEventWithNoEventQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalEventWithNoEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalEventWithNoEventMatcher.on(engine);
  }
  
  @Override
  public SignalEventWithNoEventMatch newEmptyMatch() {
    return SignalEventWithNoEventMatch.newEmptyMatch();
  }
  
  @Override
  public SignalEventWithNoEventMatch newMatch(final Object... parameters) {
    return SignalEventWithNoEventMatch.newMatch((org.eclipse.uml2.uml.SignalEvent) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SignalEventWithNoEventQuerySpecification INSTANCE = make();
    
    public static SignalEventWithNoEventQuerySpecification make() {
      return new SignalEventWithNoEventQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalEventWithNoEventQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.SignalEventWithNoEvent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ev");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ev", "org.eclipse.uml2.uml.SignalEvent"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_ev = body.getOrCreateVariableByName("ev");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_ev), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_ev, "ev")
      		));
      		// 	neg find SignalEvent(ev, _)
      		new NegativePatternCall(body, new FlatTuple(var_ev, var___0_), SignalEventQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Signal event must have an associated signal");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "ev"
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
