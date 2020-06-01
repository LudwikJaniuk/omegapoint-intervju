package validitychecker;
import java.util.*;

public class NotEmptyCheck implements ValidityCheck<String> {
	public String checkAndReturnNullOrError(String data) {
		if (new String("").equals(data)) return "input is empty.";
		return null;
	}

	public String name() {
		return "NotEmpty";
	}
}
