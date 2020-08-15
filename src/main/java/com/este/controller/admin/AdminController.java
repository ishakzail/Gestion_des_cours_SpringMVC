package com.este.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="admin")
public class AdminController {

	@RequestMapping(value="/home")
	public String index() {
		return "components/blank";
	}
	
//	@RequestMapping(value="/profs")
//	public String getProfs() {
//		return "components/blank";
//	}
//	
//	@RequestMapping(value="/etudiants")
//	public String getEtudiants() {
//		return "components/blank";
//	}
	
	
}
