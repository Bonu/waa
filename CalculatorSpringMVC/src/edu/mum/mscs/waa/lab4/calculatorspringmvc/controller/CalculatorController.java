package edu.mum.mscs.waa.lab4.calculatorspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mscs.waa.lab4.calculatorspringmvc.domain.Calculator;
import edu.mum.mscs.waa.lab4.calculatorspringmvc.service.CalculatorService;
import edu.mum.mscs.waa.lab4.calculatorspringmvc.validator.CalculatorValidator;

@Controller
public class CalculatorController {

	@Autowired
	CalculatorValidator calculatorValidator;

	@Autowired
	CalculatorService calculatorService;
	 
	@RequestMapping(value = { "/", "/calcHandle" }, method = RequestMethod.GET)
	public String inputCalc(Calculator calculator) {
		System.out.println("Inside inputcalc");
		return "CalculatorForm";
	}

	@RequestMapping(value = "/calcHandle", method = RequestMethod.POST)
	public String handleCalc(Calculator calculator, HttpServletRequest request,
			HttpServletResponse response) {

		List<String> errors = calculatorValidator.validate(calculator);
		if (errors.isEmpty()) {
			calculatorService.add(calculator);
			calculatorService.mult(calculator);
			request.setAttribute("calculator", calculator);
			return "CalculatorView";
		} else {
			// store errors and calculator in a scope variable for the view
			request.setAttribute("errors", errors);
			request.setAttribute("calculator", calculator);
			return "CalculatorForm";
		}

	}

}
