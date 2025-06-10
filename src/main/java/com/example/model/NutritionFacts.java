package com.example.model;

import java.util.Objects;

public class NutritionFacts {
	private String ingredientName; //apple
	private double calories; //на 100 грамм
	private double protein; //на 100 грамм
	private double fats; //на 100 грамм 
	private double carbs;// на 100 грамм

	public NutritionFacts(String name, double calories, double protein, double fats, double carbs) {
		this.ingredientName = Objects.requireNonNull(name, "Имя набора нутриентов не может быть null");
		this.calories = calories;
		this.protein = protein;
		this.fats = fats;
		this.carbs = carbs;
	}

	public String getName() {
		return ingredientName;
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
	
	@Override
	public String toString() {
		return ingredientName + ": " + calories + " ккал, Б: " + protein + "г, Ж: " + fats + "гб у: " + carbs + "г";
	}

	public double getCaloriesForGrams(int grams) {
		return (getCalories() * grams) / 100.0;
	}
	
	public void add(NutritionFacts other) {
		this.calories += other.getCalories();
		this.protein += other.getProtein();
		this.fats += other.getFats();
		this.carbs += other.getCarbs();
	}

}