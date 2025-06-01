import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Diet diet1 = new Diet("Рацион на 2000 калорий");
		List<String> ingredientsForMealDiet1 = List.of("Яйцо С0 2 шт", "Форель слабосоленная 75 грамм", "Сыр творожный с зеленью Hohland 30 грамм",
			"Хлебцы dr.korner гречневые 2 шт", "Итальянская смесь 200 грамм", "половинка огурца");
		String descriptionForMealDiet1 = "Замороженные овощи высыпаем на сковороду(средний огонь) и накрываем крышкой на 6-8 минут....";
		diet1.addMeal(new Meal("Завтрак", 515, ingredientsForMealDiet1, "Омлет с овощами и хлебцы с красной рыбой", descriptionForMealDiet1, 20,
			42, 36));


		Meal lunch = new Meal("Обед", 465, "Картофель по деревенски с индейкой", 13, 45, 40);
		diet1.addMeal(lunch);
		Meal dinner = new Meal("Ужин", 435, "Макароны с броколли и черри", 12, 54, 29);
		diet1.addMeal(dinner);

		System.out.println("Программа запущена!");
		for ( Meal meal : diet1.getMeals()) {
			System.out.println(meal.getName() + " " + meal.getCalories());
		}
	}
}