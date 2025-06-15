package com.example.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingList {
    // Храним ингредиенты и их суммарный вес/количество
    private final Map<Ingredient, Double> ingredients = new HashMap<>();
    
    /**
     * Добавляет блюдо в список покупок
     * @param dish — блюдо, из которого берём ингредиенты
     */
    public void addDish(Dish dish) {
        for (IngredientAmount amount : dish.getRecipe().getIngredients()) {
            ingredients.merge(amount.getIngredient(), amount.getWeightInGrams(), Double::sum);
        }
    }
    
    /**
     * Добавляет все ингредиенты из приёма пищи
     * @param meal — приём пищи (завтрак, обед и т.д.)
     */
    public void addMeal(Meal meal) {
        for (Dish dish : meal.getDishes()) {
            addDish(dish);
        }
    }
    
    /**
     * Добавляет все ингредиенты из рациона на день
     * @param dayPlan — рацион на день
     */
    public void addDayPlan(DayPlan dayPlan) {
        for (Meal meal : dayPlan.getMeals()) {
            addMeal(meal);
        }
    }
    
    /**
     * Возвращает неизменяемый список ингредиентов
     */
    public Map<Ingredient, Double> getIngredients() {
        return Collections.unmodifiableMap(ingredients);
    }
    
    /**
     * Выводит список покупок в читаемом виде
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🛒 Список покупок:\n");
        
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double totalWeight = entry.getValue();
            
            // Если это штукообразный продукт (например, яйца), можно показать примерное количество
            if (ingredient.isMeasurableInPieces()) {
                int pieces = (int) Math.ceil(totalWeight / ingredient.getWeightPerPiece());
                sb.append(String.format(" - %s — %.0f г (%d шт)\n", ingredient.getName(), totalWeight, pieces));
            } else {
                sb.append(String.format(" - %s — %.0f г\n", ingredient.getName(), totalWeight));
            }
        }
        
        return sb.toString();
    }
}
