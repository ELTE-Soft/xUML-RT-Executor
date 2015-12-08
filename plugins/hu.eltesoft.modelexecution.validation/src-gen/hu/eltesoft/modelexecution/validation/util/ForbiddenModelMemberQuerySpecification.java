package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ForbiddenModelMemberMatch;
import hu.eltesoft.modelexecution.validation.ForbiddenModelMemberMatcher;
import hu.eltesoft.modelexecution.validation.util.GeneralPackagedElementQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PackageImportQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ProfileApplicationQuerySpecification;
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
 * A pattern-specific query specification that can instantiate ForbiddenModelMemberMatcher in a type-safe way.
 * 
 * @see ForbiddenModelMemberMatcher
 * @see ForbiddenModelMemberMatch
 * 
 */
@SuppressWarnings("all")
public final class ForbiddenModelMemberQuerySpecification extends BaseGeneratedEMFQuerySpecification<ForbiddenModelMemberMatcher> {
  private ForbiddenModelMemberQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ForbiddenModelMemberQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ForbiddenModelMemberMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ForbiddenModelMemberMatcher.on(engine);
  }
  
  @Override
  public ForbiddenModelMemberMatch newEmptyMatch() {
    return ForbiddenModelMemberMatch.newEmptyMatch();
  }
  
  @Override
  public ForbiddenModelMemberMatch newMatch(final Object... parameters) {
    return ForbiddenModelMemberMatch.newMatch((org.eclipse.uml2.uml.Model) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static ForbiddenModelMemberQuerySpecification INSTANCE = make();
    
    public static ForbiddenModelMemberQuerySpecification make() {
      return new ForbiddenModelMemberQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ForbiddenModelMemberQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ForbiddenModelMember";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("md","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("md", "org.eclipse.uml2.uml.Model"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_md = body.getOrCreateVariableByName("md");
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		new TypeConstraint(body, new FlatTuple(var_md), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Model")));
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_md, "md"),
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	Package.ownedElement(md, elem)
      		new TypeConstraint(body, new FlatTuple(var_md), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_md, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find GeneralPackagedElement(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), GeneralPackagedElementQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find PackageImport(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), PackageImportQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find ProfileApplication(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), ProfileApplicationQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Models can only contain components, packages, events, signals, classes, associations, package imports and profile application");
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
