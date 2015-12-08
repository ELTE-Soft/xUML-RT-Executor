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
 * A pattern-specific query specification that can instantiate ParamsCheckMatcher in a type-safe way.
 * 
 * @see ParamsCheckMatcher
 * @see ParamsCheckMatch
 * 
 */
@SuppressWarnings("all")
final class ParamsCheckQuerySpecification extends BaseGeneratedEMFQuerySpecification<IncQueryMatcher<IPatternMatch>> {
  private ParamsCheckQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ParamsCheckQuerySpecification instance() throws IncQueryException {
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
    private final static ParamsCheckQuerySpecification INSTANCE = make();
    
    public static ParamsCheckQuerySpecification make() {
      return new ParamsCheckQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ParamsCheckQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ParamsCheck";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("opParam","methodParam");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("opParam", "org.eclipse.uml2.uml.Parameter"),new PParameter("methodParam", "org.eclipse.uml2.uml.Parameter"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_opParam = body.getOrCreateVariableByName("opParam");
      		PVariable var_methodParam = body.getOrCreateVariableByName("methodParam");
      		PVariable var_type = body.getOrCreateVariableByName("type");
      		PVariable var_dir = body.getOrCreateVariableByName("dir");
      		PVariable var_lv = body.getOrCreateVariableByName("lv");
      		PVariable var_uv = body.getOrCreateVariableByName("uv");
      		new TypeConstraint(body, new FlatTuple(var_opParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		new TypeConstraint(body, new FlatTuple(var_methodParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_opParam, "opParam"),
      		   new ExportedParameter(body, var_methodParam, "methodParam")
      		));
      		// 	Parameter.type(opParam, type)
      		new TypeConstraint(body, new FlatTuple(var_opParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_opParam, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      		new Equality(body, var__virtual_0_, var_type);
      		// 	Parameter.type(methodParam, type)
      		new TypeConstraint(body, new FlatTuple(var_methodParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var_methodParam, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type")));
      		new Equality(body, var__virtual_1_, var_type);
      		// 	Parameter.direction(opParam, dir)
      		new TypeConstraint(body, new FlatTuple(var_opParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      		new TypeConstraint(body, new FlatTuple(var_opParam, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_2_, var_dir);
      		// 	Parameter.direction(methodParam, dir)
      		new TypeConstraint(body, new FlatTuple(var_methodParam), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter")));
      		PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      		new TypeConstraint(body, new FlatTuple(var_methodParam, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Parameter", "direction")));
      		new Equality(body, var__virtual_3_, var_dir);
      		// 	find LowerValue(opParam, lv)
      		new PositivePatternCall(body, new FlatTuple(var_opParam, var_lv), LowerValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find LowerValue(methodParam, lv)
      		new PositivePatternCall(body, new FlatTuple(var_methodParam, var_lv), LowerValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find UpperValue(opParam, uv)
      		new PositivePatternCall(body, new FlatTuple(var_opParam, var_uv), UpperValueQuerySpecification.instance().getInternalQueryRepresentation());
      		// 	find UpperValue(methodParam, uv)
      		new PositivePatternCall(body, new FlatTuple(var_methodParam, var_uv), UpperValueQuerySpecification.instance().getInternalQueryRepresentation());
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
