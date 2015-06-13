package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndLowerBoundQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ClassAssociationUpperBoundMatcher in a type-safe way.
 * 
 * @see ClassAssociationUpperBoundMatcher
 * @see ClassAssociationUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassAssociationUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<ClassAssociationUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassAssociationUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ClassAssociationUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ClassAssociationUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","end","type","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("end", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Association"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public ClassAssociationUpperBoundMatch newEmptyMatch() {
    return ClassAssociationUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public ClassAssociationUpperBoundMatch newMatch(final Object... parameters) {
    return ClassAssociationUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Association) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_end, "end"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_end, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association"), "http://www.eclipse.org/uml2/5.0.0/UML/Association");
      
      new TypeUnary(body, var_upperBound, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "ValueSpecification"), "http://www.eclipse.org/uml2/5.0.0/UML/ValueSpecification");
      new PositivePatternCall(body, new FlatTuple(var_type, var_end, var_cls, var_upperBound), AssociationEndLowerBoundQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ClassAssociationUpperBoundQuerySpecification INSTANCE = make();
    
    public static ClassAssociationUpperBoundQuerySpecification make() {
      return new ClassAssociationUpperBoundQuerySpecification();					
      
    }
  }
}
