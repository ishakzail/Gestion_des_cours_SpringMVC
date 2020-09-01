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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.este.models.Cour;
import com.este.models.Departement;
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
	private ProfesseurService professeurService;

	@RequestMapping(value="cours" ,method = RequestMethod.GET)
	public String list(ModelMap modelMap ) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);
		modelMap.put("cours", courService.selectAll(prof));
		return "Professeur/cours/index";
	}
	
	@RequestMapping(value="cour/ajouter" , method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);
		Cour cour = new Cour();
		modelMap.put("cour" , cour ); 
		return "Professeur/cours/ajouter";
	}
	
	@RequestMapping(value="cour/enregister" , method = RequestMethod.POST)
	public String enregister(ModelMap modelMap , @ModelAttribute("cour") Cour cour) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);
		cour.setProf(prof);
		courService.save(cour);
		return "redirect:/professeur/cours";
	}
	
	@RequestMapping(value="cour/modifier/{idCour}",method = RequestMethod.GET)
	public String edit(@PathVariable("idCour") int idCour ,  ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName()); 
		modelMap.put("prof", prof);
		modelMap.put("cour" , courService.find(idCour));
		 return "Professeur/cours/modifier";
	}
	
	@RequestMapping(value="cour/modifier",method = RequestMethod.POST)
	public String edit(@ModelAttribute("cour") Cour cour) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		cour.setProf(prof);
		courService.save(cour);
		return "redirect:/professeur/cours";
	}
	
	@RequestMapping(value="cour/supprimer/{idCour}")
	public String supprimer( @PathVariable int idCour ,  RedirectAttributes redirectAttribute) {
		try {
			courService.delete(idCour);
		}catch(Exception e) {
			redirectAttribute.addFlashAttribute("error" , "Problème lors de la suppression !!");
		}
		return "redirect:/professeur/cours";
	}
}
