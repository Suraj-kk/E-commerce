package com.example.demoSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoSpring.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
