package com.codingdojo.rentproject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.weaver.loadtime.Agent;
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
		model.addAttribute("States", ps.allStates());
		return "home.jsp";
	}
	
	
	
	
	@RequestMapping("/single/{id}")
	public String single(Model model, @PathVariable("id") Long id,HttpSession session) {
		model.addAttribute("apartment", ps.apartmentById(id));
		model.addAttribute("States", ps.allStates());
		return "single.jsp";
	}
	
	
	
	@RequestMapping("/prop")
	public String prop(Model model,HttpSession session) {
		model.addAttribute("Options", ps.allApartments());
		model.addAttribute("States", ps.allStates());
		return "properties.jsp";
	}
	
	
	
	
	
	@RequestMapping("/agentsGrid")
	public String agentsGrid(Model model,HttpSession session) {
		model.addAttribute("Agents", ps.allAgents());
		model.addAttribute("States", ps.allStates());
		return "agents-grid.jsp";
	}
	
	
	
	@RequestMapping("/agentsGridone/{id}")
	public String agentsone(Model model , @PathVariable("id") Long id,HttpSession session) {
		model.addAttribute("Agent", ps.userById(id));
		model.addAttribute("States", ps.allStates());
		return "agents_single.jsp";
	}
	
	@RequestMapping("/contact")
	public String contact(HttpSession session,Model model) {
		return "contact.jsp";
	}
	@RequestMapping("/signup")
	public String Register(Model model,@ModelAttribute("user") User User) {
		List<Role> x=ps.allRoles();
		model.addAttribute("x",x);
		return "signup.jsp";
	}
	@RequestMapping("/filter")
		public String filter(Model model, @RequestParam("state")String state , @RequestParam("price")int price, @RequestParam("bedrooms")int bedrooms , @RequestParam("bathrooms")int bathrooms ) {
			model.addAttribute("Options", ps.filteredApartments(state,  price, bedrooms , bathrooms));
			return "properties.jsp";
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
	            session.setAttribute("role", user.getRole().getId());
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
	    		session.setAttribute("role", user.getRole().getId());
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
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session,Model model) {
		  session.invalidate();
		  return "redirect:/";
	 }
	 @RequestMapping("/admin")
	 public String admin(HttpSession session,Model model) {
		 Long id=(Long)session.getAttribute("user.id");
			if (id == null ) {
				return "redirect:/login";
			}
			User user=ps.findUserById(id);
			if(user.getRole().getId() != 1) {
				return "redirect:/";
			}
			
			int x=ps.allAgents().size();
			int y=ps.allApartments().size();
			model.addAttribute("user",user);
			model.addAttribute("x",x);
			model.addAttribute("y",y);
			return "adminHome.jsp";
	 }
	 @RequestMapping("/admin/agents")
	 public String adminagent(Model model,HttpSession session) {
		 Long id=(Long)session.getAttribute("user.id");
			if (id == null ) {
				return "redirect:/login";
			}
			User user=ps.findUserById(id);
			if(user.getRole().getId() != 1) {
				return "redirect:/";
			}
			model.addAttribute("user",user);
			List <User> agents=ps.allAgents();
			model.addAttribute("agents",agents);
			return "adminagents.jsp";
	 }
	 @RequestMapping("/admin/apps")
	 public String adminapp(Model model,HttpSession session) {
		 Long id=(Long)session.getAttribute("user.id");
			if (id == null ) {
				return "redirect:/login";
			}
			User user=ps.findUserById(id);
			if(user.getRole().getId() != 1) {
				return "redirect:/";
			}
			model.addAttribute("user",user);
			List <Apartment> apps=ps.allApartments();
			model.addAttribute("apps",apps);
			return "adminprop.jsp";
	 }
}
