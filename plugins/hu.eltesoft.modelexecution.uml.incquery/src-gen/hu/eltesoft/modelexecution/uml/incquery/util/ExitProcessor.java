package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ExitMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Exit pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExitProcessor implements IMatchProcessor<ExitMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pState the value of pattern parameter state in the currently processed match
   * @param pExit the value of pattern parameter exit in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final State pState, final Behavior pExit);
  
  @Override
  public void process(final ExitMatch match) {
    process(match.getRegion(), match.getState(), match.getExit());
    
  }
}
