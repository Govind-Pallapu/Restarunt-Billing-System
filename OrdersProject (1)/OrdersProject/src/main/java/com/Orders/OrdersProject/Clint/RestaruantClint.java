package com.Orders.OrdersProject.Clint;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Orders.OrdersProject.Response.ItemsResponse;
import com.Orders.OrdersProject.Response.RestaruantResponse;

@FeignClient(name = "Restarunt", url =
"http://localhost:8080/restaruant")
public interface RestaruantClint {
	
	@GetMapping("/getRestaurantById/{restaurantId}")
	RestaruantResponse getRestaurant(@PathVariable("restaurantId") int id);
	
	@GetMapping("/getFoodItemsByRestaurantId/{restaurantId}")
	List<ItemsResponse> getFoodItems(@PathVariable("restaurantId") int id);

	

}
