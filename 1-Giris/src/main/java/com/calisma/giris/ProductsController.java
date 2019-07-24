package com.calisma.giris;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {
	
	ArrayList<String> ls = new ArrayList<String>();
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model) {
		ls.add("Ali");
		ls.add("Veli");
		ls.add("Serkan");
		model.addAttribute("data", "Send To Data");
		model.addAttribute("ls", ls);
		return "products";
	}
	

}
