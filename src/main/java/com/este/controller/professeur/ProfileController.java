package com.este.controller.professeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Professeur;
import com.este.service.ProfesseurService;

@Controller
@RequestMapping("/professeur")
public class ProfileController {
	
	@Autowired
	private ProfesseurService professeurService;
	

	@RequestMapping(value="/profile" , method = RequestMethod.GET)
	public String profile(ModelMap modelMap , @ModelAttribute("professeur") Professeur professeur) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);

		return "Professeur/profile/index";
	}

}
