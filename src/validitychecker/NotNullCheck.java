package validitychecker;
import java.util.*;

public class NotNullCheck implements ValidityCheck<Object> {
	public String checkAndReturnNullOrError(Object data) {
		if (data == null) return "input is null.";
		return null;
	}

	public String name() {
		return "NotNull";
	}
}
