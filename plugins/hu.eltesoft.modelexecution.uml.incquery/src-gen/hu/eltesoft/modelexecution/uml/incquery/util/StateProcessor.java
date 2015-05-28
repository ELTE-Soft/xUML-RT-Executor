package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.StateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.State pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StateProcessor implements IMatchProcessor<StateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pState the value of pattern parameter state in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final State pState);
  
  @Override
  public void process(final StateMatch match) {
    process(match.getRegion(), match.getState());
    
  }
}
