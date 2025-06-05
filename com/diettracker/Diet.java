package com.diettracker;

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
		long sameTypeCount = meals.stream()
				.filter(m -> m.getType().equalsIgnoreCase(meal.getType()))
				.count();
		
		boolean canAdd = switch (meal.getType().toLowerCase()) {
			case "завтрак", "обед", "ужин" -> sameTypeCount < 1;
			case "перекус" -> sameTypeCount < 2;
			default -> false;
		};
		if(!canAdd) {
			System.out.println("Превышен лимит приемов пищи для типа: " + meal.getType());
			return;
		}
		meals.add(meal);
	}

	public List<Meal> getMeals() {
		return meals;
	}
	
	public NutritionFacts getTotalNutrition() {
		NutritionFacts total = new NutritionFacts("Total", 0, 0, 0, 0);
		for (Meal meal : meals) {
			total = addNutrition(total, meal.toNutritionFacts());
		}
		return total;
	}
	
	private NutritionFacts addNutrition(NutritionFacts a, NutritionFacts b) {
		return new NutritionFacts("Total",
				a.getCalories() + b.getCalories(),
				a.getProtein() + b.getProtein(),
				a.getFats() + b.getFats(),
				a.getCarbs() + b.getCarbs());
	}
	
	public void printMeals() {
		for (Meal m : meals) {
			System.out.println(m);
		}
	}
	
	public void printSummary() {
		for (Meal meal : meals) {
			System.out.println(meal.toString());
		}
		System.out.println("Суммарное КБЖУ: ");
		NutritionFacts total = getTotalNutrition();
		System.out.println(total);
	}

}