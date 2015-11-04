package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.PackageTemplateParameterMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.PackageTemplateParameter pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PackageTemplateParameterProcessor implements IMatchProcessor<PackageTemplateParameterMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPk the value of pattern parameter pk in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Package pPk);
  
  @Override
  public void process(final PackageTemplateParameterMatch match) {
    process(match.getPk());
  }
}
