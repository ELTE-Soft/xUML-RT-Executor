package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatch;
import hu.eltesoft.modelexecution.uml.incquery.RegionOfClassMatcher;
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
 * A pattern-specific query specification that can instantiate RegionOfClassMatcher in a type-safe way.
 * 
 * @see RegionOfClassMatcher
 * @see RegionOfClassMatch
 * 
 */
@SuppressWarnings("all")
public final class RegionOfClassQuerySpecification extends BaseGeneratedQuerySpecification<RegionOfClassMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RegionOfClassQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected RegionOfClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RegionOfClassMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.RegionOfClass";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","region");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("region", "org.eclipse.uml2.uml.Region"));
  }
  
  @Override
  public RegionOfClassMatch newEmptyMatch() {
    return RegionOfClassMatch.newEmptyMatch();
  }
  
  @Override
  public RegionOfClassMatch newMatch(final Object... parameters) {
    return RegionOfClassMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Region) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_region, "region")
      ));
      
      new TypeUnary(body, var_cls, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeBinary(body, CONTEXT, var_cls, var_stateMachine, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "ownedBehavior"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioredClassifier.ownedBehavior");
      new TypeBinary(body, CONTEXT, var_stateMachine, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine", "region"), "http://www.eclipse.org/uml2/5.0.0/UML/StateMachine.region");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static RegionOfClassQuerySpecification INSTANCE = make();
    
    public static RegionOfClassQuerySpecification make() {
      return new RegionOfClassQuerySpecification();					
      
    }
  }
}
