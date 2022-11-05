package com.example.demo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mvc.models.Book;
import com.example.demo.mvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
}
