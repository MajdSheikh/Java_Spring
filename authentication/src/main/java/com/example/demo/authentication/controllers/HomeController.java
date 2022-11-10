package com.example.demo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.authentication.models.LoginUser;
import com.example.demo.authentication.models.User;
import com.example.demo.authentication.services.UserService;

@Controller
public class HomeController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model , HttpSession session) {
	 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
	 
	 if (session.getAttribute("user_id") != null) {		
 		return "redirect:/";					
 	}
 	
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "loginAndReg.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {

	  userServ.register(newUser, result);
     if(result.hasErrors()) {

         model.addAttribute("newLogin", new LoginUser());
         return "loginAndReg.jsp";
     }
     
     // TO-DO Later: Store their ID from the DB in session, 
     session.setAttribute("user_id", newUser.getId());
     return "redirect:/success";
 }
 
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
     // User user = userServ.login(newLogin, result);
	 	User user = userServ.login(newLogin, result);
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "loginAndReg.jsp";
     }

     // Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("user_id", user.getId());
     return "redirect:/success";
 }
 
 
 
 @GetMapping("/success")
 public String home(Model model, HttpSession session) {
     if (session.getAttribute("user_id") != null) {
     Long user_id = (Long) session.getAttribute("user_id");
     User thisUser = userServ.findUserById(user_id);
     model.addAttribute("thisUser", thisUser);
     return "success.jsp";
 }
     else {
         return "redirect:/";
     }
 }
 
 
 @GetMapping("/logout")
 public String logout(HttpSession session) { 
         session.invalidate();
         return "redirect:/";

 }
 
 

 
}
