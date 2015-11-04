package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ExternalEntityNameNotValidMatch;
import hu.eltesoft.modelexecution.validation.ExternalEntityNameNotValidMatcher;
import hu.eltesoft.modelexecution.validation.Helpers;
import hu.eltesoft.modelexecution.validation.util.ExternalEntityQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ExternalEntityNameNotValidMatcher in a type-safe way.
 * 
 * @see ExternalEntityNameNotValidMatcher
 * @see ExternalEntityNameNotValidMatch
 * 
 */
@SuppressWarnings("all")
public final class ExternalEntityNameNotValidQuerySpecification extends BaseGeneratedEMFQuerySpecification<ExternalEntityNameNotValidMatcher> {
  private ExternalEntityNameNotValidQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ExternalEntityNameNotValidQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ExternalEntityNameNotValidMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ExternalEntityNameNotValidMatcher.on(engine);
  }
  
  @Override
  public ExternalEntityNameNotValidMatch newEmptyMatch() {
    return ExternalEntityNameNotValidMatch.newEmptyMatch();
  }
  
  @Override
  public ExternalEntityNameNotValidMatch newMatch(final Object... parameters) {
    return ExternalEntityNameNotValidMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ExternalEntityNameNotValidQuerySpecification INSTANCE = make();
    
    public static ExternalEntityNameNotValidQuerySpecification make() {
      return new ExternalEntityNameNotValidQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ExternalEntityNameNotValidQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ExternalEntityNameNotValid";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("cl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("cl", "org.eclipse.uml2.uml.Class"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_cl = body.getOrCreateVariableByName("cl");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_cl, "cl")
      	));
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new PositivePatternCall(body, new FlatTuple(var_cl, var___0_), ExternalEntityQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_cl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
      	new TypeConstraint(body, new FlatTuple(var_cl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
      	new Equality(body, var__virtual_0_, var_name);
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern ExternalEntityNameNotValid";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("name");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.String name = (java.lang.String) provider.getValue("name");
      			return evaluateExpression_1_1(name);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Name of an external entity class must be a valid Java class name");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"cl"
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
  
  private static boolean evaluateExpression_1_1(final String name) {
    boolean _validJavaIdentifierName = Helpers.validJavaIdentifierName(name);
    boolean _not = (!_validJavaIdentifierName);
    return _not;
  }
}
