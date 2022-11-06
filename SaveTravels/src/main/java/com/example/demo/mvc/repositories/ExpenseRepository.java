package com.example.demo.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.mvc.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
    List<Expense> findAll();
    List<Expense> findBynameContaining(String search);


}
