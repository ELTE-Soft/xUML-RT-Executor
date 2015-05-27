package hu.eltesoft.modelexecution.m2t.java;

import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.signal.SignalFactory;

public class FakeNamedReference extends NamedReference {

	private static final long serialVersionUID = 1L;

	public FakeNamedReference(String originalName) {
		// the actual reference does not matter, so creates an arbitrary EObject
		super(SignalFactory.eINSTANCE.createSgSignal(), originalName);
	}
}
