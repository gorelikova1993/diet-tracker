import java.util.ArrayList;
import java.util.List;

public class Diet {
	private String name;
	private List<Meal> meals;

	public Diet(String name) {
		this.name = name;
		this.meals = new ArrayList<>();
	}

	public void addMeal(Meal meal) {
		this.meals.add(meal);
	}

	public List<Meal> getMeals() {
		return meals;
	}

}