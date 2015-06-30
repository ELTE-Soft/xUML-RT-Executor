package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.ClassAssociationLowerBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClassAssociationLowerBoundProcessor implements IMatchProcessor<ClassAssociationLowerBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pEnd the value of pattern parameter end in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pLowerBound the value of pattern parameter lowerBound in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Property pEnd, final Association pType, final ValueSpecification pLowerBound);
  
  @Override
  public void process(final ClassAssociationLowerBoundMatch match) {
    process(match.getCls(), match.getEnd(), match.getType(), match.getLowerBound());
    
  }
}