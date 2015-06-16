package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionParameterTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ReceptionParameterUpperBoundMatcher in a type-safe way.
 * 
 * @see ReceptionParameterUpperBoundMatcher
 * @see ReceptionParameterUpperBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionParameterUpperBoundQuerySpecification extends BaseGeneratedQuerySpecification<ReceptionParameterUpperBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionParameterUpperBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReceptionParameterUpperBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterUpperBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterUpperBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","reception","parameter","type","upperBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("upperBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public ReceptionParameterUpperBoundMatch newEmptyMatch() {
    return ReceptionParameterUpperBoundMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionParameterUpperBoundMatch newMatch(final Object... parameters) {
    return ReceptionParameterUpperBoundMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2], (org.eclipse.uml2.uml.Type) parameters[3], (org.eclipse.uml2.uml.ValueSpecification) parameters[4]);
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
      PVariable var_upperBound = body.getOrCreateVariableByName("upperBound");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_reception, "reception"), 
        new ExportedParameter(body, var_parameter, "parameter"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_upperBound, "upperBound")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeUnary(body, var_reception, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception"), "http://www.eclipse.org/uml2/5.0.0/UML/Reception");
      
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type"), "http://www.eclipse.org/uml2/5.0.0/UML/Type");
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_reception, var_parameter, var_type, var___0_, var___1_), ReceptionParameterTypeQuerySpecification.instance());
      new TypeUnary(body, var_parameter, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_upperBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "upperValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.upperValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReceptionParameterUpperBoundQuerySpecification INSTANCE = make();
    
    public static ReceptionParameterUpperBoundQuerySpecification make() {
      return new ReceptionParameterUpperBoundQuerySpecification();					
      
    }
  }
}
