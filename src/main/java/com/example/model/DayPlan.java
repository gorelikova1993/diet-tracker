package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class DayPlan {
    private List<Meal> meals;
    
    public DayPlan() {
        this.meals = new ArrayList<>();
    }
    
    public void addMeal(Meal meal) {
        meals.add(meal);
    }
    
    public List<Meal> getMeals() {
        return meals;
    }
    
    public NutritionFacts calculateTotalNutrition() {
        double totalCalories = 0;
        double totalProtein = 0;
        double totalFats = 0;
        double totalCarbs = 0;
        
        for (Meal meal : meals) {
            NutritionFacts facts = meal.toNutritionFacts(); // используем toNutritionFacts()
            totalCalories += facts.getCalories();
            totalProtein += facts.getProtein();
            totalFats += facts.getFats();
            totalCarbs += facts.getCarbs();
        }
        
        return new NutritionFacts("Итого за день", totalCalories, totalProtein, totalFats, totalCarbs);
    }
    
    public Meal getMealByType(String type) {
        for (Meal meal : meals) {
            if (meal.getType().equalsIgnoreCase(type)) {
                return meal;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Рацион дня:\n");
        for (Meal meal : meals) {
            sb.append("- ").append(meal).append("\n");
        }
        
        NutritionFacts total = calculateTotalNutrition();
        sb.append("Суммарно: ").append(total);
        return sb.toString();
    }
}
