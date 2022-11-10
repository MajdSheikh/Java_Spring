package com.example.demo.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.project.models.LoginUser;
import com.example.demo.project.models.User;
import com.example.demo.project.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult results, Model model, HttpSession session,
            RedirectAttributes redirectAttributes) {
        
        
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	results.rejectValue("confirm", "Matches", "Password Must Match Confirmation");
        }
        
        if(userService.getUserByEmail(newUser.getEmail()) != null) {
        	results.rejectValue("email", "Email", "The Email Address Already Exists");
        }
        
        if(results.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            redirectAttributes.addFlashAttribute("message", "Registration Could Not Be Completed");
            return "index.jsp";
        }
        
        userService.createUser(newUser);
    	session.setAttribute("userId", newUser.getId());
        
        redirectAttributes.addFlashAttribute("message", "Thank You For Registering");
        
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            model.addAttribute("message", "Invalid User");
            return "index.jsp";
        }
    
    	User user = userService.authenticate(newLogin);
    	if(user == null) {
            model.addAttribute("message", "Invalid User");
    		return "redirect:/";
    	}
     
    	session.setAttribute("userId", user.getId());
        redirectAttributes.addFlashAttribute("message", "Welcome Back");
        
        return "redirect:/dashboard";
    }	
	
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	return "redirect:/";
    }
    
	

}