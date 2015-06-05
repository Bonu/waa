package com.students.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.domain.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
 
	private static final Log logger = LogFactory.getLog(UserController.class);

	@RequestMapping(value = "/adduser", method=RequestMethod.GET)
	public String showUser(@ModelAttribute User user, Model model) {	
		model.addAttribute("user", new User());
 		return "user";
	}
	
	@RequestMapping(value = "/saveuser", method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
		logger.info("addUser called ");
		if(result.hasErrors()) {
			logger.info("--------Errors in the form----------");
			return "user";
		}else {
			return "userdetails";
		}
	}
	
}
