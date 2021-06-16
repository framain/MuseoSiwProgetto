package it.uniroma3.siw.spring.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Collezione;

@Component
public class CollezioneValidator implements Validator {
	

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");

	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Collezione.class.equals(clazz);
	}
}