package hu.eltesoft.modelexecution.uml.alf;

public class UnsupportedAlfFeatureException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public UnsupportedAlfFeatureException(String element) {
		super(element);
	}
}
