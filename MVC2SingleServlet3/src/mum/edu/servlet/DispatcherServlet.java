package mum.edu.servlet;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.controller.Controller;

public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 98279L;

 	Map<String, Controller> controllers = new HashMap<String, Controller>();
	Map<String, Controller> dispatchers = new HashMap<String, Controller>();
	Map<String, String> dispatcherMethods = new HashMap<String, String>();


    @Override
    public void init( ) throws ServletException {
 
    	String configFile = getServletConfig().getInitParameter("configFile");
     	
      LoadServletProperties  loadServletProperties = new LoadServletProperties();
 	  loadServletProperties.loadControllers(configFile,controllers,dispatchers,dispatcherMethods);
    }	
    
    
    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri has this form
         * /resourceName, e.g.: /product_input
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex); 
        String dispatchUrl = null;
 
        // Get controller based on URI
         Controller controller =  (Controller) dispatchers.get(action);
         // Get method to invoke
     	String methodName = dispatcherMethods.get(action);
   	
	try{ 
		//TODO: Performance Consideration: 
		// Move as much Reflection to "Configuration" - LoadServletProperties  as possible
		
		// Find Controller method... ASSUMES: only one method with this name
 		Class classObject = controller.getClass();
		Method method = null;
		for(Method m : classObject.getMethods()) {
		    if (m.getName().equals(methodName)) {
		    	method = m;
 		    	break;
		    }
		}
		 
		// Get the parameters...ASSUMES if NOT HTTP request, response arguments then create ONE...
		// e.g method:  saveInput(Product,HttpRequest, HttpResponse)
		Object[] methodParams = new Object[method.getParameterTypes().length];
		int n = 0;
		// We will bind to the domain object on a POST
		Object domainObject = null;
	    for (int i = 0; i < method.getParameterTypes().length; i ++) {
	         Class<?> paramClass = method.getParameterTypes()[i];
	  
	         if (paramClass == HttpServletRequest.class) {
	        	 methodParams[n++] = request;
	         }
	         else if (paramClass == HttpServletResponse.class) {
	        	 methodParams[n++] = response;
	         }
	         else {
	        	 // Save extra parameter as this is our domain object ASSUMES: ONLY ONE
	        	 // e.g Product
 	  			domainObject =   paramClass.getConstructor().newInstance();
	        	methodParams[n++] = domainObject;
	         }
	     }
		
	    // If it is a POST,  we want to BIND the request parameters to the Domain Object (e.g. Product)
 	    if (request.getMethod().equals("POST"))  
 	    		dataBinding(request,domainObject);
 
 	    // call the controller method with the appropriate "args"
 	    // for example, productController.saveProduct(product,request,response)
 		dispatchUrl = (String) method.invoke(controller, methodParams);
	}
	catch (Exception e){
		   System.out.println("BAD REQUEST: " + e.getMessage());  
	
	}
	
         // forward to a view
        if (dispatchUrl != null) {
            RequestDispatcher requestDispatcher = 
                    request.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(request, response);
        }
    }
 
/*
 *  Takes the parameters from the form [ via the request object]
 *  and binds them to the domain object. "For Example", the fields from the
 *  the ProductForm.jsp would be mapped to mum.edu.domain.Product.
 */

 void dataBinding(HttpServletRequest request, Object domainObject) {
 		Method domainMethod = null;
	    Map parameterMap = request.getParameterMap();
	    Enumeration parameterNames = request.getParameterNames();

	    // Loop through all the request/form parameters
	    while (parameterNames.hasMoreElements()) {  
				String name = (String) parameterNames.nextElement();  
				
				// this "for example" would be the value of the form field, name,description OR price
				// in the case of the ProductForm.jsp
				Object[] value = (Object[])parameterMap.get(name);
				
				// use the setter methods on domain Object...
					name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
					String domainObjectSetter = "set" + name;
		
					// Loop through domainObject Methods looking for Setter 
					// "for example" looking through Product for setName,SetDescription, setPrice
					Class<?>[] parameterTypes = null;
					for(Method m : domainObject.getClass().getMethods()) {
					    if (m.getName().equals(domainObjectSetter)) {
					    	domainMethod = m;
					    	break;
					    }
					}
					
					// We have the domainMethod, for example, setName
					// Now, we need to determine the "arg" types 
					// we want to end up with setName (String value)
					parameterTypes = domainMethod.getParameterTypes();
					
					try{ 

						if (parameterTypes[0]  == String.class) {
							domainMethod.invoke(domainObject, value[0] );
						}
						else if (parameterTypes[0]  == Double.class) {
							String strVal = ((String)value[0]).trim();
							Double val = null;
							if (!strVal.isEmpty())  
							 	val = Double.valueOf(strVal);
							domainMethod.invoke(domainObject, val);
						}
					}
					catch (Exception e){
						   System.out.println("BAD Data Binding: " + e.getMessage());  
					}

		}
 	}
	
 
 
 
 }


