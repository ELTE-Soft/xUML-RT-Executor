package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.LeafRedefinedMatch;
import hu.eltesoft.modelexecution.validation.LeafRedefinedMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate LeafRedefinedMatcher in a type-safe way.
 * 
 * @see LeafRedefinedMatcher
 * @see LeafRedefinedMatch
 * 
 */
@SuppressWarnings("all")
public final class LeafRedefinedQuerySpecification extends BaseGeneratedEMFQuerySpecification<LeafRedefinedMatcher> {
  private LeafRedefinedQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LeafRedefinedQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected LeafRedefinedMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LeafRedefinedMatcher.on(engine);
  }
  
  @Override
  public LeafRedefinedMatch newEmptyMatch() {
    return LeafRedefinedMatch.newEmptyMatch();
  }
  
  @Override
  public LeafRedefinedMatch newMatch(final Object... parameters) {
    return LeafRedefinedMatch.newMatch((org.eclipse.uml2.uml.RedefinableElement) parameters[0], (org.eclipse.uml2.uml.RedefinableElement) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static LeafRedefinedQuerySpecification INSTANCE = make();
    
    public static LeafRedefinedQuerySpecification make() {
      return new LeafRedefinedQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static LeafRedefinedQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.LeafRedefined";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("elem","redefining");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("elem", "org.eclipse.uml2.uml.RedefinableElement"),new PParameter("redefining", "org.eclipse.uml2.uml.RedefinableElement"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		PVariable var_redefining = body.getOrCreateVariableByName("redefining");
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement")));
      		new TypeConstraint(body, new FlatTuple(var_redefining), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_elem, "elem"),
      		   new ExportedParameter(body, var_redefining, "redefining")
      		));
      		// 	RedefinableElement.redefinedElement(redefining, elem)
      		new TypeConstraint(body, new FlatTuple(var_redefining), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_redefining, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement", "redefinedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	RedefinableElement.isLeaf(elem, true)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, true);
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_elem, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement", "isLeaf")));
      		new Equality(body, var__virtual_2_, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Redefinition of leaf element is not allowed");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "redefining"
      		                }));
      		addAnnotation(annotation);
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
