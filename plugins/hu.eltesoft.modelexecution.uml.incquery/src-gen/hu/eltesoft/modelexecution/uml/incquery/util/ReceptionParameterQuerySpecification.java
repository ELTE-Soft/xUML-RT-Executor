package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReceptionParameterMatcher in a type-safe way.
 * 
 * @see ReceptionParameterMatcher
 * @see ReceptionParameterMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionParameterQuerySpecification extends BaseGeneratedQuerySpecification<ReceptionParameterMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionParameterQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReceptionParameterMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionParameterMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ReceptionParameter";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","reception","parameter");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("parameter", "org.eclipse.uml2.uml.Parameter"));
  }
  
  @Override
  public ReceptionParameterMatch newEmptyMatch() {
    return ReceptionParameterMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionParameterMatch newMatch(final Object... parameters) {
    return ReceptionParameterMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (org.eclipse.uml2.uml.Parameter) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_reception = body.getOrCreateVariableByName("reception");
      PVariable var_parameter = body.getOrCreateVariableByName("parameter");
      PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      PVariable var_direction = body.getOrCreateVariableByName("direction");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_reception, "reception"), 
        new ExportedParameter(body, var_parameter, "parameter")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      
      new PositivePatternCall(body, new FlatTuple(var_cls, var_reception, var___0_), ReceptionQuerySpecification.instance());
      new TypeUnary(body, var_reception, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception"), "http://www.eclipse.org/uml2/5.0.0/UML/Reception");
      new TypeBinary(body, CONTEXT, var_reception, var_parameter, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioralFeature.ownedParameter");
      new TypeBinary(body, CONTEXT, var_parameter, var_direction, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction"), "http://www.eclipse.org/uml2/5.0.0/UML/Parameter.direction");
      new ConstantValue(body, var_direction, org.eclipse.uml2.uml.ParameterDirectionKind.get("in"));
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReceptionParameterQuerySpecification INSTANCE = make();
    
    public static ReceptionParameterQuerySpecification make() {
      return new ReceptionParameterQuerySpecification();					
      
    }
  }
}
