package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayPlan {
    // Мы будем хранить приёмы пищи в виде списка
    private final List<Meal> meals = new ArrayList<>();
    
    /**
     * Добавляет приём пищи в рацион дня
     * @param meal — приём пищи (завтрак, обед и т.д.)
     */
    public void addMeal(Meal meal) {
        meals.add(meal);
    }
    
    /**
     * Возвращает список всех приёмов пищи
     */
    public List<Meal> getMeals() {
        return Collections.unmodifiableList(meals);
    }
    
    /**
     * Рассчитывает общее количество калорий за день
     */
    public double getTotalCalories() {
        double total = 0.0;
        for (Meal meal : meals) {
            total += meal.getTotalCalories();
        }
        return total;
    }
    
    /**
     * Рассчитывает общее количество белков за день
     */
    public double getTotalProteins() {
        double total = 0.0;
        for (Meal meal : meals) {
            total += meal.getTotalProteins();
        }
        return total;
    }
    
    /**
     * Рассчитывает общее количество жиров за день
     */
    public double getTotalFats() {
        double total = 0.0;
        for (Meal meal : meals) {
            total += meal.getTotalFats();
        }
        return total;
    }
    
    /**
     * Рассчитывает общее количество углеводов за день
     */
    public double getTotalCarbs() {
        double total = 0.0;
        for (Meal meal : meals) {
            total += meal.getTotalCarbs();
        }
        return total;
    }
    
    /**
     * Выводит информацию о рационе на день
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("📅 Рацион на день:\n");
        
        // Выводим каждый приём пищи
        for (Meal meal : meals) {
            sb.append(meal.toString()).append("\n");
        }
        
        // Общее КБЖУ за день
        sb.append(String.format("ИТОГО: %.0f ккал / %.0f г Б / %.0f г Ж / %.0f г У",
                getTotalCalories(), getTotalProteins(), getTotalFats(), getTotalCarbs()));
        
        return sb.toString();
    }
}
