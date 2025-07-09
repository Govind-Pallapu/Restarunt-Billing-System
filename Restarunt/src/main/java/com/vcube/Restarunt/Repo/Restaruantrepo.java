package com.vcube.Restarunt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.Restarunt.Model.Restarunt;

@Repository
public interface Restaruantrepo extends JpaRepository<Restarunt, Integer> {
	
}
