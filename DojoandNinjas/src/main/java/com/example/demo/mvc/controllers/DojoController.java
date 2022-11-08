package com.example.demo.mvc.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mvc.models.Dojo;
import com.example.demo.mvc.services.DojoService;



@Controller
public class DojoController {
	
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService =  dojoService;
	}
	
	@GetMapping("/dojos/new")
    public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
	 model.addAttribute("dojos", dojoService.allDojos());
        return "index.jsp";
    }
	
	
	
	   @PostMapping("/dojos/new")
	   public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	      if (result.hasErrors()) {
	          return "/index.jsp";
	      } else {
	          dojoService.createDojo(dojo);
	          return "redirect:/ninjas/new";
	        }
	    }
	
	
	
}
