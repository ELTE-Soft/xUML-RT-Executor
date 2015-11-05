package hu.eltesoft.modelexecution.validation.util;

import com.google.common.collect.Sets;
import hu.eltesoft.modelexecution.validation.ReceptionWithoutSignalMatch;
import hu.eltesoft.modelexecution.validation.ReceptionWithoutSignalMatcher;
import hu.eltesoft.modelexecution.validation.util.ReceptionSignalQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReceptionWithoutSignalMatcher in a type-safe way.
 * 
 * @see ReceptionWithoutSignalMatcher
 * @see ReceptionWithoutSignalMatch
 * 
 */
@SuppressWarnings("all")
public final class ReceptionWithoutSignalQuerySpecification extends BaseGeneratedEMFQuerySpecification<ReceptionWithoutSignalMatcher> {
  private ReceptionWithoutSignalQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReceptionWithoutSignalQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReceptionWithoutSignalMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionWithoutSignalMatcher.on(engine);
  }
  
  @Override
  public ReceptionWithoutSignalMatch newEmptyMatch() {
    return ReceptionWithoutSignalMatch.newEmptyMatch();
  }
  
  @Override
  public ReceptionWithoutSignalMatch newMatch(final Object... parameters) {
    return ReceptionWithoutSignalMatch.newMatch((org.eclipse.uml2.uml.Reception) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static ReceptionWithoutSignalQuerySpecification INSTANCE = make();
    
    public static ReceptionWithoutSignalQuerySpecification make() {
      return new ReceptionWithoutSignalQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ReceptionWithoutSignalQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.eltesoft.modelexecution.validation.ReceptionWithoutSignal";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("rc");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("rc", "org.eclipse.uml2.uml.Reception"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_rc = body.getOrCreateVariableByName("rc");
      	PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_rc, "rc")
      	));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new TypeConstraint(body, new FlatTuple(var_rc), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Reception")));
      	new NegativePatternCall(body, new FlatTuple(var_rc, var___0_), ReceptionSignalQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Violation");
      	annotation.addAttribute("message", "Reception without signal");
      	annotation.addAttribute("mark", Arrays.asList(new Object[] {
      					"rc"
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
}