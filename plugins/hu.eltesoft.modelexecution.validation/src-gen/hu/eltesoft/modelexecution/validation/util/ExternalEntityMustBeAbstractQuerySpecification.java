package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstractMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstractMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityMustBeAbstractMatcher in a type-safe way.
 * 
 * @see ExternalEntityMustBeAbstractMatcher
 * @see ExternalEntityMustBeAbstractMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityMustBeAbstractQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityMustBeAbstractMatcher> {
  private ExternalEntityMustBeAbstractQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityMustBeAbstractQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityMustBeAbstractMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityMustBeAbstractMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityMustBeAbstractMatch newEmptyMatch() {
    return ExternalEntityMustBeAbstractMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityMustBeAbstractMatch newMatch(final Object... parameters) {
    return ExternalEntityMustBeAbstractMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityMustBeAbstractQuerySpecification INSTANCE = make();
    
    public static ExternalEntityMustBeAbstractQuerySpecification make() {
      return new ExternalEntityMustBeAbstractQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityMustBeAbstractQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityMustBeAbstract";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cl", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_cl = body.getOrCreateVariableByName("cl");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cl, "cl")
      		));
      		// 	find ExternalEntity(cl, _)
      		new PositivePatternCall(body, new FlatTuple(var_cl, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.isAbstract(cl, false)
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new ConstantValue(body, var__virtual_0_, false);
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Classifier", "isAbstract")));
      		new Equality(body, var__virtual_1_, var__virtual_0_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "External entity must be an abstract class");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "cl"
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
