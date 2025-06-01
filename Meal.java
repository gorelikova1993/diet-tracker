import java.util.ArrayList;
import java.util.List;

public class Meal {
	private String type; //завтрак, обед, ужин
	private double calories; //калории
	private List<String> ingredients; //ингредипенты
	private String name; // название блюда
	private String description;// рецепт
	private int fats;
	private int carbs;
	private int protein;

	public Meal(String type, double calories, List<String> ingredients, String name, String description,
				int fats, int carbs, int protein) {
		this.type = type;
		this.calories = calories;
		this.ingredients = ingredients;
		this.name = name;
		this.description = description;
		this.fats = fats;
		this.carbs = carbs;
		this.protein = protein;
	}

	public Meal(String type, double calories, List<String> ingredients, String name, int fats, int carbs, int protein) {
		this.type = type;
		this.calories = calories;
		this.ingredients = ingredients;
		this.name = name;
		this.fats = fats;
		this.carbs = carbs;
		this.protein = protein;
	}

	public Meal(String type, double calories, String name, int fats, int carbs, int protein) {
		this.type = type;
		this.calories = calories;
		this.name = name;
		this.fats = fats;
		this.carbs = carbs;
		this.protein = protein;
	}

	public String getType() {
		return type;
	}

	public double getCalories() {
		return calories;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getFats() {
		return fats;
	}

	public int getCarbs() {
		return carbs;
	}

	public int getProtein() {
		return protein;
	}
}