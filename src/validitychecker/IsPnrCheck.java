package validitychecker;
import java.util.*;
import java.util.regex.*;

public class IsPnrCheck implements ValidityCheck<String> {
	public String checkAndReturnNullOrError(String data) {
		if(data == null)
			return "null is not a personnummer";

		if(!Pattern.matches("^\\d\\d\\d\\d\\d\\d\\d\\d-\\d\\d\\d\\d$", data))
			return "personnummer string is ill-formed";

		// Not validating first two numbers - future/hisotry proof ;)

		int[] numbers = new int[12]; // todo how to declare


		// Parse the numbers
		for(int i = 0; i <= 7; i++) {
			numbers[i] = Character.getNumericValue(data.charAt(i));
		}
		for(int i = 8; i <= 11; i++) {
			numbers[i] = Character.getNumericValue(data.charAt(i+1));
		}

		numbers[2] *= 2;
		numbers[3] *= 1;
		numbers[4] *= 2;
		numbers[5] *= 1;
		numbers[6] *= 2;
		numbers[7] *= 1;
		numbers[8] *= 2;
		numbers[9] *= 1;
		numbers[10] *= 2;

		// All acc to wikipedia - "Luhn algo"
		for(int i = 2; i <= 10; i++) {
			numbers[i] = numbers[i]%10 + numbers[i]/10;
		}

		numbers[10] = numbers[10]%10 + numbers[10]/10;

		int total = 0;
		for(int i = 2; i <= 10; i++) {
			total += numbers[i];
		}

		int check = 10 - (total % 10);  // Last mod 10 is a noop

		if(check != numbers[11])
			return "Control number is incorrect";

		return null;
	}

	public String name() {
		return "IsPersonnummer";
	}
}
