package com.este.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class FiliereController {
	
	@RequestMapping(value="filieres")
	public String index() {
		return("Admin/filiere/index");
	}
	
	@RequestMapping(value="filiere/ajouter")
	public String Ajouter() {
		return("Admin/filiere/ajouter");
	}
	
	@RequestMapping(value="filiere/modifier")
	public String modifier() {
		return("Admin/filiere/modifier");
	}

}
