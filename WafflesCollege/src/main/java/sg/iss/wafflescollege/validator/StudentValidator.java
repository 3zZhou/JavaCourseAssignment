package sg.iss.wafflescollege.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.User;

@Component
public class StudentValidator implements org.springframework.validation.Validator {

	public StudentValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student s = (Student) target;
		ValidationUtils.rejectIfEmpty(errors, "stuId", "Student Id cant be empty");
		ValidationUtils.rejectIfEmpty(errors, "stuFirstmidname", "Student First Mid Name cant be empty");
		ValidationUtils.rejectIfEmpty(errors, "stuLastname", "Student Last Name cant be empty");
		
		
	    System.out.println(s.toString());

	}

}
