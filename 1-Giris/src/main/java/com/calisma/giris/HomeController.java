package com.calisma.giris;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeController call");
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model, Date dt) {
		
		System.out.println("home fnc call");
		model.addAttribute("serverTime", "Giden Data" );
		
		return "home";
	}
	
}
