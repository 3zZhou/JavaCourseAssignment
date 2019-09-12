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

import sg.iss.wafflescollege.exception.LecturerNotFound;
import sg.iss.wafflescollege.exception.StudentNotFound;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.services.LecturerService;
import sg.iss.wafflescollege.services.StudentService;
import sg.iss.wafflescollege.validator.LecturerValidator;
import sg.iss.wafflescollege.validator.StudentValidator;

@RequestMapping(value = "/admin/managelecturers")
@Controller
public class ManageLecturersController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@Autowired
	private LecturerValidator lecturerValidator;
	
	@InitBinder("lecturer")
	private void initManageStudentBinder(WebDataBinder binder) {
		
		binder.addValidators(lecturerValidator);
	}

	//Show Lecturers List
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView listAllLecturers() {
		ModelAndView mav = new ModelAndView("ManageLecturers");
		ArrayList<Lecturer> lecturer = lecturerService.findAllLecturers();
		mav.addObject("lecturers", lecturer);
		return mav;
	}
	
	//Error Page Show
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView ErrorPageLecturers() {
		ModelAndView mav = new ModelAndView("DeleteErrorLecturer");
		return mav;
	}
	
	//Success Page Show
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView SuccessPageLecturers() {
		ModelAndView mav = new ModelAndView("DeleteSuccessLecturer");
		return mav;
	}
	
	//Add New Lecturers
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	
	public ModelAndView newLecturerPage() {
		
		ModelAndView mav = new ModelAndView("LecturerFormNew","lecturer",new Lecturer());
		
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewLecturer(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("LecturerFormNew");
			ModelAndView mav = new ModelAndView();

			lecturerService.createLecturer(lecturer);
			String message = "New lecturer " + lecturer.getLecFirstmidname() + lecturer.getLecLastname() +" was successfully created.";
			mav.setViewName("redirect:/admin/managelecturers/load");
			return mav;
		}
	
	
	//Edit Lecturer 
	@RequestMapping(value = "/edit/{lecId}", method = RequestMethod.GET)
	public ModelAndView editLecturerPage(@PathVariable String lecId) {
		ModelAndView mav = new ModelAndView("LecturerFormEdit");

		mav.addObject("lecturer", lecturerService.findLecturer(lecId));

		return mav;
	}

	@RequestMapping(value = "/edit/{lecId}", method = RequestMethod.POST)
	public ModelAndView editLecturer(@ModelAttribute @Valid Lecturer lecturer, @PathVariable String lecId,
			BindingResult result, final RedirectAttributes redirectAttributes) throws LecturerNotFound {
		
		if (result.hasErrors())

			return new ModelAndView("LecturerFormEdit");

		lecturerService.updateLecturer(lecturer);

		ModelAndView mav = new ModelAndView("redirect:/admin/managelecturers/load");
		
		String message = "Lecturer" + lecturer.getLecId() + " was successfully updated.";
		
		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
		
	}
	
	//Delete Lecturer
	@RequestMapping(value = "/delete/{lecId}", method = RequestMethod.GET)
	public ModelAndView deleteLecturer(@PathVariable String lecId, final RedirectAttributes redirectAttributes)
			throws LecturerNotFound {
		
		Lecturer lecturer = lecturerService.findLecturer(lecId);

		lecturerService.removeLecturer(lecturer);
		System.out.println("CANNOT DELETE" + lecturer.getLecFirstmidname() + lecturer.getLecLastname());
		
		
		if(lecturerService.removeLecturer(lecturer) > 0) {
			ModelAndView mav = new ModelAndView("redirect:/admin/managelecturers/error");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("redirect:/admin/managelecturers/success");
			String message = "The lecturer " + lecturer.getLecId() + " was successfully deleted.";

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
	
	}	 
}