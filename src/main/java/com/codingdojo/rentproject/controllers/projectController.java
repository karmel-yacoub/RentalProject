package com.codingdojo.rentproject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.rentproject.models.Role;
import com.codingdojo.rentproject.models.User;
import com.codingdojo.rentproject.services.projectservice;

@Controller
public class projectController {
	private final projectservice ps;
	
	public projectController(projectservice ps) {
		this.ps = ps;
	}
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
	
	
	@RequestMapping("/single")
	public String single() {
		return "single.jsp";
	}
	
	
	
	@RequestMapping("/prop")
	public String prop() {
		return "properties.jsp";
	}
	
	
	
	
	
	@RequestMapping("/agentsGrid")
	public String agentsGrid() {
		return "agents-grid.jsp";
	}
	
	
	
	@RequestMapping("/agentsGridone")
	public String agentsone() {
		return "agents_single.jsp";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact.jsp";
	}
	@RequestMapping("/signup")
	public String Register(Model model,@ModelAttribute("user") User User) {
		List<Role> x=ps.allRoles();
		model.addAttribute("x",x);
		return "signup.jsp";
	}

}
