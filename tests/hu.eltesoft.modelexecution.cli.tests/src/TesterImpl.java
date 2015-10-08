public class TesterImpl implements Tester {

	private static boolean hookAdded = false;

	private boolean success = false;
	private boolean fail = false;

	public TesterImpl() {
		if (!hookAdded) {
			hookAdded = true;
			Runtime.getRuntime().addShutdownHook(new Thread(() -> check()));
		}
	}

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
		if (!wasFail && wasSuccess) {
			System.out.println("success");
		} else {
			System.out.println("failure");
		}
	}
}
