public class NutritionFacts {
	private String name; //apple
	private double calories; //на 100 грамм
	private double protein; //на 100 грамм
	private double fats; //на 100 грамм 
	private double carbs;// на 100 грамм

	public NutritionFacts(String name, double calories, double protein, double fats, double carbs) {
		this.name = name;
		this.calories = calories;
		this.protein = protein;
		this.fats = fats;
		this.carbs = carbs;
	}

	public String getName() {
		return name;
	}

	public double getCalories() {
		return calories;
	}

	public double getProtein() {
		return protein;
	}

	public double getFats() {
		return fats;
	}

	public double getCarbs() {
		return carbs;
	}

	public void print() {
		System.out.println("Название: " + getName() + "\n" +
							"Калории: " + getCalories() + " ккал \n" + 
							"Белки " + getProtein() + " г\n" +
							"Жиры: " + getFats() + "г\n" +
							"Углеводы: " + getCarbs()  + "г");
	}

	public double getCaloriesForGrams(int grams) {
		return (getCalories() * grams) / 100.0;
	}

}