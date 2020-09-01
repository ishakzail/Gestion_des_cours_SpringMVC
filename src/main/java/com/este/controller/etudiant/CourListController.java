package com.este.controller.etudiant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Etudiant;
import com.este.models.Fichier;
import com.este.models.Professeur;
import com.este.service.CourService;
import com.este.service.EtudiantService;
import com.este.service.FichierService;

@Controller
@RequestMapping("etudiant")
public class CourListController {
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Autowired
	private CourService courService;
	
	@Autowired
	private FichierService fichierService;
	
	@RequestMapping(value="cours" ,method = RequestMethod.GET)
	public String list(ModelMap modelMap ) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		Etudiant etud = etudiantService.getByEmail(auth.getName());
		modelMap.put("prof", etud);
		modelMap.put("cours", courService.getAllCours());
		return "Etudiant/cours/index";
	}
	
	@RequestMapping(value = "cour/fichier/{id}",method = RequestMethod.GET)
	public String fichiersDeCour(@PathVariable("id") int id ,ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Etudiant etud = etudiantService.getByEmail(auth.getName());
		modelMap.put("etud", etud);
		modelMap.put("cour", courService.find(id));
		modelMap.put("fichier", fichierService.getFichiers());
		
		return "Etudiant/cours/listFichiers";
	}
	
	@RequestMapping(value="cour/fichier/telecharger/{idFic}" , method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> telecharger(@PathVariable int idFic){
		Fichier fiche = fichierService.getFile(idFic).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(fiche.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement:filename=\"" +fiche.getNom()+"\"")
				.body(new ByteArrayResource(fiche.getData()));
	}

}
