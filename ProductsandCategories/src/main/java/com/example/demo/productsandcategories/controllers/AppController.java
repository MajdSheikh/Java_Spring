package com.example.demo.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.productsandcategories.models.Category;
import com.example.demo.productsandcategories.models.Product;
import com.example.demo.productsandcategories.services.AppService;



@Controller
public class AppController {
	
	@Autowired
	 AppService appService;
	
	
	
	
	@GetMapping("/")
    public String dashboard( Model model) {
		
		List<Product> product = appService.allProducts();
		model.addAttribute("products", product);
		
		List<Category> category = appService.allCategories();
		model.addAttribute("categories", category);
		
        return "index.jsp";
    }
	
	@GetMapping("/products/new")
	public String product(@ModelAttribute("product") Product product) {
		return "products.jsp";
	}
	
	@PostMapping("/products/new")
	public String products(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "products.jsp";
		}
		else {
			appService.createProduct(product);
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/categories/new")
	public String category(@ModelAttribute("category") Category category) {
		return "categories.jsp";
	}
	
	@PostMapping("/categories/new")
	public String categories(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		if(result.hasErrors()) {
			return "categories.jsp";
		}
		else {
			appService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@GetMapping("/products/{productId}")
	public String show1(@PathVariable("productId") Long id, Model model) {
		Product product = appService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", appService.categoriesNotInProduct(product));
		return "showProduct.jsp";
	}
	
	@PostMapping("/products/addcategory")
	public String addcat(@RequestParam("product") Long id1, @RequestParam("category") Long id2) {
		Product product1 = appService.findProduct(id1);
		Category category1 = appService.findCategory(id2);
		List<Category> product1Categories = product1.getCategories();
		product1Categories.add(category1);
		product1.setCategories(product1Categories);
		appService.updateProduct(id1, product1);
		return "redirect:/";
	}
	
	@GetMapping("/categories/{categorytId}")
	public String show2(@PathVariable("categorytId") Long id, Model model) {
		Category category = appService.findCategory(id);
		model.addAttribute("category", category);
		
		model.addAttribute("products", appService.productsNotInCategory(category));
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/addproduct")
	public String addpro(@RequestParam("category") Long id1, @RequestParam("product") Long id2) {
		Product product1 = appService.findProduct(id1);
		Category category1 = appService.findCategory(id2);
		List<Product> category1Products = category1.getProducts();
		category1Products.add(product1);
		category1.setProducts(category1Products);
		appService.updateCategory(id2, category1);
		return "redirect:/";
	}
	
	

}
