package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
Хранит тип приёма пищи (например, "Завтрак")
Содержит одно или несколько блюд (List<Dish>)
Рассчитывает суммарное КБЖУ
Выводит информацию о себе
 */

public class Meal {
	private final String type; // Тип приёма пищи: завтрак, обед и т.д.
	private final List<Dish> dishes = new ArrayList<>(); // Блюда, входящие в этот приём пищи
	
	/**
	 * Конструктор
	 * @param type — тип приёма пищи (например, "Завтрак")
	 */
	public Meal(String type) {
		this.type = type;
	}
	
	/**
	 * Добавляет блюдо в приём пищи
	 * @param dish — блюдо, которое ты ешь на этом приёме пищи
	 */
	public void addDish(Dish dish) {
		dishes.add(dish);
	}
	
	/**
	 * Возвращает список всех блюд
	 * @return неизменяемый список блюд
	 */
	public List<Dish> getDishes() {
		return Collections.unmodifiableList(dishes);
	}
	
	/**
	 * Возвращает тип приёма пищи
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Рассчитывает общее количество калорий всех блюд
	 */
	public double getTotalCalories() {
		double total = 0.0;
		for (Dish dish : dishes) {
			total += dish.getCalories();
		}
		return total;
	}
	
	/**
	 * Рассчитывает общее количество белков всех блюд
	 */
	public double getTotalProteins() {
		double total = 0.0;
		for (Dish dish : dishes) {
			total += dish.getProteins();
		}
		return total;
	}
	
	/**
	 * Рассчитывает общее количество жиров всех блюд
	 */
	public double getTotalFats() {
		double total = 0.0;
		for (Dish dish : dishes) {
			total += dish.getFats();
		}
		return total;
	}
	
	/**
	 * Рассчитывает общее количество углеводов всех блюд
	 */
	public double getTotalCarbs() {
		double total = 0.0;
		for (Dish dish : dishes) {
			total += dish.getCarbs();
		}
		return total;
	}
	
	/**
	 * Возвращает строку с информацией о приёме пищи
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("🍽 ").append(type).append(": ")
				.append(String.format("%.0f ккал / %.0f г Б / %.0f г Ж / %.0f г У%n",
						getTotalCalories(), getTotalProteins(), getTotalFats(), getTotalCarbs()));
		
		sb.append("Блюда:%n");
		for (Dish dish : dishes) {
			sb.append(" - ").append(dish.toString()).append("%n");
		}
		
		return sb.toString();
	}
}