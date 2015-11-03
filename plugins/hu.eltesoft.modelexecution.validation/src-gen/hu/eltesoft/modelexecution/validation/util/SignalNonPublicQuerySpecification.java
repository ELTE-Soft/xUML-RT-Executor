package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.SignalNonPublicMatch;
import hu.eltesoft.modelexecution.validation.SignalNonPublicMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalNonPublicMatcher in a type-safe way.
 * 
 * @see SignalNonPublicMatcher
 * @see SignalNonPublicMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalNonPublicQuerySpecification extends BaseGeneratedEMFQuerySpecification<SignalNonPublicMatcher> {
  private SignalNonPublicQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalNonPublicQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SignalNonPublicMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalNonPublicMatcher.on(engine);
  }
  
  @Override
  public SignalNonPublicMatch newEmptyMatch() {
    return SignalNonPublicMatch.newEmptyMatch();
  }
  
  @Override
  public SignalNonPublicMatch newMatch(final Object... parameters) {
    return SignalNonPublicMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SignalNonPublicQuerySpecification INSTANCE = make();
    
    public static SignalNonPublicQuerySpecification make() {
      return new SignalNonPublicQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SignalNonPublicQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.SignalNonPublic";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sg", "org.eclipse.uml2.uml.Signal"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_sg = body.getOrCreateVariableByName("sg");
      	PVariable var_visibility = body.getOrCreateVariableByName("visibility");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_sg, "sg")
      	));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_sg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "visibility")));
      	new Equality(body, var__virtual_0_, var_visibility);
      	new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.VisibilityKind.get("public"));
      	new Inequality(body, var_visibility, var__virtual_1_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Signal visibility must be public");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"sg"
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
