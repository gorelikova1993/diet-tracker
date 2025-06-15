package com.example;

import com.example.model.DayPlan;
import com.example.model.Dish;
import com.example.model.Ingredient;
import com.example.model.IngredientAmount;
import com.example.model.Meal;
import com.example.model.Recipe;
import com.example.model.ShoppingList;
import com.example.model.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Ингредиенты для завтрака
        Ingredient cottageCheese = new Ingredient("творог 2%", 98, 14, 2, 3, 100); // 100 г
        Ingredient flour = new Ingredient("мука пшеничная", 330, 9, 1, 70, 100); // 100 г
        Ingredient eggC0 = new Ingredient("яйцо С0", 157, 13, 11, 1.1, 50); // штука ~50 г
        Ingredient apple = new Ingredient("яблоко", 52, 0.3, 0.2, 10, 100); // 100 г
        Ingredient cinnamon = new Ingredient("корица", 247, 1, 1, 80, 100); // 100 г порошка
        Ingredient sweetener = new Ingredient("подсластитель", 0, 0, 0, 0, 100); // условно 100 г
        
        // Ингредиенты для сырников
        List<IngredientAmount> omeletteIngredients = Arrays.asList(
                new IngredientAmount(cottageCheese, 600, Unit.GRAMS),
                new IngredientAmount(flour, 75, Unit.GRAMS),
                new IngredientAmount(eggC0, 2, Unit.PIECES),
                new IngredientAmount(apple, 3, Unit.PIECES), // яблоки средние
                new IngredientAmount(cinnamon, 7.5, Unit.GRAMS),
                new IngredientAmount(sweetener, 5, Unit.GRAMS)
        );
        
        Recipe omeletteRecipe = new Recipe(
                "Сырники с тушеным яблоком",
                Arrays.asList(
                        "К творогу добавьте яйца и муку, замесите мягкое тесто.",
                        "Разделите массу на небольшие шарики (6–9 шт) и сформируйте сырники.",
                        "Обжарьте на сухой сковороде до румяной корочки под крышкой (по 3–5 минут с каждой стороны).",
                        "Нарежьте яблоки кубиками и потушите с корицей и подсластителем 5–7 минут."
                ),
                omeletteIngredients,
                Map.of("пшеничная мука", "ЦЗ мука", "яблоко", "груша"), 2
        );
        
        Dish breakfastDish = new Dish("Сырники с яблоком", omeletteRecipe, 1);
        
        Meal breakfast = new Meal("Завтрак");
        breakfast.addDish(breakfastDish);
        
        
        // Ингредиенты для обеда
        Ingredient turkey = new Ingredient("филе индейки", 109, 22, 3, 0, 100);
        Ingredient pasta = new Ingredient("пенне", 371, 13, 1.5, 75, 100);
        Ingredient cream = new Ingredient("сливки 10%", 108, 2.5, 10, 3, 100);
        Ingredient mushroom = new Ingredient("шампиньоны", 22, 2.7, 0.3, 3.3, 100);
        Ingredient onionMeal = new Ingredient("лук", 41, 1.1, 0.1, 9.3, 100);
        Ingredient spinach = new Ingredient("шпинат", 23, 2.9, 0.3, 1.4, 100);
        Ingredient parmesan = new Ingredient("пармезан", 420, 38, 29, 4, 100);
        
        List<IngredientAmount> lunchIngredients = Arrays.asList(
                new IngredientAmount(turkey, 300, Unit.GRAMS),
                new IngredientAmount(pasta, 180, Unit.GRAMS),
                new IngredientAmount(cream, 200, Unit.MILLILITERS),
                new IngredientAmount(mushroom, 200, Unit.GRAMS),
                new IngredientAmount(onionMeal, 1, Unit.PIECES),
                new IngredientAmount(spinach, 100, Unit.GRAMS),
                new IngredientAmount(parmesan, 15, Unit.GRAMS)
        );
        
        Recipe lunchRecipe = new Recipe(
                "Паста с индейкой в сливочном соусе",
                Arrays.asList(
                        "Обжарьте кусочки индейки до румяности, снимите со сковороды.",
                        "На той же сковороде пассеруйте лук с шампиньонами.",
                        "Верните индейку, влейте сливки и тушите 5 минут.",
                        "Отварите пенне al dente.",
                        "За минуту до готовности добавьте в соус шпинат.",
                        "Смешайте пасту с соусом, распределите на три порции."
                ),
                lunchIngredients,
                Map.of("филе индейки", "куриное филе, форель/кета/кижуч"), 2
        );
        
        Dish lunchDish = new Dish("Паста с индейкой", lunchRecipe, 1);
        
        Meal lunch = new Meal("Обед");
        lunch.addDish(lunchDish);
        
        
        // Ингредиенты для ужина
        Ingredient pollock = new Ingredient("филе палтуса", 100, 20, 1, 0, 100);
        Ingredient potato = new Ingredient("картофель", 77, 2, 0.1, 17, 100);
        Ingredient tomato = new Ingredient("помидор", 18, 0.9, 0.2, 3.9, 100);
        Ingredient cucumber = new Ingredient("огурцы", 15, 0.7, 0.1, 3.6, 100);
        Ingredient sourCream = new Ingredient("сметана 10%", 115, 3, 10, 4, 100);
        Ingredient oliveOil = new Ingredient("оливковое масло", 884, 0, 100, 0, 100);
        
        List<IngredientAmount> dinnerIngredients = Arrays.asList(
                new IngredientAmount(pollock, 400, Unit.GRAMS),
                new IngredientAmount(potato, 450, Unit.GRAMS),
                new IngredientAmount(tomato, 3, Unit.PIECES),
                new IngredientAmount(cucumber, 3, Unit.PIECES),
                new IngredientAmount(sourCream, 60, Unit.GRAMS),
                new IngredientAmount(oliveOil, 5, Unit.GRAMS)
        );
        
        Recipe dinnerRecipe = new Recipe(
                "Палтус с картофелем",
                Arrays.asList(
                        "Картофель отварите в подсоленной воде до готовности, слейте воду и слегка обсушите.",
                        "Филе палтуса разморозьте в холодильнике, обжарьте на оливковом масле по 3–4 минуты с каждой стороны.",
                        "Всё распределите на 3 равные порции.",
                        "Для салата нарежьте огурцы и помидоры, заправьте сметаной перед употреблением."
                ),
                dinnerIngredients,
                Map.of("сметана", "греческий йогурт", "палтус", "треска, минтай", "картофель", "батат"), 2
        );
        
        Dish dinnerDish = new Dish("Палтус с картофелем", dinnerRecipe, 1);
        
        Meal dinner = new Meal("Ужин");
        dinner.addDish(dinnerDish);
        
        
        // Рацион на день
        DayPlan dayPlan = new DayPlan();
        dayPlan.addMeal(breakfast);
        dayPlan.addMeal(lunch);
        dayPlan.addMeal(dinner);
        
        System.out.println(dayPlan);
        
        
        // Список покупок
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addDayPlan(dayPlan);
        
        System.out.println("\n🛒 Список покупок:");
        System.out.println(shoppingList);
    }
}
