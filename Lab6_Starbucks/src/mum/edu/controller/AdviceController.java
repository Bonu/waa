package mum.edu.controller;

import java.util.HashMap;
import java.util.List;

import mum.edu.service.AdviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class AdviceController  {
	
	  @Autowired
	  AdviceService adviceService;

		public HashMap<Integer, String> roasts =  new HashMap<Integer, String>() {
            {
                put(1, "dark");
                put(2, "medium");
                put(3, "light");
             }
        };
		
 		@RequestMapping (value="/advice",method = RequestMethod.GET)
		public String adviceForm(Model model) {
		
 			model.addAttribute("roasts",roasts);
			
			return "advice";
		}

	  @RequestMapping (value="/advice",method = RequestMethod.POST)
	  public String adviceList( Integer roastKey, Model model) throws Exception {

		  String roast = roasts.get(roastKey);
 		List<String> roastList  = adviceService.getListByType(roast);
 
		model.addAttribute("roast",roast);
		model.addAttribute("roastList",roastList);
 		
		return "display" ;
 
	}
	
 
}
