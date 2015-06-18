package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorParameterUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnLowerBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.BehaviorReturnUpperBoundMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StaticBehaviorMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AlfCodeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorParameterUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnLowerBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.BehaviorReturnUpperBoundQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfBehaviorQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.StaticBehaviorQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in behavior.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file behavior.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Behavior</li>
 * <li>ContainerClassOfBehavior</li>
 * <li>BehaviorParameter</li>
 * <li>BehaviorParameterType</li>
 * <li>BehaviorParameterLowerBound</li>
 * <li>BehaviorParameterUpperBound</li>
 * <li>BehaviorReturnType</li>
 * <li>BehaviorReturnLowerBound</li>
 * <li>BehaviorReturnUpperBound</li>
 * <li>StaticBehavior</li>
 * <li>AlfCode</li>
 * <li>ContainerClassOfVertex</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Behavior extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Behavior instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Behavior();
    }
    return INSTANCE;
    
  }
  
  private static Behavior INSTANCE;
  
  private Behavior() throws IncQueryException {
    querySpecifications.add(BehaviorQuerySpecification.instance());
    querySpecifications.add(ContainerClassOfBehaviorQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterTypeQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterLowerBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorParameterUpperBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnTypeQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnLowerBoundQuerySpecification.instance());
    querySpecifications.add(BehaviorReturnUpperBoundQuerySpecification.instance());
    querySpecifications.add(StaticBehaviorQuerySpecification.instance());
    querySpecifications.add(AlfCodeQuerySpecification.instance());
    
  }
  
  public BehaviorQuerySpecification getBehavior() throws IncQueryException {
    return BehaviorQuerySpecification.instance();
  }
  
  public BehaviorMatcher getBehavior(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorMatcher.on(engine);
  }
  
  public ContainerClassOfBehaviorQuerySpecification getContainerClassOfBehavior() throws IncQueryException {
    return ContainerClassOfBehaviorQuerySpecification.instance();
  }
  
  public ContainerClassOfBehaviorMatcher getContainerClassOfBehavior(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfBehaviorMatcher.on(engine);
  }
  
  public BehaviorParameterQuerySpecification getBehaviorParameter() throws IncQueryException {
    return BehaviorParameterQuerySpecification.instance();
  }
  
  public BehaviorParameterMatcher getBehaviorParameter(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterMatcher.on(engine);
  }
  
  public BehaviorParameterTypeQuerySpecification getBehaviorParameterType() throws IncQueryException {
    return BehaviorParameterTypeQuerySpecification.instance();
  }
  
  public BehaviorParameterTypeMatcher getBehaviorParameterType(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterTypeMatcher.on(engine);
  }
  
  public BehaviorParameterLowerBoundQuerySpecification getBehaviorParameterLowerBound() throws IncQueryException {
    return BehaviorParameterLowerBoundQuerySpecification.instance();
  }
  
  public BehaviorParameterLowerBoundMatcher getBehaviorParameterLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterLowerBoundMatcher.on(engine);
  }
  
  public BehaviorParameterUpperBoundQuerySpecification getBehaviorParameterUpperBound() throws IncQueryException {
    return BehaviorParameterUpperBoundQuerySpecification.instance();
  }
  
  public BehaviorParameterUpperBoundMatcher getBehaviorParameterUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorParameterUpperBoundMatcher.on(engine);
  }
  
  public BehaviorReturnTypeQuerySpecification getBehaviorReturnType() throws IncQueryException {
    return BehaviorReturnTypeQuerySpecification.instance();
  }
  
  public BehaviorReturnTypeMatcher getBehaviorReturnType(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnTypeMatcher.on(engine);
  }
  
  public BehaviorReturnLowerBoundQuerySpecification getBehaviorReturnLowerBound() throws IncQueryException {
    return BehaviorReturnLowerBoundQuerySpecification.instance();
  }
  
  public BehaviorReturnLowerBoundMatcher getBehaviorReturnLowerBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnLowerBoundMatcher.on(engine);
  }
  
  public BehaviorReturnUpperBoundQuerySpecification getBehaviorReturnUpperBound() throws IncQueryException {
    return BehaviorReturnUpperBoundQuerySpecification.instance();
  }
  
  public BehaviorReturnUpperBoundMatcher getBehaviorReturnUpperBound(final IncQueryEngine engine) throws IncQueryException {
    return BehaviorReturnUpperBoundMatcher.on(engine);
  }
  
  public StaticBehaviorQuerySpecification getStaticBehavior() throws IncQueryException {
    return StaticBehaviorQuerySpecification.instance();
  }
  
  public StaticBehaviorMatcher getStaticBehavior(final IncQueryEngine engine) throws IncQueryException {
    return StaticBehaviorMatcher.on(engine);
  }
  
  public AlfCodeQuerySpecification getAlfCode() throws IncQueryException {
    return AlfCodeQuerySpecification.instance();
  }
  
  public AlfCodeMatcher getAlfCode(final IncQueryEngine engine) throws IncQueryException {
    return AlfCodeMatcher.on(engine);
  }
}
