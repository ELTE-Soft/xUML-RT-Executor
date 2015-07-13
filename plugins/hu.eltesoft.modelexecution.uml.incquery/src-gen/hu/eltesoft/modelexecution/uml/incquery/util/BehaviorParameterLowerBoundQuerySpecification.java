package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate BehaviorParameterLowerBoundMatcher in a type-safe way.
 * 
 * @see BehaviorParameterLowerBoundMatcher
 * @see BehaviorParameterLowerBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorParameterLowerBoundQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorParameterLowerBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorParameterLowerBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorParameterLowerBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterLowerBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","parameter","type","lowerBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("lowerBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public BehaviorParameterLowerBoundMatch newEmptyMatch() {
    return BehaviorParameterLowerBoundMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorParameterLowerBoundMatch newMatch(final Object... parameters) {
    return BehaviorParameterLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lowerBound = body.getOrCreateVariableByName("lowerBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lowerBound, "lowerBound")
      ));
      
      new TypeUnary(body, var_behavior, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior");
      
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      
      
      new PositivePatternCall(body, new FlatTuple(var_behavior, var_parameter, var_type, var___0_, var___1_), BehaviorParameterTypeQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_parameter, var_lowerBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorParameterLowerBoundQuerySpecification INSTANCE = make();
    
    public static BehaviorParameterLowerBoundQuerySpecification make() {
      return new BehaviorParameterLowerBoundQuerySpecification();					
      
    }
  }
}
