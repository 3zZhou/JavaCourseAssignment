package sg.iss.wafflescollege.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.wafflescollege.model.User;
import sg.iss.wafflescollege.services.UserService;
import sg.iss.wafflescollege.validator.UserValidator;

@Controller
@RequestMapping(value = "/MainPage")
public class CommonController {

	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator sValidator;

	@InitBinder("user")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(sValidator);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView MainPage() {
		ModelAndView mav5 = new ModelAndView("MainPage");
		return mav5;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("Login");
		UserSession us = new UserSession();
		ModelAndView mav1 = null;
		if (user.getUseId() != null && user.getUsePassword() != null) {
			User u = uService.authenticate(user.getUseId(), user.getUsePassword());
			if (u != null) {

				us.setUser(u);

				us.setSessionId(session.getId());
				us.setUser(uService.findUserById(us.getUser().getUseId()));
				System.out.println(uService.findUserById(us.getUser().getUseId()));

				String resultL = us.getUser().getUseRole();
				String resultuseId = us.getUser().getUseId();

				System.out.println("RESULT ROLE" + resultL);

				if (resultL.equals("Admin")) {

					mav1 = new ModelAndView("redirect:/admin/managestudents/list");
				}
				if (resultL.equals("Student")) {
					UserSession.studentId = resultuseId;
					mav1 = new ModelAndView("redirect:/student/gpa");
				}
				if (resultL.equals("Lecturer")) {
					
					UserSession.lecturerId = resultuseId;
					mav1 = new ModelAndView("redirect:/lecturer/courses");
				}
				// }

				session.setAttribute("USERSESSION", us);

				return mav1;
			}
		}
		String message = "Check Your user ID and Password";
		redirectAttributes.addFlashAttribute("message", message);
		System.out.println("Your user name is wrong!!!!");
		return new ModelAndView("redirect:/MainPage/Login");
	}
}