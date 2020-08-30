package com.este.controller.professeur;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;


@Controller 	
@RequestMapping("professeur-panel")
public class LoginProfesseurController {
	
	
	
	@RequestMapping(value = {"" , "acc"} , method = RequestMethod.GET)
	public String index() {
		return "redirect:/professeur-panel/login";
	}
	
	@RequestMapping(value = "login" , method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error" , required = false) String error ,
			@RequestParam(value = "logout" , required = false) String logout ,
			ModelMap modelMap) {
		
		if(error != null) {
			
			modelMap.put("msg" , "Invalid email or password");	
		}
		if(logout != null) {
			modelMap.put("msg" , "Logout Seccussfully");
		}
		
		return "Professeur/auth/login";
	}
	
	
	@RequestMapping( value="process" , method = RequestMethod.GET)
	public String process() {
		return "redirect:/professeur/accueil";
	}
	

	@RequestMapping( value="logout" , method = RequestMethod.GET)
	public String logout() {
		return "redirect:/professeur-panel/login?logout";
	}
	
	
	@RequestMapping( value="accessDenied" , method = RequestMethod.GET)
	public String accessDenied(Authentication authentication , ModelMap modelMap) {
		if(authentication != null) {
			modelMap.put("msg" , "Bonjour" + authentication.getName() + ", vous n'avez pas la permission");
		}else {
			modelMap.put("msg", "Vous n'avez pas la permission pour cette page!");
		}
		return "Admin/accessDenied";
	}
	
	@RequestMapping( value="welcome" , method = RequestMethod.GET)
	public String welcome() {
		return "redirect:/professeur/accueil";
	}
	
	
}
