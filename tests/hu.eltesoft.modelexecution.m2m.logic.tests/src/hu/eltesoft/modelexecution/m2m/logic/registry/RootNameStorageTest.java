package hu.eltesoft.modelexecution.m2m.logic.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.junit.Test;

public class RootNameStorageTest extends ModelBasedTestCase {

	private static final String UML_TEST_MODEL_PATH = "resources/2015_q1_model.uml";

	public RootNameStorageTest() {
		super(UML_TEST_MODEL_PATH);
	}

	private RootNameStorage rootNames;
	private Class class1;

	@Override
	public void setUp() {
		super.setUp();
		rootNames = new RootNameStorage();
		class1 = namedChild(model, Class.class, "Class1");
	};

	@Test
	public void testConsumeRemovesTheName() {
		rootNames.saveRootName(class1);
		List<String> consumed = new ArrayList<>();
		rootNames.consumeRootName(class1, name -> consumed.add(name));
		rootNames.consumeRootName(class1, name -> consumed.add(name));

		assertEquals(1, consumed.size());
		assertEquals(NamedReference.getIdentifier(class1), consumed.get(0));
	}

	@Test
	public void testUnableToSaveDestroyedObject() {
		class1.destroy();
		rootNames.saveRootName(class1);
		List<String> consumed = new ArrayList<>();
		rootNames.consumeRootName(class1, name -> consumed.add(name));

		assertTrue(consumed.isEmpty());
	}

	@Test
	public void testUnableToConsumeUnsavedObject() {
		List<String> consumed = new ArrayList<>();
		rootNames.consumeRootName(class1, name -> consumed.add(name));

		assertTrue(consumed.isEmpty());
	}
}
