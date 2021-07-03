package com.codingdojo.rentproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class projectController {
@RequestMapping("/")
public String home() {
	return "home.jsp";
}
<<<<<<< HEAD

@RequestMapping("/")
public String single() {
	return "single.jsp";
=======
<<<<<<< HEAD

@RequestMapping("/")
public String prop() {
	return "properties.jsp";
}


=======
@RequestMapping("/agentsGrid")
public String agentsGrid() {
	return "agents-grid.jsp";
}
>>>>>>> 62a557ccc1188ca6bd9664e9ef3fc555a3cbed32
>>>>>>> 843142059a2eca1922f8cc0e1760fdd6cafc4eb1
}
}