package com.example.demoSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor

public class ProductDto{
	
		private int id;
		
		private String name;
		
		private int categoryId;
		
		private double price;
		
		private String description;
		
		private String imageName;

		public  ProductDto() {
			
		}
		
	}

