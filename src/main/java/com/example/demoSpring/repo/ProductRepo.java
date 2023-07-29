package com.example.demoSpring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSpring.model.Products;

public interface ProductRepo extends JpaRepository<Products, Integer> {

	List<Products> findByCategory_id(int id);



}

