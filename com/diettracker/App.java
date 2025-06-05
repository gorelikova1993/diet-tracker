package com.diettracker;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Diet diet1 = new Diet("Рацион на 2000 калорий");
		List<String> ingredientsForMealDiet1 = List.of("Яйцо С0 2 шт", "Форель слабосоленная 75 грамм", "Сыр творожный с зеленью Hohland 30 грамм",
			"Хлебцы dr.korner гречневые 2 шт", "Итальянская смесь 200 грамм", "половинка огурца");
		String descriptionForMealDiet1 = "Замороженные овощи высыпаем на сковороду(средний огонь) и накрываем крышкой на 6-8 минут....";
		Recipe recipe = new Recipe("Омлет с овощами и хлебцы с красной рыбой", ingredientsForMealDiet1, descriptionForMealDiet1);
		diet1.addMeal(new Meal("Завтрак", 515,  "Омлет с овощами и хлебцы с красной рыбой", recipe,  20,
			42, 36));


		Meal lunch = new Meal("Обед", 465, "Картофель по деревенски с индейкой", 13, 45, 40);
		diet1.addMeal(lunch);
		Meal dinner = new Meal("Ужин", 435, "Макароны с броколли и черри", 12, 54, 29);
		diet1.addMeal(dinner);

		System.out.println("Программа запущена!");
		
		System.out.println("---------------------");
		
		diet1.printMeals();
		System.out.println("Суммарное КБЖУ: ");
		System.out.println(diet1.getTotalNutrition());
		
		System.out.println("---------------------");
		diet1.printSummary();
		
		Scanner scanner = new Scanner(System.in);
		Meal meal = readMealFromUser(scanner);
		diet1.addMeal(meal);
		diet1.printSummary();
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