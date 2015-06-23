package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.FinalStateMatch;
import hu.eltesoft.modelexecution.uml.incquery.FinalStateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.StateQuerySpecification;
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
 * A pattern-specific query specification that can instantiate FinalStateMatcher in a type-safe way.
 * 
 * @see FinalStateMatcher
 * @see FinalStateMatch
 * 
 */
@SuppressWarnings("all")
public final class FinalStateQuerySpecification extends BaseGeneratedQuerySpecification<FinalStateMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FinalStateQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected FinalStateMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FinalStateMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.FinalState";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","state");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("state", "org.eclipse.uml2.uml.State"));
  }
  
  @Override
  public FinalStateMatch newEmptyMatch() {
    return FinalStateMatch.newEmptyMatch();
  }
  
  @Override
  public FinalStateMatch newMatch(final Object... parameters) {
    return FinalStateMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.State) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_state = body.getOrCreateVariableByName("state");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_state, "state")
      ));
      
      new TypeUnary(body, var_region, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region"), "http://www.eclipse.org/uml2/5.0.0/UML/Region");
      
      new PositivePatternCall(body, new FlatTuple(var_region, var_state), StateQuerySpecification.instance());
      new TypeUnary(body, var_state, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "FinalState"), "http://www.eclipse.org/uml2/5.0.0/UML/FinalState");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static FinalStateQuerySpecification INSTANCE = make();
    
    public static FinalStateQuerySpecification make() {
      return new FinalStateQuerySpecification();					
      
    }
  }
}
