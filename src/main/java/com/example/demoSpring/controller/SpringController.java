package com.example.demoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoSpring.CartData.CartData;
import com.example.demoSpring.model.Products;
import com.example.demoSpring.model.Users;
import com.example.demoSpring.service.CategoryService;
import com.example.demoSpring.service.ProductService;
import com.example.demoSpring.service.UserService;

@Controller
public class SpringController {

	@Autowired
	CategoryService categoryservice;
	@Autowired
	ProductService productservice;
	@Autowired
	UserService userservice;


	@GetMapping("/")
	public String HomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String signupPage() {
		return "register";
	}
////	@PostMapping("/register")
//	public String processRegister(@RequestBody Users user) {
//		userservice.adduser(user);
//		return "shop";
//	}


	@GetMapping("/login")
	public String signinPage() {
		return "Userlogin";
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
//	    // login logic
//	    redirectAttributes.addFlashAttribute("message", "Login successful!");
//	    return "redirect:/home";
//	}


	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryservice.GetAllCategory());
		model.addAttribute("products", productservice.getAllProducts());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String shopByCatgory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryservice.GetAllCategory());
		model.addAttribute("products", productservice.GetProductByCategory_Id(id));
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		model.addAttribute("product", productservice.GetProductById(id).get());
		System.out.println(model);
		return "viewproduct";
	}

	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		CartData.cart.add(productservice.GetProductById(id).get());
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String viewCart(Model model) {
		model.addAttribute("cartCount", CartData.cart.size());
		model.addAttribute("total", CartData.cart.stream().mapToDouble(Products::getPrice).sum());
		model.addAttribute("cart", CartData.cart);
		return "cart";
	}

	@GetMapping("/cart/removeId/{index}")
	public String RemoveItem(@PathVariable int index) {
		CartData.cart.remove(index);
		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", CartData.cart.stream().mapToDouble(Products::getPrice).sum());
		return "checkout";
	}
}
