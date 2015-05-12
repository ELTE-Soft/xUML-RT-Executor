package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.StateMatch;
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate StateMatcher in a type-safe way.
 * 
 * @see StateMatcher
 * @see StateMatch
 * 
 */
@SuppressWarnings("all")
public final class StateQuerySpecification extends BaseGeneratedQuerySpecification<StateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StateQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected StateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StateMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.State";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","state","stateName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("stateName", "java.lang.String"));
  }
  
  @Override
  public StateMatch newEmptyMatch() {
    return StateMatch.newEmptyMatch();
  }
  
  @Override
  public StateMatch newMatch(final Object... parameters) {
    return StateMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_state = body.getOrCreateVariableByName("state");
      PVariable var_stateName = body.getOrCreateVariableByName("stateName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_state, "state"), 
        new ExportedParameter(body, var_stateName, "stateName")
      ));
      
      
      new TypeUnary(body, var_state, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      
      new TypeBinary(body, CONTEXT, var_state, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Vertex.container");
      new TypeBinary(body, CONTEXT, var_state, var_stateName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static StateQuerySpecification INSTANCE = make();
    
    public static StateQuerySpecification make() {
      return new StateQuerySpecification();					
      
    }
  }
}
