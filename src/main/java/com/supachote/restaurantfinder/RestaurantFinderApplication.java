package com.supachote.restaurantfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RestaurantFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantFinderApplication.class, args);
	}
}
