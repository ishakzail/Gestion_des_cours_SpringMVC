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

import com.este.models.Filiere;
import com.este.services.DepartementService;
import com.este.services.FiliereService;

@Controller
@RequestMapping(value="admin")
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private DepartementService departementService;
	
	@RequestMapping(value="filieres")
	public String index(Model model) {
		List<Filiere> fils = filiereService.selectAll();
		if(fils == null) {
			fils = new ArrayList<Filiere>();
		}
		model.addAttribute("fils", fils);
		return "Admin/filieres/index";
	}
	
	
	@RequestMapping(value="filiere/ajouter", method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		Filiere fils = new Filiere();
		modelMap.put("fils" , fils ); 
		modelMap.put("departement" , departementService.selectAll());
		return "Admin/filieres/ajouter";
	}
	
	@RequestMapping(value="filiere/enregister", method = RequestMethod.POST)
	public String enregister(Model model , Filiere fil) throws IOException {
		
		if(fil != null) {
			if(fil.getIdFil() != null) {
				filiereService.update(fil);
			} else {
				filiereService.save(fil);
			}
		}
		return "redirect:/admin/filieres";
	}
	
	@RequestMapping(value="filiere/modifier/{idFil}")
	public String modifier(Model model , @PathVariable Long idFil ) {
		if(idFil != null) {
			Filiere fils = filiereService.getById(idFil);
			model.addAttribute("departement", departementService.selectAll());
			if(fils != null) {
				model.addAttribute("fils" , fils);
				
			}
		}
		return "Admin/filieres/ajouter";
	}
	
	@RequestMapping(value="filiere/supprimer/{idFil}")
	public String supprimer(Model model , @PathVariable Long idFil) {
		if(idFil != null) {
			Filiere fils = filiereService.getById(idFil);
			if(fils != null) {
				filiereService.remove(idFil);
			}
		}
		return "redirect:/admin/filieres";
	}
	
	

}
