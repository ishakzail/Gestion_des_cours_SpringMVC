package com.este.controller.professeur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="professeur")
public class CourController {

	@RequestMapping(value="cour" ,method = RequestMethod.GET)
	public String list() {
		return "Professeur/cours/index";
		
	}
}
