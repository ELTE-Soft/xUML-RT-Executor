package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionSignalChecksMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionSignalChecks pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionSignalChecksProcessor implements IMatchProcessor<ReceptionSignalChecksMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParam the value of pattern parameter param in the currently processed match
   * @param pProperty the value of pattern parameter property in the currently processed match
   * @param pRc the value of pattern parameter rc in the currently processed match
   * @param pSg the value of pattern parameter sg in the currently processed match
   * 
   */
  public abstract void process(final Parameter pParam, final Property pProperty, final Reception pRc, final Signal pSg);
  
  @Override
  public void process(final ReceptionSignalChecksMatch match) {
    process(match.getParam(), match.getProperty(), match.getRc(), match.getSg());
  }
}
