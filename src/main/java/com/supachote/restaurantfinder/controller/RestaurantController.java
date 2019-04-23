package com.supachote.restaurantfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.supachote.restaurantfinder.model.Restaurant;
import com.supachote.restaurantfinder.model.RestaurantDetail;
import com.supachote.restaurantfinder.service.RestaurantService;

@Controller
public class RestaurantController {

	   @Autowired
	   RestaurantService restaurantService;
		   
		@GetMapping("/")
		public String getPageRestaurantList(Model model) {
			List<Restaurant> restaurants = restaurantService.getAllRestaurant();
			
			model.addAttribute("restaurants", restaurants);

			return "RestaurantList";
		}
		
		@GetMapping("/restaurant/{id}")
		public String getPageRestaurantDetail(@PathVariable(value = "id") int restaurantId, Model model) {
			RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(restaurantId);
			
			model.addAttribute("restaurantDetail", restaurantDetail);
			
			return "RestaurantDetail";
		}
}
