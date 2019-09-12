package sg.iss.wafflescollege.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.exception.CourseNotFound;
import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.services.CourseService;

import sg.iss.wafflescollege.validator.CourseValidator;

@RequestMapping(value = "/admin/managecourses")
@Controller
public class ManageCoursesController {

	@Autowired
	private CourseService cService;
	
	@Autowired
	private CourseValidator cValidator;

	@InitBinder("course")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(cValidator);
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView createCoursePage() {
		ModelAndView mav = new ModelAndView("AddCourses", "course", new Course());
		mav.addObject("cidlist", cService.findAllCourses());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("AddCourses");

		ModelAndView mav = new ModelAndView();
		String message = "Your new course: " + course.getCseId() + " was successfully created.";
		cService.createCourse(course);
		mav.setViewName("redirect:/admin/managecourses/list"); //change this later!
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView courseListPage() {
		ModelAndView mav = new ModelAndView("LoadCourses", "course", new Course());
		List<Course> CourseList = cService.findAllCourses();
		mav.addObject("CourseList", CourseList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("EditCourse");
		mav.addObject("course", cService.findCourseById(id));
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Course course, @PathVariable String id,
			BindingResult result, final RedirectAttributes redirectAttributes) throws CourseNotFound {
		System.out.println("Course"+course.toString());
		if (result.hasErrors())
			return new ModelAndView("EditCourse");
		cService.updateCourse(course);
		ModelAndView mav = new ModelAndView("redirect:/admin/managecourses/list");
		String message = "Course" + course.getCseId() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
		
	}

	@RequestMapping(value = "/delete/{cseId}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable String cseId, final RedirectAttributes redirectAttributes)
			throws CourseNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/managecourses/list");
		Course course = cService.findCourseById(cseId);
		cService.removeCourse(course);
		String message = "Course " + course.getCseId() + " was successfully deleted.";

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
