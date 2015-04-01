package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
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
 * A pattern-specific query specification that can instantiate BehaviorMatcher in a type-safe way.
 * 
 * @see BehaviorMatcher
 * @see BehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Behavior";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","behaviorName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("behaviorName", "java.lang.String"));
  }
  
  @Override
  public BehaviorMatch newEmptyMatch() {
    return BehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorMatch newMatch(final Object... parameters) {
    return BehaviorMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_behaviorName = body.getOrCreateVariableByName("behaviorName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_behaviorName, "behaviorName")
      ));
      
      
      new TypeUnary(body, var_behavior, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior"), "http://www.eclipse.org/uml2/5.0.0/UML/OpaqueBehavior");
      new TypeBinary(body, CONTEXT, var_behavior, var_behaviorName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorQuerySpecification INSTANCE = make();
    
    public static BehaviorQuerySpecification make() {
      return new BehaviorQuerySpecification();					
      
    }
  }
}
