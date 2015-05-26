package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.Utils;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate AlfCodeMatcher in a type-safe way.
 * 
 * @see AlfCodeMatcher
 * @see AlfCodeMatch
 * 
 */
@SuppressWarnings("all")
public final class AlfCodeQuerySpecification extends BaseGeneratedQuerySpecification<AlfCodeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AlfCodeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected AlfCodeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return AlfCodeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.AlfCode";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("behavior","containerClass","alfCode");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("containerClass", "org.eclipse.uml2.uml.Class"),new PParameter("alfCode", "java.lang.String"));
  }
  
  @Override
  public AlfCodeMatch newEmptyMatch() {
    return AlfCodeMatch.newEmptyMatch();
  }
  
  @Override
  public AlfCodeMatch newMatch(final Object... parameters) {
    return AlfCodeMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (org.eclipse.uml2.uml.Class) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_containerClass = body.getOrCreateVariableByName("containerClass");
      PVariable var_alfCode = body.getOrCreateVariableByName("alfCode");
      PVariable var_langName = body.getOrCreateVariableByName("langName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_containerClass, "containerClass"), 
        new ExportedParameter(body, var_alfCode, "alfCode")
      ));
      
      
      new TypeUnary(body, var_containerClass, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class"), "http://www.eclipse.org/uml2/5.0.0/UML/Class");
      
      new TypeBinary(body, CONTEXT, var_behavior, var_alfCode, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior", "body"), "http://www.eclipse.org/uml2/5.0.0/UML/OpaqueBehavior.body");
      new TypeBinary(body, CONTEXT, var_behavior, var_langName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior", "language"), "http://www.eclipse.org/uml2/5.0.0/UML/OpaqueBehavior.language");
      new PositivePatternCall(body, new FlatTuple(var_behavior, var_containerClass), ContainerClassOfBehaviorQuerySpecification.instance());
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
        @Override
        public String getShortDescription() {
        	return "Expression evaluation from pattern AlfCode";
        }
        
        @Override
        public Iterable<String> getInputParameterNames() {
        	return Arrays.asList("langName");
        }
        
        @Override
        public Object evaluateExpression(IValueProvider provider) throws Exception {
        	java.lang.String langName = (java.lang.String) provider.getValue("langName");
        	return evaluateExpression_1_1(langName);
        }
        
        },  null); 
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static AlfCodeQuerySpecification INSTANCE = make();
    
    public static AlfCodeQuerySpecification make() {
      return new AlfCodeQuerySpecification();					
      
    }
  }
  
  private boolean evaluateExpression_1_1(final String langName) {
    String _lowerCase = Utils.toLowerCase(langName);
    boolean _equals = _lowerCase.equals("alf");
    return _equals;
  }
}
