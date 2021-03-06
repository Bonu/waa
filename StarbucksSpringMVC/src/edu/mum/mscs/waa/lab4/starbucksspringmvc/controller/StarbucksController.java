/**
 * 
 */
package edu.mum.mscs.waa.lab4.starbucksspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mscs.waa.lab4.starbucksspringmvc.domain.User;
import edu.mum.mscs.waa.lab4.starbucksspringmvc.service.AdviceService;
import edu.mum.mscs.waa.lab4.starbucksspringmvc.service.AuthenticationService;

/**
 * @author janardhanbonu
 *
 */
@Controller
public class StarbucksController {

	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	AdviceService adviceService;
	
	// Action class for application default display
	@RequestMapping(value={"/","/login"}, method = RequestMethod.GET)
	public String userLogin(User user, Model model){
		return "login";
	}
	
	// Validate user credentials in database
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String validateUser(User user, Model model){
		return authenticationService.validateUserCredentials(user) ? "loginsuccess": "login";
	}
	
	// Login success page to Roast advice page
	@RequestMapping(value="/roastadvice", method = RequestMethod.GET)
	public String adviceRoast(Model model){
		return "advice";
	}
	
	// Login success page to Roast advice page
	@RequestMapping(value="/roastadvice", method = RequestMethod.POST)
	public String adviceView(String roastAdvice, Model model){
		List<String> advices = adviceService.getAdviceDetails(roastAdvice);
		 model.addAttribute("roastAdvice", roastAdvice);
		model.addAttribute("advices", advices);
		return "display";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
