package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

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
    return Arrays.asList("behavior","alfCode");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("behavior", "org.eclipse.uml2.uml.Behavior"),new PParameter("alfCode", "java.lang.String"));
  }
  
  @Override
  public AlfCodeMatch newEmptyMatch() {
    return AlfCodeMatch.newEmptyMatch();
  }
  
  @Override
  public AlfCodeMatch newMatch(final Object... parameters) {
    return AlfCodeMatch.newMatch((org.eclipse.uml2.uml.Behavior) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_behavior = body.getOrCreateVariableByName("behavior");
      PVariable var_alfCode = body.getOrCreateVariableByName("alfCode");
      PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_behavior, "behavior"), 
        new ExportedParameter(body, var_alfCode, "alfCode")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_behavior, var_alfCode, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior", "body"), "http://www.eclipse.org/uml2/5.0.0/UML/OpaqueBehavior.body");
      new ConstantValue(body, var__virtual_1_, "Alf");
      new TypeBinary(body, CONTEXT, var_behavior, var__virtual_1_, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "OpaqueBehavior", "language"), "http://www.eclipse.org/uml2/5.0.0/UML/OpaqueBehavior.language");
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
}
