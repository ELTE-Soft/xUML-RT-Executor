package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate IsStereotypeMatcher in a type-safe way.
 * 
 * @see IsStereotypeMatcher
 * @see IsStereotypeMatch
 * 
 */
@SuppressWarnings("all")
final class IsStereotypeQuerySpecification extends BaseGeneratedQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IsStereotypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected IncQueryMatcher<IPatternMatch> instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.IsStereotype";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("stereotype");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("stereotype", "org.eclipse.uml2.uml.Stereotype"));
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
      PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_stereotype, "stereotype")
      ));
      
      new TypeUnary(body, var_stereotype, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Stereotype"), "http://www.eclipse.org/uml2/5.0.0/UML/Stereotype");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static IsStereotypeQuerySpecification INSTANCE = make();
    
    public static IsStereotypeQuerySpecification make() {
      return new IsStereotypeQuerySpecification();					
      
    }
  }
}
