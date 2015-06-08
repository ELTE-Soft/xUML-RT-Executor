package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ClsQuerySpecification;
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
 * A pattern-specific query specification that can instantiate AssociationMatcher in a type-safe way.
 * 
 * @see AssociationMatcher
 * @see AssociationMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationQuerySpecification extends BaseGeneratedQuerySpecification<AssociationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AssociationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Association";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","association","type","lower","upper");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("association", "org.eclipse.uml2.uml.Association"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("lower", "org.eclipse.uml2.uml.ValueSpecification"),new PParameter("upper", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public AssociationMatch newEmptyMatch() {
    return AssociationMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationMatch newMatch(final Object... parameters) {
    return AssociationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Association) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3], (org.eclipse.uml2.uml.ValueSpecification) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_association = body.getOrCreateVariableByName("association");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lower = body.getOrCreateVariableByName("lower");
      PVariable var_upper = body.getOrCreateVariableByName("upper");
      PVariable var_property = body.getOrCreateVariableByName("property");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_association, "association"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lower, "lower"), 
        new ExportedParameter(body, var_upper, "upper")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls), ClsQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_association, var_property, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "memberEnd"), "http://www.eclipse.org/uml2/5.0.0/UML/Association.memberEnd");
      new TypeBinary(body, CONTEXT, var_cls, var_property, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute"), "http://www.eclipse.org/uml2/5.0.0/UML/StructuredClassifier.ownedAttribute");
      new TypeBinary(body, CONTEXT, var_property, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new TypeBinary(body, CONTEXT, var_property, var_lower, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      new TypeBinary(body, CONTEXT, var_property, var_upper, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.upperValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AssociationQuerySpecification INSTANCE = make();
    
    public static AssociationQuerySpecification make() {
      return new AssociationQuerySpecification();					
      
    }
  }
}
