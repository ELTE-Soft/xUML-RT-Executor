package hu.eltesoft.modelexecution.cli.exceptions;

import hu.eltesoft.modelexecution.cli.Messages;

public class ModelLoadFailedException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	String modelPath;

	public ModelLoadFailedException(String modelPath) {
		this.modelPath = modelPath;
	}

	@Override
	public String toString() {
		return Messages.MODEL_LOAD_FAILED.getMsg(modelPath);
	}

	@Override
	public String getLocalizedMessage() {
		return toString();
	}
}
