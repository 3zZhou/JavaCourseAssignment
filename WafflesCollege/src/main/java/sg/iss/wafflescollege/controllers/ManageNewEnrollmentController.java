package sg.iss.wafflescollege.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

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

import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.services.EnrollmentService;
import sg.iss.wafflescollege.services.LecturerService;
import sg.iss.wafflescollege.validator.StudentValidator;


@RequestMapping(value = "/admin/managenewenrollment")
@Controller
public class ManageNewEnrollmentController {
	
	@Autowired
	private EnrollmentService eService;
	


	@RequestMapping(value = "/new", method=RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Enrollment> enrollment = eService.findAllNewEnrollments();
		ModelAndView mav = new ModelAndView("ManageNewEnrollment");
		mav.addObject("enrollment", enrollment);
		return mav;
		}
	@RequestMapping(value = "/new/display/{id}", method = RequestMethod.GET)
	public ModelAndView newDisplayPage(@PathVariable int id) {
		Enrollment enrollment = eService.findEnrollmentById(id);
		ModelAndView mav = new ModelAndView("ManageNewEnrollment2", "enrollment", enrollment);
		mav.addObject("approve", new sg.iss.wafflescollege.javabeans.Approve());
		return mav;
	}
	@RequestMapping(value = "/new/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectCourse(@ModelAttribute("approve") sg.iss.wafflescollege.javabeans.Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("ManageNewEnrollment2");
		Enrollment c = eService.findEnrollmentById(id);
		if (approve.getDecision().equalsIgnoreCase(Enrollment.APPROVED)) {
			c.setEnrStatus(Enrollment.APPROVED);
		
		} else {
			c.setEnrStatus(Enrollment.REJECTED);
		}
			System.out.println(c.toString());
			eService.updateEnrollment(c);
		ModelAndView mav = new ModelAndView("redirect:/admin/managenewenrollment/new");
		String message = "Enrollment was successfully added.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}