package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionNonPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Reception;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionNonPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionNonPublicProcessor implements IMatchProcessor<ReceptionNonPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRc the value of pattern parameter rc in the currently processed match
   * 
   */
  public abstract void process(final Reception pRc);
  
  @Override
  public void process(final ReceptionNonPublicMatch match) {
    process(match.getRc());
  }
}
