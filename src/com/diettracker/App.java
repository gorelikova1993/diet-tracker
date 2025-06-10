package com.diettracker;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		Meal meal = readMealFromUser(scanner);
//		diet1.addMeal(meal);
//		diet1.printSummary();
		
		// Создаём рацион на день
		DayPlan mondayPlan = new DayPlan();
		
		// Добавим несколько блюд
		Meal breakfast = new Meal("Завтрак", 350, "Овсянка с бананом", 8, 12, 60);
		Meal lunch = new Meal("Обед", 600, "Курица с рисом", 35, 20, 50);
		Meal dinner = new Meal("Ужин", 480, "Творог с ягодами", 28, 15, 25);
		
		mondayPlan.addMeal(breakfast);
		mondayPlan.addMeal(lunch);
		mondayPlan.addMeal(dinner);
		
		DayPlan tuesday = new DayPlan();
		tuesday.addMeal(new Meal("Завтрак", 360, "Яичница", 10, 12, 55));
		tuesday.addMeal(new Meal("Обед", 620, "Гречка", 33, 14, 45));
		tuesday.addMeal(new Meal("Ужин", 480, "Творог", 35, 15, 25));
		
		MealReplacer.swapMeals(mondayPlan, tuesday, "Завтрак", 100);
		
		System.out.println("Понедельник:\n" + mondayPlan);
		System.out.println("Вторник:\n" + tuesday);
		
	}
	
	public static Meal readMealFromUser(Scanner scanner) {
		System.out.print("Введите название блюда: ");
		String name = scanner.nextLine();
		System.out.println("Введите прием пищи (Завтрак, Обед, Ужин, Перекус): ");
		String type = scanner.nextLine();
		System.out.println("Введите калорийность блюда: ");
		double calories = Double.parseDouble(scanner.nextLine());
		System.out.println("Введите количество жиров в блюде: ");
		double fats = Double.parseDouble(scanner.nextLine());
		System.out.println("Введите количество белков в блюде: ");
		double protein = Double.parseDouble(scanner.nextLine());
		System.out.println("Введите количество углеводов в блюд: ");
		double carbs = Double.parseDouble(scanner.nextLine());
		
		Recipe recipe = null;
		System.out.print("Хотите ввести рецепт (ингредиенты и описание)? (да/нет): ");
		String answer = scanner.nextLine();
		if (answer.equalsIgnoreCase("да")) {
			System.out.println("Введите ингредиенты через запятую:");
			String[] rawIngredients = scanner.nextLine().split(",");
			List<String> ingredients = List.of(rawIngredients);
			System.out.println("Введите описание приготовления:");
			String description = scanner.nextLine();
			recipe = new Recipe(name, ingredients, description);
		}
		
		Meal meal = new Meal(type, calories, name, fats, carbs, protein);
		return meal;
	}
}