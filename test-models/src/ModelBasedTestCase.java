
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.runtime.BaseRuntime;
import junit.framework.TestCase;

public class ModelBasedTestCase extends TestCase {

	private String clsId;
	private String opId;

	public ModelBasedTestCase(String name, Class cls, Operation op) {
		clsId = NamedReference.getIdentifier(cls);
		opId = NamedReference.getIdentifier(op);
		setName(name + " (" + clsId + ")");
	}

	@Override
	protected void runTest() throws Throwable {
		withTimeout(() -> {
			BaseRuntime runtime = BaseRuntime.getInstance();
			runtime.run(clsId, opId);
			TesterImpl checker = runtime.getExternalEntity(Tester.class);
			checker.check();
			return true;
		});
	}

	private void withTimeout(Callable<Boolean> task) throws Exception {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Boolean> future = executor.submit(task);
		System.out.println(future.get(3, TimeUnit.SECONDS));
	}

}
