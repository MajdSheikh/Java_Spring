package com.example.demo.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.productsandcategories.models.Category;
import com.example.demo.productsandcategories.models.Product;



public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAll();
    List<Product> findByCategoriesNotContains(Category category);
}
