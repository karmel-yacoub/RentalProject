package com.codingdojo.rentproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.rentproject.models.Apartment;
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
	public String home(HttpSession session,Model model) {
		Long id=(Long)session.getAttribute("user.id");
		if (id == null) {
			return "home.jsp";
		}
		User user=ps.findUserById(id);
		model.addAttribute("user",user);
		return "home.jsp";
	}
	
	
	
	
	@RequestMapping("/single/{id}")
	public String single(Model model, @PathVariable("id") Long id) {
		model.addAttribute("apartment", ps.apartmentById(id));
		return "single.jsp";
	}
	
	
	
	@RequestMapping("/prop")
	public String prop(Model model) {
		model.addAttribute("Options", ps.allApartments());
		return "properties.jsp";
	}
	
	
	
	
	
	@RequestMapping("/agentsGrid")
	public String agentsGrid(Model model) {
		model.addAttribute("Agents", ps.allAgents());
		return "agents-grid.jsp";
	}
	
	
	
	@RequestMapping("/agentsGridone/{id}")
	public String agentsone(Model model , @PathVariable("id") Long id) {
		model.addAttribute("Agent", ps.userById(id));
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
	    	if(user.getPasswordConfirmation().equals(user.getPassword())) {
	    		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	            user.setImage(fileName);
	            User savedUser=ps.registerUser(user);
	            String uploadDir = "user-photos/" + savedUser.getId();
	            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	            session.setAttribute("user.id", user.getId());
	            return "redirect:/";
	        	}
	    	else
	    		return "redirect:/signup";
	    }
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	        // if the user is authenticated, save their user id in session
	        // else, add error messages and return the login page
	    	if(ps.authenticateUser(email, password)==true) {
	    		User user=ps.findByEmail(email);
	    		session.setAttribute("user.id", user.getId());
	    		return "redirect:/";
	    		
	    	}
	    	else {
	    		return "redirect:/login";
	    	}
	    }
	 @RequestMapping("/addapp")
	 public String addapp(@ModelAttribute ("Apartment") Apartment Apartment,Model model,HttpSession session) {
		 User user=ps.findUserById((Long)session.getAttribute("user.id"));
		 model.addAttribute("user",user);
		 return "addapp.jsp";
		 
	 }
	 @RequestMapping(value="/addapp",method=RequestMethod.POST)
	  public String addapp(@Valid @ModelAttribute("Apartment") Apartment Apartment, BindingResult result, HttpSession session, @RequestParam("Image") MultipartFile multipartFile) throws IOException {
		 
		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		 Apartment.setImage(fileName);
		 ps.createapp(Apartment);
         User savedUser=ps.findUserById((Long)session.getAttribute("user.id"));
         String uploadDir = "user-photos/" + savedUser.getId();
         FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		 return "redirect:/";
		 
	 }
}
