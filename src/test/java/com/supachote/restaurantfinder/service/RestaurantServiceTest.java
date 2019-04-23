package com.supachote.restaurantfinder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.supachote.restaurantfinder.model.Restaurant;
import com.supachote.restaurantfinder.model.RestaurantDetail;

@RunWith(SpringRunner.class)
public class RestaurantServiceTest {
	
	private RestaurantService restaurantService;
	
	@Before
	public void setUp() throws Exception {
		FileService fileService = new FileService();
		restaurantService = new RestaurantService(fileService);
	}
	
	@Test
	public void Should_Restaurants_Not_Null_When_Get_All_Restaurant() throws Exception {
		// Act
		List<Restaurant> restaurants = restaurantService.getAllRestaurant();
		
		// Assert
		assertThat(restaurants).isNotNull();
	}
	
	@Test
	public void Should_RestaurantDetail_IsNot_Null_When_Get_Restaurant_Id_Is_0() throws Exception {
		// Arrange
		int restaurantId = 0;
		
		// Act
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(restaurantId);
		
		// Assert
		assertThat(restaurantDetail).isNotNull();
	}
	
	@Test
	public void Should_RestaurantDetail_Id_Is_1_When_Get_Restaurant_Id_Is_1() throws Exception {
		// Arrange
		int restaurantId = 1;
		
		// Act
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(restaurantId);
		
		// Assert
		assertThat(restaurantDetail.getId()).isEqualTo(1);
	}
	
	@Test
	public void Should_RestaurantDetail_Name_IsNot_Empty_When_Get_Restaurant_Id_Is_1() throws Exception {
		// Arrange
		int restaurantId = 1;
		
		// Act
		RestaurantDetail restaurantDetail = restaurantService.getRestaurantDetail(restaurantId);
		
		// Assert
		assertThat(restaurantDetail.getName()).isNotEmpty();
	}
}
