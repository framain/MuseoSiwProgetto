package it.uniroma3.siw.spring.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Opera;

@Component
public class OperaValidator implements Validator {
	

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annoRealizzazione", "required");
		
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Opera.class.equals(clazz);
	}
}
