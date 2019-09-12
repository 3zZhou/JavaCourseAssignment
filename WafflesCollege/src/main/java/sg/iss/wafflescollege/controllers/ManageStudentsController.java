package sg.iss.wafflescollege.controllers;
import java.util.ArrayList;
import java.util.Collections;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sg.iss.wafflescollege.exception.StudentNotFound;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.services.StudentService;

import sg.iss.wafflescollege.validator.StudentValidator;

@RequestMapping(value = "/admin/managestudents")
@Controller
public class ManageStudentsController {


	@Autowired
	StudentService sService;
	@Autowired
	private StudentValidator sValidator;
	
	@InitBinder("student")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("StudentCRUD");
		ArrayList<Student> student = sService.findAllStudents();
		mav.addObject("students", student);
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		ModelAndView mav = new ModelAndView("StudentFormNew", "student", new Student());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createNewStudent(@ModelAttribute @Valid Student student, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("StudentFormNew");
		ModelAndView mav = new ModelAndView();

		sService.createStudent(student);
		mav.setViewName("redirect:/admin/managestudents/list");
		return mav;
	}

	@RequestMapping(value = "edit/{stuId}", method = RequestMethod.GET)
	public ModelAndView editStudentPage(@PathVariable String stuId) {
		ModelAndView mav = new ModelAndView("StudentFormEdit");
		mav.addObject("student", sService.findStudent(stuId));
		return mav;
		
		}

	@RequestMapping(value = "edit/{stuId}", method = RequestMethod.POST)
	public ModelAndView editStudent(@ModelAttribute @Valid Student student, @PathVariable String stuId,
		BindingResult result, final RedirectAttributes redirectAttributes) throws StudentNotFound {
		System.out.println("student"+student.toString());
		if (result.hasErrors())
			return new ModelAndView("StudentFormEdit");
		sService.updateStudent(student);
		ModelAndView mav = new ModelAndView("redirect:/admin/managestudents/list");
		String message = "Student" + student.getStuId() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "delete/{stuId}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable String stuId, final RedirectAttributes redirectAttributes)
			throws StudentNotFound {
		Student student = sService.findStudent(stuId);
		sService.removeStudent(student);
		ModelAndView mav = new ModelAndView("redirect:/admin/managestudents/list");
		String message = "The student " + student.getStuId() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	

	@ModelAttribute("ActivitySelection")
	public ArrayList<String> CreateActivityTypes() {
		ArrayList<String> ActivitySelection = new ArrayList<>();
		Collections.addAll(ActivitySelection, "Active","Inactive");
		return (ArrayList<String>) ActivitySelection;
	    }


}


