package com.este.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Departement;
import com.este.service.DepartementService;
import com.este.service.EtudiantService;
import com.este.service.FiliereService;
import com.este.service.ProfesseurService;


@RequestMapping("/admin/accueil")
public class AccueilController {
	
	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private FiliereService filieretService;
	
	@Autowired
	private ProfesseurService professeurtService;
	
	@Autowired
	private EtudiantService etduainttService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Iterable<Departement> departement =  departementService.selectAll();
		
		long size = StreamSupport.stream(departement.spliterator(), false).count();
		modelMap.put("dept", size );

		return "Admin/auth/accueil";
	}

}
