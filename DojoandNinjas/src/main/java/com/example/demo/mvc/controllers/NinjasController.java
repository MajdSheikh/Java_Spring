package com.example.demo.mvc.controllers;

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

import com.example.demo.mvc.models.Dojo;
import com.example.demo.mvc.models.Ninjas;
import com.example.demo.mvc.services.DojoService;
import com.example.demo.mvc.services.NinjasService;

@Controller
public class NinjasController {
	

	@Autowired
	 DojoService dojoService;
	
	private final NinjasService ninjasService;
	public NinjasController(NinjasService ninjasService) {
		this.ninjasService = ninjasService;
	}
	

	
	
	@GetMapping("/ninjas/new")
    public String ninjas(@ModelAttribute("ninja") Ninjas ninjas, Model model) {
		
		List<Dojo> dojo = dojoService.allDojos();
		model.addAttribute("dojo", dojo);
		
        return "ninjasIndex.jsp";
    }
	
	@PostMapping("/ninjas/new")
	public String create(@Valid @ModelAttribute("ninjas") Ninjas ninjas, BindingResult result, Model model) {
	   if (result.hasErrors()) {
		   model.addAttribute("dojo", dojoService.allDojos());
	       return "ninjasIndex.jsp";
	   } 
	   else {
	       ninjasService.createNinjas(ninjas);
	       return "redirect:/ninjas/new";
	     }
	 }
	
	
	@GetMapping("/dojos/{dojoId}")
	public String show(Model model, @PathVariable(value="dojoId") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
}



