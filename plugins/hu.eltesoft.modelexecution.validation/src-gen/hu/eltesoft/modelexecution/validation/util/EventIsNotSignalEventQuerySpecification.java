package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.EventIsNotSignalEventMatch;
import hu.eltesoft.modelexecution.validation.EventIsNotSignalEventMatcher;
import hu.eltesoft.modelexecution.validation.util.IsSignalEventQuerySpecification;
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
 * A pattern-specific query specification that can instantiate EventIsNotSignalEventMatcher in a type-safe way.
 * 
 * @see EventIsNotSignalEventMatcher
 * @see EventIsNotSignalEventMatch
 * 
 */
@SuppressWarnings("all")
public final class EventIsNotSignalEventQuerySpecification extends BaseGeneratedEMFQuerySpecification<EventIsNotSignalEventMatcher> {
  private EventIsNotSignalEventQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventIsNotSignalEventQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EventIsNotSignalEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventIsNotSignalEventMatcher.on(engine);
  }
  
  @Override
  public EventIsNotSignalEventMatch newEmptyMatch() {
    return EventIsNotSignalEventMatch.newEmptyMatch();
  }
  
  @Override
  public EventIsNotSignalEventMatch newMatch(final Object... parameters) {
    return EventIsNotSignalEventMatch.newMatch((org.eclipse.uml2.uml.Event) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static EventIsNotSignalEventQuerySpecification INSTANCE = make();
    
    public static EventIsNotSignalEventQuerySpecification make() {
      return new EventIsNotSignalEventQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EventIsNotSignalEventQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.EventIsNotSignalEvent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ev");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ev", "org.eclipse.uml2.uml.Event"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ev = body.getOrCreateVariableByName("ev");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ev, "ev")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ev), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Event")));
      	new NegativePatternCall(body, new FlatTuple(var_ev), IsSignalEventQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Only signal events are supported");
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
