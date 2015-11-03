package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityGeneralizationMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityGeneralizationMatcher;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityQuerySpecification;
import hu.eltesoft.modelexecution.validation.util._ParentQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ExternalEntityGeneralizationMatcher in a type-safe way.
 * 
 * @see ExternalEntityGeneralizationMatcher
 * @see ExternalEntityGeneralizationMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityGeneralizationQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityGeneralizationMatcher> {
  private ExternalEntityGeneralizationQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityGeneralizationQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityGeneralizationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityGeneralizationMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityGeneralizationMatch newEmptyMatch() {
    return ExternalEntityGeneralizationMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityGeneralizationMatch newMatch(final Object... parameters) {
    return ExternalEntityGeneralizationMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityGeneralizationQuerySpecification INSTANCE = make();
    
    public static ExternalEntityGeneralizationQuerySpecification make() {
      return new ExternalEntityGeneralizationQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityGeneralizationQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityGeneralization";
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
      	PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_cl, "cl")
      	));
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new PositivePatternCall(body, new FlatTuple(var_cl, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_cl, var___1_), _ParentQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "External entity cannot be the generalization of a class");
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
