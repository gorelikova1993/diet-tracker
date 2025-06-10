package com.diettracker;

import java.util.List;
import java.util.Objects;

public class Meal {
	private String type; //завтрак, обед, ужин
	private double calories; //калории
	private String name; // название блюда
	private double fats;
	private double carbs;
	private double protein;
	private Recipe recipe;//рецепт

	public Meal(String type, double calories, String name, Recipe recipe,
				double fats, double carbs, double protein) {
		this.type = Objects.requireNonNull(type, "Вид приема пищи не может быть null");
		this.calories = calories;
		this.name = Objects.requireNonNull(name, "Название блюда не может быть null");
		this.recipe = recipe;
		this.fats = fats;
		this.carbs = carbs;
		this.protein = protein;
	}
	public Meal(String type, double calories, String name, double fats, double carbs, double protein) {
		this.type = Objects.requireNonNull(type, "Вид приема пищи не может быть null");
		this.calories = calories;
		this.name = Objects.requireNonNull(name, "Название блюда не может быть null");
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

	public String getName() {
		return name;
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