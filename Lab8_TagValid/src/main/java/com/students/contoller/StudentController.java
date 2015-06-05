package com.students.contoller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.domain.Student;

@Controller
public class StudentController {

	@RequestMapping(value = "/registration",method = RequestMethod.GET)
	public String showForm(@ModelAttribute Student student,
			Model model) {
		System.out.println("-----Inside GET method-------");
		return "registration";
	}

	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public String processForm(@ModelAttribute @Valid Student student,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			System.out.println("-----Inside errors method-------");
			return "registration";
		}else{
			System.out.println("-----Inside POST method-------");
			return "success";
		}
	}

}
