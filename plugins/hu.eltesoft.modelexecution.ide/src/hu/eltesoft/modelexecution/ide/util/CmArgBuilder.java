package hu.eltesoft.modelexecution.ide.util;

public class CmArgBuilder {

	private static final String SPACE = " "; //$NON-NLS-1$
	private StringBuilder sb = new StringBuilder();

	public void append(String arg) {
		sb.append(SPACE + arg);
	}

	@Override
	public String toString() {
		return sb.toString();
	}

}
