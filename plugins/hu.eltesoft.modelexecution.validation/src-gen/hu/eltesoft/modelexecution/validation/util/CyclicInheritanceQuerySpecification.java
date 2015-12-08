package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.IsAncestorQuerySpecification;
import hu.eltesoft.modelexecution.validation.CyclicInheritanceMatch;
import hu.eltesoft.modelexecution.validation.CyclicInheritanceMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate CyclicInheritanceMatcher in a type-safe way.
 * 
 * @see CyclicInheritanceMatcher
 * @see CyclicInheritanceMatch
 * 
 */
@SuppressWarnings("all")
public final class CyclicInheritanceQuerySpecification extends BaseGeneratedEMFQuerySpecification<CyclicInheritanceMatcher> {
  private CyclicInheritanceQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static CyclicInheritanceQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CyclicInheritanceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return CyclicInheritanceMatcher.on(engine);
  }
  
  @Override
  public CyclicInheritanceMatch newEmptyMatch() {
    return CyclicInheritanceMatch.newEmptyMatch();
  }
  
  @Override
  public CyclicInheritanceMatch newMatch(final Object... parameters) {
    return CyclicInheritanceMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static CyclicInheritanceQuerySpecification INSTANCE = make();
    
    public static CyclicInheritanceQuerySpecification make() {
      return new CyclicInheritanceQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static CyclicInheritanceQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.CyclicInheritance";
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
      		PVariable var_other = body.getOrCreateVariableByName("other");
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cl, "cl")
      		));
      		// 	find IsAncestor(cl, other)
      		new PositivePatternCall(body, new FlatTuple(var_cl, var_other), IsAncestorQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find IsAncestor(other, cl)
      		new PositivePatternCall(body, new FlatTuple(var_other, var_cl), IsAncestorQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Cyclic inheritance");
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
