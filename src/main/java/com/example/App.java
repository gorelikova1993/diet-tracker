package com.example;

import com.example.model.Ingredient;
import com.example.model.IngredientAmount;
import com.example.model.Recipe;
import com.example.model.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Ingredient egg = new Ingredient("Яйцо", 157, 13, 11, 1.1);
        Ingredient mushroom = new Ingredient("Шампиньоны", 22, 2.7, 0.3, 3.3);
        Ingredient ham = new Ingredient("Ветчина", 148, 19, 7.5, 0.0);
        
        // Яйцо С1
        Ingredient eggC1 = new Ingredient("Яйцо С1", 157, 13, 11, 1.1, 50); // 50 г на штуку

        // Помидор
        Ingredient tomato = new Ingredient("Помидор", 18, 0.9, 0.2, 3.9, 100); // 1 помидор ≈ 100 г

        // Молоко (не измеряется штуками)
        Ingredient milk = new Ingredient("Молоко", 54, 3, 2.5, 4.7); // weightPerPiece = 0

        // Хлеб (можно в штуках, например, кусок хлеба)
        Ingredient bread = new Ingredient("Хлеб", 265, 8, 3, 49, 30); // кусок хлеба ≈ 30 г
        
        List<String> steps = Arrays.asList("Обжарьте лук до прозрачности.", "Добавьте шампиньоны и готовьте до испарения жидкости.", "Добавьте ветчину и прогрейте 1-2 минуты.");
        
        List<IngredientAmount> ingredients = new ArrayList<>();
        ingredients.add(new IngredientAmount(eggC1, 2, Unit.PIECES)); // 2 яйца по 50 г = 100 г
        ingredients.add(new IngredientAmount(tomato, 1, Unit.PIECES)); // 1 помидор = 100 г
        ingredients.add(new IngredientAmount(bread, 2, Unit.PIECES)); // 2 куска хлеба = 60 г
        
        Recipe recipe = new Recipe(
                "Завтрак",
                Arrays.asList("Поджарь хлеб", "Пожарь яйца", "Нарежь помидор"),
                ingredients
        );
        
        System.out.println(recipe);
    }
}
