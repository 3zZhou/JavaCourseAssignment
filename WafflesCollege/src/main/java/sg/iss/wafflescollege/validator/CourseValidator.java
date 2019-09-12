package sg.iss.wafflescollege.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.wafflescollege.model.Course;

@Component
public class CourseValidator implements Validator {
	
	public CourseValidator() {
	
	}
	
	public boolean supports(Class<?> arg0) {
		return true;

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Course course = (Course) arg0;	
	/*
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseId", "error.course.cseId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "lecturer.lecId", "error.course.lecturer.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseDesc",  "error.course.cseDesc.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseMaxSize",  "error.course.cseMaxSize.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseCredit",  "errors.course.cseCredit.empty");*/
		//ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseStartdate",  "error.course.cseStartdate.empty");
		//ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "cseStatus",  "error.course.cseStatus.empty");
	}


}
