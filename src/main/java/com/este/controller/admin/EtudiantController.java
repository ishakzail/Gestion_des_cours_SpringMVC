package com.este.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.este.models.Etudiant;
import com.este.models.Role;
import com.este.service.FiliereService;
import com.este.service.EtudiantService;

@Controller
@RequestMapping(value="admin")
public class EtudiantController {

	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private EtudiantService etudiantService;

	@RequestMapping(value="etudiants")
	public String index(ModelMap modelMap) {
		modelMap.put("etuds", etudiantService.selectAll());
		return "Admin/etudiants/index";
	}
	
	@RequestMapping(value="etudiant/ajouter", method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		Etudiant etud = new Etudiant();		
		modelMap.put("etud" , etud ); 
		modelMap.put("filiere" , filiereService.selectAll());
		
		return "Admin/etudiants/ajouter";
	}
	
	@RequestMapping(value="etudiant/enregister", method = RequestMethod.POST)
	public String enregister(ModelMap modelMap , @ModelAttribute("etudiant") Etudiant etudiant) throws IOException {
		etudiant.setRole_etudiant(new Role(3));
		etudiantService.save(etudiant);
		return "redirect:/admin/etudiants";
	}
	
	@RequestMapping(value="etudiant/modifier/{idEtud}",method = RequestMethod.GET)
	public String edit(@PathVariable("idEtud") int idEtud ,  ModelMap modelMap) {
		modelMap.put("filiere", filiereService.selectAll());
		 modelMap.put("etudiant", etudiantService.find(idEtud));
		 return "Admin/etudiants/modifier";
	}
	
	@RequestMapping(value="etudiant/modifier",method = RequestMethod.POST)
	public String edit(@ModelAttribute("etudiant") Etudiant etudiant) {
		etudiantService.save(etudiant);
		return "redirect:/admin/etudiants";
	}
	
	@RequestMapping(value="etudiant/supprimer/{idEtud}")
	public String supprimer( @PathVariable int idEtud ,  RedirectAttributes redirectAttribute) {
		try {
			etudiantService.delete(idEtud);
		}catch(Exception e) {
			redirectAttribute.addFlashAttribute("error" , "Deleted Failed");
		}
		return "redirect:/admin/etudiants";
	}
		
}
