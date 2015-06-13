package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalAttributeTypeMatcher in a type-safe way.
 * 
 * @see SignalAttributeTypeMatcher
 * @see SignalAttributeTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalAttributeTypeQuerySpecification extends BaseGeneratedQuerySpecification<SignalAttributeTypeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalAttributeTypeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SignalAttributeTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeTypeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalAttributeType";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("signal","attribute","type");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Type"));
  }
  
  @Override
  public SignalAttributeTypeMatch newEmptyMatch() {
    return SignalAttributeTypeMatch.newEmptyMatch();
  }
  
  @Override
  public SignalAttributeTypeMatch newMatch(final Object... parameters) {
    return SignalAttributeTypeMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_type = body.getOrCreateVariableByName("type");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_signal, "signal"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_type, "type")
      ));
      
      new TypeUnary(body, var_signal, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal"), "http://www.eclipse.org/uml2/5.0.0/UML/Signal");
      
      
      new PositivePatternCall(body, new FlatTuple(var_signal, var_attribute), SignalAttributeQuerySpecification.instance());
      new TypeUnary(body, var_attribute, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_attribute, var_type, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "TypedElement", "type"), "http://www.eclipse.org/uml2/5.0.0/UML/TypedElement.type");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SignalAttributeTypeQuerySpecification INSTANCE = make();
    
    public static SignalAttributeTypeQuerySpecification make() {
      return new SignalAttributeTypeQuerySpecification();					
      
    }
  }
}
