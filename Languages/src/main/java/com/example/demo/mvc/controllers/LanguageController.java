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

import com.example.demo.mvc.models.Language;
import com.example.demo.mvc.services.LanguageService;



@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService =  languageService;
	}
	
	@GetMapping("/languages")
    public String newLanguage(@ModelAttribute("language") Language language, Model model) {
	 model.addAttribute("languages", languageService.allLanguages());
        return "index.jsp";
    }
 
 
    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    
    @GetMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    
    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("languages") Language language,@PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(id,language);
            return "redirect:/languages";
        }
    }
    
    
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    @RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
    
    
}
