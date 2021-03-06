package hu.eltesoft.modelexecution.m2t.smap.xtend;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.smap.SmapStratum;

/**
 * Holds text with its source mapping information. When an Xtend template class
 * is annotated as {@link SourceMappedTemplate}, the template methods will
 * return an instance of this class instead of a CharSequence.
 * 
 * String representation of an instance is simply the stored text. Source map
 * stratum, and the internal line mapping can also be accessed with a getter.
 */
@SuppressWarnings("restriction")
public class SourceMappedText implements CharSequence {

	private final String stratumName;
	private final List<LineMapping> mapping;
	private final CharSequence text;

	private Smap cachedSmap;

	SourceMappedText(String stratumName, List<LineMapping> mapping, CharSequence text) {
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
	public Smap getSmap() {
		if (null == cachedSmap) {
			cachedSmap = createSmap();
		}
		return cachedSmap;
	}

	private Smap createSmap() {
		SmapStratum stratum = new SmapStratum(stratumName);
		addLinesToSmap(stratum);
		stratum.optimizeLineSection();
		Smap smap = new Smap();
		smap.addStratum(stratum);
		return smap;
	}

	private void addLinesToSmap(SmapStratum stratum) {
		for (LineMapping m : mapping) {
			Location l = m.getInputLocation();
			int inputLineCount = l.getEndLine() - l.getStartLine() + 1;
			String filePath = l.getFilePath();
			if (filePath != null && !filePath.equals("")) {
				URI uri = URI.createURI(filePath);
				String fileName = uri.lastSegment();
				stratum.addFile(fileName, filePath);
				stratum.addLineData(l.getStartLine(), fileName, inputLineCount, m.getOutputStartLine(),
						m.getOutputLineIncrement());
			}
		}
	}

	@Override
	public char charAt(int index) {
		return text.toString().charAt(index);
	}

	@Override
	public int length() {
		return text.toString().length();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return text.toString().subSequence(start, end);
	}

	@Override
	public String toString() {
		return text.toString();
	}
}
