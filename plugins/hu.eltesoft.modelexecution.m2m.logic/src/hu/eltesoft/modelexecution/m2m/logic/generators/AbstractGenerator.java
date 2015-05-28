package hu.eltesoft.modelexecution.m2m.logic.generators;

import hu.eltesoft.modelexecution.m2m.logic.TextChangesListener;
import hu.eltesoft.modelexecution.m2m.metamodel.base.ModelRoot;
import hu.eltesoft.modelexecution.m2t.java.DebugSymbols;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.smap.xtend.SourceMappedText;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractGenerator<S extends EObject, R extends ModelRoot, T extends Template>
		implements Generator<S, R> {

	protected final TextChangesListener textChangesListener;

	public AbstractGenerator(TextChangesListener listener) {
		this.textChangesListener = listener;
	}

	@Override
	public void generateText(R root) {
		T template = createTemplate(root);

		SourceMappedText output = (SourceMappedText) template.generate();
		DebugSymbols symbols = template.getDebugSymbols();

		String fileName = root.getReference().getIdentifier();
		textChangesListener.contentChanged(fileName, output, symbols);
	}

	protected abstract T createTemplate(R root);

	protected void check(boolean success) throws GenerationException {
		if (!success) {
			throw new GenerationException();
		}
	}
}
