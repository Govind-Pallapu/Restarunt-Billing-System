package com.vcube.Restarunt.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.Restarunt.Model.FoodItems;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItems, Integer>{
	
	List<FoodItems> findByRest_Id(int id); 

}
