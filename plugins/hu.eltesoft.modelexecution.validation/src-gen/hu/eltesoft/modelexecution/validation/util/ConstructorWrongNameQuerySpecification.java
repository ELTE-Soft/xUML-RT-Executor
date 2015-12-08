package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ConstructorWrongNameMatch;
import hu.eltesoft.modelexecution.validation.ConstructorWrongNameMatcher;
import hu.eltesoft.modelexecution.validation.util.ConstructorQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ConstructorWrongNameMatcher in a type-safe way.
 * 
 * @see ConstructorWrongNameMatcher
 * @see ConstructorWrongNameMatch
 * 
 */
@SuppressWarnings("all")
public final class ConstructorWrongNameQuerySpecification extends BaseGeneratedEMFQuerySpecification<ConstructorWrongNameMatcher> {
  private ConstructorWrongNameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ConstructorWrongNameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ConstructorWrongNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ConstructorWrongNameMatcher.on(engine);
  }
  
  @Override
  public ConstructorWrongNameMatch newEmptyMatch() {
    return ConstructorWrongNameMatch.newEmptyMatch();
  }
  
  @Override
  public ConstructorWrongNameMatch newMatch(final Object... parameters) {
    return ConstructorWrongNameMatch.newMatch((org.eclipse.uml2.uml.Operation) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ConstructorWrongNameQuerySpecification INSTANCE = make();
    
    public static ConstructorWrongNameQuerySpecification make() {
      return new ConstructorWrongNameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ConstructorWrongNameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ConstructorWrongName";
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
      		PVariable var_name1 = body.getOrCreateVariableByName("name1");
      		PVariable var_cls = body.getOrCreateVariableByName("cls");
      		PVariable var_name2 = body.getOrCreateVariableByName("name2");
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_op, "op")
      		));
      		// 	find Constructor(op)
      		new PositivePatternCall(body, new FlatTuple(var_op), ConstructorQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Operation.name(op, name1)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name1);
      		// 	Operation.class(op, cls)
      		new TypeConstraint(body, new FlatTuple(var_op), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_op, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation", "class")));
      		new Equality(body, var__virtual_1_, var_cls);
      		// 	Class.name(cls, name2)
      		new TypeConstraint(body, new FlatTuple(var_cls), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_cls, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_2_, var_name2);
      		// 	name1 != name2
      		new Inequality(body, var_name1, var_name2);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "The constructor must have the same name as the class");
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
