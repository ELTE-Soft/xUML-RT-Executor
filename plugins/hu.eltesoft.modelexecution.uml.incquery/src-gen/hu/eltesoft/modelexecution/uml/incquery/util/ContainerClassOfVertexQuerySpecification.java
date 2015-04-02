package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
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
 * A pattern-specific query specification that can instantiate ContainerClassOfVertexMatcher in a type-safe way.
 * 
 * @see ContainerClassOfVertexMatcher
 * @see ContainerClassOfVertexMatch
 * 
 */
@SuppressWarnings("all")
final class ContainerClassOfVertexQuerySpecification extends BaseGeneratedQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ContainerClassOfVertexQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected IncQueryMatcher<IPatternMatch> instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfVertex";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("vertex","containerClassName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("vertex", "org.eclipse.uml2.uml.Vertex"),new PParameter("containerClassName", "java.lang.String"));
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_vertex = body.getOrCreateVariableByName("vertex");
      PVariable var_containerClassName = body.getOrCreateVariableByName("containerClassName");
      PVariable var_region = body.getOrCreateVariableByName("region");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_vertex, "vertex"), 
        new ExportedParameter(body, var_containerClassName, "containerClassName")
      ));
      
      
      new TypeUnary(body, var_vertex, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "State"), "http://www.eclipse.org/uml2/5.0.0/UML/State");
      new TypeBinary(body, CONTEXT, var_vertex, var_region, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Vertex", "container"), "http://www.eclipse.org/uml2/5.0.0/UML/Vertex.container");
      new PositivePatternCall(body, new FlatTuple(var_region, var_containerClassName), ContainerClassOfRegionQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ContainerClassOfVertexQuerySpecification INSTANCE = make();
    
    public static ContainerClassOfVertexQuerySpecification make() {
      return new ContainerClassOfVertexQuerySpecification();					
      
    }
  }
}
