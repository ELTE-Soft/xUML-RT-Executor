package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNumMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNum pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReceptionSignalParameterNumProcessor implements IMatchProcessor<ReceptionSignalParameterNumMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRc the value of pattern parameter rc in the currently processed match
   * @param pSg the value of pattern parameter sg in the currently processed match
   * @param pParams the value of pattern parameter params in the currently processed match
   * @param pProperties the value of pattern parameter properties in the currently processed match
   * 
   */
  public abstract void process(final Reception pRc, final Signal pSg, final Integer pParams, final Integer pProperties);
  
  @Override
  public void process(final ReceptionSignalParameterNumMatch match) {
    process(match.getRc(), match.getSg(), match.getParams(), match.getProperties());
  }
}
