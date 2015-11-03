package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.StateMachineMustHaveOneRegion pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateMachineMustHaveOneRegionProcessor implements IMatchProcessor<StateMachineMustHaveOneRegionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSm the value of pattern parameter sm in the currently processed match
   * @param pRg1 the value of pattern parameter rg1 in the currently processed match
   * @param pRg2 the value of pattern parameter rg2 in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pSm, final Region pRg1, final Region pRg2);
  
  @Override
  public void process(final StateMachineMustHaveOneRegionMatch match) {
    process(match.getSm(), match.getRg1(), match.getRg2());
  }
}
