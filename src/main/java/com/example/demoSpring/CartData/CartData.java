package com.example.demoSpring.CartData;

import java.util.ArrayList;
import java.util.List;

import com.example.demoSpring.model.Products;

public class CartData {
	public static List<Products> cart;

	static {
		cart = new ArrayList<Products>();
	}
}
