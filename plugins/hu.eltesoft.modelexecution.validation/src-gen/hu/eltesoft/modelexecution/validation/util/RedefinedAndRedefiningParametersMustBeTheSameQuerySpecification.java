package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSameMatch;
import hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSameMatcher;
import hu.eltesoft.modelexecution.validation.util.ParamsCheckQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate RedefinedAndRedefiningParametersMustBeTheSameMatcher in a type-safe way.
 * 
 * @see RedefinedAndRedefiningParametersMustBeTheSameMatcher
 * @see RedefinedAndRedefiningParametersMustBeTheSameMatch
 * 
 */
@SuppressWarnings("all")
public final class RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification extends BaseGeneratedEMFQuerySpecification<RedefinedAndRedefiningParametersMustBeTheSameMatcher> {
  private RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RedefinedAndRedefiningParametersMustBeTheSameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedAndRedefiningParametersMustBeTheSameMatcher.on(engine);
  }
  
  @Override
  public RedefinedAndRedefiningParametersMustBeTheSameMatch newEmptyMatch() {
    return RedefinedAndRedefiningParametersMustBeTheSameMatch.newEmptyMatch();
  }
  
  @Override
  public RedefinedAndRedefiningParametersMustBeTheSameMatch newMatch(final Object... parameters) {
    return RedefinedAndRedefiningParametersMustBeTheSameMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification INSTANCE = make();
    
    public static RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification make() {
      return new RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSame";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("redefined","redefiner");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("redefined", "org.eclipse.uml2.uml.Operation"),new PParameter("redefiner", "org.eclipse.uml2.uml.Operation"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_redefined = body.getOrCreateVariableByName("redefined");
      		PVariable var_redefiner = body.getOrCreateVariableByName("redefiner");
      		PVariable var_redefinedParam = body.getOrCreateVariableByName("redefinedParam");
      		PVariable var_redefinerParam = body.getOrCreateVariableByName("redefinerParam");
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		new TypeConstraint(body, new FlatTuple(var_redefiner), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_redefined, "redefined"),
      		   new ExportedParameter(body, var_redefiner, "redefiner")
      		));
      		// 	Operation.redefinedOperation(redefiner, redefined)
      		new TypeConstraint(body, new FlatTuple(var_redefiner), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_redefiner, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "redefinedOperation")));
      		new Equality(body, var__virtual_0_, var_redefined);
      		// 	Operation.ownedParameter(redefined, redefinedParam)
      		new TypeConstraint(body, new FlatTuple(var_redefined), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_redefined, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_1_, var_redefinedParam);
      		// 	Operation.ownedParameter(redefiner, redefinerParam)
      		new TypeConstraint(body, new FlatTuple(var_redefiner), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_redefiner, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "ownedParameter")));
      		new Equality(body, var__virtual_2_, var_redefinerParam);
      		// 	neg find ParamsCheck(redefinedParam, redefinerParam)
      		new NegativePatternCall(body, new FlatTuple(var_redefinedParam, var_redefinerParam), ParamsCheckQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("post", "hu.eltesoft.modelexecution.validation.utils.IndexChecked");
      		annotation.addAttribute("message", "Parameters of the operation must be the same as the redefined operation {redefined}");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "redefiner"
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
