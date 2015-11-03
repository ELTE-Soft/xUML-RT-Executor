package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.ParentQuerySpecification;
import hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClassMatch;
import hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClassMatcher;
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
 * A pattern-specific query specification that can instantiate GeneralizationOfAssocClassMatcher in a type-safe way.
 * 
 * @see GeneralizationOfAssocClassMatcher
 * @see GeneralizationOfAssocClassMatch
 * 
 */
@SuppressWarnings("all")
public final class GeneralizationOfAssocClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<GeneralizationOfAssocClassMatcher> {
  private GeneralizationOfAssocClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GeneralizationOfAssocClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected GeneralizationOfAssocClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GeneralizationOfAssocClassMatcher.on(engine);
  }
  
  @Override
  public GeneralizationOfAssocClassMatch newEmptyMatch() {
    return GeneralizationOfAssocClassMatch.newEmptyMatch();
  }
  
  @Override
  public GeneralizationOfAssocClassMatch newMatch(final Object... parameters) {
    return GeneralizationOfAssocClassMatch.newMatch((org.eclipse.uml2.uml.AssociationClass) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static GeneralizationOfAssocClassQuerySpecification INSTANCE = make();
    
    public static GeneralizationOfAssocClassQuerySpecification make() {
      return new GeneralizationOfAssocClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static GeneralizationOfAssocClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ac","spec");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ac", "org.eclipse.uml2.uml.AssociationClass"),new PParameter("spec", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ac = body.getOrCreateVariableByName("ac");
      	PVariable var_spec = body.getOrCreateVariableByName("spec");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ac, "ac"),
      				
      		new ExportedParameter(body, var_spec, "spec")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "AssociationClass")));
      	new TypeConstraint(body, new FlatTuple(var_spec), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new PositivePatternCall(body, new FlatTuple(var_spec, var_ac), ParentQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Generalization of association class {ac} is not supported");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"spec"
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
