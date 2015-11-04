package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ForbiddenComponentMemberMatch;
import hu.eltesoft.modelexecution.validation.ForbiddenComponentMemberMatcher;
import hu.eltesoft.modelexecution.validation.util.GeneralPackagedElementQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ForbiddenComponentMemberMatcher in a type-safe way.
 * 
 * @see ForbiddenComponentMemberMatcher
 * @see ForbiddenComponentMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class ForbiddenComponentMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<ForbiddenComponentMemberMatcher> {
  private ForbiddenComponentMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ForbiddenComponentMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForbiddenComponentMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenComponentMemberMatcher.on(engine);
  }
  
  @Override
  public ForbiddenComponentMemberMatch newEmptyMatch() {
    return ForbiddenComponentMemberMatch.newEmptyMatch();
  }
  
  @Override
  public ForbiddenComponentMemberMatch newMatch(final Object... parameters) {
    return ForbiddenComponentMemberMatch.newMatch((org.eclipse.uml2.uml.Component) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ForbiddenComponentMemberQuerySpecification INSTANCE = make();
    
    public static ForbiddenComponentMemberQuerySpecification make() {
      return new ForbiddenComponentMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ForbiddenComponentMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ForbiddenComponentMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cp","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cp", "org.eclipse.uml2.uml.Component"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_cp = body.getOrCreateVariableByName("cp");
      	PVariable var_elem = body.getOrCreateVariableByName("elem");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_cp, "cp"),
      				
      		new ExportedParameter(body, var_elem, "elem")
      	));
      	new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      	new TypeConstraint(body, new FlatTuple(var_cp), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Component")));
      	new TypeConstraint(body, new FlatTuple(var_cp, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      	new Equality(body, var__virtual_0_, var_elem);
      	new NegativePatternCall(body, new FlatTuple(var_elem), GeneralPackagedElementQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Packages can only contain components, packages, events, signals and classes");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"elem"
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
