package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.RegionNotPublicMatch;
import hu.eltesoft.modelexecution.validation.RegionNotPublicMatcher;
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
 * A pattern-specific query specification that can instantiate RegionNotPublicMatcher in a type-safe way.
 * 
 * @see RegionNotPublicMatcher
 * @see RegionNotPublicMatch
 * 
 */
@SuppressWarnings("all")
public final class RegionNotPublicQuerySpecification extends BaseGeneratedEMFQuerySpecification<RegionNotPublicMatcher> {
  private RegionNotPublicQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RegionNotPublicQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RegionNotPublicMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RegionNotPublicMatcher.on(engine);
  }
  
  @Override
  public RegionNotPublicMatch newEmptyMatch() {
    return RegionNotPublicMatch.newEmptyMatch();
  }
  
  @Override
  public RegionNotPublicMatch newMatch(final Object... parameters) {
    return RegionNotPublicMatch.newMatch((org.eclipse.uml2.uml.Region) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static RegionNotPublicQuerySpecification INSTANCE = make();
    
    public static RegionNotPublicQuerySpecification make() {
      return new RegionNotPublicQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RegionNotPublicQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.RegionNotPublic";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rg");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rg", "org.eclipse.uml2.uml.Region"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_rg = body.getOrCreateVariableByName("rg");
      	PVariable var_visibility = body.getOrCreateVariableByName("visibility");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_rg, "rg")
      	));
      	new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_rg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Region")));
      	new TypeConstraint(body, new FlatTuple(var_rg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "visibility")));
      	new Equality(body, var__virtual_0_, var_visibility);
      	new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.VisibilityKind.get("public"));
      	new Inequality(body, var_visibility, var__virtual_1_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "State machine regions must be public");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"rg"
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
