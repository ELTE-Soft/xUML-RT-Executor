package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBoundMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AssociationEndUpperBoundMatcher in a type-safe way.
 * 
 * @see AssociationEndUpperBoundMatcher
 * @see AssociationEndUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationEndUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<AssociationEndUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationEndUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AssociationEndUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("association","end","cls","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("association", "org.eclipse.uml2.uml.Association"),new PParameter("end", "org.eclipse.uml2.uml.Property"),new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public AssociationEndUpperBoundMatch newEmptyMatch() {
    return AssociationEndUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationEndUpperBoundMatch newMatch(final Object... parameters) {
    return AssociationEndUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Class) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_association = body.getOrCreateVariableByName("association");
      PVariable var_end = body.getOrCreateVariableByName("end");
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_association, "association"), 
        new ExportedParameter(body, var_end, "end"), 
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_association, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association"), "http://www.eclipse.org/uml2/5.0.0/UML/Association");
      
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new PositivePatternCall(body, new FlatTuple(var_association, var_end, var_cls), AssociationEndTypeQuerySpecification.instance());
      new TypeUnary(body, var_end, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_end, var_upperBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AssociationEndUpperBoundQuerySpecification INSTANCE = make();
    
    public static AssociationEndUpperBoundQuerySpecification make() {
      return new AssociationEndUpperBoundQuerySpecification();					
      
    }
  }
}
