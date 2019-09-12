package sg.iss.wafflescollege.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import sg.iss.wafflescollege.model.Enrollment;

@Component
public class EnrollmentValidator implements Validator {

	public EnrollmentValidator() {
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Enrollment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		Enrollment e = (Enrollment) target;
		//ValidationUtils.rejectIfEmpty(errors, "enrDate", "Enrollment Date cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "course.cseId", "Course ID cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "student.stuId", "Student ID cant be empty");
	
		
	    System.out.println(e.toString());
	}

}