package sg.iss.wafflescollege.controllers;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.iss.wafflescollege.services.StudentService;
import sg.iss.wafflescollege.services.CourseService;
import sg.iss.wafflescollege.services.EnrollmentService;
import sg.iss.wafflescollege.exception.StudentNotFound;
import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;

@Controller
@RequestMapping(value = "/student")
public class StudentsController {

	@Autowired
	StudentService sService;

	@Autowired
	CourseService cService;

	@Autowired
	EnrollmentService eService;

	@RequestMapping(value = "/gpa", method = RequestMethod.GET)
	public ModelAndView viewGrades() {
		
		Double cGPA = sService.CalculateCGPA(UserSession.studentId);
		List<String[]> Display = sService.getStudentGrades(UserSession.studentId);
		ModelAndView mav = new ModelAndView("StudentViewGrades");
		mav.addObject("cGPA", cGPA);
		mav.addObject("Display", Display);
		return mav;
	}

	@RequestMapping(value = "/viewenrolled", method = RequestMethod.GET)
	public ModelAndView viewEnrolledCourses() {
		ModelAndView mav = new ModelAndView("StudentViewEnrolledCourses");
		List<String[]> Display = sService.getEnrolledCourses(UserSession.studentId);
		mav.addObject("Display", Display);
		return mav;
	}

	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	public ModelAndView viewAllCourses() {
		ModelAndView mav = new ModelAndView("StudentViewAllCourses");
		List<String[]> Display = sService.getNewCourses(UserSession.studentId);
		mav.addObject("Display", Display);
		return mav;
	}

	@RequestMapping(value = "/enrolnew", method = RequestMethod.GET)
	public ModelAndView viewAllCoursesForEnrol() {
		ModelAndView mav = new ModelAndView("StudentEnrollmentCourse", "enrollment", new Enrollment());
		List<Course> Display = sService.getNewCoursesList(UserSession.studentId);
		mav.addObject("Display", Display);
		return mav;
	}

	@RequestMapping(value = "enrolnewform/{id}", method = RequestMethod.GET)
	public ModelAndView enrolCourse(@PathVariable String id) {

		ModelAndView mav = new ModelAndView("StudentNewEnrollment2");
		Course c = new Course();
		c.setCseId(id);
		mav.addObject("course", c);
		
		return mav;
	}
	

	@RequestMapping(value = "enrolnewform/{id}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Course course, @PathVariable String id,
		BindingResult result, final RedirectAttributes redirectAttributes) throws StudentNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("StudentNewEnrollment2");
		
		sService.createnewEnrollment(id);
		
		ModelAndView mav = new ModelAndView("redirect:/student/enrolnew");
		String message = "Student was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
