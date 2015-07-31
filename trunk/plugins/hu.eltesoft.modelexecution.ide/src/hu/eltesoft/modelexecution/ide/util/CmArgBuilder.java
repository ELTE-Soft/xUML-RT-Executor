package hu.eltesoft.modelexecution.ide.util;

public class CmArgBuilder {

	private static final String SPACE = " "; //$NON-NLS-1$
	private StringBuilder sb = new StringBuilder();

	protected void appendObject(Object obj) {
		sb.append(SPACE + obj);
	}
	
	public void append(String arg) {
		appendObject(arg);
	}
	
	public void append(int arg) {
		appendObject(arg);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
