package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndTypeQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ClassAssociationMatcher in a type-safe way.
 * 
 * @see ClassAssociationMatcher
 * @see ClassAssociationMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassAssociationQuerySpecification extends BaseGeneratedQuerySpecification<ClassAssociationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassAssociationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ClassAssociationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ClassAssociation";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","end");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("end", "org.eclipse.uml2.uml.Property"));
  }
  
  @Override
  public ClassAssociationMatch newEmptyMatch() {
    return ClassAssociationMatch.newEmptyMatch();
  }
  
  @Override
  public ClassAssociationMatch newMatch(final Object... parameters) {
    return ClassAssociationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_end, "end")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_end, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new PositivePatternCall(body, new FlatTuple(var___0_, var_end, var_cls), AssociationEndTypeQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ClassAssociationQuerySpecification INSTANCE = make();
    
    public static ClassAssociationQuerySpecification make() {
      return new ClassAssociationQuerySpecification();					
      
    }
  }
}
