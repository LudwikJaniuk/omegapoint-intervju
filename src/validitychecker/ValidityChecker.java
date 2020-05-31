package validitychecker;

import java.util.ArrayList;

public class ValidityChecker<T> {
	private ArrayList<ValidityCheck<T>> checks = new ArrayList<ValidityCheck<T>>();
	private ErrorReport errorReport = null;

	public void addCheck(ValidityCheck check) {
		checks.add(check);
	}

	public boolean allPass(T data) {
		for(int i = 0; i < checks.size(); i++) {
			String err = checks.get(i).checkAndReturnNullOrError(data);
			if(err != null) {
				errorReport = new ErrorReport(i, err, checks.get(i));
				return false;
			}
		}
		return true;
	}

	public void logError() {
		if(errorReport == null) {
			System.out.println("No errors found");
			return;
		}

		System.out.format("Check %d (%s) failed.\n", errorReport.index, errorReport.check.name());
		System.out.format("Error: %s\n", errorReport.error);
	}

	public class ErrorReport {
		int index;
		String error;
		ValidityCheck check;
		public ErrorReport(int _index, String _error, ValidityCheck _check) {
			index = _index;
			error = _error;
			check = _check;
		}
	}
}
