package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate OperationParameterLowerBoundMatcher in a type-safe way.
 * 
 * @see OperationParameterLowerBoundMatcher
 * @see OperationParameterLowerBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationParameterLowerBoundQuerySpecification extends BaseGeneratedQuerySpecification<OperationParameterLowerBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationParameterLowerBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OperationParameterLowerBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterLowerBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationParameterLowerBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","parameter","type","lowerBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("lowerBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public OperationParameterLowerBoundMatch newEmptyMatch() {
    return OperationParameterLowerBoundMatch.newEmptyMatch();
  }
  
  @Override
  public OperationParameterLowerBoundMatch newMatch(final Object... parameters) {
    return OperationParameterLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2], (org.eclipse.uml2.uml.Type) parameters[3], (org.eclipse.uml2.uml.ValueSpecification) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lowerBound = body.getOrCreateVariableByName("lowerBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lowerBound, "lowerBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var_parameter, var_type, var___0_, var___1_), OperationParameterTypeQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_lowerBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OperationParameterLowerBoundQuerySpecification INSTANCE = make();
    
    public static OperationParameterLowerBoundQuerySpecification make() {
      return new OperationParameterLowerBoundQuerySpecification();					
      
    }
  }
}
