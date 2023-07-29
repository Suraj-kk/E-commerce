package com.example.demoSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSpring.model.Products;
import com.example.demoSpring.repo.ProductRepo;
@Service
public class ProductService {
	@Autowired
	ProductRepo productRepo;
	
	public List<Products> getAllProducts(){
		return productRepo.findAll(); 
	}
	
	public Products addProducts(Products product){
		return productRepo.save(product); 
	}
	public void RemoveProductById(int id){
		 productRepo.deleteById(id); 
	}
	
	public Optional<Products> GetProductById(int id) {
		return productRepo.findById(id);
	}
	
	public List<Products> GetProductByCategory_Id(int id) {
		return productRepo.findByCategory_id(id);
	}
}
   