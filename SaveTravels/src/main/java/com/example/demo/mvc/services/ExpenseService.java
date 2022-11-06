package com.example.demo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mvc.models.Expense;
import com.example.demo.mvc.repositories.ExpenseRepository;


@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    //repository interface as a dependency
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    
    // creates an expense
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    
    //update a certain expense (that we get by its id), it takes 
    public Expense updateExpense(Long id, String name, String vendor, Integer amount , String description) {
    	Optional<Expense> optionalExpense = expenseRepository.findById(id);
    	if(optionalExpense.isPresent()) {
    		Expense expense = optionalExpense.get();
    		expense.setName(name);
    		expense.setVendor(vendor);
    		expense.setDescription(description);
    		expense.setAmount(amount);
    		return expenseRepository.save(expense);
    	}
    	else {
    		return null;
    	}
    	
    }
    
    // delete expense by its id
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
    
    
    
}
