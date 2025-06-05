package com.diettracker;

import java.util.List;

public class Meal {
	private String type; //завтрак, обед, ужин
	private double calories; //калории
	private List<String> ingredients; //ингредиенты
	private String name; // название блюда
	private String description;// рецепт
	private double fats;
	private double carbs;
	private double protein;

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

	public double getFats() {
		return fats;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getProtein() {
		return protein;
	}
	
	@Override
	public String toString() {
		return name + " (" + type + "): " + calories + " ккал, Б: " + protein + ", Ж: " + fats + ", У: " + carbs;
	}
	
	public NutritionFacts toNutritionFacts() {
		return new NutritionFacts(name, calories, protein, fats, carbs);
	}
}