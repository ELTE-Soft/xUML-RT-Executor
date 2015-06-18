package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalAttributeUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.SignalMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalAttributeUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.SignalQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in signal.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file signal.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Signal</li>
 * <li>SignalAttribute</li>
 * <li>SignalAttributeLowerBound</li>
 * <li>SignalAttributeUpperBound</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Signal extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Signal instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Signal();
    }
    return INSTANCE;
    
  }
  
  private static Signal INSTANCE;
  
  private Signal() throws IncQueryException {
    querySpecifications.add(SignalQuerySpecification.instance());
    querySpecifications.add(SignalAttributeQuerySpecification.instance());
    querySpecifications.add(SignalAttributeLowerBoundQuerySpecification.instance());
    querySpecifications.add(SignalAttributeUpperBoundQuerySpecification.instance());
    
  }
  
  public SignalQuerySpecification getSignal() throws IncQueryException {
    return SignalQuerySpecification.instance();
  }
  
  public SignalMatcher getSignal(final IncQueryEngine engine) throws IncQueryException {
    return SignalMatcher.on(engine);
  }
  
  public SignalAttributeQuerySpecification getSignalAttribute() throws IncQueryException {
    return SignalAttributeQuerySpecification.instance();
  }
  
  public SignalAttributeMatcher getSignalAttribute(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeMatcher.on(engine);
  }
  
  public SignalAttributeLowerBoundQuerySpecification getSignalAttributeLowerBound() throws IncQueryException {
    return SignalAttributeLowerBoundQuerySpecification.instance();
  }
  
  public SignalAttributeLowerBoundMatcher getSignalAttributeLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeLowerBoundMatcher.on(engine);
  }
  
  public SignalAttributeUpperBoundQuerySpecification getSignalAttributeUpperBound() throws IncQueryException {
    return SignalAttributeUpperBoundQuerySpecification.instance();
  }
  
  public SignalAttributeUpperBoundMatcher getSignalAttributeUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return SignalAttributeUpperBoundMatcher.on(engine);
  }
}
