package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RedefinedLeafMatch;
import hu.eltesoft.modelexecution.validation.RedefinedLeafMatcher;
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
 * A pattern-specific query specification that can instantiate RedefinedLeafMatcher in a type-safe way.
 * 
 * @see RedefinedLeafMatcher
 * @see RedefinedLeafMatch
 * 
 */
@SuppressWarnings("all")
public final class RedefinedLeafQuerySpecification extends BaseGeneratedEMFQuerySpecification<RedefinedLeafMatcher> {
  private RedefinedLeafQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RedefinedLeafQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RedefinedLeafMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedLeafMatcher.on(engine);
  }
  
  @Override
  public RedefinedLeafMatch newEmptyMatch() {
    return RedefinedLeafMatch.newEmptyMatch();
  }
  
  @Override
  public RedefinedLeafMatch newMatch(final Object... parameters) {
    return RedefinedLeafMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static RedefinedLeafQuerySpecification INSTANCE = make();
    
    public static RedefinedLeafQuerySpecification make() {
      return new RedefinedLeafQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RedefinedLeafQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RedefinedLeaf";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("op","redefined");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("op", "org.eclipse.uml2.uml.Operation"),new PParameter("redefined", "org.eclipse.uml2.uml.Operation"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_op = body.getOrCreateVariableByName("op");
      		PVariable var_redefined = body.getOrCreateVariableByName("redefined");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op"),
      		   new ExportedParameter(body, var_redefined, "redefined")
      		));
      		// 	Operation.redefinedOperation(op, redefined)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "redefinedOperation")));
      		new Equality(body, var__virtual_0_, var_redefined);
      		// 	Operation.isLeaf(redefined, true)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, true);
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_redefined, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "RedefinableElement", "isLeaf")));
      		new Equality(body, var__virtual_2_, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Cannot redefine the leaf operation {redefined}");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "op"
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
