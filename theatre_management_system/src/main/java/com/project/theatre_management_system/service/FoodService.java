package com.project.theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.FoodDao;
import com.project.theatre_management_system.dto.Food;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	
	public Food saveFood(Food food) {
		return foodDao.saveFood(food);
	}
	
	public Food fetchFoodById(int foodId) {
		return foodDao.fetchFoodById(foodId);
	}
	
	public List<Food> fetchAllFood() {
		return foodDao.fetchAllFood();
	}
	
	public Food deleteFoodById(int foodId) {
		return foodDao.deleteFoodById(foodId);
	}
	
	public Food updateFoodById(int oldFoodId, Food newFood) {
		return foodDao.updateFoodById(oldFoodId, newFood);
	}
}
