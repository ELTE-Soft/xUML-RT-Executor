package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterQuerySpecification;
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
 * A pattern-specific query specification that can instantiate BehaviorParameterTypeMatcher in a type-safe way.
 * 
 * @see BehaviorParameterTypeMatcher
 * @see BehaviorParameterTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorParameterTypeQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorParameterTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorParameterTypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorParameterTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterTypeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterType";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","parameter","type","ordered","unique");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("ordered", "java.lang.Boolean"),new PParameter("unique", "java.lang.Boolean"));
  }
  
  @Override
  public BehaviorParameterTypeMatch newEmptyMatch() {
    return BehaviorParameterTypeMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorParameterTypeMatch newMatch(final Object... parameters) {
    return BehaviorParameterTypeMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (java.lang.Boolean) parameters[3], (java.lang.Boolean) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_ordered = body.getOrCreateVariableByName("ordered");
      PVariable var_unique = body.getOrCreateVariableByName("unique");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_ordered, "ordered"), 
        new ExportedParameter(body, var_unique, "unique")
      ));
      
      new TypeUnary(body, var_behavior, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior");
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_behavior, var_parameter, var___0_), BehaviorParameterQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_parameter, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new TypeBinary(body, CONTEXT, var_parameter, var_ordered, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isOrdered"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isOrdered");
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_unique, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isUnique"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isUnique");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorParameterTypeQuerySpecification INSTANCE = make();
    
    public static BehaviorParameterTypeQuerySpecification make() {
      return new BehaviorParameterTypeQuerySpecification();					
      
    }
  }
}
