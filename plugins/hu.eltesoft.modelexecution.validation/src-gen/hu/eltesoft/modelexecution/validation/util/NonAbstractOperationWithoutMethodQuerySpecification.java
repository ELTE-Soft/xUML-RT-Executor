package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethodMatch;
import hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethodMatcher;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.HasMethodQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NonAbstractOperationWithoutMethodMatcher in a type-safe way.
 * 
 * @see NonAbstractOperationWithoutMethodMatcher
 * @see NonAbstractOperationWithoutMethodMatch
 * 
 */
@SuppressWarnings("all")
public final class NonAbstractOperationWithoutMethodQuerySpecification extends BaseGeneratedEMFQuerySpecification<NonAbstractOperationWithoutMethodMatcher> {
  private NonAbstractOperationWithoutMethodQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NonAbstractOperationWithoutMethodQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NonAbstractOperationWithoutMethodMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NonAbstractOperationWithoutMethodMatcher.on(engine);
  }
  
  @Override
  public NonAbstractOperationWithoutMethodMatch newEmptyMatch() {
    return NonAbstractOperationWithoutMethodMatch.newEmptyMatch();
  }
  
  @Override
  public NonAbstractOperationWithoutMethodMatch newMatch(final Object... parameters) {
    return NonAbstractOperationWithoutMethodMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static NonAbstractOperationWithoutMethodQuerySpecification INSTANCE = make();
    
    public static NonAbstractOperationWithoutMethodQuerySpecification make() {
      return new NonAbstractOperationWithoutMethodQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NonAbstractOperationWithoutMethodQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.NonAbstractOperationWithoutMethod";
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
      		PVariable var_cls = body.getOrCreateVariableByName("cls");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op")
      		));
      		// 	Operation.isAbstract(op, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "BehavioralFeature", "isAbstract")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		// 	Operation.class(op, cls)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "class")));
      		new Equality(body, var__virtual_2_, var_cls);
      		// 	neg find ExternalEntity(cls, _)
      		new NegativePatternCall(body, new FlatTuple(var_cls, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find HasMethod(op)
      		new NegativePatternCall(body, new FlatTuple(var_op), HasMethodQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "If the operation is not abstract it must have a method");
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
