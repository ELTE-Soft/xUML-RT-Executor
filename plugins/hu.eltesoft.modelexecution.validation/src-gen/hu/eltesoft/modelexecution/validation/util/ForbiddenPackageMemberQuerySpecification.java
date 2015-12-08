package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ForbiddenPackageMemberMatch;
import hu.eltesoft.modelexecution.validation.ForbiddenPackageMemberMatcher;
import hu.eltesoft.modelexecution.validation.util.GeneralPackagedElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ForbiddenPackageMemberMatcher in a type-safe way.
 * 
 * @see ForbiddenPackageMemberMatcher
 * @see ForbiddenPackageMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class ForbiddenPackageMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<ForbiddenPackageMemberMatcher> {
  private ForbiddenPackageMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ForbiddenPackageMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForbiddenPackageMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenPackageMemberMatcher.on(engine);
  }
  
  @Override
  public ForbiddenPackageMemberMatch newEmptyMatch() {
    return ForbiddenPackageMemberMatch.newEmptyMatch();
  }
  
  @Override
  public ForbiddenPackageMemberMatch newMatch(final Object... parameters) {
    return ForbiddenPackageMemberMatch.newMatch((org.eclipse.uml2.uml.Package) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ForbiddenPackageMemberQuerySpecification INSTANCE = make();
    
    public static ForbiddenPackageMemberQuerySpecification make() {
      return new ForbiddenPackageMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ForbiddenPackageMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ForbiddenPackageMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pk","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pk", "org.eclipse.uml2.uml.Package"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_pk = body.getOrCreateVariableByName("pk");
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		new TypeConstraint(body, new FlatTuple(var_pk), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_pk, "pk"),
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	find Package(pk)
      		new PositivePatternCall(body, new FlatTuple(var_pk), PackageQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Package.ownedElement(pk, elem)
      		new TypeConstraint(body, new FlatTuple(var_pk), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_pk, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find GeneralPackagedElement(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), GeneralPackagedElementQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Packages can only contain components, packages, events, signals, associations and classes");
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
