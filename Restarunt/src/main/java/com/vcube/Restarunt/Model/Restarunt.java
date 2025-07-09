package com.vcube.Restarunt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Restaruant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restarunt {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;

}
