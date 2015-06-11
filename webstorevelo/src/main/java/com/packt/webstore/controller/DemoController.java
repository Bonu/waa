package com.packt.webstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.interceptor.EmailDemo;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	ProductService productService;
 
 	@RequestMapping({"","/demo"})
	public String demo() {

 		return "demo";
 	}
 	@RequestMapping("/velocity")
	public ModelAndView velocityProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, String> categoryOptions = new HashMap<String, String>();
		categoryOptions.put("Jewelry", "Jewelry");
		categoryOptions.put("Electronics", "Tablet");
		categoryOptions.put("Shoes", "Shoes");
		categoryOptions.put("Toys", "Toys");
		modelAndView.addObject("categoryList",categoryOptions);

		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Walmart");
		categoryList.add("Tiffanys");
		categoryList.add("Dillards");
		categoryList.add("Neiman-Marcus");
		modelAndView.addObject("category",categoryList);
		
		modelAndView.addObject("product", productService.getProductById("P1236"));
		modelAndView.setViewName("velocitydemo");
		return modelAndView;
	}
 
	@RequestMapping("/saveVelocity")
	public ModelAndView saveVelocityProducts(Product product) {
		ModelAndView modelAndView = new ModelAndView();
 
		System.out.println("Product: " + product.getName());
		System.out.println("Manufacturer: " + product.getManufacturer());
		System.out.println("Description: " + product.getDescription());
		System.out.println("Category: " + product.getCategory());
		
		modelAndView.setViewName("redirect:demo");
		return modelAndView;
	}
	

 	@RequestMapping("/freemarker")
	public ModelAndView freemarkerProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, String> categoryOptions = new HashMap<String, String>();
		categoryOptions.put("Jewelry", "Jewelry");
		categoryOptions.put("Electronics", "Tablet");
		categoryOptions.put("Shoes", "Shoes");
		categoryOptions.put("Toys", "Toys");
		modelAndView.addObject("categoryList",categoryOptions);

		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Jewelry");
		categoryList.add("Tablet");
		categoryList.add("Toys");
		categoryList.add("Shoes");
		modelAndView.addObject("category",categoryList);
		
		modelAndView.addObject("product", productService.getProductById("P1236"));
		modelAndView.setViewName("freemarkerdemo");
		return modelAndView;
	}
 
	
	@RequestMapping("/jsp")
	public ModelAndView jspProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, String> categoryOptions = new HashMap<String, String>();
		categoryOptions.put("Jewelry", "Jewelry");
		categoryOptions.put("Electronics", "Tablet");
		categoryOptions.put("Shoes", "Shoes");
		categoryOptions.put("Toys", "Toys");
 		modelAndView.addObject("categoryMap",categoryOptions);

		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Jewelry");
		categoryList.add("Tablet");
		categoryList.add("Toys");
		categoryList.add("Shoes");
		modelAndView.addObject("categoryList",categoryList);
		
		modelAndView.addObject("product", productService.getProductById("P1236"));
		modelAndView.setViewName("jspdemo");
		return modelAndView;
	}
	
 	@RequestMapping("/email")
	public String email(@ModelAttribute("product") Product product) {
 
        ArrayList<Map<String,String>> parameterList = new ArrayList<Map<String,String>>();
        Map<String, String> map = new HashMap<String, String>();

        map.put("name", "Cow");
        map.put("price", "$100.00");
        parameterList.add( map );
 
        map = new HashMap<String, String>();
        map.put("name", "Eagle");
        map.put("price", "$59.99");
        parameterList.add( map );

        map = new HashMap<String, String>();
        map.put("name", "Shark");
        map.put("price", "$3.99");
        parameterList.add( map );
        
        

 		new EmailDemo().generateEmail("Kemosabe", "email_html.vm",parameterList );
		
		return "welcome";
 	}
}
