package hu.eltesoft.modelexecution.validation;

import hu.eltesoft.modelexecution.validation.OperationMethodParameterCheckMatcher;
import hu.eltesoft.modelexecution.validation.OperationMethodParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionSignalChecksMatcher;
import hu.eltesoft.modelexecution.validation.ReceptionSignalParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedAndRedefiningParametersMustBeTheSameMatcher;
import hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNumMatcher;
import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterCheckQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.OperationMethodParameterNumQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionSignalChecksQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.ReceptionSignalParameterNumQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification;
import hu.eltesoft.modelexecution.validation.util.RedefinedOperationParameterNumQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in ParameterChecks.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file ParameterChecks.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.validation, the group contains the definition of the following patterns: <ul>
 * <li>OperationMethodParameterNum</li>
 * <li>ParameterOfOperation</li>
 * <li>ParameterOfBehavior</li>
 * <li>OperationMethodParameterCheck</li>
 * <li>ParamsCheck</li>
 * <li>LowerValue</li>
 * <li>Lower</li>
 * <li>UpperValue</li>
 * <li>Upper</li>
 * <li>ReceptionSignalParameterNum</li>
 * <li>ParameterOfReception</li>
 * <li>PropertiesOfSignal</li>
 * <li>ReceptionSignalChecks</li>
 * <li>ParamPropCheck</li>
 * <li>RedefinedOperationParameterNum</li>
 * <li>RedefinedAndRedefiningParametersMustBeTheSame</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class ParameterChecks extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static ParameterChecks instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new ParameterChecks();
    }
    return INSTANCE;
  }
  
  private static ParameterChecks INSTANCE;
  
  private ParameterChecks() throws IncQueryException {
    querySpecifications.add(OperationMethodParameterNumQuerySpecification.instance());
    querySpecifications.add(OperationMethodParameterCheckQuerySpecification.instance());
    querySpecifications.add(ReceptionSignalParameterNumQuerySpecification.instance());
    querySpecifications.add(ReceptionSignalChecksQuerySpecification.instance());
    querySpecifications.add(RedefinedOperationParameterNumQuerySpecification.instance());
    querySpecifications.add(RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification.instance());
  }
  
  public OperationMethodParameterNumQuerySpecification getOperationMethodParameterNum() throws IncQueryException {
    return OperationMethodParameterNumQuerySpecification.instance();
  }
  
  public OperationMethodParameterNumMatcher getOperationMethodParameterNum(final IncQueryEngine engine) throws IncQueryException {
    return OperationMethodParameterNumMatcher.on(engine);
  }
  
  public OperationMethodParameterCheckQuerySpecification getOperationMethodParameterCheck() throws IncQueryException {
    return OperationMethodParameterCheckQuerySpecification.instance();
  }
  
  public OperationMethodParameterCheckMatcher getOperationMethodParameterCheck(final IncQueryEngine engine) throws IncQueryException {
    return OperationMethodParameterCheckMatcher.on(engine);
  }
  
  public ReceptionSignalParameterNumQuerySpecification getReceptionSignalParameterNum() throws IncQueryException {
    return ReceptionSignalParameterNumQuerySpecification.instance();
  }
  
  public ReceptionSignalParameterNumMatcher getReceptionSignalParameterNum(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionSignalParameterNumMatcher.on(engine);
  }
  
  public ReceptionSignalChecksQuerySpecification getReceptionSignalChecks() throws IncQueryException {
    return ReceptionSignalChecksQuerySpecification.instance();
  }
  
  public ReceptionSignalChecksMatcher getReceptionSignalChecks(final IncQueryEngine engine) throws IncQueryException {
    return ReceptionSignalChecksMatcher.on(engine);
  }
  
  public RedefinedOperationParameterNumQuerySpecification getRedefinedOperationParameterNum() throws IncQueryException {
    return RedefinedOperationParameterNumQuerySpecification.instance();
  }
  
  public RedefinedOperationParameterNumMatcher getRedefinedOperationParameterNum(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedOperationParameterNumMatcher.on(engine);
  }
  
  public RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification getRedefinedAndRedefiningParametersMustBeTheSame() throws IncQueryException {
    return RedefinedAndRedefiningParametersMustBeTheSameQuerySpecification.instance();
  }
  
  public RedefinedAndRedefiningParametersMustBeTheSameMatcher getRedefinedAndRedefiningParametersMustBeTheSame(final IncQueryEngine engine) throws IncQueryException {
    return RedefinedAndRedefiningParametersMustBeTheSameMatcher.on(engine);
  }
}
