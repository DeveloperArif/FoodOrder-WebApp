package co.grandcircus.foods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodsController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping("/food")
	public ModelAndView listFood(@RequestParam(value="category", required=false) String category) {
		ModelAndView mav = new ModelAndView("list-food");
		if (category != null && !category.isEmpty()) {
			mav.addObject("foods", foodService.getFoodsInCategory(category));
			mav.addObject("category", category);
		} else {
			mav.addObject("foods", foodService.getAllFoods());
		}
		return mav;
	}
	
	@RequestMapping("/add-food")
	public ModelAndView showFoodForm() {
		return new ModelAndView("food-form");
	}
	
	// Two controllers handling the same URL path, but this one handles the POST
	// which is triggered when the form submits.
	@RequestMapping(value="/add-food", method=RequestMethod.POST)
	// When a POJO (Java Bean) is provided as a parameter, Spring MVC automatically
	// fills in all the properties from the request params!
	public ModelAndView submitFoodForm(Food food) {
		foodService.addFood(food);
		// using a view name that starts with "redirect:" skips the JSP and instead
		// redirects the browser to the given URL, effectively redirecting to another
		// controller.
		return new ModelAndView("redirect:/food");
	}
}
