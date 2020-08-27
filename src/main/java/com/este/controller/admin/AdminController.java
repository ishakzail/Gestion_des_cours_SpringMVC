package com.este.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.este.models.Admin;
import com.este.services.AdminService;


@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@RequestMapping(value="/home")
	public String index() {
		return "components/blank";
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(ModelMap model ) {
		 List<Admin> admin = adminService.selectAll();
	        return "Admin/login";
	 }
	
	 @RequestMapping(value = "/seconnecter", method = RequestMethod.POST)
	    public String loginProccess(ModelMap model , String email , String motdepass) {
		 Admin adm = new Admin();
		 if(adm.getEmail() == email && adm.getMotdepass() == motdepass ) {
			 return "redirect:/admin/home";
		 }else {
			 return "Admin/login";
		 }
	        
	 }
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(ModelMap model) {
	        return "Admin/login";
	}
	
}
