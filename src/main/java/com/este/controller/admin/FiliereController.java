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


import com.este.models.Filiere;
import com.este.service.DepartementService;
import com.este.service.FiliereService;

@Controller
@RequestMapping(value="admin")
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private DepartementService departementService;
	
	@RequestMapping(value="filieres")
	public String index(ModelMap modelMap) {
		modelMap.put("fils", filiereService.selectAll());
		return "Admin/filieres/index";
	}
	
	
	@RequestMapping(value="filiere/ajouter", method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		Filiere filiere = new Filiere();
		modelMap.put("filiere" , filiere ); 
		modelMap.put("departement" , departementService.selectAll());
		return "Admin/filieres/ajouter";
	}
	
	@RequestMapping(value="filiere/enregister", method = RequestMethod.POST)
	public String enregister(ModelMap modelMap , @ModelAttribute("filiere") Filiere filiere ) throws IOException {
		filiereService.save(filiere);
		return "redirect:/admin/filieres";
	}
	
	@RequestMapping(value="filiere/modifier/{idFil}",method = RequestMethod.GET)
	public String edit(@PathVariable("idFil") int idFil ,  ModelMap modelMap) {
		modelMap.put("departement", departementService.selectAll());
		 modelMap.put("filiere", filiereService.find(idFil));
		 return "Admin/filieres/modifier";
	}
	
	@RequestMapping(value="filiere/modifier",method = RequestMethod.POST)
	public String edit(@ModelAttribute("filiere") Filiere filiere) {
		filiereService.save(filiere);
		return "redirect:/admin/filieres";
	}
	
	@RequestMapping(value="filiere/supprimer/{idFil}")
	public String supprimer( @PathVariable int idFil ,  RedirectAttributes redirectAttribute) {
		try {
			filiereService.delete(idFil);
		}catch(Exception e) {
			redirectAttribute.addFlashAttribute("error" , "Deleted Failed");
		}
		return "redirect:/admin/filieres";
	}
	
	

}
