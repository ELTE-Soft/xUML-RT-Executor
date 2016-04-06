
public class TesterImpl implements Tester {
	
	private boolean success = false;
	private boolean fail = false;

	@Override
	public void success() {
		success = true;
	}
	
	@Override
	public void fail() {
		fail = true;
	}
	
	public void check() {
		boolean wasFail = fail;
		boolean wasSuccess = success;
		success = false;
		fail = false;
		if (wasFail) {
			throw new RuntimeException("The method fail was called");
		}
		if (!wasSuccess) {
			throw new RuntimeException("The method success was not called");
		}
	}

}
