package com.diettracker;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private List<String> ingredients; //ингредиенты
    private String description;// способ готовки
    private String name; //название блюда
    
    public Recipe(String name, List<String> ingredients, String description) {
        this.name = Objects.requireNonNull(name, "Название блюда не может быть null");
        this.description = description;
        this.ingredients = ingredients;
    }
    
    public List<String> getIngredients() {
        return ingredients;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Название блюда: ").append(name).append("\n");
        if (ingredients != null && !ingredients.isEmpty()) {
            sb.append("Ингредиенты: ").append(String.join(", ", ingredients)).append("\n");
        }
        if (description != null && !description.isBlank()) {
            sb.append("Рецепт: ").append(description);
        }
        return sb.toString();
    }
}
