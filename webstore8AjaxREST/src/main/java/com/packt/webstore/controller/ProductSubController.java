package com.packt.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductSubController {

	@RequestMapping(value="/getcategory", method = RequestMethod.POST)
	public  @ResponseBody List<String> getCategory(Model model, @RequestParam("manufacturer") String manufacturer) {
		System.out.println("Service invoked");
		List<String> cats = new ArrayList<String>();
		
		if(manufacturer.equals("DELL")){
			cats.add("laptop");
			cats.add("workstation");
			cats.add("tablets");
			cats.add("accessories");
		}else if(manufacturer.equals("GOOGLE")){
			cats.add("Tablet");
			cats.add("Glassess");
			cats.add("Doodles");
			cats.add("T-Shirts");
			cats.add("Mugs");
		}
		
		return cats;
		
	}
	
}
