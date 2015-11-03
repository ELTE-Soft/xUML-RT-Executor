package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.EventWithoutReceptionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.EventWithoutReception pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EventWithoutReceptionProcessor implements IMatchProcessor<EventWithoutReceptionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTr the value of pattern parameter tr in the currently processed match
   * @param pCl the value of pattern parameter cl in the currently processed match
   * @param pSg the value of pattern parameter sg in the currently processed match
   * 
   */
  public abstract void process(final Transition pTr, final org.eclipse.uml2.uml.Class pCl, final Signal pSg);
  
  @Override
  public void process(final EventWithoutReceptionMatch match) {
    process(match.getTr(), match.getCl(), match.getSg());
  }
}
