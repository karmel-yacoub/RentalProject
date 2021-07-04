package com.codingdojo.rentproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, @RequestParam("Image") MultipartFile multipartFile) throws IOException {
	        // if result has errors, return the registration page (don't worry about validations just now)
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
			System.out.println(user.getPassword()+user.getPasswordConfirmation());
	    	if(user.getPasswordConfirmation().equals(user.getPassword())) {
	    		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	            user.setImage(fileName);
	            User savedUser=ps.registerUser(user);
	            System.out.println(user.getImage());
	            String uploadDir = "user-photos/" + savedUser.getId();
	            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	            session.setAttribute("user.id", user.getId());
	            return "redirect:/";
	        	}
	    	else
	    		return "redirect:/signup";
	    }

}
