package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatch;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher;
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
 * A pattern-specific query specification that can instantiate TransitionEffectMatcher in a type-safe way.
 * 
 * @see TransitionEffectMatcher
 * @see TransitionEffectMatch
 * 
 */
@SuppressWarnings("all")
public final class TransitionEffectQuerySpecification extends BaseGeneratedQuerySpecification<TransitionEffectMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TransitionEffectQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected TransitionEffectMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TransitionEffectMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.TransitionEffect";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","state","transition","effect");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("transition", "org.eclipse.uml2.uml.Transition"),new PParameter("effect", "org.eclipse.uml2.uml.Behavior"));
  }
  
  @Override
  public TransitionEffectMatch newEmptyMatch() {
    return TransitionEffectMatch.newEmptyMatch();
  }
  
  @Override
  public TransitionEffectMatch newMatch(final Object... parameters) {
    return TransitionEffectMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1], (org.eclipse.uml2.uml.Transition) parameters[2], (org.eclipse.uml2.uml.Behavior) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_state = body.getOrCreateVariableByName("state");
      PVariable var_transition = body.getOrCreateVariableByName("transition");
      PVariable var_effect = body.getOrCreateVariableByName("effect");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_state, "state"), 
        new ExportedParameter(body, var_transition, "transition"), 
        new ExportedParameter(body, var_effect, "effect")
      ));
      
      
      new TypeUnary(body, var_state, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      
      
      new TypeBinary(body, CONTEXT, var_transition, var_state, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.source");
      new TypeBinary(body, CONTEXT, var_transition, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.container");
      new TypeBinary(body, CONTEXT, var_transition, var_effect, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "effect"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.effect");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static TransitionEffectQuerySpecification INSTANCE = make();
    
    public static TransitionEffectQuerySpecification make() {
      return new TransitionEffectQuerySpecification();					
      
    }
  }
}
