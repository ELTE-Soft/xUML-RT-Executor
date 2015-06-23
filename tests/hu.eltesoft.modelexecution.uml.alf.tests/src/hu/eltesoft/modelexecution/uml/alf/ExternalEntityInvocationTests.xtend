package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Operation
import org.junit.Test

import static org.junit.Assert.*

class ExternalEntityInvocationTests extends ModelBasedTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml"

	var Class eClass
	var Operation aOp
	var Operation bOp

	var AlfAnalyzer analyzer

	public new() {
		super(UML_TEST_MODEL_PATH)
	}

	override setUp() {
		super.setUp()

		eClass = model.namedChild(Class, "E")
		aOp = eClass.namedChild(Operation, "ExternalOpA")
		bOp = eClass.namedChild(Operation, "ExternalOpB")

		analyzer = new AlfAnalyzer
	}

	@Test
	def void testEmptyOperationMapping() {
		val result = analyzer.analyze("", eClass)
		assertFalse(result.references.mapsOperation(aOp))
		assertFalse(result.references.mapsOperation(bOp))
	}

	@Test
	def void testOparationABehaviorMapping() {
		val result = analyzer.analyze("E::ExternalOpA();", eClass)
		assertTrue(result.references.mapsOperation(aOp))
	}

	@Test
	def void testBothOperationMapping() {
		val result = analyzer.analyze("E::ExternalOpA();E::ExternalOpB(this);", eClass)
		assertTrue(result.references.mapsOperation(aOp))
		assertTrue(result.references.mapsOperation(bOp))
	}

	def boolean mapsOperation(ModelReferences references, Operation operation) {
		val target = new ExternalEntityInvocation(operation)
		for (invocation : references.mapping.values) {
			if (target.equals(invocation)) {
				return true
			}
		}
		return false
	}
}
