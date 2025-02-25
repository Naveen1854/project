package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.FoodDao;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.exception.FoodIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Food> responseStructure;

	@Autowired
	ResponseStructureList<Food> responseStructureList;

	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully food saved into db");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully food fetched by id");
			responseStructure.setData(foodDao.fetchFoodById(foodId));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Food>> fetchAllFood() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully AllFood fetched by id from db");
		responseStructureList.setData(foodDao.fetchAllFood());
		return new ResponseEntity<ResponseStructureList<Food>>(responseStructureList,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Food deleted by id from db");
			responseStructure.setData(foodDao.deleteFoodById(foodId));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> updateFoodById(int oldFoodId, Food newFood) {
		Food food = foodDao.fetchFoodById(oldFoodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully Food updated by id in db");
			responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}
}
