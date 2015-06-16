package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate BehaviorReturnUpperBoundMatcher in a type-safe way.
 * 
 * @see BehaviorReturnUpperBoundMatcher
 * @see BehaviorReturnUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class BehaviorReturnUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<BehaviorReturnUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BehaviorReturnUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BehaviorReturnUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","parameter","type","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public BehaviorReturnUpperBoundMatch newEmptyMatch() {
    return BehaviorReturnUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public BehaviorReturnUpperBoundMatch newMatch(final Object... parameters) {
    return BehaviorReturnUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Parameter) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_behavior, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Behavior"), "http://www.eclipse.org/uml2/5.0.0/UML/Behavior");
      
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type"), "http://www.eclipse.org/uml2/5.0.0/UML/Type");
      
      new PositivePatternCall(body, new FlatTuple(var_behavior, var_parameter, var_type, var___0_, var___1_), BehaviorReturnTypeQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_upperBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.upperValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BehaviorReturnUpperBoundQuerySpecification INSTANCE = make();
    
    public static BehaviorReturnUpperBoundQuerySpecification make() {
      return new BehaviorReturnUpperBoundQuerySpecification();					
      
    }
  }
}
