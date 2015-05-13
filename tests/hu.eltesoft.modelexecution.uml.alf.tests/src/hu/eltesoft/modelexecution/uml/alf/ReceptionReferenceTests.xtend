package hu.eltesoft.modelexecution.uml.alf

import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase
import org.eclipse.emf.ecore.EObject
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Reception
import org.junit.Test

class ReceptionReferenceTests extends ModelBasedTestCase {

	static val UML_TEST_MODEL_PATH = "resources/model.uml"

	var EObject cClass

	public new() {
		super(UML_TEST_MODEL_PATH)
	}

	override setUp() {
		super.setUp()
		cClass = model.firstNamed(Class, "C")
	}

	@Test
	def test() {
		// TODO: implement the actual tests
		val a = cClass.firstNamed(Reception, "ReceptionA")
		val b = cClass.firstNamed(Reception, "ReceptionB")
		System.out.println(a)
		System.out.println(b)
	}
}
