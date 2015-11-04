package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionParameterNotInMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionParameterNotIn pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionParameterNotInProcessor implements IMatchProcessor<ReceptionParameterNotInMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParam the value of pattern parameter param in the currently processed match
   * 
   */
  public abstract void process(final Parameter pParam);
  
  @Override
  public void process(final ReceptionParameterNotInMatch match) {
    process(match.getParam());
  }
}
