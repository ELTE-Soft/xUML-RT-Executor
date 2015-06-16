package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate OperationReturnMatcher in a type-safe way.
 * 
 * @see OperationReturnMatcher
 * @see OperationReturnMatch
 * 
 */
@SuppressWarnings("all")
final class OperationReturnQuerySpecification extends BaseGeneratedQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationReturnQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected IncQueryMatcher<IPatternMatch> instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationReturn";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","parameter");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"));
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_parameter, "parameter")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var___0_), OperationQuerySpecification.instance());
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      new TypeBinary(body, CONTEXT, var_operation, var_parameter, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioralFeature.ownedParameter");
      new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      new TypeBinary(body, CONTEXT, var_parameter, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter.direction");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OperationReturnQuerySpecification INSTANCE = make();
    
    public static OperationReturnQuerySpecification make() {
      return new OperationReturnQuerySpecification();					
      
    }
  }
}
