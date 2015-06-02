package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatch;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate ExitMatcher in a type-safe way.
 * 
 * @see ExitMatcher
 * @see ExitMatch
 * 
 */
@SuppressWarnings("all")
public final class ExitQuerySpecification extends BaseGeneratedQuerySpecification<ExitMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExitQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ExitMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExitMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Exit";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","state","exit");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("state", "org.eclipse.uml2.uml.State"),new PParameter("exit", "org.eclipse.uml2.uml.Behavior"));
  }
  
  @Override
  public ExitMatch newEmptyMatch() {
    return ExitMatch.newEmptyMatch();
  }
  
  @Override
  public ExitMatch newMatch(final Object... parameters) {
    return ExitMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1], (org.eclipse.uml2.uml.Behavior) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_state = body.getOrCreateVariableByName("state");
      PVariable var_exit = body.getOrCreateVariableByName("exit");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_state, "state"), 
        new ExportedParameter(body, var_exit, "exit")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_state, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Vertex.container");
      new TypeBinary(body, CONTEXT, var_state, var_exit, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State", "exit"), "http://www.eclipse.org/uml2/5.0.0/UML/State.exit");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ExitQuerySpecification INSTANCE = make();
    
    public static ExitQuerySpecification make() {
      return new ExitQuerySpecification();					
      
    }
  }
}
