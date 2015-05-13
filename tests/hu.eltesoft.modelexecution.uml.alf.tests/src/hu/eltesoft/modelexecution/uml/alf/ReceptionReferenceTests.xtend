package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Reception
import org.junit.Test

import static org.junit.Assert.*

class ReceptionReferenceTests extends ModelBasedTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml"

	var Class cClass
	var Reception aReception
	var Reception bReception

	var AlfAnalyzer analyzer

	public new() {
		super(UML_TEST_MODEL_PATH)
	}

	override setUp() {
		super.setUp()

		cClass = model.namedChild(Class, "C")
		aReception = cClass.namedChild(Reception, "ReceptionA")
		bReception = cClass.namedChild(Reception, "ReceptionB")

		analyzer = new AlfAnalyzer
	}

	@Test
	def void testEmptyReceptionMapping() {
		val result = analyzer.analyze("", cClass)
		assertFalse(result.references.mapsReception(aReception))
		assertFalse(result.references.mapsReception(bReception))
	}

	@Test
	def void testReceptionAFeatureMapping() {
		val result = analyzer.analyze("this.ReceptionA();", cClass)
		assertTrue(result.references.mapsReception(aReception))
	}

	@Test
	def void testReceptionBBehaviorMapping() {
		val result = analyzer.analyze("ReceptionB();", cClass)
		assertTrue(result.references.mapsReception(bReception))
	}

	@Test
	def void testBothReceptionMapping() {
		val result = analyzer.analyze("this.ReceptionB();ReceptionA();", cClass)
		assertTrue(result.references.mapsReception(aReception))
		assertTrue(result.references.mapsReception(bReception))
	}
}
