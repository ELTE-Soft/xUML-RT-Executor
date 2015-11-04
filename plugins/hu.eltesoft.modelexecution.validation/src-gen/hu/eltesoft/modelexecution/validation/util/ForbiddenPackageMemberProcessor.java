package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ForbiddenPackageMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ForbiddenPackageMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenPackageMemberProcessor implements IMatchProcessor<ForbiddenPackageMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPk the value of pattern parameter pk in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pPk, final Element pElem);
  
  @Override
  public void process(final ForbiddenPackageMemberMatch match) {
    process(match.getPk(), match.getElem());
  }
}
