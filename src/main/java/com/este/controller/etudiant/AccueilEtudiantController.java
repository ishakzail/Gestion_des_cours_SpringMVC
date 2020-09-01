package com.este.controller.etudiant;

import java.util.HashMap;
import java.util.List;
import java.util.stream.StreamSupport;


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
import com.este.models.Departement;
import com.este.models.Etudiant;
import com.este.service.CourService;
import com.este.service.DepartementService;
import com.este.service.EtudiantService;
import com.este.service.FiliereService;
import com.este.service.EtudiantService;



@Controller
@RequestMapping("/etudiant")
public class AccueilEtudiantController {
	
	@Autowired
	private CourService courService;
	
	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private FiliereService filieretService;
	
	@Autowired
	private EtudiantService etudiantService;

	
	@RequestMapping(value="/accueil",method = RequestMethod.GET)
	public String index(ModelMap modelMap ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Etudiant etud = etudiantService.getByEmail(auth.getName());
		
		System.out.println("etudiant x :" + etud.getNom());
		
		modelMap.put("etud", etud);
		
		return "Etudiant/auth/accueil";
	}
	
	
	
	

}
