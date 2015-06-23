package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.ExternalOperationParameterMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedClsMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedOperationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.NamedReceptionMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.ExternalOperationParameterQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedClsQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedOperationQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.NamedReceptionQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in external.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file external.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>NamedCls</li>
 * <li>NamedOperation</li>
 * <li>ExternalOperationParameter</li>
 * <li>NamedReception</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class External extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static External instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new External();
    }
    return INSTANCE;
    
  }
  
  private static External INSTANCE;
  
  private External() throws IncQueryException {
    querySpecifications.add(NamedClsQuerySpecification.instance());
    querySpecifications.add(NamedOperationQuerySpecification.instance());
    querySpecifications.add(ExternalOperationParameterQuerySpecification.instance());
    querySpecifications.add(NamedReceptionQuerySpecification.instance());
    
  }
  
  public NamedClsQuerySpecification getNamedCls() throws IncQueryException {
    return NamedClsQuerySpecification.instance();
  }
  
  public NamedClsMatcher getNamedCls(final IncQueryEngine engine) throws IncQueryException {
    return NamedClsMatcher.on(engine);
  }
  
  public NamedOperationQuerySpecification getNamedOperation() throws IncQueryException {
    return NamedOperationQuerySpecification.instance();
  }
  
  public NamedOperationMatcher getNamedOperation(final IncQueryEngine engine) throws IncQueryException {
    return NamedOperationMatcher.on(engine);
  }
  
  public ExternalOperationParameterQuerySpecification getExternalOperationParameter() throws IncQueryException {
    return ExternalOperationParameterQuerySpecification.instance();
  }
  
  public ExternalOperationParameterMatcher getExternalOperationParameter(final IncQueryEngine engine) throws IncQueryException {
    return ExternalOperationParameterMatcher.on(engine);
  }
  
  public NamedReceptionQuerySpecification getNamedReception() throws IncQueryException {
    return NamedReceptionQuerySpecification.instance();
  }
  
  public NamedReceptionMatcher getNamedReception(final IncQueryEngine engine) throws IncQueryException {
    return NamedReceptionMatcher.on(engine);
  }
}
