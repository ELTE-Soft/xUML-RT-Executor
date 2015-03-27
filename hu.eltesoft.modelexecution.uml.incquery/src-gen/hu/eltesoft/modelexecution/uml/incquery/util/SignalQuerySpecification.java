package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate SignalMatcher in a type-safe way.
 * 
 * @see SignalMatcher
 * @see SignalMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalQuerySpecification extends BaseGeneratedQuerySpecification<SignalMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SignalMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Signal";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("signal","signalName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("signalName", "java.lang.String"));
  }
  
  @Override
  public SignalMatch newEmptyMatch() {
    return SignalMatch.newEmptyMatch();
  }
  
  @Override
  public SignalMatch newMatch(final Object... parameters) {
    return SignalMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      PVariable var_signalName = body.getOrCreateVariableByName("signalName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_signal, "signal"), 
        new ExportedParameter(body, var_signalName, "signalName")
      ));
      
      
      new TypeUnary(body, var_signal, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal"), "http://www.eclipse.org/uml2/5.0.0/UML/Signal");
      new TypeBinary(body, CONTEXT, var_signal, var_signalName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SignalQuerySpecification INSTANCE = make();
    
    public static SignalQuerySpecification make() {
      return new SignalQuerySpecification();					
      
    }
  }
}
