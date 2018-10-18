package co.grandcircus.foods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

// The @Component annotation makes this is a singleton Spring Bean,
// created and managed by Spring. (Alternatively, could use @Service)
@Component
public class FoodService {
	
	private List<Food> list = new ArrayList<>();
	
	public FoodService() {
		list.add(new Food("Apples", "Fruit", "Sweet and crunchy."));
		list.add(new Food("Carrots", "Vegetable", "Orange root vegtable."));
		list.add(new Food("Peas", "Vegetable", "Small, round, and green."));
		list.add(new Food("Cake", "Prepared", "Fluffy baked good with icing."));
		list.add(new Food("Lemon", "Fruit", "Sour citrus."));
		list.add(new Food("Sandwich", "Prepared", "Versatile staple."));
		list.add(new Food("Blueberry", "Fruit", "Small, round, and blue."));
	}
	
	/**
	 * Get list of all foods.
	 */
	public List<Food> getAllFoods() {
		return list;
	}
	
	/**
	 * Get list of foods in a given category.
	 */
	public List<Food> getFoodsInCategory(String category) {
		List<Food> matches = new ArrayList<>();
		for(Food food : list) {
			if (food.getCategory().equalsIgnoreCase(category)) {
				matches.add(food);
			}
		}
		return matches;
	}
	
	/**
	 * Get list of food with name matching a keyword.
	 */
	public List<Food> getFoodsByKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		List<Food> matches = new ArrayList<>();
		for(Food food : list) {
			if (food.getName().toLowerCase().contains(keyword)) {
				matches.add(food);
			}
		}
		return matches;
	}
	
	/**
	 * Get set of food categories.
	 */
	public Set<String> getCategories() {
		Set<String> categories = new TreeSet<>();
		for(Food food : list) {
			categories.add(food.getCategory());
		}
		return categories;
	}

	/**
	 * Add a food to the list
	 */
	public void addFood(Food food) {
		list.add(food);
	}
}
