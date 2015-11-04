package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionWithoutSignalMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Reception;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionWithoutSignal pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionWithoutSignalProcessor implements IMatchProcessor<ReceptionWithoutSignalMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRc the value of pattern parameter rc in the currently processed match
   * 
   */
  public abstract void process(final Reception pRc);
  
  @Override
  public void process(final ReceptionWithoutSignalMatch match) {
    process(match.getRc());
  }
}
