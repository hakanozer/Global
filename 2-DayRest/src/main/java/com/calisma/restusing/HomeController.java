package com.calisma.restusing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		//ModelAndView model = new ModelAndView("page");
		//model.addObject("data", "send data");
		return "send data";
	}
	
}
