package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfRegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.EntryMatcher;
import hu.eltesoft.modelexecution.uml.incquery.ExitMatcher;
import hu.eltesoft.modelexecution.uml.incquery.InitialsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.RegionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.StateMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatcher;
import hu.eltesoft.modelexecution.uml.incquery.TransitionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ContainerClassOfRegionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.EntryQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.ExitQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.InitialsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.RegionQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.StateQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionEffectQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.TransitionQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in region.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file region.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Region</li>
 * <li>ContainerClassOfRegion</li>
 * <li>Initials</li>
 * <li>State</li>
 * <li>Entry</li>
 * <li>Exit</li>
 * <li>Transition</li>
 * <li>TransitionEffect</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Region extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Region instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Region();
    }
    return INSTANCE;
    
  }
  
  private static Region INSTANCE;
  
  private Region() throws IncQueryException {
    querySpecifications.add(RegionQuerySpecification.instance());
    querySpecifications.add(ContainerClassOfRegionQuerySpecification.instance());
    querySpecifications.add(InitialsQuerySpecification.instance());
    querySpecifications.add(StateQuerySpecification.instance());
    querySpecifications.add(EntryQuerySpecification.instance());
    querySpecifications.add(ExitQuerySpecification.instance());
    querySpecifications.add(TransitionQuerySpecification.instance());
    querySpecifications.add(TransitionEffectQuerySpecification.instance());
    
  }
  
  public RegionQuerySpecification getRegion() throws IncQueryException {
    return RegionQuerySpecification.instance();
  }
  
  public RegionMatcher getRegion(final IncQueryEngine engine) throws IncQueryException {
    return RegionMatcher.on(engine);
  }
  
  public ContainerClassOfRegionQuerySpecification getContainerClassOfRegion() throws IncQueryException {
    return ContainerClassOfRegionQuerySpecification.instance();
  }
  
  public ContainerClassOfRegionMatcher getContainerClassOfRegion(final IncQueryEngine engine) throws IncQueryException {
    return ContainerClassOfRegionMatcher.on(engine);
  }
  
  public InitialsQuerySpecification getInitials() throws IncQueryException {
    return InitialsQuerySpecification.instance();
  }
  
  public InitialsMatcher getInitials(final IncQueryEngine engine) throws IncQueryException {
    return InitialsMatcher.on(engine);
  }
  
  public StateQuerySpecification getState() throws IncQueryException {
    return StateQuerySpecification.instance();
  }
  
  public StateMatcher getState(final IncQueryEngine engine) throws IncQueryException {
    return StateMatcher.on(engine);
  }
  
  public EntryQuerySpecification getEntry() throws IncQueryException {
    return EntryQuerySpecification.instance();
  }
  
  public EntryMatcher getEntry(final IncQueryEngine engine) throws IncQueryException {
    return EntryMatcher.on(engine);
  }
  
  public ExitQuerySpecification getExit() throws IncQueryException {
    return ExitQuerySpecification.instance();
  }
  
  public ExitMatcher getExit(final IncQueryEngine engine) throws IncQueryException {
    return ExitMatcher.on(engine);
  }
  
  public TransitionQuerySpecification getTransition() throws IncQueryException {
    return TransitionQuerySpecification.instance();
  }
  
  public TransitionMatcher getTransition(final IncQueryEngine engine) throws IncQueryException {
    return TransitionMatcher.on(engine);
  }
  
  public TransitionEffectQuerySpecification getTransitionEffect() throws IncQueryException {
    return TransitionEffectQuerySpecification.instance();
  }
  
  public TransitionEffectMatcher getTransitionEffect(final IncQueryEngine engine) throws IncQueryException {
    return TransitionEffectMatcher.on(engine);
  }
}
