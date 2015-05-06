package hu.eltesoft.modelexecution.m2t.smap.xtend;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.smap.SmapStratum;

/**
 * Represents source mapping information for a class. It could contain multiple
 * strata. The return value of toString contains appropriate header and footer.
 */
@SuppressWarnings("restriction")
public class Smap {

	private List<SmapStratum> strata = new ArrayList<>();

	public void addStratum(SmapStratum stratum) {
		strata.add(stratum);
	}

	/**
	 * Returns the string representation assuming an empty output file name.
	 */
	@Override
	public String toString() {
		return toString("");
	}

	public String toString(String outputFileName) {
		if (strata.isEmpty()) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("SMAP\n");
		builder.append(outputFileName);
		builder.append("\n");
		builder.append(strata.get(0).getStratumName());
		builder.append("\n");
		for (SmapStratum stratum : strata) {
			String text = stratum.toString();
			if (null != text) {
				builder.append(text);
			}
		}
		builder.append("*E\n");
		return builder.toString();
	}
}
