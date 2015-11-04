package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.StateMachineMustHaveRegion pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineMustHaveRegionProcessor implements IMatchProcessor<StateMachineMustHaveRegionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSm the value of pattern parameter sm in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pSm);
  
  @Override
  public void process(final StateMachineMustHaveRegionMatch match) {
    process(match.getSm());
  }
}
