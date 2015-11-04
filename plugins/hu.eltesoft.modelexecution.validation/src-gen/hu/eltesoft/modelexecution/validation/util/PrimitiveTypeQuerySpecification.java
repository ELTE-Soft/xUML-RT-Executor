package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate PrimitiveTypeMatcher in a type-safe way.
 * 
 * @see PrimitiveTypeMatcher
 * @see PrimitiveTypeMatch
 * 
 */
@SuppressWarnings("all")
final class PrimitiveTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private PrimitiveTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PrimitiveTypeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncQueryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  private static class LazyHolder {
    private final static PrimitiveTypeQuerySpecification INSTANCE = make();
    
    public static PrimitiveTypeQuerySpecification make() {
      return new PrimitiveTypeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PrimitiveTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.PrimitiveType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ty");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ty", "org.eclipse.uml2.uml.PrimitiveType"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ty = body.getOrCreateVariableByName("ty");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ty, "ty")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PrimitiveType")));
      	new TypeConstraint(body, new FlatTuple(var_ty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PrimitiveType")));
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
