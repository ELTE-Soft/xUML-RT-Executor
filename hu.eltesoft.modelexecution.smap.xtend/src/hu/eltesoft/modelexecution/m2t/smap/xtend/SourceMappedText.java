package hu.eltesoft.modelexecution.m2t.smap.xtend;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.smap.SmapStratum;

/**
 * Holds text with its source mapping information. When an Xtend template class
 * is annotated as @SourceMappedTemplate, the template methods will return an
 * instance of this class instead of a CharSequence.
 * 
 * String representation of an instance is simply the stored text. Source map
 * stratum, and the internal line mapping can also be accessed with a getter.
 */
@SuppressWarnings("restriction")
public class SourceMappedText {

	private final String stratumName;
	private final List<LineMapping> mapping;
	private final CharSequence text;

	private SmapStratum cachedSmap;

	SourceMappedText(String stratumName, List<LineMapping> mapping,
			CharSequence text) {
		this.stratumName = stratumName;
		this.mapping = mapping;
		this.text = text;
	}

	public String getStratumName() {
		return stratumName;
	}

	public List<LineMapping> getMapping() {
		return Collections.unmodifiableList(mapping);
	}

	public CharSequence getText() {
		return text;
	}

	/**
	 * Caches an internal instance of an SmapStratum and always returns that
	 * reference after the first invocation. Lazy creation of the stratum is
	 * beneficial as it will never happen for nested template invocations.
	 */
	public SmapStratum getSmap() {
		if (null == cachedSmap) {
			cachedSmap = createSmap();
		}
		return cachedSmap;
	}

	private SmapStratum createSmap() {
		SmapStratum smap = new SmapStratum(stratumName);
		addLinesToSmap(smap);
		smap.optimizeLineSection();
		return smap;
	}

	private void addLinesToSmap(SmapStratum smap) {
		for (LineMapping m : mapping) {
			Location l = m.getInputLocation();
			int inputLineCount = l.getEndLine() - l.getStartLine() + 1;
			String filePath = l.getFilePath();
			String fileName = Paths.get(filePath).getFileName().toString();
			smap.addFile(fileName, filePath);
			smap.addLineData(l.getStartLine(), fileName, inputLineCount,
					m.getOutputStartLine(), m.getOutputLineIncrement());
		}
	}

	@Override
	public String toString() {
		return text.toString();
	}
}
