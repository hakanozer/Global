package com.calisma.daytwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncludeController {

	@RequestMapping(value = "/css", method = RequestMethod.GET)
	public String css() {
		return "inc/css";
	}
	
}
