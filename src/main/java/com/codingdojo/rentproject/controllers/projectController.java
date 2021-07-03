package com.codingdojo.rentproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class projectController {
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

}
