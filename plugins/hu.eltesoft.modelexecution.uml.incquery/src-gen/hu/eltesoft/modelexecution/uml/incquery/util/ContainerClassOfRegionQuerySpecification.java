package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatcher;
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
 * A pattern-specific query specification that can instantiate ContainerClassOfRegionMatcher in a type-safe way.
 * 
 * @see ContainerClassOfRegionMatcher
 * @see ContainerClassOfRegionMatch
 * 
 */
@SuppressWarnings("all")
public final class ContainerClassOfRegionQuerySpecification extends BaseGeneratedQuerySpecification<ContainerClassOfRegionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ContainerClassOfRegionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ContainerClassOfRegionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfRegionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegion";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("region","containerClass","containerClassName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("region", "org.eclipse.uml2.uml.Region"),new PParameter("containerClass", "org.eclipse.uml2.uml.Class"),new PParameter("containerClassName", "java.lang.String"));
  }
  
  @Override
  public ContainerClassOfRegionMatch newEmptyMatch() {
    return ContainerClassOfRegionMatch.newEmptyMatch();
  }
  
  @Override
  public ContainerClassOfRegionMatch newMatch(final Object... parameters) {
    return ContainerClassOfRegionMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_region = body.getOrCreateVariableByName("region");
      PVariable var_containerClass = body.getOrCreateVariableByName("containerClass");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_stateMachine = body.getOrCreateVariableByName("stateMachine");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_region, "region"), 
        new ExportedParameter(body, var_containerClass, "containerClass"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      
      new TypeUnary(body, var_containerClass, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      new TypeBinary(body, CONTEXT, var_containerClass, var_containerClassName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      new TypeBinary(body, CONTEXT, var_containerClass, var_stateMachine, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioredClassifier", "ownedBehavior"), "http://www.eclipse.org/uml2/5.0.0/UML/BehavioredClassifier.ownedBehavior");
      new TypeBinary(body, CONTEXT, var_stateMachine, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StateMachine", "region"), "http://www.eclipse.org/uml2/5.0.0/UML/StateMachine.region");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ContainerClassOfRegionQuerySpecification INSTANCE = make();
    
    public static ContainerClassOfRegionQuerySpecification make() {
      return new ContainerClassOfRegionQuerySpecification();					
      
    }
  }
}
