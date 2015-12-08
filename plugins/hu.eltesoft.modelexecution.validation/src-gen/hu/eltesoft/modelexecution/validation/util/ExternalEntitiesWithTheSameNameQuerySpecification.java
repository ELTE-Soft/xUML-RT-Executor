package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameNameMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameNameMatcher;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ExternalEntitiesWithTheSameNameMatcher in a type-safe way.
 * 
 * @see ExternalEntitiesWithTheSameNameMatcher
 * @see ExternalEntitiesWithTheSameNameMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntitiesWithTheSameNameQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntitiesWithTheSameNameMatcher> {
  private ExternalEntitiesWithTheSameNameQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntitiesWithTheSameNameQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntitiesWithTheSameNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntitiesWithTheSameNameMatcher.on(engine);
  }
  
  @Override
  public ExternalEntitiesWithTheSameNameMatch newEmptyMatch() {
    return ExternalEntitiesWithTheSameNameMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntitiesWithTheSameNameMatch newMatch(final Object... parameters) {
    return ExternalEntitiesWithTheSameNameMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntitiesWithTheSameNameQuerySpecification INSTANCE = make();
    
    public static ExternalEntitiesWithTheSameNameQuerySpecification make() {
      return new ExternalEntitiesWithTheSameNameQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntitiesWithTheSameNameQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameName";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cl1","cl2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cl1", "org.eclipse.uml2.uml.Class"),new PParameter("cl2", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_cl1 = body.getOrCreateVariableByName("cl1");
      		PVariable var_cl2 = body.getOrCreateVariableByName("cl2");
      		PVariable var_name = body.getOrCreateVariableByName("name");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_cl1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_cl2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cl1, "cl1"),
      		   new ExportedParameter(body, var_cl2, "cl2")
      		));
      		// 	find ExternalEntity(cl1, _)
      		new PositivePatternCall(body, new FlatTuple(var_cl1, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find ExternalEntity(cl2, _)
      		new PositivePatternCall(body, new FlatTuple(var_cl2, var___1_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.name(cl1, name)
      		new TypeConstraint(body, new FlatTuple(var_cl1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cl1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_0_, var_name);
      		// 	Class.name(cl2, name)
      		new TypeConstraint(body, new FlatTuple(var_cl2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_cl2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      		new Equality(body, var__virtual_1_, var_name);
      		// 	cl1 != cl2
      		new Inequality(body, var_cl1, var_cl2);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Two external entities cannot have the same name");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "cl1", 
      		                "cl2"
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
