package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassOrAssocClassQuerySpecification;
import hu.eltesoft.modelexecution.validation.AssociationEndMustBeClassMatch;
import hu.eltesoft.modelexecution.validation.AssociationEndMustBeClassMatcher;
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
 * A pattern-specific query specification that can instantiate AssociationEndMustBeClassMatcher in a type-safe way.
 * 
 * @see AssociationEndMustBeClassMatcher
 * @see AssociationEndMustBeClassMatch
 * 
 */
@SuppressWarnings("all")
public final class AssociationEndMustBeClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<AssociationEndMustBeClassMatcher> {
  private AssociationEndMustBeClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AssociationEndMustBeClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected AssociationEndMustBeClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndMustBeClassMatcher.on(engine);
  }
  
  @Override
  public AssociationEndMustBeClassMatch newEmptyMatch() {
    return AssociationEndMustBeClassMatch.newEmptyMatch();
  }
  
  @Override
  public AssociationEndMustBeClassMatch newMatch(final Object... parameters) {
    return AssociationEndMustBeClassMatch.newMatch((org.eclipse.uml2.uml.Association) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static AssociationEndMustBeClassQuerySpecification INSTANCE = make();
    
    public static AssociationEndMustBeClassQuerySpecification make() {
      return new AssociationEndMustBeClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static AssociationEndMustBeClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.AssociationEndMustBeClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ac");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ac", "org.eclipse.uml2.uml.Association"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ac = body.getOrCreateVariableByName("ac");
      	PVariable var_me = body.getOrCreateVariableByName("me");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var_t = body.getOrCreateVariableByName("t");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ac, "ac")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_ac), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association")));
      	new TypeConstraint(body, new FlatTuple(var_ac, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Association", "memberEnd")));
      	new Equality(body, var__virtual_0_, var_me);
      	new TypeConstraint(body, new FlatTuple(var_me), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_me, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      	new Equality(body, var__virtual_1_, var_t);
      	new NegativePatternCall(body, new FlatTuple(var_t), ClassOrAssocClassQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Association ends must have class type");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"ac"
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
