package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Recipe {
    private final String name;
    private final  List<String> description;
    private final List<IngredientAmount> ingredients; // ингредиент + количество + единица измерения
    private final Map<String, String> substitutions;   // "ветчина" → "куриная грудка" на что можно заменить ингредиент в рецепте
    
    public Recipe(String name, List<String> description, List<IngredientAmount> ingredients, Map<String, String> substitutions) {
        this.name = Objects.requireNonNull(name);
        this.description = new ArrayList<>(description);
        this.ingredients = new ArrayList<>(ingredients);
        this.substitutions = substitutions == null ? new HashMap<>() : new HashMap<>(substitutions);
    }
    
    public Recipe(String name, List<String> description, List<IngredientAmount> ingredients) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.substitutions = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<String> getDescription() {
        return description;
    }
    
    public List<IngredientAmount> getIngredients() {
        return ingredients;
    }
    
    public Map<String, String> getSubstitutions() {
        return substitutions;
    }
    
    // Метод toString для вывода рецепта
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🔸 ").append(name).append("\n");
        
        // Ингредиенты
        for (IngredientAmount amount : ingredients) {
            sb.append(amount.toString()).append("\n");
        }
        
        // Замены
        if (!substitutions.isEmpty()) {
            sb.append("Замена: ");
            for (Map.Entry<String, String> sub : substitutions.entrySet()) {
                sb.append(sub.getKey()).append(" ↔️ ").append(sub.getValue()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()).append("\n");
        }
        
        // Шаги приготовления
        sb.append("Приготовление:\n");
        for (int i = 0; i < description.size(); i++) {
            sb.append(i + 1).append(". ").append(description.get(i)).append("\n");
        }
        
        return sb.toString();
    }
}
