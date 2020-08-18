package com.este.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class ProfesseurController {

		@RequestMapping(value="profs")
		public String index() {
			return("Admin/professeurs/index");
		}
		
		@RequestMapping(value="profs/ajouter")
		public String Ajouter() {
			return("Admin/professeurs/ajouter");
		}
		
		@RequestMapping(value="profs/modifier")
		public String modifier() {
			return("Admin/professeurs/modifier");
		}
		
		
}
