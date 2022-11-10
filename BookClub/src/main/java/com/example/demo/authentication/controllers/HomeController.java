package com.example.demo.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.authentication.models.Book;
import com.example.demo.authentication.models.LoginUser;
import com.example.demo.authentication.models.User;
import com.example.demo.authentication.services.BookService;
import com.example.demo.authentication.services.UserService;

@Controller
public class HomeController {
 
 // Add once service is implemented:
  @Autowired
  private UserService userServ;
  
  
  @Autowired
  private BookService bookService; 
 
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
     return "redirect:/home";
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
     return "redirect:/home";
 }
 
 
 
 @GetMapping("/home")
 public String home(Model model, HttpSession session) {
     if (session.getAttribute("user_id") != null) {
    	 // if the session had a user in it, get this user by its id (through using the service method), 
    	 // and get the list of books (also though the service method)
     Long user_id = (Long) session.getAttribute("user_id");
     
     User thisUser = userServ.findUserById(user_id);
     model.addAttribute("thisUser", thisUser);
     
     List<Book> books = bookService.allBooks();
 	 model.addAttribute("books", books);
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
 
 
 @GetMapping("/books/new")
 public String newBook(Model model, HttpSession session) {
	 // this method is for creating a new book
	 // get an empty book object 
 	model.addAttribute("book", new Book());
 	// and find the user by its id in the session
 	User user = userServ.findUserById((Long)session.getAttribute("user_id"));
 	// there must be an attribute of a user in all the pages, 
 	//so in all getMapping methods i need to add the following line
 	model.addAttribute("user", user);
 	return "NewBook.jsp";
 }
 
 @PostMapping("/books/create")
 public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
 	if(result.hasErrors()) {
 		return "NewBook.jsp";
 	} else {
 		bookService.createBook(book);
 		return "redirect:/home";
 	}
 }
 
 
 @GetMapping("/books/{id}/view")
 public String showBook(Model model, HttpSession session, @PathVariable("id") Long id) {
	 // in order to show the book's details, id need to get the book by its id using the service method
	 Book book = bookService.findBook(id);
 	model.addAttribute("book", book);
 	User user = userServ.findUserById((Long)session.getAttribute("user_id"));
 	model.addAttribute("user", user);
 	return "ViewBook.jsp";
	 
 }
 
 @GetMapping("/books/{id}/edit")
 public String editBook(Model model, HttpSession session, @PathVariable("id") Long id) {
	 Book book = bookService.findBook(id);
	 model.addAttribute("book", book);
	 User user = userServ.findUserById((Long)session.getAttribute("user_id"));
	 model.addAttribute("user", user);
	 return "editBook.jsp";
	 
 }


 @PutMapping("/books/{id}/update")
 public String updateBook(@PathVariable("id") Long id, HttpSession session, Model model,
		 @Valid @ModelAttribute("book") Book book, BindingResult result) {
	 	if(result.hasErrors()) {
	 		return "editBook.jsp";
	 	}
	 	else {
	 		bookService.updateBook(book);
	 		return "redirect:/home";
	 	}
 }
   	
 
 @DeleteMapping("/books/{id}/delete")
 public String deleteBook(@PathVariable("id") Long id) {
	 bookService.deleteBook(id);
	 return "redirect:/home";
 }
 
 

 
 }
 

 
 
 

 

