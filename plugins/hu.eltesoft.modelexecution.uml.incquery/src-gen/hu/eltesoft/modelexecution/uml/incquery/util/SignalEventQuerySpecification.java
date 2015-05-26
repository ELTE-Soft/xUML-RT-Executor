package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalEventMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate SignalEventMatcher in a type-safe way.
 * 
 * @see SignalEventMatcher
 * @see SignalEventMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalEventQuerySpecification extends BaseGeneratedQuerySpecification<SignalEventMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalEventQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SignalEventMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalEventMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalEvent";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("event","signal");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("event", "org.eclipse.uml2.uml.SignalEvent"),new PParameter("signal", "org.eclipse.uml2.uml.Signal"));
  }
  
  @Override
  public SignalEventMatch newEmptyMatch() {
    return SignalEventMatch.newEmptyMatch();
  }
  
  @Override
  public SignalEventMatch newMatch(final Object... parameters) {
    return SignalEventMatch.newMatch((org.eclipse.uml2.uml.SignalEvent) parameters[0], (org.eclipse.uml2.uml.Signal) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_event = body.getOrCreateVariableByName("event");
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_event, "event"), 
        new ExportedParameter(body, var_signal, "signal")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_event, var_signal, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent", "signal"), "http://www.eclipse.org/uml2/5.0.0/UML/SignalEvent.signal");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SignalEventQuerySpecification INSTANCE = make();
    
    public static SignalEventQuerySpecification make() {
      return new SignalEventQuerySpecification();					
      
    }
  }
}
