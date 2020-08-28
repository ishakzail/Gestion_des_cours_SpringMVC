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
	
}
