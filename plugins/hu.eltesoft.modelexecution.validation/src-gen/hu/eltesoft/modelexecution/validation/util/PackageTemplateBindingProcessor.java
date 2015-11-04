package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.PackageTemplateBindingMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.PackageTemplateBinding pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PackageTemplateBindingProcessor implements IMatchProcessor<PackageTemplateBindingMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPk the value of pattern parameter pk in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pPk);
  
  @Override
  public void process(final PackageTemplateBindingMatch match) {
    process(match.getPk());
  }
}
