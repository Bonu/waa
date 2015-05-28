/**
 * 
 */
package edu.mum.mscs.waa.calculator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mscs.waa.calculator.domain.Calculator;
import edu.mum.mscs.waa.calculator.validator.CalculatorValidator;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.controller.Controller;

/**
 * @author 984417
 *
 */
public class CalculatorController implements Controller {

	@AutoWired
	CalculatorValidator calculatorValidator;

	public String inputCalculator(HttpServletRequest request,
			HttpServletResponse response) {
		return "/WEB-INF/jsp/calculator.jsp";
	}

	public String resultCalculator(Calculator calculator, HttpServletRequest request,
			HttpServletResponse response) {
		List<String> errors = calculatorValidator.validate(calculator);
		System.out.println("----resultCalculator----");
		if (errors.isEmpty()) {
			// store product in a scope variable for the view
			
			request.setAttribute("calculator", calculator);
			return "/WEB-INF/jsp/result.jsp";
		} else {
			// store errors and product in a scope variable for the view
			request.setAttribute("errors", errors);
			request.setAttribute("form", calculator);
			return "/WEB-INF/jsp/calculator.jsp";
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
