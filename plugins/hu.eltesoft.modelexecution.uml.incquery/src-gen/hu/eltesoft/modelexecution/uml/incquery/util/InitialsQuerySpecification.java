package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatch;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate InitialsMatcher in a type-safe way.
 * 
 * @see InitialsMatcher
 * @see InitialsMatch
 * 
 */
@SuppressWarnings("all")
public final class InitialsQuerySpecification extends BaseGeneratedQuerySpecification<InitialsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InitialsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected InitialsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InitialsMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Initials";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","initPseudostate","initTransition","firstState");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("initPseudostate", "org.eclipse.uml2.uml.Pseudostate"),new PParameter("initTransition", "org.eclipse.uml2.uml.Transition"),new PParameter("firstState", "org.eclipse.uml2.uml.State"));
  }
  
  @Override
  public InitialsMatch newEmptyMatch() {
    return InitialsMatch.newEmptyMatch();
  }
  
  @Override
  public InitialsMatch newMatch(final Object... parameters) {
    return InitialsMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.Pseudostate) parameters[1], (org.eclipse.uml2.uml.Transition) parameters[2], (org.eclipse.uml2.uml.State) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_initPseudostate = body.getOrCreateVariableByName("initPseudostate");
      PVariable var_initTransition = body.getOrCreateVariableByName("initTransition");
      PVariable var_firstState = body.getOrCreateVariableByName("firstState");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_initPseudostate, "initPseudostate"), 
        new ExportedParameter(body, var_initTransition, "initTransition"), 
        new ExportedParameter(body, var_firstState, "firstState")
      ));
      
      
      
      
      new TypeUnary(body, var_firstState, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      new TypeBinary(body, CONTEXT, var_initPseudostate, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Vertex.container");
      new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.PseudostateKind.get("initial"));
      new TypeBinary(body, CONTEXT, var_initPseudostate, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Pseudostate", "kind"), "http://www.eclipse.org/uml2/5.0.0/UML/Pseudostate.kind");
      new TypeBinary(body, CONTEXT, var_initTransition, var_initPseudostate, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "source"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.source");
      new TypeBinary(body, CONTEXT, var_initTransition, var_firstState, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Transition", "target"), "http://www.eclipse.org/uml2/5.0.0/UML/Transition.target");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static InitialsQuerySpecification INSTANCE = make();
    
    public static InitialsQuerySpecification make() {
      return new InitialsQuerySpecification();					
      
    }
  }
}
