package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
	
	 @RequestMapping("/")
	public String index(HttpSession session, Model model){
		 if (session.getAttribute("count" )== null) {
			 session.setAttribute("count", 0);
		 }
		 else {
			 Integer counter = (Integer) session.getAttribute("count");
			 	counter++;
			 	session.setAttribute("count", counter);
		 }
		 
		return "index.jsp";
		}
	 
	 
	 @RequestMapping("/counter")
		public String counter(HttpSession session, Model model ){
		 Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			return "counter.jsp";
			}
}

