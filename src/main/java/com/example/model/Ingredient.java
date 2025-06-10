package com.example.model;

import java.util.Objects;

//Описывает один продукт, используемый в рецептах.
public class Ingredient {
    private final String name;
    private final double caloriesPer100g;
    private final double proteinsPer100g;
    private final double fatsPer100g;
    private final double carbsPer100g;
    
    // Новый параметр: вес одной штуки (если измеряется в штуках)
    private final double weightPerPiece; // в граммах
    
    public Ingredient(String name, double caloriesPer100g, double proteinsPer100g, double fatsPer100g, double carbsPer100g) {
        this(name, caloriesPer100g, proteinsPer100g, fatsPer100g, carbsPer100g, 0);
    }
    
    // Конструктор с возможностью указать вес на штуку
    public Ingredient(String name,
                      double caloriesPer100g,
                      double proteinsPer100g,
                      double fatsPer100g,
                      double carbsPer100g,
                      double weightPerPiece) {
        if (caloriesPer100g < 0 || proteinsPer100g < 0 ||
                fatsPer100g < 0 || carbsPer100g < 0) {
            throw new IllegalArgumentException("БЖУ не могут быть отрицательными");
        }
        
        this.name = Objects.requireNonNull(name);
        this.caloriesPer100g = caloriesPer100g;
        this.proteinsPer100g = proteinsPer100g;
        this.fatsPer100g = fatsPer100g;
        this.carbsPer100g = carbsPer100g;
        this.weightPerPiece = weightPerPiece;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }
    
    public double getProteinsPer100g() {
        return proteinsPer100g;
    }
    
    public double getFatsPer100g() {
        return fatsPer100g;
    }
    
    public double getCarbsPer100g() {
        return carbsPer100g;
    }
    
    public double getWeightPerPiece() { return weightPerPiece; }
    
    // Метод, который поможет нам понять, можно ли использовать единицу PIECES для этого ингредиента
    public boolean isMeasurableInPieces() {
        return weightPerPiece > 0;
    }
    
    @Override
    public String toString() {
        return "Ингредиент{" +
                "name='" + name + '\'' +
                ", калории=" + caloriesPer100g +
                ", белки=" + proteinsPer100g +
                ", жиры=" + fatsPer100g +
                ", углеводы=" + carbsPer100g +
                '}';
    }
}
