package com.este.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.este.models.Departement;
import com.este.service.DepartementService;

@Controller
@RequestMapping(value="admin")
public class DepartementController {
	
	@Autowired
	private DepartementService departementService;

	@RequestMapping(value="departements" , method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("departement", departementService.selectAll());
		return "Admin/departements/index";
	}
	
	@RequestMapping(value="departement/ajouter", method = RequestMethod.GET)
	public String ajouter(ModelMap modelMap) {
		Departement dept = new Departement();
		modelMap.put("dept" , dept ); 
		return "Admin/departements/ajouter";
	}
	
	@RequestMapping(value="departement/enregister", method = RequestMethod.POST)
	public String enregister(Model model , @ModelAttribute("departement") Departement departement ) throws IOException {
		departementService.save(departement);
		return "redirect:/admin/departements";
	}
	
	@RequestMapping(value="departement/modifier/{idDept}",method = RequestMethod.GET)
	public String edit(@PathVariable("idDept") int idDept , ModelMap modelMap) {
		 modelMap.put("departement", departementService.find(idDept));
		 return "Admin/departements/modifier";
	}
	
	@RequestMapping(value="departement/modifier",method = RequestMethod.POST)
	public String edit(@ModelAttribute("departement") Departement departement) {
		departementService.save(departement);
		return "redirect:/admin/departements";
	}
	
	
	@RequestMapping(value="departement/supprimer/{idDept}")
	public String supprimer( @PathVariable int idDept ,  RedirectAttributes redirectAttribute) {
		try {
			departementService.delete(idDept);
		}catch(Exception e) {
			redirectAttribute.addFlashAttribute("error" , "Deleted Failed");
		}
		return "redirect:/admin/departements";
	}
	
}
