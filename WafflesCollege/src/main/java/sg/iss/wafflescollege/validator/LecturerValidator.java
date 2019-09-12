package sg.iss.wafflescollege.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sg.iss.wafflescollege.model.Lecturer;

@Component
public class LecturerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Lecturer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Lecturer u = (Lecturer) target;
		ValidationUtils.rejectIfEmpty(errors, "lecId", "error.user.lecId.empty");
		ValidationUtils.rejectIfEmpty(errors, "lecFirstmidname", "error.user.lecFirstmidname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lecLastname", "error.user.lecLastname.empty");
		System.out.println(u.toString());
	}

}
