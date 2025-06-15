package com.example.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

//блюдо
/*
Этот класс :
Хранит название блюда
Содержит рецепт (Recipe)
Рассчитывает КБЖУ на основе ингредиентов
Выводит информацию о блюде
* */
public class Dish {
    private final String name;
    private final Recipe recipe;
    private final int usedPortions;
    
    public Dish(String name, Recipe recipe, int usedPortions) {
        this.name = Objects.requireNonNull(name);
        this.recipe = Objects.requireNonNull(recipe);
        this.usedPortions = usedPortions;
    }
    
    public String getName() {
        return name;
    }
    
    public Recipe getRecipe() {
        return recipe;
    }
    
    // Расчёт калорий блюда
    public double getCalories() {
        return recipe.getTotalCalories(usedPortions);
    }
    
    // Расчёт белков
    public double getProteins() {
        return recipe.getTotalProteins(usedPortions);
    }
    
    // Расчёт жиров
    public double getFats() {
        return recipe.getTotalFats(usedPortions);
    }
    
    // Расчёт углеводов
    public double getCarbs() {
        return recipe.getTotalCarbs(usedPortions);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %.0f ккал / %.0f г Б / %.0f г Ж / %.0f г У",
                name, getCalories(), getProteins(), getFats(), getCarbs());
    }
}
