package com.example.demo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    
	    @GetMapping("/expenses/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Expense expense = expenseService.findExpense(id);
	        model.addAttribute("expense", expense);
	        return "edit.jsp";
	    }
	    
	    
	    @PutMapping("/expenses/{id}")
	    public String update(@Valid @ModelAttribute("expenses") Expense expense,@PathVariable("id") Long id, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	expenseService.updateExpense(id,expense);
	            return "redirect:/expenses";
	        }
	    }
	    
	    
	    @DeleteMapping("/expenses/{id}")
	    public String destroy(@PathVariable("id") Long id) {
	    	expenseService.deleteExpense(id);
	        return "redirect:/expenses";
	    }
	    
	    @RequestMapping("/expenses/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
	    	Expense expense = expenseService.findExpense(id);
			model.addAttribute("expense", expense);
			return "show.jsp";
		}

	    
	    
}
