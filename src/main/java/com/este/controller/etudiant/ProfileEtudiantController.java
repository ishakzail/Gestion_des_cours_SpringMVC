package com.este.controller.etudiant;

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

import com.este.models.Etudiant;
import com.este.service.EtudiantService;

@Controller
@RequestMapping("/etudiant")
public class ProfileEtudiantController {
	
	@Autowired
	private EtudiantService etudiantService;
	

	@RequestMapping(value="/profile" , method = RequestMethod.GET)
	public String profile(ModelMap modelMap , @ModelAttribute("etudiant") Etudiant etudiant) {
		
		return "Etudiant/profile/index";
	}

}
