package com.diettracker;

public class MealReplacer {
    /**
     * Заменяет прием пищи заданного типа между двумя рационами, если калории отличаются не более чем на tolerance.
     */
    
    public static boolean swapMeals(DayPlan day1, DayPlan day2, String mealType, double tolerance) {
        Meal meal1 = day1.getMealByType(mealType);
        Meal meal2 = day2.getMealByType(mealType);
        
        if (meal1 == null || meal2 == null) {
            System.out.println("Один из рационов не содержит прием пищи типа: " + mealType);
            return false;
        }
        
        double calorieDiff = Math.abs(meal1.getCalories() - meal2.getCalories());
        
        if (calorieDiff <= tolerance) {
            // Удаляем старые приёмы
            day1.getMeals().remove(meal1);
            day2.getMeals().remove(meal2);
            // Обмениваем
            day1.addMeal(meal2);
            day2.addMeal(meal1);
            
            System.out.println("Обмен прошёл успешно! Разница в калориях: " + calorieDiff);
            return true;
        } else {
            System.out.println("Разница в калориях слишком велика: " + calorieDiff + " > " + tolerance);
            return false;
        }
    }
}
