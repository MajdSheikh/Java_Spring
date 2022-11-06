package com.example.demo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mvc.models.Expense;
import com.example.demo.mvc.services.ExpenseService;

@Controller
public class ExpenseController {
	
	
	// we need to add these lines in the controller to take methods from the Service file
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService =  expenseService;
	}
	 
	 @GetMapping("/expenses")
	    public String newBook(@ModelAttribute("expense") Expense expense, Model model) {
		 model.addAttribute("expenses", expenseService.allExpenses());
	        return "index.jsp";
	    }
	 
	 
	    @PostMapping("/expenses")
	    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/index.jsp";
	        } else {
	        	expenseService.createExpense(expense);
	            return "redirect:/expenses";
	        }
	    }
}
