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
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityMatcher in a type-safe way.
 * 
 * @see ExternalEntityMatcher
 * @see ExternalEntityMatch
 * 
 */
@SuppressWarnings("all")
final class ExternalEntityQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private ExternalEntityQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityQuerySpecification instance() throws IncQueryException {
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
    private final static ExternalEntityQuerySpecification INSTANCE = make();
    
    public static ExternalEntityQuerySpecification make() {
      return new ExternalEntityQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntity";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("base","annot");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("base", "org.eclipse.uml2.uml.Class"),new PParameter("annot", "hu.eltesoft.modelexecution.profile.xumlrt.ExternalEntity"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_base = body.getOrCreateVariableByName("base");
      		PVariable var_annot = body.getOrCreateVariableByName("annot");
      		new TypeConstraint(body, new FlatTuple(var_base), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_annot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://modelexecution.eltesoft.hu/xumlrt/", "ExternalEntity")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_base, "base"),
      		   new ExportedParameter(body, var_annot, "annot")
      		));
      		// 	ExternalEntity.base_Class(annot, base)
      		new TypeConstraint(body, new FlatTuple(var_annot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://modelexecution.eltesoft.hu/xumlrt/", "ExternalEntity")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_annot, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://modelexecution.eltesoft.hu/xumlrt/", "ExternalEntity", "base_Class")));
      		new Equality(body, var__virtual_0_, var_base);
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
