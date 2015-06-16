package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ReceptionParameterTypeMatcher in a type-safe way.
 * 
 * @see ReceptionParameterTypeMatcher
 * @see ReceptionParameterTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionParameterTypeQuerySpecification extends BaseGeneratedQuerySpecification<ReceptionParameterTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionParameterTypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReceptionParameterTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterTypeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterType";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","reception","parameter","type","ordered","unique");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("ordered", "java.lang.Boolean"),new PParameter("unique", "java.lang.Boolean"));
  }
  
  @Override
  public ReceptionParameterTypeMatch newEmptyMatch() {
    return ReceptionParameterTypeMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionParameterTypeMatch newMatch(final Object... parameters) {
    return ReceptionParameterTypeMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2], (org.eclipse.uml2.uml.Type) parameters[3], (java.lang.Boolean) parameters[4], (java.lang.Boolean) parameters[5]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_reception = body.getOrCreateVariableByName("reception");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_ordered = body.getOrCreateVariableByName("ordered");
      PVariable var_unique = body.getOrCreateVariableByName("unique");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_reception, "reception"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_ordered, "ordered"), 
        new ExportedParameter(body, var_unique, "unique")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_reception, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception"), "http://www.eclipse.org/uml2/5.0.0/UML/Reception");
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_reception, var_parameter), ReceptionParameterQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      new TypeBinary(body, CONTEXT, var_parameter, var_ordered, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isOrdered"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isOrdered");
      new TypeBinary(body, CONTEXT, var_parameter, var_unique, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "isUnique"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.isUnique");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReceptionParameterTypeQuerySpecification INSTANCE = make();
    
    public static ReceptionParameterTypeQuerySpecification make() {
      return new ReceptionParameterTypeQuerySpecification();					
      
    }
  }
}
