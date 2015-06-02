package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatch;
import hu.eltesoft.modelexecution.uml.incquery.MethodMatcher;
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
 * A pattern-specific query specification that can instantiate MethodMatcher in a type-safe way.
 * 
 * @see MethodMatcher
 * @see MethodMatch
 * 
 */
@SuppressWarnings("all")
public final class MethodQuerySpecification extends BaseGeneratedQuerySpecification<MethodMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static MethodQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected MethodMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return MethodMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Method";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","operation","method");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("operation", "org.eclipse.uml2.uml.Operation"),new PParameter("method", "org.eclipse.uml2.uml.Behavior"));
  }
  
  @Override
  public MethodMatch newEmptyMatch() {
    return MethodMatch.newEmptyMatch();
  }
  
  @Override
  public MethodMatch newMatch(final Object... parameters) {
    return MethodMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1], (org.eclipse.uml2.uml.Behavior) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_operation = body.getOrCreateVariableByName("operation");
      PVariable var_method = body.getOrCreateVariableByName("method");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_operation, "operation"), 
        new ExportedParameter(body, var_method, "method")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_cls, var_operation, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedOperation");
      new TypeBinary(body, CONTEXT, var_operation, var_method, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "method"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioralFeature.method");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static MethodQuerySpecification INSTANCE = make();
    
    public static MethodQuerySpecification make() {
      return new MethodQuerySpecification();					
      
    }
  }
}
