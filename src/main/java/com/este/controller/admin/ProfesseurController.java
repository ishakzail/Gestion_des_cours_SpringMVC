package com.este.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Departement;
import com.este.models.Filiere;
import com.este.models.Professeur;
import com.este.services.DepartementService;
import com.este.services.FiliereService;
import com.este.services.ProfesseurService;

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
		public String index(Model model) {
			List<Professeur> profss = professeurService.selectAll();
			if(profss == null) {
				profss = new ArrayList<Professeur>();
			}
			model.addAttribute("profss", profss);
			return "Admin/professeurs/index";
		}
		
		@RequestMapping(value="professeur/ajouter", method = RequestMethod.GET)
		public String ajouter(Model model) {
			Professeur prof = new Professeur();
			List<Filiere> filiere = filiereService.selectAll();
			model.addAttribute("prof" , prof ); 
			model.addAttribute("departement" , departementService.selectAll());
			model.addAttribute("filiere" , filiere);
			
			return "Admin/professeurs/ajouter";
		}
		
		@RequestMapping(value="professeur/enregister", method = RequestMethod.POST)
		public String enregister(Model model , Professeur prof) throws IOException {
			
			if(prof != null) {
				if(prof.getIdProf() != null) {
					professeurService.update(prof);
				} else {
					professeurService.save(prof);
				}
			}
			return "redirect:/admin/professeurs";
		}
		
		@RequestMapping(value="professeur/modifier/{idProf}")
		public String modifier(Model model , @PathVariable Long idProf) {
			if(idProf != null) {
				
				List<Filiere> filiere = filiereService.selectAll();
				model.addAttribute("departement" , departementService.selectAll());
				model.addAttribute("filiere" , filiere);
				
				Professeur prof = professeurService.getById(idProf);
				if(prof != null) {
					model.addAttribute("prof" , prof);
				}
			}
			return "Admin/professeurs/ajouter";
		}
		
		@RequestMapping(value="professeur/supprimer/{idProf}")
		public String supprimer(Model model , @PathVariable Long idProf) {
			if(idProf != null) {
				Professeur prof = professeurService.getById(idProf);
				if(prof != null) {
					professeurService.remove(idProf);
				}
			}
			return "redirect:/admin/professeurs";
		}
		
}
