package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatch;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeTypeQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SignalAttributeLowerBoundMatcher in a type-safe way.
 * 
 * @see SignalAttributeLowerBoundMatcher
 * @see SignalAttributeLowerBoundMatch
 * 
 */
@SuppressWarnings("all")
public final class SignalAttributeLowerBoundQuerySpecification extends BaseGeneratedQuerySpecification<SignalAttributeLowerBoundMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SignalAttributeLowerBoundQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SignalAttributeLowerBoundMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeLowerBoundMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBound";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("signal","attribute","type","lowerBound");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("attribute", "org.eclipse.uml2.uml.Property"),new PParameter("type", "org.eclipse.uml2.uml.Type"),new PParameter("lowerBound", "org.eclipse.uml2.uml.ValueSpecification"));
  }
  
  @Override
  public SignalAttributeLowerBoundMatch newEmptyMatch() {
    return SignalAttributeLowerBoundMatch.newEmptyMatch();
  }
  
  @Override
  public SignalAttributeLowerBoundMatch newMatch(final Object... parameters) {
    return SignalAttributeLowerBoundMatch.newMatch((org.eclipse.uml2.uml.Signal) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.Type) parameters[2], (org.eclipse.uml2.uml.ValueSpecification) parameters[3]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      PVariable var_attribute = body.getOrCreateVariableByName("attribute");
      PVariable var_type = body.getOrCreateVariableByName("type");
      PVariable var_lowerBound = body.getOrCreateVariableByName("lowerBound");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_signal, "signal"), 
        new ExportedParameter(body, var_attribute, "attribute"), 
        new ExportedParameter(body, var_type, "type"), 
        new ExportedParameter(body, var_lowerBound, "lowerBound")
      ));
      
      new TypeUnary(body, var_signal, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Signal"), "http://www.eclipse.org/uml2/5.0.0/UML/Signal");
      
      
      new TypeUnary(body, var_type, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Type"), "http://www.eclipse.org/uml2/5.0.0/UML/Type");
      
      new PositivePatternCall(body, new FlatTuple(var_signal, var_attribute, var_type), SignalAttributeTypeQuerySpecification.instance());
      new TypeUnary(body, var_attribute, getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property"), "http://www.eclipse.org/uml2/5.0.0/UML/Property");
      new TypeBinary(body, CONTEXT, var_attribute, var_lowerBound, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "MultiplicityElement", "lowerValue"), "http://www.eclipse.org/uml2/5.0.0/UML/MultiplicityElement.lowerValue");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SignalAttributeLowerBoundQuerySpecification INSTANCE = make();
    
    public static SignalAttributeLowerBoundQuerySpecification make() {
      return new SignalAttributeLowerBoundQuerySpecification();					
      
    }
  }
}
