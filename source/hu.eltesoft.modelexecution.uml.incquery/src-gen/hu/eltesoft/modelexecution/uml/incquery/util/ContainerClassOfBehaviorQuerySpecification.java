package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfVertexQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ContainerClassOfBehaviorMatcher in a type-safe way.
 * 
 * @see ContainerClassOfBehaviorMatcher
 * @see ContainerClassOfBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class ContainerClassOfBehaviorQuerySpecification extends BaseGeneratedQuerySpecification<ContainerClassOfBehaviorMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ContainerClassOfBehaviorQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ContainerClassOfBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfBehaviorMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehavior";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","containerClassName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("containerClassName", "java.lang.String"));
  }
  
  @Override
  public ContainerClassOfBehaviorMatch newEmptyMatch() {
    return ContainerClassOfBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public ContainerClassOfBehaviorMatch newMatch(final Object... parameters) {
    return ContainerClassOfBehaviorMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_operation, var_behavior, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "method"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioralFeature.method");
      new TypeBinary(body, CONTEXT, var_cls, var_operation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedOperation");
      new TypeBinary(body, CONTEXT, var_cls, var_containerClassName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_state = body.getOrCreateVariableByName("state");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_state, var_behavior, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "entry"), "http://www.eclipse.org/uml2/5.0.0/UML/State.entry");
      new PositivePatternCall(body, new FlatTuple(var_state, var_containerClassName), ContainerClassOfVertexQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_state = body.getOrCreateVariableByName("state");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_state, var_behavior, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "exit"), "http://www.eclipse.org/uml2/5.0.0/UML/State.exit");
      new PositivePatternCall(body, new FlatTuple(var_state, var_containerClassName), ContainerClassOfVertexQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_transition = body.getOrCreateVariableByName("transition");
      PVariable var_region = body.getOrCreateVariableByName("region");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_transition, var_behavior, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "effect"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.effect");
      new TypeBinary(body, CONTEXT, var_transition, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.container");
      new PositivePatternCall(body, new FlatTuple(var_region, var_containerClassName), ContainerClassOfRegionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ContainerClassOfBehaviorQuerySpecification INSTANCE = make();
    
    public static ContainerClassOfBehaviorQuerySpecification make() {
      return new ContainerClassOfBehaviorQuerySpecification();					
      
    }
  }
}
