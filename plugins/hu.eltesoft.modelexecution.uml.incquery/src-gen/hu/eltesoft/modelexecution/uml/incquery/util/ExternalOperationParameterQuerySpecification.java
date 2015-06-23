package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationParameterQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ExternalOperationParameterMatcher in a type-safe way.
 * 
 * @see ExternalOperationParameterMatcher
 * @see ExternalOperationParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalOperationParameterQuerySpecification extends BaseGeneratedQuerySpecification<ExternalOperationParameterMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalOperationParameterQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ExternalOperationParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalOperationParameterMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameter";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","parameter","typeName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("typeName", "java.lang.String"));
  }
  
  @Override
  public ExternalOperationParameterMatch newEmptyMatch() {
    return ExternalOperationParameterMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalOperationParameterMatch newMatch(final Object... parameters) {
    return ExternalOperationParameterMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2], (java.lang.String) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_typeName = body.getOrCreateVariableByName("typeName");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var_type = body.getOrCreateVariableByName("type");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_typeName, "typeName")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_operation, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation"), "http://www.eclipse.org/uml2/5.0.0/UML/Operation");
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_operation, var_parameter, var___0_), OperationParameterQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new TypeBinary(body, CONTEXT, var_type, var_typeName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ExternalOperationParameterQuerySpecification INSTANCE = make();
    
    public static ExternalOperationParameterQuerySpecification make() {
      return new ExternalOperationParameterQuerySpecification();					
      
    }
  }
}
