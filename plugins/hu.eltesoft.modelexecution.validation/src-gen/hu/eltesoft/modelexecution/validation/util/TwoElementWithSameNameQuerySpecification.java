package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.TwoElementWithSameNameMatch;
import hu.eltesoft.modelexecution.validation.TwoElementWithSameNameMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TwoElementWithSameNameMatcher in a type-safe way.
 * 
 * @see TwoElementWithSameNameMatcher
 * @see TwoElementWithSameNameMatch
 * 
 */
@SuppressWarnings("all")
public final class TwoElementWithSameNameQuerySpecification extends BaseGeneratedEMFQuerySpecification<TwoElementWithSameNameMatcher> {
  private TwoElementWithSameNameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static TwoElementWithSameNameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected TwoElementWithSameNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return TwoElementWithSameNameMatcher.on(engine);
  }
  
  @Override
  public TwoElementWithSameNameMatch newEmptyMatch() {
    return TwoElementWithSameNameMatch.newEmptyMatch();
  }
  
  @Override
  public TwoElementWithSameNameMatch newMatch(final Object... parameters) {
    return TwoElementWithSameNameMatch.newMatch((java.lang.String) parameters[0], (org.eclipse.uml2.uml.NamedElement) parameters[1], (org.eclipse.uml2.uml.NamedElement) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static TwoElementWithSameNameQuerySpecification INSTANCE = make();
    
    public static TwoElementWithSameNameQuerySpecification make() {
      return new TwoElementWithSameNameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TwoElementWithSameNameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.TwoElementWithSameName";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("qname","elem1","elem2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("qname", "java.lang.String"),new PParameter("elem1", "org.eclipse.uml2.uml.NamedElement"),new PParameter("elem2", "org.eclipse.uml2.uml.NamedElement"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_qname = body.getOrCreateVariableByName("qname");
      	PVariable var_elem1 = body.getOrCreateVariableByName("elem1");
      	PVariable var_elem2 = body.getOrCreateVariableByName("elem2");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_qname, "qname"),
      				
      		new ExportedParameter(body, var_elem1, "elem1"),
      				
      		new ExportedParameter(body, var_elem2, "elem2")
      	));
      	new TypeConstraint(body, new FlatTuple(var_elem1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
      	new TypeConstraint(body, new FlatTuple(var_elem2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
      	new TypeConstraint(body, new FlatTuple(var_elem1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
      	new TypeConstraint(body, new FlatTuple(var_elem1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "qualifiedName")));
      	new Equality(body, var__virtual_0_, var_qname);
      	new TypeConstraint(body, new FlatTuple(var_elem2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement")));
      	new TypeConstraint(body, new FlatTuple(var_elem2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "qualifiedName")));
      	new Equality(body, var__virtual_1_, var_qname);
      	new Inequality(body, var_elem1, var_elem2);
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
