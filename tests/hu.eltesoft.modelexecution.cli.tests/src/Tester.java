/**
 * This interface has to be an exact copy of the interface generated from
 * external entity Tester in Tester.uml.
 */
@javax.annotation.Generated(date = "Wed Oct 07 14:18:51 CEST 2015", value = {}, comments = "Tester")
@hu.eltesoft.modelexecution.runtime.external.ExternalEntity(implementationClass = "TesterImpl", type = hu.eltesoft.modelexecution.runtime.external.ExternalEntityType.Singleton)
public interface Tester {

	public void success();

	public void fail();
}
