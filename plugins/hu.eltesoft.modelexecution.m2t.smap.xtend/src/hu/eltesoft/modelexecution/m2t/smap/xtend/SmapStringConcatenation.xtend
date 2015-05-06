package hu.eltesoft.modelexecution.m2t.smap.xtend

import java.lang.reflect.Field
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * Maps an input source location to output lines.
 * 
 * Excerpt from JSR-045:
 * 
 * A range of output source lines is mapped to a single input source line.
 * 
 * For each n between zero and (InputLineCount - 1)
 * the input source line number (InputStartLine + n)
 * maps to the output source line numbers from (OutputStartLine + (n * OutputLineIncrement))
 * through (OutputStartLine + ((n + 1) * OutputLineIncrement) - 1),
 * where InputLineCount is (inputLocation.endLine - inputLocation.startLine + 1) below.
 */
@Data
class LineMapping {
	Location inputLocation
	int outputStartLine
	int outputLineIncrement
}

/**
 * A source mapping capable extension of StringConcatenation,
 * which is used by Xtend to build text in generated template code.
 * 
 * Overloading of the append method enables it to track source information
 * attached to the actually substituted template variable.
 * 
 * Template substitution results in a {@link SourceMappedText} instance.
 */
class SmapStringConcatenation extends StringConcatenation {

	private val String stratumName
	private val List<LineMapping> mapping

	new(String stratumName) {
		this.stratumName = stratumName
		mapping = new ArrayList
	}

	/**
     * Usually invoked from generated template code by using a
     * trace method in a template body. Assigns the given input
     * location to the current output line, and appends the text
     * represented by the given data.
     */
	def dispatch append(DataWithLocation<?> dataWithLocation, String indentation) {

		// assume that parameters are substituted to continuous line ranges in the template
		val outputLineIncrement = 1

		mapping.add(new LineMapping(dataWithLocation.location, lineNumber, outputLineIncrement))
		append(dataWithLocation.toString, indentation)
	}

	/**
     * Implements nested template support, as substitution of inner
     * templates will also result in a SourceMappedText instance.
     * Requires dynamic dispatch in some cases, see append for objects.
     */
	def dispatch append(SourceMappedText sourceMappedText, String indentation) {
		sourceMappedText.mapping.forEach [ m |
			mapping.add(new LineMapping(m.inputLocation, lineNumber + m.outputStartLine - 1, m.outputLineIncrement))
		]
		append(sourceMappedText.text, indentation)
	}

	/**
     * General case of dynamic dispatch. Delegates call to inherited implementation.
     */
	def dispatch append(Object object, String indentation) {
		super.append(object, indentation)
	}

	/**
     * Invocations with SourceMappedText could happen from generated code, but
     * the static type is CharSequence there, so dynamic dispatch must be done.
     */
	def toSourceMappedText() {
		return new SourceMappedText(stratumName, mapping, toString())
	}

	/**
     * Returns the current line number in the output text by examining
     * inherited internal structure. As the segments field is private,
     * we use reflection here to access its contents.
     */
	private def getLineNumber() {
		val Field field = StringConcatenation.getDeclaredField("segments")
		field.accessible = true
		val segments = field.get(this) as ArrayList<String>

		// as segments also contains single line delimiters,
		// only the ordinary lines should be counted
		segments.filter[e|e == lineDelimiter].length + 1
	}
}
