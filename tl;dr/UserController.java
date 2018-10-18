package co.grandcircus.foods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping("/register-user")
	public ModelAndView showUserForm() {
		return new ModelAndView("user-form");
	}
	
	@RequestMapping("/submit-user-registration")
	public ModelAndView submitUserForm(
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("password") String password) {
		
		// construct a user from the URL params
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPassword(password);
		
		ModelAndView mav = new ModelAndView("user-confirmation");
		// send the whole user object to the JSP.
		mav.addObject("user", user);
		return mav;
	}
}
