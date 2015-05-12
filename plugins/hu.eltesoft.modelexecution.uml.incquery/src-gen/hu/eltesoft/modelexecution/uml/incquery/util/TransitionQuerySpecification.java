package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatch;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionBaseQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TransitionMatcher in a type-safe way.
 * 
 * @see TransitionMatcher
 * @see TransitionMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionQuerySpecification extends BaseGeneratedQuerySpecification<TransitionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected TransitionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Transition";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","source","transition","messageName","target");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("source", "org.eclipse.uml2.uml.State"),new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("messageName", "java.lang.String"),new PParameter("target", "org.eclipse.uml2.uml.State"));
  }
  
  @Override
  public TransitionMatch newEmptyMatch() {
    return TransitionMatch.newEmptyMatch();
  }
  
  @Override
  public TransitionMatch newMatch(final Object... parameters) {
    return TransitionMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1], (org.eclipse.uml2.uml.Transition) parameters[2], (java.lang.String) parameters[3], (org.eclipse.uml2.uml.State) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_source = body.getOrCreateVariableByName("source");
      PVariable var_transition = body.getOrCreateVariableByName("transition");
      PVariable var_messageName = body.getOrCreateVariableByName("messageName");
      PVariable var_target = body.getOrCreateVariableByName("target");
      PVariable var_event = body.getOrCreateVariableByName("event");
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_source, "source"), 
        new ExportedParameter(body, var_transition, "transition"), 
        new ExportedParameter(body, var_messageName, "messageName"), 
        new ExportedParameter(body, var_target, "target")
      ));
      
      new TypeUnary(body, var_region, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region"), "http://www.eclipse.org/uml2/5.0.0/UML/Region");
      
      new TypeUnary(body, var_source, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      
      new TypeUnary(body, var_transition, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition");
      
      
      new TypeUnary(body, var_target, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      new PositivePatternCall(body, new FlatTuple(var_region, var_source, var_transition, var_event, var_target), TransitionBaseQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_event, var_signal, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "SignalEvent", "signal"), "http://www.eclipse.org/uml2/5.0.0/UML/SignalEvent.signal");
      new TypeBinary(body, CONTEXT, var_signal, var_messageName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static TransitionQuerySpecification INSTANCE = make();
    
    public static TransitionQuerySpecification make() {
      return new TransitionQuerySpecification();					
      
    }
  }
}
