package com.este.controller.professeur;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.este.models.Cour;
import com.este.models.Fichier;
import com.este.models.Professeur;
import com.este.service.CourService;
import com.este.service.FichierService;
import com.este.service.ProfesseurService;

@Controller
@RequestMapping("professeur")
public class FichierController {
	
	private ServletContext servletContext;
	
	@Autowired
	private CourService courService;
	
	@Autowired
	private FichierService fichierService;
	
	@Autowired
	private ProfesseurService professeurService;
	
	@RequestMapping(value = "cour/fichier/{id}",method = RequestMethod.GET)
	public String fichiersDeCour(@PathVariable("id") int id ,ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);
		modelMap.put("cour", courService.find(id));
		modelMap.put("fichier", fichierService.getFichiers());
		
		return "Professeur/fichier/index";
	}

	@RequestMapping(value = "fichier/ajouter/{id}",method = RequestMethod.GET)
	public String add(@PathVariable("id") int id , ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Professeur prof = professeurService.getByEmail(auth.getName());
		modelMap.put("prof", prof);
		Cour cour = courService.find(id);
		Fichier fichier = new Fichier();
		fichier.setCour(cour);
		modelMap.put("fichier", fichier); 
		modelMap.put("cour", cour);
		return "Professeur/fichier/ajouter";
	}
	
	@RequestMapping(value = "fichier/enregister", method = RequestMethod.POST )
	public String enregistrer(@ModelAttribute("fichier") Fichier fichier,
			@RequestParam(value="file") MultipartFile file){
		String ficheNom = file.getOriginalFilename();
		try {
			Fichier fiche = new Fichier( file.getBytes(), ficheNom , fichier.getCour() , file.getContentType());
			fichierService.save(fiche);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/professeur/cour/fichier/" + fichier.getCour().getIdCour();
	}
	
	@RequestMapping(value = "fichier/supprimer/{idFic}/{idCour}",method = RequestMethod.GET)
	public String supprimer(@PathVariable("idFic") int idFic , @PathVariable("idCour") int idCour ) {
		fichierService.delete(idFic);
		return "redirect:/professeur/cour/fichier/" + idCour ;
	}
	
	
	

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext ;
		
	}
	
}
