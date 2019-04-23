package com.supachote.restaurantfinder.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.supachote.restaurantfinder.appconst.AppConst;
import com.supachote.restaurantfinder.model.Restaurant;
import com.supachote.restaurantfinder.model.RestaurantDetail;
import com.google.gson.reflect.TypeToken;

@Service
public class RestaurantService {
	@Autowired
	FileService fileService;
	
	public RestaurantService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public List<Restaurant> getAllRestaurant() {
		String restaurantJson = fileService.readFileAsString(AppConst.RESTAURANT_JSON_FILE_PATH);
		
		if (restaurantJson == null) {
			return new ArrayList<Restaurant>();
		}
		
		Type restaurantListType = new TypeToken<ArrayList<Restaurant>>(){}.getType();

		return new Gson().fromJson(restaurantJson, restaurantListType);
	}
	
	public RestaurantDetail getRestaurantDetail(int restaurantId) {
		List<Restaurant> restaurants = getAllRestaurant();

		for (Restaurant restaurant : restaurants) {
			if (restaurant.getId() == restaurantId) {
				RestaurantDetail restaurantDetail = new RestaurantDetail();
				
				restaurantDetail.setId(restaurant.getId());
				restaurantDetail.setName(restaurant.getName());
				restaurantDetail.setAddress(restaurant.getAddress());
				restaurantDetail.setPhone(restaurant.getPhone());
				restaurantDetail.setDescription("Dummy Description ");
				restaurantDetail.setReviewCount(restaurant.getReviewCount());
				restaurantDetail.setReviews(getDummyReviews(restaurantDetail.getReviewCount()));
		
				return restaurantDetail;
			}
		}
		
		// Not found in restaurant list
		return new RestaurantDetail();
	}
	
	private List<String> getDummyReviews(int reviewCount) {
		if (reviewCount == 0) {
			return new ArrayList<String>();
		}
		
		List<String> reviews = new ArrayList<String>();
		
		for (int i = 0; i < reviewCount; i++) {
			reviews.add("Review Number - " + (i + 1));
		}
		
		return reviews;
	}
	
}
