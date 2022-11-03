package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OmikujiForm {

	@RequestMapping("/omikuji")
	public String index() {

		return "OmikujiForm.jsp";
	}
	
	
	@PostMapping("/omikuji/show")
	public String process(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="nice") String nice,
			HttpSession session) {
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("livingThing", livingThing);
			session.setAttribute("nice", nice);
			return "redirect:/show";
	}
	@RequestMapping("/show")
	public String show(HttpSession session, Model model){
		
	    
	    // get any info needed out of session and add to the
	    // view model to render on the page.
	       

	    return "show.jsp";
	}

}
