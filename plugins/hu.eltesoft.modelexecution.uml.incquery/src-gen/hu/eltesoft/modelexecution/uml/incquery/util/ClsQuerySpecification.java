package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.IsBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.IsStereotypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ClsMatcher in a type-safe way.
 * 
 * @see ClsMatcher
 * @see ClsMatch
 * 
 */
@SuppressWarnings("all")
public final class ClsQuerySpecification extends BaseGeneratedQuerySpecification<ClsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ClsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClsMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Cls";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"));
  }
  
  @Override
  public ClsMatch newEmptyMatch() {
    return ClsMatch.newEmptyMatch();
  }
  
  @Override
  public ClsMatch newMatch(final Object... parameters) {
    return ClsMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      new NegativePatternCall(body, new FlatTuple(var_cls), IsBehaviorQuerySpecification.instance().instance());
      new NegativePatternCall(body, new FlatTuple(var_cls), IsStereotypeQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ClsQuerySpecification INSTANCE = make();
    
    public static ClsQuerySpecification make() {
      return new ClsQuerySpecification();					
      
    }
  }
}
