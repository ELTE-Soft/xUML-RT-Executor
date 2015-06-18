package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate AssociationMatcher in a type-safe way.
 * 
 * @see AssociationMatcher
 * @see AssociationMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationQuerySpecification extends BaseGeneratedQuerySpecification<AssociationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AssociationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Association";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("association");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("association", "org.eclipse.uml2.uml.Association"));
  }
  
  @Override
  public AssociationMatch newEmptyMatch() {
    return AssociationMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationMatch newMatch(final Object... parameters) {
    return AssociationMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_association = body.getOrCreateVariableByName("association");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_association, "association")
      ));
      
      new TypeUnary(body, var_association, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association"), "http://www.eclipse.org/uml2/5.0.0/UML/Association");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AssociationQuerySpecification INSTANCE = make();
    
    public static AssociationQuerySpecification make() {
      return new AssociationQuerySpecification();					
      
    }
  }
}
