package com.example.model;

import java.util.Objects;

public class IngredientAmount {
    private final Ingredient ingredient;
    private final double quantity;
    private final Unit unit;
    
    public IngredientAmount(Ingredient ingredient, double quantity, Unit unit) {
        this.ingredient = Objects.requireNonNull(ingredient);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }
        this.quantity = quantity;
        this.unit = Objects.requireNonNull(unit);
    }
    
    public Ingredient getIngredient() {
        return ingredient;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    // Преобразование в граммы для расчёта КБЖУ
    public double getWeightInGrams() {
        return switch (unit) {
            case GRAMS -> quantity;
            case MILLILITERS -> quantity * 1.0; // упрощённо для жидкостей
            case PIECES -> {
                if (!ingredient.isMeasurableInPieces()) {
                    throw new IllegalStateException("Ингредиент " + ingredient.getName() + " не может быть указан в штуках");
                }
                yield quantity * ingredient.getWeightPerPiece();
            }
        };
    }
    
    @Override
    public String toString() {
        return String.format("%s — %.0f %s", ingredient.getName(), quantity, unit.getShortName());
    }
}
