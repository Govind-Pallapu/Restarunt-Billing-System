package com.Orders.OrdersProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.Orders.OrdersProject")
public class OrdersProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersProjectApplication.class, args);
	}

}
