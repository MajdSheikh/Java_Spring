package com.example.demo;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NinjaGoldController {
	@RequestMapping("/gold")
	public String index(HttpSession session) {

		

		return "NinjaGold.jsp";
	}
}
