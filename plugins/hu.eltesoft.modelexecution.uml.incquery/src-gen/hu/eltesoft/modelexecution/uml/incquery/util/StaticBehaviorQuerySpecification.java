package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatch;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate StaticBehaviorMatcher in a type-safe way.
 * 
 * @see StaticBehaviorMatcher
 * @see StaticBehaviorMatch
 * 
 */
@SuppressWarnings("all")
public final class StaticBehaviorQuerySpecification extends BaseGeneratedQuerySpecification<StaticBehaviorMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StaticBehaviorQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected StaticBehaviorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StaticBehaviorMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.StaticBehavior";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"));
  }
  
  @Override
  public StaticBehaviorMatch newEmptyMatch() {
    return StaticBehaviorMatch.newEmptyMatch();
  }
  
  @Override
  public StaticBehaviorMatch newMatch(final Object... parameters) {
    return StaticBehaviorMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior")
      ));
      
      new TypeBinary(body, CONTEXT, var_behavior, var_operation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior", "specification"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior.specification");
      new ConstantValue(body, var__virtual_1_, true);
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      new TypeBinary(body, CONTEXT, var_operation, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Feature", "isStatic"), "http://www.eclipse.org/uml2/5.0.0/UML/Feature.isStatic");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static StaticBehaviorQuerySpecification INSTANCE = make();
    
    public static StaticBehaviorQuerySpecification make() {
      return new StaticBehaviorQuerySpecification();					
      
    }
  }
}
