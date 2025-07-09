package com.Orders.OrdersProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Orders.OrdersProject.Clint.RestaruantClint;
import com.Orders.OrdersProject.Model.Orders;
import com.Orders.OrdersProject.Repositary.OrderRespositary;
import com.Orders.OrdersProject.Response.ItemsResponse;
import com.Orders.OrdersProject.Response.OrderResponse;
import com.Orders.OrdersProject.Response.RestaruantResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderRespositary orderRepos;
	@Autowired
	RestaruantClint clintRepo;
	
	@PostMapping
	public Orders placeOrder(@RequestBody Orders order) {
		
		return orderRepos.save(order);
		
	}
	
	@GetMapping("/getOrderDetails/{id}")
	public ResponseEntity<OrderResponse> getOrderDetailsById(@PathVariable int id) {
	    Orders ordersEntity = orderRepos.findById(id).orElseThrow();

	   
	    RestaruantResponse restaurantResponse = clintRepo.getRestaurant(ordersEntity.getRestaurantId());

	    List<ItemsResponse> foodItems = clintRepo.getFoodItems(ordersEntity.getRestaurantId());

	    ItemsResponse foodItemsResponse = foodItems.stream()
	            .filter(f -> f.getId() == ordersEntity.getFoodItemId())
	            .findFirst()
	            .orElse(null); 

	    OrderResponse response = new OrderResponse(
	            ordersEntity.getCustomerName(),
	            restaurantResponse,
	            foodItemsResponse
	    );

	    return ResponseEntity.ok(response);
	}


}
