package gwicket;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class ExistingUserValidation implements IValidator <String> {

	List<String> existingUsernames = Arrays.asList("govind@gmail.com", "g@gmail.com", "gma@g.com");

	public void validate(IValidatable<String> validatable) {
		String chosenUserName = validatable.getValue();

		if(existingUsernames.contains(chosenUserName)){
			ValidationError error = new ValidationError();
			Random random = new Random();

			error.setVariable("suggestedUserName", 
					validatable.getValue() + random.nextInt());
			validatable.error(error);
		}
	}	

}
