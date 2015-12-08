package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ClassOrAssocClassQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.EventQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.MethodQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.OperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ReceptionQuerySpecification;
import hu.eltesoft.modelexecution.validation.UnrecognizedElementInClassMatch;
import hu.eltesoft.modelexecution.validation.UnrecognizedElementInClassMatcher;
import hu.eltesoft.modelexecution.validation.util.GeneralizationQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.PropertyQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.Signal_QuerySpecification;
import hu.eltesoft.modelexecution.validation.util.StateMachineQuerySpecification;
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
 * A pattern-specific query specification that can instantiate UnrecognizedElementInClassMatcher in a type-safe way.
 * 
 * @see UnrecognizedElementInClassMatcher
 * @see UnrecognizedElementInClassMatch
 * 
 */
@SuppressWarnings("all")
public final class UnrecognizedElementInClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<UnrecognizedElementInClassMatcher> {
  private UnrecognizedElementInClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UnrecognizedElementInClassQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UnrecognizedElementInClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UnrecognizedElementInClassMatcher.on(engine);
  }
  
  @Override
  public UnrecognizedElementInClassMatch newEmptyMatch() {
    return UnrecognizedElementInClassMatch.newEmptyMatch();
  }
  
  @Override
  public UnrecognizedElementInClassMatch newMatch(final Object... parameters) {
    return UnrecognizedElementInClassMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Element) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static UnrecognizedElementInClassQuerySpecification INSTANCE = make();
    
    public static UnrecognizedElementInClassQuerySpecification make() {
      return new UnrecognizedElementInClassQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UnrecognizedElementInClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.UnrecognizedElementInClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cl","elem");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cl", "org.eclipse.uml2.uml.Class"),new PParameter("elem", "org.eclipse.uml2.uml.Element"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_cl = body.getOrCreateVariableByName("cl");
      		PVariable var_elem = body.getOrCreateVariableByName("elem");
      		PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      		PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
      		PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
      		PVariable var___3_ = body.getOrCreateVariableByName("_<3>");
      		PVariable var___4_ = body.getOrCreateVariableByName("_<4>");
      		PVariable var___5_ = body.getOrCreateVariableByName("_<5>");
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		new TypeConstraint(body, new FlatTuple(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_cl, "cl"),
      		   new ExportedParameter(body, var_elem, "elem")
      		));
      		// 	find ClassOrAssocClass(cl)
      		new PositivePatternCall(body, new FlatTuple(var_cl), ClassOrAssocClassQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	Class.ownedElement(cl, elem)
      		new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
      		new Equality(body, var__virtual_0_, var_elem);
      		// 	neg find Property(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), PropertyQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Operation(_, elem, _)
      		new NegativePatternCall(body, new FlatTuple(var___0_, var_elem, var___1_), OperationQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Reception(_, elem, _)
      		new NegativePatternCall(body, new FlatTuple(var___2_, var_elem, var___3_), ReceptionQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Method(_, _, elem)
      		new NegativePatternCall(body, new FlatTuple(var___4_, var___5_, var_elem), MethodQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Event(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), EventQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Signal_(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), Signal_QuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Association(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), AssociationQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find Generalization(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), GeneralizationQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	neg find StateMachine(elem)
      		new NegativePatternCall(body, new FlatTuple(var_elem), StateMachineQuerySpecification.instance().getInternalQueryRepresentation());
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Unknown element in class {cl}");
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
