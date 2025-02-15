package com.project.theatre_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;

	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}

	public Food fetchFoodById(int foodId) {
		return foodRepo.findById(foodId).get();
	}

	public List<Food> fetchAllFood() {
		return foodRepo.findAll();
	}

	public Food deleteFoodById(int foodId) {
		Food food = fetchFoodById(foodId);
		foodRepo.delete(food);
		return food;
	}

	public Food updateFoodById(int oldFoodId, Food newFood) {
		newFood.setFoodId(oldFoodId);
		return saveFood(newFood);
	}
}
