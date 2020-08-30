package com.este.controller.admin;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.este.models.Professeur;
import com.este.models.Role;
import com.este.service.DepartementService;
import com.este.service.FiliereService;
import com.este.service.ProfesseurService;

@Controller
@RequestMapping(value="admin")
public class ProfesseurController {
	
		@Autowired
		private DepartementService departementService;
		
		@Autowired
		private FiliereService filiereService;
		
		@Autowired
		private ProfesseurService professeurService;

		@RequestMapping(value="professeurs")
		public String index(ModelMap modelMap) {
			modelMap.put("profss", professeurService.selectAll());
			return "Admin/professeurs/index";
		}
		
		@RequestMapping(value="professeur/ajouter", method = RequestMethod.GET)
		public String ajouter(ModelMap modelMap) {
			Professeur prof = new Professeur();		
			modelMap.put("prof" , prof ); 
			modelMap.put("departement" , departementService.selectAll());
			modelMap.put("filiere" , filiereService.selectAll());
			
			return "Admin/professeurs/ajouter";
		}
		
		@RequestMapping(value="professeur/enregister", method = RequestMethod.POST)
		public String enregister(ModelMap modelMap , @ModelAttribute("professeur") Professeur professeur) throws IOException {
			String hashPass = new BCryptPasswordEncoder().encode(professeur.getMotdepass());
			professeur.setMotdepass(hashPass);
			professeur.setRole_prof(new Role(2));
			professeurService.save(professeur);
			return "redirect:/admin/professeurs";
		}
		
		@RequestMapping(value="professeur/modifier/{idProf}",method = RequestMethod.GET)
		public String edit(@PathVariable("idProf") int idProf ,  ModelMap modelMap) {
			modelMap.put("filiere", filiereService.selectAll());
			modelMap.put("departement", departementService.selectAll());
			 modelMap.put("professeur", professeurService.find(idProf));
			 return "Admin/professeurs/modifier";
		}
		
		@RequestMapping(value="professeur/modifier",method = RequestMethod.POST)
		public String edit(@ModelAttribute("professeur") Professeur professeur) {
			professeurService.save(professeur);
			return "redirect:/admin/professeurs";
		}
		
		@RequestMapping(value="professeur/supprimer/{idProf}")
		public String supprimer( @PathVariable int idProf ,  RedirectAttributes redirectAttribute) {
			try {
				professeurService.delete(idProf);
			}catch(Exception e) {
				redirectAttribute.addFlashAttribute("error" , "Deleted Failed");
			}
			return "redirect:/admin/professeurs";
		}
		
		
}
