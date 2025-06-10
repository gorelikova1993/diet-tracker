package com.example.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Dish {
    private final String name;
    private final Map<Ingredient, Double> ingredients = new LinkedHashMap<>();
    
    public Dish(String name) {
        this.name = Objects.requireNonNull(name);
    }
    
    public void addIngredient(Ingredient ingredient, double grams) {
        if (grams <= 0) {
            throw new IllegalArgumentException("Вес ингредиента должен быть больше нуля.");
        }
        ingredients.put(ingredient, grams);
    }
    
    public double getCalories() {
        double total = 0.0;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double grams = entry.getValue();
            total += ingredient.getCaloriesPer100g() * grams / 100;
        }
        return total;
    }
    
    public double getProteins() {
        double total = 0.0;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double grams = entry.getValue();
            total += ingredient.getProteinsPer100g() * grams / 100;
        }
        return total;
    }
    
    public double getFats() {
        double total = 0.0;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double grams = entry.getValue();
            total += ingredient.getFatsPer100g() * grams / 100;
        }
        return total;
    }
    
    public double getCarbs() {
        double total = 0.0;
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            double grams = entry.getValue();
            total += ingredient.getCarbsPer100g() * grams / 100;
        }
        return total;
    }
    
    public String getName() {
        return name;
    }
    
    public Map<Ingredient, Double> getIngredients() {
        return Collections.unmodifiableMap(ingredients);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %.1f ккал, %.1f Б, %.1f Ж, %.1f У",
                name, getCalories(), getProteins(), getFats(), getCarbs());
    }
}
