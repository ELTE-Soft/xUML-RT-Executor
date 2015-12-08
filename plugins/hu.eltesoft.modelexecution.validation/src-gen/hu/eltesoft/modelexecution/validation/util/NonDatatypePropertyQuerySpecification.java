package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.AttributeTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassOrAssocClassQuerySpecification;
import hu.eltesoft.modelexecution.validation.NonDatatypePropertyMatch;
import hu.eltesoft.modelexecution.validation.NonDatatypePropertyMatcher;
import hu.eltesoft.modelexecution.validation.util.DataTypeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NonDatatypePropertyMatcher in a type-safe way.
 * 
 * @see NonDatatypePropertyMatcher
 * @see NonDatatypePropertyMatch
 * 
 */
@SuppressWarnings("all")
public final class NonDatatypePropertyQuerySpecification extends BaseGeneratedEMFQuerySpecification<NonDatatypePropertyMatcher> {
  private NonDatatypePropertyQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NonDatatypePropertyQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected NonDatatypePropertyMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NonDatatypePropertyMatcher.on(engine);
  }
  
  @Override
  public NonDatatypePropertyMatch newEmptyMatch() {
    return NonDatatypePropertyMatch.newEmptyMatch();
  }
  
  @Override
  public NonDatatypePropertyMatch newMatch(final Object... parameters) {
    return NonDatatypePropertyMatch.newMatch((org.eclipse.uml2.uml.Property) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static NonDatatypePropertyQuerySpecification INSTANCE = make();
    
    public static NonDatatypePropertyQuerySpecification make() {
      return new NonDatatypePropertyQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static NonDatatypePropertyQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.NonDatatypeProperty";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pr");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pr", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_pr = body.getOrCreateVariableByName("pr");
      		PVariable var_cl = body.getOrCreateVariableByName("cl");
      		PVariable var_ty = body.getOrCreateVariableByName("ty");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		new TypeConstraint(body, new FlatTuple(var_pr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pr, "pr")
      		));
      		// 	find ClassOrAssocClass(cl)
      		new PositivePatternCall(body, new FlatTuple(var_cl), ClassOrAssocClassQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find AttributeType(cl, pr, ty, _, _)
      		new PositivePatternCall(body, new FlatTuple(var_cl, var_pr, var_ty, var___0_, var___1_), AttributeTypeQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find DataType(ty)
      		new NegativePatternCall(body, new FlatTuple(var_ty), DataTypeQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Type of class attribute must be a data type");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "pr"
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
