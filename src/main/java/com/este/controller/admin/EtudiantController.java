package com.este.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class EtudiantController {

		@RequestMapping(value="etudiants")
		public String index() {
			return("components/blank");
		}
		
		
}
