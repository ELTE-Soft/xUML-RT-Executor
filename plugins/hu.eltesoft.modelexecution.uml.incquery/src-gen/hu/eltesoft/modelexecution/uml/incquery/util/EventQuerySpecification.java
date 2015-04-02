package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.EventMatch;
import hu.eltesoft.modelexecution.uml.incquery.EventMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate EventMatcher in a type-safe way.
 * 
 * @see EventMatcher
 * @see EventMatch
 * 
 */
@SuppressWarnings("all")
public final class EventQuerySpecification extends BaseGeneratedQuerySpecification<EventMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EventQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected EventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EventMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Event";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("event","eventName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("event", "org.eclipse.uml2.uml.SignalEvent"),new PParameter("eventName", "java.lang.String"));
  }
  
  @Override
  public EventMatch newEmptyMatch() {
    return EventMatch.newEmptyMatch();
  }
  
  @Override
  public EventMatch newMatch(final Object... parameters) {
    return EventMatch.newMatch((org.eclipse.uml2.uml.SignalEvent) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_event = body.getOrCreateVariableByName("event");
      PVariable var_eventName = body.getOrCreateVariableByName("eventName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_event, "event"), 
        new ExportedParameter(body, var_eventName, "eventName")
      ));
      
      new TypeUnary(body, var_event, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent"), "http://www.eclipse.org/uml2/5.0.0/UML/SignalEvent");
      
      new TypeBinary(body, CONTEXT, var_event, var_eventName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static EventQuerySpecification INSTANCE = make();
    
    public static EventQuerySpecification make() {
      return new EventQuerySpecification();					
      
    }
  }
}
