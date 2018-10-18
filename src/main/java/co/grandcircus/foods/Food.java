package co.grandcircus.foods;

// A simple class with getters and setters can be referred to as
// - a Java Bean
// - a POJO (plain old Java object)
// - a DTO (data transfer object)
public class Food {
	
	private String name;
	private String category;
	private String description;
	
	public Food() {}
	
	public Food(String name, String category, String description) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", category=" + category + "]";
	}
	
}
