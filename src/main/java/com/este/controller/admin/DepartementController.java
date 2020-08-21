package com.este.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Departement;
import com.este.services.DepartementService;

@Controller
@RequestMapping(value="admin")
public class DepartementController {
	
	@Autowired
	private DepartementService departementService;

	@RequestMapping(value="departements")
	public String index(Model model) {
		List<Departement> departements = departementService.selectAll();
		if(departements == null) {
			departements = new ArrayList<Departement>();
		}
		model.addAttribute("departement", departements);
		return "Admin/departements/index";
	}
	
	@RequestMapping(value="departement/ajouter", method = RequestMethod.GET)
	public String ajouter(Model model) {
		Departement dept = new Departement();
		model.addAttribute("dept" , dept ); 
		
		return "Admin/departements/ajouter";
	}
	
	@RequestMapping(value="departement/enregister", method = RequestMethod.POST)
	public String enregister(Model model , Departement dept) throws IOException {
		
		if(dept != null) {
			if(dept.getIdDept() != null) {
				departementService.update(dept);
			} else {
				departementService.save(dept);
			}
		}
		return "redirect:/admin/departements";
	}
	
	@RequestMapping(value="departement/modifier/{idDept}")
	public String modifier(Model model , @PathVariable Long idDept) {
		if(idDept != null) {
			Departement dept = departementService.getById(idDept);
			if(dept != null) {
				model.addAttribute("dept" , dept);
			}
		}
		return "Admin/departements/ajouter";
	}
	
	@RequestMapping(value="departement/supprimer/{idDept}")
	public String supprimer(Model model , @PathVariable Long idDept) {
		if(idDept != null) {
			Departement dept = departementService.getById(idDept);
			if(dept != null) {
				departementService.remove(idDept);
			}
		}
		return "redirect:/admin/departements";
	}
}
