package sg.iss.wafflescollege.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.wafflescollege.model.User;


@Component
public class UserValidator implements Validator {

	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		
		ValidationUtils.rejectIfEmpty(errors, "useId", "UserId cant be empty");
		ValidationUtils.rejectIfEmpty(errors, "usePassword", "Password cant be empty");
		
		System.out.println(u.toString());
	}

}
