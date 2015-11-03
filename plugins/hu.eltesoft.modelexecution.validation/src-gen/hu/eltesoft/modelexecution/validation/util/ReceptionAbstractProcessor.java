package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionAbstractMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Reception;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionAbstract pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionAbstractProcessor implements IMatchProcessor<ReceptionAbstractMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRc the value of pattern parameter rc in the currently processed match
   * 
   */
  public abstract void process(final Reception pRc);
  
  @Override
  public void process(final ReceptionAbstractMatch match) {
    process(match.getRc());
  }
}
