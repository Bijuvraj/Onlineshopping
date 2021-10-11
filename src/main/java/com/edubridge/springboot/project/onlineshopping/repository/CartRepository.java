package com.edubridge.springboot.project.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.project.onlineshopping.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	
}
