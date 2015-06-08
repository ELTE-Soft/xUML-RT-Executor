package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatch;
import hu.eltesoft.modelexecution.uml.incquery.OperationMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate OperationMatcher in a type-safe way.
 * 
 * @see OperationMatcher
 * @see OperationMatch
 * 
 */
@SuppressWarnings("all")
public final class OperationQuerySpecification extends BaseGeneratedQuerySpecification<OperationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OperationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OperationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OperationMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Operation";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","isStatic");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("isStatic", "java.lang.Boolean"));
  }
  
  @Override
  public OperationMatch newEmptyMatch() {
    return OperationMatch.newEmptyMatch();
  }
  
  @Override
  public OperationMatch newMatch(final Object... parameters) {
    return OperationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (java.lang.Boolean) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_isStatic = body.getOrCreateVariableByName("isStatic");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_isStatic, "isStatic")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_cls, var_operation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedOperation");
      new TypeBinary(body, CONTEXT, var_operation, var_isStatic, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Feature", "isStatic"), "http://www.eclipse.org/uml2/5.0.0/UML/Feature.isStatic");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OperationQuerySpecification INSTANCE = make();
    
    public static OperationQuerySpecification make() {
      return new OperationQuerySpecification();					
      
    }
  }
}
