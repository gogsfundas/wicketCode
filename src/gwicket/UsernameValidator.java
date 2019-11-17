package gwicket;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.Validatable;
import org.apache.wicket.validation.ValidationError;
import org.omg.DynamicAny.DynAnyPackage.InvalidValueHelper;

public class UsernameValidator implements IValidator<String>   {

	@Override
	public void validate(IValidatable<String> validatable) {
	System.out.println(" inside validator " +validatable.getValue());
	ValidationError error = new ValidationError();
	error.setMessage(" this is error ");
	validatable.error(error);
	}

}
