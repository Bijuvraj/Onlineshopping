package com.edubridge.springboot.project.onlineshopping.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.project.onlineshopping.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByEmail(String email);
}



