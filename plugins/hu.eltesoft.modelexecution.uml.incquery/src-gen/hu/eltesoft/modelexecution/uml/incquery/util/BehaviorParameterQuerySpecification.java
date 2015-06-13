package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate BehaviorParameterMatcher in a type-safe way.
 * 
 * @see BehaviorParameterMatcher
 * @see BehaviorParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorParameterQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorParameterMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorParameterQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorParameter";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","parameter","direction");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("direction", "org.eclipse.uml2.uml.ParameterDirectionKind"));
  }
  
  @Override
  public BehaviorParameterMatch newEmptyMatch() {
    return BehaviorParameterMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorParameterMatch newMatch(final Object... parameters) {
    return BehaviorParameterMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.ParameterDirectionKind) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_direction = body.getOrCreateVariableByName("direction");
      PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_direction, "direction")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_behavior, var_parameter, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior", "ownedParameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior.ownedParameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_direction, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter.direction");
      new ConstantValue(body, var__virtual_2_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      new Inequality(body, var_direction, var__virtual_2_);
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorParameterQuerySpecification INSTANCE = make();
    
    public static BehaviorParameterQuerySpecification make() {
      return new BehaviorParameterQuerySpecification();					
      
    }
  }
}
