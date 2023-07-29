package com.example.demoSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_price",nullable=false)
	private double price;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "product_image")
	private String imageName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cat_id",referencedColumnName = "cat_id")
	private Category category;
}
