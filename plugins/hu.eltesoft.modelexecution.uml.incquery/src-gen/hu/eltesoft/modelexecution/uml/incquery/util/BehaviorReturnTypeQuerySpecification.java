package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate BehaviorReturnTypeMatcher in a type-safe way.
 * 
 * @see BehaviorReturnTypeMatcher
 * @see BehaviorReturnTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorReturnTypeQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorReturnTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorReturnTypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorReturnTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnTypeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnType";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","type");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("type", "org.eclipse.uml2.uml.Type"));
  }
  
  @Override
  public BehaviorReturnTypeMatch newEmptyMatch() {
    return BehaviorReturnTypeMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorReturnTypeMatch newMatch(final Object... parameters) {
    return BehaviorReturnTypeMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Type) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_type, "type")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_behavior, var_parameter, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior", "ownedParameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior.ownedParameter");
      new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      new TypeBinary(body, CONTEXT, var_parameter, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter.direction");
      new TypeBinary(body, CONTEXT, var_parameter, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorReturnTypeQuerySpecification INSTANCE = make();
    
    public static BehaviorReturnTypeQuerySpecification make() {
      return new BehaviorReturnTypeQuerySpecification();					
      
    }
  }
}
