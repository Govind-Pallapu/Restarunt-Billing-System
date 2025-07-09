package com.vcube.Restarunt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fooditems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="restarunt_id", referencedColumnName ="id")
	private Restarunt rest;
	

}
