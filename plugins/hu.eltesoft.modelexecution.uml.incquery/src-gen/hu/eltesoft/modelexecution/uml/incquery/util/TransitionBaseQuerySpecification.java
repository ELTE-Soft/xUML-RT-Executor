package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate TransitionBaseMatcher in a type-safe way.
 * 
 * @see TransitionBaseMatcher
 * @see TransitionBaseMatch
 * 
 */
@SuppressWarnings("all")
final class TransitionBaseQuerySpecification extends BaseGeneratedQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionBaseQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected IncQueryMatcher<IPatternMatch> instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.TransitionBase";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","source","transition","event","eventName","target");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("source", "org.eclipse.uml2.uml.State"),new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("event", "org.eclipse.uml2.uml.Event"),new PParameter("eventName", "java.lang.String"),new PParameter("target", "org.eclipse.uml2.uml.State"));
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_source = body.getOrCreateVariableByName("source");
      PVariable var_transition = body.getOrCreateVariableByName("transition");
      PVariable var_event = body.getOrCreateVariableByName("event");
      PVariable var_eventName = body.getOrCreateVariableByName("eventName");
      PVariable var_target = body.getOrCreateVariableByName("target");
      PVariable var_trigger = body.getOrCreateVariableByName("trigger");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_source, "source"), 
        new ExportedParameter(body, var_transition, "transition"), 
        new ExportedParameter(body, var_event, "event"), 
        new ExportedParameter(body, var_eventName, "eventName"), 
        new ExportedParameter(body, var_target, "target")
      ));
      
      
      new TypeUnary(body, var_source, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      
      
      
      
      new TypeUnary(body, var_target, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      new TypeBinary(body, CONTEXT, var_transition, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.container");
      new TypeBinary(body, CONTEXT, var_transition, var_source, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.source");
      new TypeBinary(body, CONTEXT, var_transition, var_target, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "target"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.target");
      new TypeBinary(body, CONTEXT, var_transition, var_trigger, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "trigger"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.trigger");
      new TypeBinary(body, CONTEXT, var_trigger, var_event, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Trigger", "event"), "http://www.eclipse.org/uml2/5.0.0/UML/Trigger.event");
      new TypeBinary(body, CONTEXT, var_event, var_eventName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static TransitionBaseQuerySpecification INSTANCE = make();
    
    public static TransitionBaseQuerySpecification make() {
      return new TransitionBaseQuerySpecification();					
      
    }
  }
}
