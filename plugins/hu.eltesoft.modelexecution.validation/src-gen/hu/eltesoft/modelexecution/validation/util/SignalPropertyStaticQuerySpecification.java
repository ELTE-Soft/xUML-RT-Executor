package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.SignalPropertyStaticMatch;
import hu.eltesoft.modelexecution.validation.SignalPropertyStaticMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalPropertyStaticMatcher in a type-safe way.
 * 
 * @see SignalPropertyStaticMatcher
 * @see SignalPropertyStaticMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalPropertyStaticQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalPropertyStaticMatcher> {
  private SignalPropertyStaticQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalPropertyStaticQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalPropertyStaticMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalPropertyStaticMatcher.on(engine);
  }
  
  @Override
  public SignalPropertyStaticMatch newEmptyMatch() {
    return SignalPropertyStaticMatch.newEmptyMatch();
  }
  
  @Override
  public SignalPropertyStaticMatch newMatch(final Object... parameters) {
    return SignalPropertyStaticMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SignalPropertyStaticQuerySpecification INSTANCE = make();
    
    public static SignalPropertyStaticQuerySpecification make() {
      return new SignalPropertyStaticQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalPropertyStaticQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.SignalPropertyStatic";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","prop");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sg", "org.eclipse.uml2.uml.Signal"),new PParameter("prop", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_sg = body.getOrCreateVariableByName("sg");
      		PVariable var_prop = body.getOrCreateVariableByName("prop");
      		new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      		new TypeConstraint(body, new FlatTuple(var_prop), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_sg, "sg"),
      		   new ExportedParameter(body, var_prop, "prop")
      		));
      		// 	Signal.ownedAttribute(sg, prop)
      		new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_sg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal", "ownedAttribute")));
      		new Equality(body, var__virtual_0_, var_prop);
      		// 	Property.isStatic(prop, true)
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new ConstantValue(body, var__virtual_1_, true);
      		new TypeConstraint(body, new FlatTuple(var_prop), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_prop, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Feature", "isStatic")));
      		new Equality(body, var__virtual_2_, var__virtual_1_);
      		bodies.add(body);
      	}
      	                {
      		PAnnotation annotation = new PAnnotation("Violation");
      		annotation.addAttribute("message", "Signals properties cannot be static");
      		annotation.addAttribute("mark", Arrays.asList(new Object[] {
      		                "prop"
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
