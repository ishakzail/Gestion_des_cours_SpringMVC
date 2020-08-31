package com.este.controller.professeur;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Cour;
import com.este.models.Professeur;
import com.este.service.CourService;
import com.este.service.DepartementService;
import com.este.service.FiliereService;
import com.este.service.ProfesseurService;


@Controller
@RequestMapping(value="professeur")
public class CourController {
	
	@Autowired
	private CourService courService;
	
	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private FiliereService filieretService;
	
	@Autowired
	private ProfesseurService professeurtService;

	@RequestMapping(value="cours" ,method = RequestMethod.GET)
	public String list(ModelMap modelMap , @ModelAttribute Professeur professeur ) {
		
		
		
		 Iterable<Cour> cours = courService.selectAll();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	
        
		//	 System.out.println("cours size :" + profs.size());
		
		 // modelMap.put("cours", courService.selectAll());		
//		System.out.println("id prof :"+ profs);
			//  modelMap.put("profss", profss);
			 
		// modelMap.put("cours", profs);
		
		modelMap.put("cours", cours);
		return "Professeur/cours/index";
	}
	
	@RequestMapping(value="cour/ajouter" , method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		return "Professeur/cours/ajouter";
	}
}
