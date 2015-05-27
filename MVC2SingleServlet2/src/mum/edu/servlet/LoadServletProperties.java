package mum.edu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mum.edu.controller.Controller;

public class LoadServletProperties {
	
	  public Map loadControllers() {
			 
	    	Properties prop = new Properties();
	    	InputStream input = null;

	    	Map<String, Controller> dispatchControllers = new HashMap<String, Controller>();

	    	try {
	 
	    		String filename = "config.properties";
	    		// Use ClassLoader to search all of classpath
	    		input = getClass().getClassLoader().getResourceAsStream(filename);
//	    		input = LoadServletProperties.class.getResourceAsStream(filename);
	    		if(input==null){
	    	            System.out.println("Unable to find " + filename);
	    		    return null;
	    		}
	 
	    		//load a properties file from class path
	    		prop.load(input);
	 
	    		   Enumeration  enumeration = prop.keys();  
	    		   while (enumeration.hasMoreElements()) {  
	    		    String key = (String) enumeration.nextElement();  
 	    		    
	    		    Controller controller = getControllerInstance((String)prop.get(key));
	    		    dispatchControllers.put(key, controller);
	    		   }  
	    	} catch (IOException e) {  
	    		   System.out.println(e.getMessage());  
	    	}  
 	        finally{
	        
	        	if(input!=null){
	        		try {
	        				input.close();
					    } catch (IOException e) {
					    	e.printStackTrace();
					  }
	        	}
	        }
	    	
	    	return dispatchControllers;
	  }


 	Controller getControllerInstance(String controllerName) {
 
 		Controller controller = null;
 		
 		try {
 			// using the Reflection API get the class(ofrName); get the default Constructor; create an instance...
 			//TODO: Looks like Factory [Method} Pattern - Should it be "Formalized"
 			controller = (Controller)  Class.forName(controllerName).getConstructor().newInstance();
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (controller);
 			
 	}
	
}