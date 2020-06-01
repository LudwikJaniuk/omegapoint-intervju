package validitychecker;
import java.util.regex.*;

public class IsCarRegCheck implements ValidityCheck<String> {
	public String checkAndReturnNullOrError(String data) {
		if(data == null)
			return "null is not a car registration";

		if(!Pattern.matches("^[a-zA-Z][a-zA-Z][a-zA-Z]\\d\\d\\d$", data))
			return "string is ill-formed";

		return null;
	}

	public String name() {
		return "IsCarRegistrationSwe";
	}
}
