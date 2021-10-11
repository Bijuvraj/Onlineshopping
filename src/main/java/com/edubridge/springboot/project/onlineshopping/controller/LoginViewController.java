package com.edubridge.springboot.project.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edubridge.springboot.project.onlineshopping.entities.Login;
import com.edubridge.springboot.project.onlineshopping.service.LoginService;


@Controller
public class LoginViewController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/")
	public String viewIndexPage(Model model) {
		List<Login>loginList=loginService.getAllLogin();
		model.addAttribute("loginList",loginList);
		return "login";
	}
	@RequestMapping("/registration")
	public String viewNewLoginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login",login);
		return "registration";
	}
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	//@PostMapping("/save")
	public String saveLogin(@ModelAttribute("login")Login login) {
		loginService.saveLogin(login);
		return"redirect:/";
	}*/
	/*@RequestMapping("/edit/{id}")
	public ModelAndView showEditLoginPage(@PathVariable(name="id")int id) {
		ModelAndView mav=new ModelAndView("edit_login");
		Department derpartment=departmentService.getDepartmentByid(id);
		mav.addObject("department", derpartment);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable(name="id")int id) {
		departmentService.deleteDepartment(id);
		return "redirect:/";
		
	}*/
}


