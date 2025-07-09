package com.Orders.OrdersProject.Response;

import lombok.Data;

@Data
public class ItemsResponse {
	
	private int id;
	private String name;
	private double price;
	private RestaruantResponse rest;
	

}
