package com.example.demo.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.productsandcategories.models.Category;
import com.example.demo.productsandcategories.models.Product;
import com.example.demo.productsandcategories.repositories.CategoryRepository;
import com.example.demo.productsandcategories.repositories.ProductRepository;



@Service
public class AppService {

    @Autowired
    ProductRepository productRepository;
    
    
    @Autowired
    CategoryRepository categoryRepository;
    
    
    
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    
    
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
    

    public Product createProduct(Product b) {
        return productRepository.save(b);
    }
    
    
    
    public Category createCategory(Category b) {
        return categoryRepository.save(b);
    }
    
    

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    
    
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    
    
    
    
    

public Product updateProduct(Long id,Product product) {
    	Product updated = findProduct(id);
	updated.setName(product.getName());
	updated.setDescription(product.getDescription());
	updated.setPrice(product.getPrice());
	productRepository.save(updated);
		return null;
	}


public Category updateCategory(Long id,Category category) {
	Category updated = findCategory(id);
updated.setName(category.getName());
categoryRepository.save(updated);
	return null;
}



    	
    

    public void deleteProduct(Long id) {
    	productRepository.deleteById(id);
    }
    
    

    public void deleteCategory(Long id) {
    	categoryRepository.deleteById(id);
    }

    
    
    public List<Category> categoriesNotInProduct(Product b){
    	return categoryRepository.findByProductsNotContains(b);
    }
    
    public List<Product> productsNotInCategory(Category b){
    	return productRepository.findByCategoriesNotContains(b);
    }
}
