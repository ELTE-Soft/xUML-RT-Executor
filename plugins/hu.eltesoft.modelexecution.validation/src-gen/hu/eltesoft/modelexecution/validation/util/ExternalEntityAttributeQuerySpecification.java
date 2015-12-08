package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityAttributeMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityAttributeMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityAttributeMatcher in a type-safe way.
 * 
 * @see ExternalEntityAttributeMatcher
 * @see ExternalEntityAttributeMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityAttributeQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityAttributeMatcher> {
  private ExternalEntityAttributeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityAttributeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityAttributeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityAttributeMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityAttributeMatch newEmptyMatch() {
    return ExternalEntityAttributeMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityAttributeMatch newMatch(final Object... parameters) {
    return ExternalEntityAttributeMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityAttributeQuerySpecification INSTANCE = make();
    
    public static ExternalEntityAttributeQuerySpecification make() {
      return new ExternalEntityAttributeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityAttributeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityAttribute";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("attr");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("attr", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_attr = body.getOrCreateVariableByName("attr");
      		PVariable var_cl = body.getOrCreateVariableByName("cl");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		new TypeConstraint(body, new FlatTuple(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_attr, "attr")
      		));
      		// 	find ExternalEntity(cl, _)
      		new PositivePatternCall(body, new FlatTuple(var_cl, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.ownedAttribute(cl, attr)
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
      		new Equality(body, var__virtual_0_, var_attr);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "An external entity has no attributes");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "attr"
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
