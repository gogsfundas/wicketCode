package gwicket;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.PatternValidator;

public class UNameValidator extends CompoundValidator<String> {
	UNameValidator()
	{
		add(PatternValidator.minimumLength(8));
	}
	
}
