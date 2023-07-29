package com.example.demoSpring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoSpring.dto.ProductDto;
import com.example.demoSpring.model.Category;
import com.example.demoSpring.model.Products;
import com.example.demoSpring.model.Users;
import com.example.demoSpring.service.CategoryService;
import com.example.demoSpring.service.ProductService;
import com.example.demoSpring.service.UserService;

@Component
@Controller
public class AdminController {
	public static String uploadDir = System.getProperty("user.dir") + "src/main/resouces/static/productImages";
	@Autowired
	ProductService productservice;

	@Autowired
	UserService userservice;

	@Autowired
	CategoryService categoryService;

	
	@GetMapping("/admin")
	public String AdminHomePage() {
		return "AdminHome";
	}

	@GetMapping("/admin/categories")
	public String categoriesPage(Model model) {
		model.addAttribute("categories", categoryService.GetAllCategory());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String Addcategories(Model model) {
		model.addAttribute("category", new Category());
		return "AddCategories";
	}

	@PostMapping("/admin/categories/add")
	public String Postcategories(@ModelAttribute("category") Category category) {
		categoryService.addcategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String DeleteCategories(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String UpadteCategories(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.UpdateCategoryById(id);
		model.addAttribute("category", category.get());
		return "AddCategories";
	}

//	product requests

	@GetMapping("/admin/products")
	public String ProductPage(Model model) {
		model.addAttribute("products", productservice.getAllProducts());
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String AddProductPage(Model model) {
		model.addAttribute("productDTO", new ProductDto());
		model.addAttribute("categories", categoryService.GetAllCategory());
		return "Addproducts";
	}

	@PostMapping("/admin/products/add")
	public String postProduct(@ModelAttribute("productDto") ProductDto productDTO, @RequestParam("productImage") MultipartFile file,
			@RequestParam("imgname")
	String imgname) throws IOException {
		Products product = new Products();
//		ProductDto PDto = new ProductDto();
//		add converter
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setCategory(categoryService.UpdateCategoryById(productDTO.getCategoryId()).get());
		String image;
		if (!file.isEmpty()) {
			image = file.getOriginalFilename();
			Path path = Paths.get(uploadDir, image);
			Files.write(path, file.getBytes());
			
		} else {
			image = imgname;
		}
		product.setImageName(image);
		productservice.addProducts(product);
		return "redirect:/admin/products";

	}

	@GetMapping("/admin/product/delete/{id}")
	public String DeleteProducts(@PathVariable int id) {
		productservice.RemoveProductById(id);
		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/update/{id}")
	public String UpdateProducts(@PathVariable int id, Model model) {

		Products product = productservice.GetProductById(id).get();
//		add converter
		ProductDto productDTO = new ProductDto();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setImageName(product.getImageName());

		model.addAttribute("categories", categoryService.GetAllCategory());
		model.addAttribute("productDTO", productDTO);
		System.out.println(productDTO);
		return "Addproducts";

	}
}
