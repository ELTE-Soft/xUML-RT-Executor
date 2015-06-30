package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationReturnTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate OperationReturnUpperBoundMatcher in a type-safe way.
 * 
 * @see OperationReturnUpperBoundMatcher
 * @see OperationReturnUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationReturnUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<OperationReturnUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationReturnUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OperationReturnUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationReturnUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationReturnUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","type","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public OperationReturnUpperBoundMatch newEmptyMatch() {
    return OperationReturnUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public OperationReturnUpperBoundMatch newMatch(final Object... parameters) {
    return OperationReturnUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var_parameter), OperationReturnQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var_type, var___0_, var___1_), OperationReturnTypeQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_upperBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.upperValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OperationReturnUpperBoundQuerySpecification INSTANCE = make();
    
    public static OperationReturnUpperBoundQuerySpecification make() {
      return new OperationReturnUpperBoundQuerySpecification();					
      
    }
  }
}