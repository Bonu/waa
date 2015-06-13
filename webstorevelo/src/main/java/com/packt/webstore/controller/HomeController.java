package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping("/freemarker")
	public String freemarkerGreeting(Model model) {
		model.addAttribute("greeting", "Welcome to Freedom!");
		model.addAttribute("tagline", "X marks the spot!");

		return "freemarker";
	}

	@RequestMapping("/velocity")
	public String velocityGreeting(Model model) {
		model.addAttribute("greeting", "Welcome to the Accelerator!");
		model.addAttribute("tagline", "Add Velocity to your orders!");

		return "velocity";
	}
}
