package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.util.LowerValueQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.UpperValueQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ParamPropCheckMatcher in a type-safe way.
 * 
 * @see ParamPropCheckMatcher
 * @see ParamPropCheckMatch
 * 
 */
@SuppressWarnings("all")
final class ParamPropCheckQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private ParamPropCheckQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParamPropCheckQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected IncQueryMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newEmptyMatch() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public IPatternMatch newMatch(final Object... parameters) {
    throw new UnsupportedOperationException();
  }
  
  private static class LazyHolder {
    private final static ParamPropCheckQuerySpecification INSTANCE = make();
    
    public static ParamPropCheckQuerySpecification make() {
      return new ParamPropCheckQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParamPropCheckQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ParamPropCheck";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("param","property");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("param", "org.eclipse.uml2.uml.Parameter"),new PParameter("property", "org.eclipse.uml2.uml.Property"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_param = body.getOrCreateVariableByName("param");
      	PVariable var_property = body.getOrCreateVariableByName("property");
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_lv = body.getOrCreateVariableByName("lv");
      	PVariable var_uv = body.getOrCreateVariableByName("uv");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_param, "param"),
      				
      		new ExportedParameter(body, var_property, "property")
      	));
      	new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_param), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      	new TypeConstraint(body, new FlatTuple(var_param, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      	new Equality(body, var__virtual_0_, var_type);
      	new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
      	new TypeConstraint(body, new FlatTuple(var_property, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      	new Equality(body, var__virtual_1_, var_type);
      	new PositivePatternCall(body, new FlatTuple(var_param, var_lv), LowerValueQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_property, var_lv), LowerValueQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_param, var_uv), UpperValueQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_property, var_uv), UpperValueQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
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
