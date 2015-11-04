package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEventsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.SignalInMultipleSignalEvents pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SignalInMultipleSignalEventsProcessor implements IMatchProcessor<SignalInMultipleSignalEventsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSg the value of pattern parameter sg in the currently processed match
   * @param pEv1 the value of pattern parameter ev1 in the currently processed match
   * @param pEv2 the value of pattern parameter ev2 in the currently processed match
   * 
   */
  public abstract void process(final Signal pSg, final SignalEvent pEv1, final SignalEvent pEv2);
  
  @Override
  public void process(final SignalInMultipleSignalEventsMatch match) {
    process(match.getSg(), match.getEv1(), match.getEv2());
  }
}
