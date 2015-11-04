package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.PackageImportNonPublicMatch;
import hu.eltesoft.modelexecution.validation.PackageImportNonPublicMatcher;
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
 * A pattern-specific query specification that can instantiate PackageImportNonPublicMatcher in a type-safe way.
 * 
 * @see PackageImportNonPublicMatcher
 * @see PackageImportNonPublicMatch
 * 
 */
@SuppressWarnings("all")
public final class PackageImportNonPublicQuerySpecification extends BaseGeneratedEMFQuerySpecification<PackageImportNonPublicMatcher> {
  private PackageImportNonPublicQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PackageImportNonPublicQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected PackageImportNonPublicMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PackageImportNonPublicMatcher.on(engine);
  }
  
  @Override
  public PackageImportNonPublicMatch newEmptyMatch() {
    return PackageImportNonPublicMatch.newEmptyMatch();
  }
  
  @Override
  public PackageImportNonPublicMatch newMatch(final Object... parameters) {
    return PackageImportNonPublicMatch.newMatch((org.eclipse.uml2.uml.PackageImport) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static PackageImportNonPublicQuerySpecification INSTANCE = make();
    
    public static PackageImportNonPublicQuerySpecification make() {
      return new PackageImportNonPublicQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PackageImportNonPublicQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.PackageImportNonPublic";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("pi");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("pi", "org.eclipse.uml2.uml.PackageImport"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_pi = body.getOrCreateVariableByName("pi");
      	PVariable var_visibility = body.getOrCreateVariableByName("visibility");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_pi, "pi")
      	));
      	new TypeConstraint(body, new FlatTuple(var_pi), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageImport")));
      	new TypeConstraint(body, new FlatTuple(var_pi), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageImport")));
      	new TypeConstraint(body, new FlatTuple(var_pi, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageImport", "visibility")));
      	new Equality(body, var__virtual_0_, var_visibility);
      	new ConstantValue(body, var__virtual_1_, org.eclipse.uml2.uml.VisibilityKind.get("public"));
      	new Inequality(body, var_visibility, var__virtual_1_);
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Package imports must be public");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"pi"
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
