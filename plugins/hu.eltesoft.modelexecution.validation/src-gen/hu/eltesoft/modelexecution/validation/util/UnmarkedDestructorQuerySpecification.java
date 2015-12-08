package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.UnmarkedDestructorMatch;
import hu.eltesoft.modelexecution.validation.UnmarkedDestructorMatcher;
import hu.eltesoft.modelexecution.validation.util.DestructorQuerySpecification;
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
 * A pattern-specific query specification that can instantiate UnmarkedDestructorMatcher in a type-safe way.
 * 
 * @see UnmarkedDestructorMatcher
 * @see UnmarkedDestructorMatch
 * 
 */
@SuppressWarnings("all")
public final class UnmarkedDestructorQuerySpecification extends BaseGeneratedEMFQuerySpecification<UnmarkedDestructorMatcher> {
  private UnmarkedDestructorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnmarkedDestructorQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnmarkedDestructorMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UnmarkedDestructorMatcher.on(engine);
  }
  
  @Override
  public UnmarkedDestructorMatch newEmptyMatch() {
    return UnmarkedDestructorMatch.newEmptyMatch();
  }
  
  @Override
  public UnmarkedDestructorMatch newMatch(final Object... parameters) {
    return UnmarkedDestructorMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static UnmarkedDestructorQuerySpecification INSTANCE = make();
    
    public static UnmarkedDestructorQuerySpecification make() {
      return new UnmarkedDestructorQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UnmarkedDestructorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.UnmarkedDestructor";
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
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op")
      		));
      		// 	neg find Destructor(op)
      		new NegativePatternCall(body, new FlatTuple(var_op), DestructorQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Operation.name(op, "destroy")
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, "destroy");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Only methods marked with the stereotype Destroy can be named 'destroy'");
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
