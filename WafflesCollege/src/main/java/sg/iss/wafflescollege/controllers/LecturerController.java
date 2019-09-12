package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.services.LecturerService;

@RequestMapping(value = "/lecturer")
@Controller
public class LecturerController {

	@Autowired
	LecturerService lService;

	@RequestMapping(value = "/courses")
	public ModelAndView viewCoursePage() {
		ArrayList<Course> courses = lService.findCourseTaught("L1003");
		ModelAndView mav = new ModelAndView("ViewCoursesTaught", "courses", courses);
		return mav;
	}

	@RequestMapping(value = "/enrollmentsofspecificcourse/{cseId}", method = RequestMethod.GET)
	public ModelAndView viewEnrollmentsPage(@PathVariable String cseId) {
		ModelAndView mav = new ModelAndView("ViewCourseEnrolment");
		ArrayList<Enrollment> enrollments = lService.findSpecificCourseEnrollment(cseId);
		mav.addObject("enrollments", enrollments);
		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}", method = RequestMethod.GET)
	public ModelAndView studentGradePage(@PathVariable String cseId) {
		ModelAndView mav = new ModelAndView("StudentGradePage");
		ArrayList<Studentgrade> studentgrades = lService.findSpecificCourseStudentgrade(cseId);
		mav.addObject("studentgrades", studentgrades);
		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}/grading/{stgId}", method = RequestMethod.GET)
	public ModelAndView gradeStudentPage(@PathVariable String cseId, @PathVariable String stgId) {
		int number = Integer.parseInt(stgId);
		Studentgrade studentgrade = lService.findStudentgradeByStgId(number);
		ModelAndView mav = new ModelAndView("GradeACourse");
		mav.addObject("studentgrade", studentgrade);

		return mav;
	}

	@RequestMapping(value = "/studentgradesofspecificcourse/{cseId}/grading/{stgId}", method = RequestMethod.POST)
	public ModelAndView gradeStudentPage(@PathVariable String cseId, @PathVariable Integer stgId,
			@ModelAttribute Studentgrade studentgrade, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("StudentGradePage");
		lService.updateStudentGrade(studentgrade);
		ArrayList<Studentgrade> studentgrades = lService.findSpecificCourseStudentgrade(cseId);
		//ModelAndView mav = new ModelAndView("GradeACourse", "studentgrades", studentgrades);
		ModelAndView mav = new ModelAndView("redirect:/lecturer/courses");
		return mav;
	}

	@RequestMapping(value = "/studentsofspecificcourse/{cseId}", method = RequestMethod.GET)
	public ModelAndView studentPerformancePage(@PathVariable String cseId) {
		ArrayList<Student> students = lService.findActiveSpecificCourseStudents(cseId);
		ModelAndView mav = new ModelAndView("ViewStudentsPerformance", "students", students);
		Course course = lService.findCourse(cseId);
		mav.addObject("course", course);
		return mav;
	}

	@RequestMapping(value = "/studentsofspecificcourse/{cseId}/viewperformance/{stuId}", method = RequestMethod.GET)
	public ModelAndView viewAStudentPerformancePage(@PathVariable String cseId, @PathVariable String stuId) {
		ArrayList<Studentgrade> sglist = lService.findStudentgradeByStuIdCseId(stuId, cseId);
		Studentgrade studentgrade = sglist.get(0);
		ModelAndView mav = new ModelAndView("ViewAStudentPerformance", "studentgrade", studentgrade);
		return mav;
	}
}