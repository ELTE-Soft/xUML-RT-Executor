package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationOtherEndQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassAssociationTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ClassAssociationLowerBoundMatcher in a type-safe way.
 * 
 * @see ClassAssociationLowerBoundMatcher
 * @see ClassAssociationLowerBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class ClassAssociationLowerBoundQuerySpecification extends BaseGeneratedQuerySpecification<ClassAssociationLowerBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ClassAssociationLowerBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ClassAssociationLowerBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ClassAssociationLowerBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","end","type","lowerBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("end", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Association"),new PParameter("lowerBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public ClassAssociationLowerBoundMatch newEmptyMatch() {
    return ClassAssociationLowerBoundMatch.newEmptyMatch();
  }
  
  @Override
  public ClassAssociationLowerBoundMatch newMatch(final Object... parameters) {
    return ClassAssociationLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Association) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lowerBound = body.getOrCreateVariableByName("lowerBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      PVariable var_otherEnd = body.getOrCreateVariableByName("otherEnd");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_end, "end"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lowerBound, "lowerBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_end, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association"), "http://www.eclipse.org/uml2/5.0.0/UML/Association");
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_end, var_type, var___0_, var___1_), ClassAssociationTypeQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_end, var_otherEnd), AssociationOtherEndQuerySpecification.instance());
      new TypeUnary(body, var_otherEnd, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_otherEnd, var_lowerBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ClassAssociationLowerBoundQuerySpecification INSTANCE = make();
    
    public static ClassAssociationLowerBoundQuerySpecification make() {
      return new ClassAssociationLowerBoundQuerySpecification();					
      
    }
  }
}
