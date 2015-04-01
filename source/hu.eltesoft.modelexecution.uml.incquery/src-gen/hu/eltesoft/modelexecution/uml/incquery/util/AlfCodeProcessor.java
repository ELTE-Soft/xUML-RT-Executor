package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AlfCodeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.AlfCode pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AlfCodeProcessor implements IMatchProcessor<AlfCodeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pAlfCode the value of pattern parameter alfCode in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final String pAlfCode);
  
  @Override
  public void process(final AlfCodeMatch match) {
    process(match.getBehavior(), match.getAlfCode());
    
  }
}
