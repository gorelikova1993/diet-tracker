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
    // Новое поле:
    private final int portions; // количество порций по рецепту
    
    //TODO реализовать конструктор  без portions6 default 1
    
    public Recipe(String name, List<String> description, List<IngredientAmount> ingredients, Map<String, String> substitutions, int portions) {
        this.name = Objects.requireNonNull(name);
        this.description = new ArrayList<>(description);
        this.ingredients = new ArrayList<>(ingredients);
        this.substitutions = substitutions == null ? new HashMap<>() : new HashMap<>(substitutions);
        this.portions = portions;
    }
    
    public Recipe(String name, List<String> description, List<IngredientAmount> ingredients, int portions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.portions = portions;
        this.substitutions = new HashMap<>();
    }
    
    // Метод для получения ингредиентов на 1 порцию
    public List<IngredientAmount> getIngredientsForPortion(int targetPortions) {
        List<IngredientAmount> portionedIngredients = new ArrayList<>();
        for (IngredientAmount amount : ingredients) {
            double weightPerPortion = amount.getWeightInGrams() / portions * targetPortions;
            Unit unit = amount.getUnit();
            if (unit == Unit.PIECES) {
                // Если штуки — округляем вверх
                int pieces = (int) Math.ceil((amount.getQuantity() / (double) portions) * targetPortions);
                portionedIngredients.add(new IngredientAmount(amount.getIngredient(), pieces, Unit.PIECES));
            } else {
                // Для граммов или мл
                portionedIngredients.add(new IngredientAmount(
                        amount.getIngredient(),
                        weightPerPortion,
                        unit
                ));
            }
        }
        return portionedIngredients;
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
    
    /**
     * Рассчитывает общее количество калорий блюда на основе ингредиентов.
     *
     * @return суммарные калории блюда
     */
    public double getTotalCalories(int targetPortions) {
        // Для каждого ингредиента:
        // 1. Берём калории на 100 грамм из Ingredient
        // 2. Умножаем на вес ингредиента (в граммах)
        // 3. Делим на 100, чтобы получить калории для нужного количества
        // Пример: яйцо (157 ккал/100г) × 50 г = 78.5 ккал
        return ingredients.stream()
                .mapToDouble(ia -> ia.getIngredient().getCaloriesPer100g() * ia.getWeightInGrams() / 100)
                .sum() / portions * targetPortions;
    }
    
    /**
     * Рассчитывает общее количество белков блюда на основе ингредиентов.
     *
     * @return суммарные белки блюда (в граммах)
     */
    public double getTotalProteins(int targetPortions) {
        return ingredients.stream()
                .mapToDouble(ia -> ia.getIngredient().getProteinsPer100g() * ia.getWeightInGrams() / 100)
                .sum() / portions * targetPortions;
    }
    
    /**
     * Рассчитывает общее количество жиров блюда на основе ингредиентов.
     *
     * @return суммарные жиры блюда (в граммах)
     */
    public double getTotalFats(int targetPortions) {
        return ingredients.stream()
                .mapToDouble(ia -> ia.getIngredient().getFatsPer100g() * ia.getWeightInGrams() / 100)
                .sum() / portions * targetPortions;
    }
    
    /**
     * Рассчитывает общее количество углеводов блюда на основе ингредиентов.
     *
     * @return суммарные углеводы блюда (в граммах)
     */
    public double getTotalCarbs(int targetPortions) {
        return ingredients.stream()
                .mapToDouble(ia -> ia.getIngredient().getCarbsPer100g() * ia.getWeightInGrams() / 100)
                .sum() / portions * targetPortions;
    }
}
