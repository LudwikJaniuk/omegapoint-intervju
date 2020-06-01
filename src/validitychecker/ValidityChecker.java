package validitychecker;

import java.util.ArrayList;

public class ValidityChecker<T> {
	private ArrayList<ValidityCheck<T>> checks = new ArrayList<ValidityCheck<T>>();

	public void addCheck(ValidityCheck check) {
		checks.add(check);
	}

	public boolean allPass(T data) {
		for(int i = 0; i < checks.size(); i++) {
			ValidityCheck<T> check = checks.get(i);
			String err = check.checkAndReturnNullOrError(data);
			if(err != null) {
				System.out.format("Check %d/%d failed (%s): %s\n", i+1, checks.size(), check.name(), err);
				return false;
			}
		}
		return true;
	}
}
