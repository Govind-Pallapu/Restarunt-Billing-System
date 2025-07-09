package com.Orders.OrdersProject.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Orders.OrdersProject.Model.Orders;

@Repository
public interface OrderRespositary extends JpaRepository<Orders, Integer> {

}
