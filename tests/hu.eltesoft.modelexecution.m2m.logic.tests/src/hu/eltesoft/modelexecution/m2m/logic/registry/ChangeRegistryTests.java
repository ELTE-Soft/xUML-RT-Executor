package hu.eltesoft.modelexecution.m2m.logic.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Class;
import org.junit.Test;

import hu.eltesoft.modelexecution.m2m.logic.DeleteSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.GenerationException;
import hu.eltesoft.modelexecution.m2m.logic.SourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.UpdateSourceCodeTask;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.classdef.ClClass;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.test.utils.ModelBasedTestCase;
import hu.eltesoft.modelexecution.uml.incquery.ClsMatch;

public class ChangeRegistryTests extends ModelBasedTestCase {

	private static final String UML_TEST_MODEL_PATH = "resources/2015_q1_model.uml";

	public ChangeRegistryTests() {
		super(UML_TEST_MODEL_PATH);
	}

	private ChangeRegistry changes;
	private Class class1;
	private FakeClassTranslator translator;

	@Override
	public void setUp() {
		super.setUp();
		changes = new ChangeRegistry();
		class1 = namedChild(model, Class.class, "Class1");
		try {
			translator = new FakeClassTranslator();
		} catch (IncQueryException e) {
			// never happens, see the fake implementation
		}
	};

	@Test
	public void testUpdatingTheSameClassTwiceResultsInOneTask() {
		changes.registerUpdate(class1, translator);
		changes.registerUpdate(class1, translator);
		List<SourceCodeTask> tasks = changes.performTranslation();

		assertEquals(1, tasks.size());
		assertTrue(tasks.get(0) instanceof UpdateSourceCodeTask);
	}

	@Test
	public void testDeletingTheSameClassTwiceResultsInOneTask() {
		String rootName = NamedReference.getIdentifier(class1);
		changes.registerDelete(rootName);
		changes.registerDelete(rootName);
		List<SourceCodeTask> tasks = changes.performTranslation();

		assertEquals(1, tasks.size());
		assertTrue(tasks.get(0) instanceof DeleteSourceCodeTask);
	}

	@Test
	public void testDeleteAfterUpdateResultsInDeleteTask() {
		changes.registerUpdate(class1, translator);
		String rootName = NamedReference.getIdentifier(class1);
		changes.registerDelete(rootName);
		List<SourceCodeTask> tasks = changes.performTranslation();

		assertEquals(1, tasks.size());
		assertTrue(tasks.get(0) instanceof DeleteSourceCodeTask);
	}

	private final class FakeClassTranslator extends RootElementTranslator<Class, ClClass, ClsMatch> {

		private FakeClassTranslator() throws IncQueryException {
			super(null);
		}

		@Override
		protected Template createTemplate(ClClass cls) {
			return null;
		}

		@Override
		protected RootNode<Class, ClClass, ClsMatch> createMapper(AdvancedIncQueryEngine engine) {
			return null;
		}

		@Override
		protected void initMapper(RootNode<?, ?, ?> rootNode, AdvancedIncQueryEngine engine) {
		}

		@Override
		protected ClClass getModel(Class source) throws GenerationException {
			return null;
		}
	}
}
