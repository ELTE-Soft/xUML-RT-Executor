package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate OperationParameterMatcher in a type-safe way.
 * 
 * @see OperationParameterMatcher
 * @see OperationParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationParameterQuerySpecification extends BaseGeneratedQuerySpecification<OperationParameterMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationParameterQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OperationParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationParameterMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.OperationParameter";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","parameter","type","direction");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("direction", "org.eclipse.uml2.uml.ParameterDirectionKind"));
  }
  
  @Override
  public OperationParameterMatch newEmptyMatch() {
    return OperationParameterMatch.newEmptyMatch();
  }
  
  @Override
  public OperationParameterMatch newMatch(final Object... parameters) {
    return OperationParameterMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2], (org.eclipse.uml2.uml.Type) parameters[3], (org.eclipse.uml2.uml.ParameterDirectionKind) parameters[4]);
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
      PVariable var_direction = body.getOrCreateVariableByName("direction");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_direction, "direction")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var___0_), OperationQuerySpecification.instance());
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      new TypeBinary(body, CONTEXT, var_operation, var_parameter, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioralFeature.ownedParameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_direction, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter.direction");
      new TypeBinary(body, CONTEXT, var_parameter, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new ConstantValue(body, var__virtual_3_, org.eclipse.uml2.uml.ParameterDirectionKind.get("return"));
      new Inequality(body, var_direction, var__virtual_3_);
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OperationParameterQuerySpecification INSTANCE = make();
    
    public static OperationParameterQuerySpecification make() {
      return new OperationParameterQuerySpecification();					
      
    }
  }
}
