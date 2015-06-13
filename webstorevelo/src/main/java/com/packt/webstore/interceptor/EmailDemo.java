package com.packt.webstore.interceptor;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class EmailDemo
{
	public static String LOGGER_NAME = "auditLogger";
	
   public void generateEmail(String mailee,String fileName, List list)     {
        /*
         *   first, get and initialize an engine
         */

        VelocityEngine velocityEngine = new VelocityEngine();
        
        velocityEngine.setProperty( RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
        	      "org.apache.velocity.runtime.log.Log4JLogChute" );

        	    velocityEngine.setProperty("runtime.log.logsystem.log4j.logger",
        	                    LOGGER_NAME);
        	    
        	    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        	    velocityEngine.setProperty("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
 	    
        	    
        velocityEngine.init();

        /*
         *   organize our data 
         */


        /*
         *  add that list to a VelocityContext
         */

        VelocityContext context = new VelocityContext();
        context.put("mailee", mailee);
        context.put("petList", list);

        /*
         *   get the Template  
         */

        Template t = velocityEngine.getTemplate(fileName);

        /*
         *  now render the template into a Writer, here 
         *  a StringWriter 
         */

        StringWriter writer = new StringWriter();

        t.merge( context, writer );

        /*
         *  use the output in the body of your emails
         */

        System.out.println( writer.toString() );
    }
}
