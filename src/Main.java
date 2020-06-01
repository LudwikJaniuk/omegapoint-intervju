import validitychecker.*;

class Main {
	public static void main(String[] args) {
		ValidityChecker<String> checker = new ValidityChecker<String>();
		checker.addCheck(new NotNullCheck());
		checker.addCheck(new NotEmptyCheck());

		System.out.format("Output of run on null: %b\n", checker.allPass(null));
		System.out.format("Output of run on test string: %b\n", checker.allPass("test"));
		System.out.format("Output of run on empty string: %b\n", checker.allPass(""));

		System.out.print("Car check\n");
		checker = new ValidityChecker<String>();
		checker.addCheck(new IsCarRegCheck());
		System.out.format("Output of run on test string: %b\n", checker.allPass("test"));
		System.out.format("Output of run on empty string: %b\n", checker.allPass(""));
		System.out.format("Output of run on valid carreg: %b\n", checker.allPass("SLA120"));
		System.out.format("Output of run on invalid carreg: %b\n", checker.allPass("SALSAL"));
		System.out.format("Output of run on too long string: %b\n", checker.allPass("SLA120oijfpweijf9w8ef"));

		System.out.print("Pnr check\n");
		checker = new ValidityChecker<String>();
		checker.addCheck(new IsPnrCheck());
		System.out.format("Output of run on test string: %b\n", checker.allPass("test"));
		System.out.format("Output of run on empty string: %b\n", checker.allPass(""));
		System.out.format("Output of run on valid pnr: %b\n", checker.allPass("19961218-2494"));
		System.out.format("Output of run on invalid pnr: %b\n", checker.allPass("19961218-2495"));
		System.out.format("Output of run on malformed pnr: %b\n", checker.allPass("199612182495"));


	}
}
