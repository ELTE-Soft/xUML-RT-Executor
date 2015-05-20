package hu.eltesoft.modelexecution.uml.incquery.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatch;
import hu.eltesoft.modelexecution.uml.incquery.ReceptionMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate ReceptionMatcher in a type-safe way.
 * 
 * @see ReceptionMatcher
 * @see ReceptionMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionQuerySpecification extends BaseGeneratedQuerySpecification<ReceptionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReceptionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.eltesoft.modelexecution.uml.incquery.Reception";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("cls","reception","receptionName","signal","signalName");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("cls", "org.eclipse.uml2.uml.Class"),new PParameter("reception", "org.eclipse.uml2.uml.Reception"),new PParameter("receptionName", "java.lang.String"),new PParameter("signal", "org.eclipse.uml2.uml.Signal"),new PParameter("signalName", "java.lang.String"));
  }
  
  @Override
  public ReceptionMatch newEmptyMatch() {
    return ReceptionMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionMatch newMatch(final Object... parameters) {
    return ReceptionMatch.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Reception) parameters[1], (java.lang.String) parameters[2], (org.eclipse.uml2.uml.Signal) parameters[3], (java.lang.String) parameters[4]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_cls = body.getOrCreateVariableByName("cls");
      PVariable var_reception = body.getOrCreateVariableByName("reception");
      PVariable var_receptionName = body.getOrCreateVariableByName("receptionName");
      PVariable var_signal = body.getOrCreateVariableByName("signal");
      PVariable var_signalName = body.getOrCreateVariableByName("signalName");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_cls, "cls"), 
        new ExportedParameter(body, var_reception, "reception"), 
        new ExportedParameter(body, var_receptionName, "receptionName"), 
        new ExportedParameter(body, var_signal, "signal"), 
        new ExportedParameter(body, var_signalName, "signalName")
      ));
      
      
      
      
      
      new TypeBinary(body, CONTEXT, var_cls, var_reception, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedReception"), "http://www.eclipse.org/uml2/5.0.0/UML/Class.ownedReception");
      new TypeBinary(body, CONTEXT, var_reception, var_signal, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception", "signal"), "http://www.eclipse.org/uml2/5.0.0/UML/Reception.signal");
      new TypeBinary(body, CONTEXT, var_reception, var_receptionName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      new TypeBinary(body, CONTEXT, var_signal, var_signalName, getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name"), "http://www.eclipse.org/uml2/5.0.0/UML/NamedElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReceptionQuerySpecification INSTANCE = make();
    
    public static ReceptionQuerySpecification make() {
      return new ReceptionQuerySpecification();					
      
    }
  }
}
