package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SignalAttributeMatcher in a type-safe way.
 * 
 * @see SignalAttributeMatcher
 * @see SignalAttributeMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalAttributeQuerySpecification extends BaseGeneratedQuerySpecification<SignalAttributeMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalAttributeQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SignalAttributeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalAttribute";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("signal","attribute");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"));
  }
  
  @Override
  public SignalAttributeMatch newEmptyMatch() {
    return SignalAttributeMatch.newEmptyMatch();
  }
  
  @Override
  public SignalAttributeMatch newMatch(final Object... parameters) {
    return SignalAttributeMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_signal, "signal"), 
        new ExportedParameter(body, var_attribute, "attribute")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_signal), SignalQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_signal, var_attribute, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal", "ownedAttribute"), "http://www.eclipse.org/uml2/5.0.0/UML/Signal.ownedAttribute");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SignalAttributeQuerySpecification INSTANCE = make();
    
    public static SignalAttributeQuerySpecification make() {
      return new SignalAttributeQuerySpecification();					
      
    }
  }
}
