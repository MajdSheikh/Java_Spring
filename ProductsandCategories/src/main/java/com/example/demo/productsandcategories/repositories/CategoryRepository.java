package com.example.demo.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.productsandcategories.models.Category;
import com.example.demo.productsandcategories.models.Product;


public interface CategoryRepository  extends CrudRepository<Category, Long>{
    List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
