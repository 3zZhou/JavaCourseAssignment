package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.exception.StudentNotFound;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.services.EnrollmentService;
import sg.iss.wafflescollege.services.LecturerService;
import sg.iss.wafflescollege.validator.EnrollmentValidator;

@Controller
@RequestMapping(value = "/admin/manageenrollment")

public class ManageEnrollmentController {

	@Autowired 
	EnrollmentService eService;
	
	
    @Autowired
	private EnrollmentValidator eValidator;
	
	@InitBinder("enrollment")
	private void initDepartmentBinder(WebDataBinder binder) {
	binder.addValidators(eValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("ManageEnrolment");
		ArrayList<Enrollment> enrollments = eService.findAllEnrollments();
		mav.addObject("enrollments", enrollments);
		return mav;	
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewEnrollment() {
		ModelAndView mav = new ModelAndView("EnrollmentFormNew", "enrollment", new Enrollment());
		ArrayList<String> statuslist = eService.findAllStatus();
		ArrayList<String> cidlist = eService.findAllCID();
		ArrayList<String> sidlist = eService.findAllSID();
		mav.addObject("statuslist", statuslist);
		mav.addObject("sidlist", sidlist);
		mav.addObject("cidlist", cidlist);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)

	public ModelAndView createNewEnrollment(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("EnrollmentFormNew");

		ModelAndView mav = new ModelAndView();
		
		
		Studentgrade sg=new Studentgrade();
		sg.setCourse(enrollment.getCourse());
		sg.setStudent(enrollment.getStudent());
		eService.createStudentgrade(sg);
		

		eService.createEnrollment(enrollment);
		mav.setViewName("redirect:/admin/manageenrollment/list");

		return mav;

	}

	@RequestMapping(value = "/edit/{enrollmentId}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable Integer enrollmentId) {
		ModelAndView mav = new ModelAndView("EnrollmentFormEdit");
		mav.addObject("enrollment", eService.findEnrollmentById(enrollmentId));
		ArrayList<String> statuslist = eService.findAllStatus();
		ArrayList<String> cidlist = eService.findAllCID();
		ArrayList<String> sidlist = eService.findAllSID();
		mav.addObject("statuslist", statuslist);
		mav.addObject("sidlist", sidlist);
		mav.addObject("cidlist", cidlist);
		return mav;

	}

	@RequestMapping(value = "/edit/{enrollmentId}", method = RequestMethod.POST)

	public ModelAndView editUser(@ModelAttribute @Valid Enrollment enrollment, BindingResult result,
			@PathVariable Integer enrollmentId, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("EnrollmentFormEdit");

		ModelAndView mav = new ModelAndView("redirect:/admin/manageenrollment/list");
		
					
		
		eService.updateEnrollment(enrollment);

		return mav;
	}

}