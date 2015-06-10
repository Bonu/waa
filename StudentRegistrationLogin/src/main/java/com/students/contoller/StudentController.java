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
@RequestMapping(value="/registration")	
public class StudentController {
	
	    @RequestMapping(method=RequestMethod.GET)	
	    public String showForm(@ModelAttribute("student") Student student, Model model){
	    	
 	        return "registration";
	    }
	
	 
	
	    @RequestMapping(method=RequestMethod.POST)	
	    public String processForm(@Valid @ModelAttribute("student") Student student,
	    		BindingResult result,Model model){
 
	        if(result.hasErrors()){
	            return "registration";
	        }else{
             return "success";
	
	        }
	
	    }
	    
	}

	

