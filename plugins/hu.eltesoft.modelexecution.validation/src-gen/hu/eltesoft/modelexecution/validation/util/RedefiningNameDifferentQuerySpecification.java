package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RedefiningNameDifferentMatch;
import hu.eltesoft.modelexecution.validation.RedefiningNameDifferentMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate RedefiningNameDifferentMatcher in a type-safe way.
 * 
 * @see RedefiningNameDifferentMatcher
 * @see RedefiningNameDifferentMatch
 * 
 */
@SuppressWarnings("all")
public final class RedefiningNameDifferentQuerySpecification extends BaseGeneratedEMFQuerySpecification<RedefiningNameDifferentMatcher> {
  private RedefiningNameDifferentQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RedefiningNameDifferentQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RedefiningNameDifferentMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RedefiningNameDifferentMatcher.on(engine);
  }
  
  @Override
  public RedefiningNameDifferentMatch newEmptyMatch() {
    return RedefiningNameDifferentMatch.newEmptyMatch();
  }
  
  @Override
  public RedefiningNameDifferentMatch newMatch(final Object... parameters) {
    return RedefiningNameDifferentMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static RedefiningNameDifferentQuerySpecification INSTANCE = make();
    
    public static RedefiningNameDifferentQuerySpecification make() {
      return new RedefiningNameDifferentQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RedefiningNameDifferentQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RedefiningNameDifferent";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("op");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("op", "org.eclipse.uml2.uml.Operation"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_op = body.getOrCreateVariableByName("op");
      		PVariable var_redefined = body.getOrCreateVariableByName("redefined");
      		PVariable var_n1 = body.getOrCreateVariableByName("n1");
      		PVariable var_n2 = body.getOrCreateVariableByName("n2");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op")
      		));
      		// 	Operation.redefinedOperation(op, redefined)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "redefinedOperation")));
      		new Equality(body, var__virtual_0_, var_redefined);
      		// 	Operation.name(op, n1)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var_n1);
      		// 	Operation.name(redefined, n2)
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_redefined, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_2_, var_n2);
      		// 	n1 != n2
      		new Inequality(body, var_n1, var_n2);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Redefining operation must have the same name as the redefined");
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
