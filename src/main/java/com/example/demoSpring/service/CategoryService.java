package com.example.demoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSpring.model.Category;
import com.example.demoSpring.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	CategoryRepo categoryRepo;

	public Category addcategory(Category category) {
		return categoryRepo.save(category);
	}

	public List<Category> GetAllCategory() {
		return categoryRepo.findAll();

	}

	public void removeCategoryById(int id) {
		categoryRepo.deleteById(id);

	}

	public Optional<Category> UpdateCategoryById(int id) {
		return categoryRepo.findById(id);
	}

}
