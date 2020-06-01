import validitychecker.*;

class Main {
	public static void main(String[] args) {
		ValidityChecker<Object> checker = new ValidityChecker<Object>();
		checker.addCheck(new NotNullCheck());

		System.out.format("Output of run on null: %b\n", checker.allPass(null));
		System.out.format("Output of run on new object: %b\n", checker.allPass(new Object()));
	}
}
