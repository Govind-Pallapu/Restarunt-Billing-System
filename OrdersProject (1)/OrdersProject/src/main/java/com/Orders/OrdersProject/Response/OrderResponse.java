package com.Orders.OrdersProject.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	private String customerName;
	private RestaruantResponse restaurant;
	private ItemsResponse foodItem;

}
